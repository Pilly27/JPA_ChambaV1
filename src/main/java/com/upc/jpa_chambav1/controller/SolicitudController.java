package com.upc.jpa_chambav1.controller;

import com.upc.jpa_chambav1.dtos.SolicitudDTO;
import com.upc.jpa_chambav1.dtos.TrabajadorSolicitudDTO;
import com.upc.jpa_chambav1.entities.Solicitud;
import com.upc.jpa_chambav1.services.SolicitudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/solicitud")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SolicitudDTO> save(@RequestBody SolicitudDTO solicitudDTO){
        ModelMapper modelMapper = new ModelMapper();
        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);
        solicitud = solicitudService.save(solicitud);
        solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);
        return new ResponseEntity<>(solicitudDTO, HttpStatus.OK);
    }

    @PutMapping("/solicitud")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody SolicitudDTO solicitudDTO){
        ModelMapper modelMapper = new ModelMapper();
        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);
        solicitudService.save(solicitud);
    }

    @GetMapping("/solicitudes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<SolicitudDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudDTO> sol = Arrays.asList(
                modelMapper.map(solicitudService.list(),
                        SolicitudDTO[].class));
        return new ResponseEntity<>(sol, HttpStatus.OK);
    }

    @DeleteMapping("/solicitud/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        solicitudService.delete(id);
    }

    @GetMapping("/solicitud/{id}")
    public ResponseEntity<SolicitudDTO> listarId(@PathVariable("id") Long id){
        ModelMapper modelMapper = new ModelMapper();
        SolicitudDTO solicitudDTO = modelMapper.map(solicitudService.listarId(id), SolicitudDTO.class);
        return new ResponseEntity<>(solicitudDTO, HttpStatus.OK);
    }

    @GetMapping("/trabajadoresSolicitudes")
    @PreAuthorize("hasAuthority('ADMIN')")

    public List<TrabajadorSolicitudDTO> findTrajadorNumberoSolicitudes(){
        return solicitudService.findTrajadorNumberoSolicitudes();
    }

    @GetMapping("/solicitudesActivas")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<SolicitudDTO>> listSolicitudesActivas() {
        ModelMapper modelMapper = new ModelMapper();
        List<SolicitudDTO> solicitudesActivas = Arrays.asList(
                modelMapper.map(solicitudService.listSolicitudesActivadas(),
                        SolicitudDTO[].class));
        return new ResponseEntity<>(solicitudesActivas, HttpStatus.OK);
    }


}
