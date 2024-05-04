package com.upc.jpa_chambav1.controller;

import com.upc.jpa_chambav1.dtos.OficioDTO;
import com.upc.jpa_chambav1.entities.Oficio;
import com.upc.jpa_chambav1.services.OficioService;
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
public class OficioController {
    @Autowired
    private OficioService oficioService;

    @PostMapping("/oficio")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<OficioDTO> save(@RequestBody OficioDTO oficioDTO){
        ModelMapper modelMapper = new ModelMapper();
        Oficio oficio = modelMapper.map(oficioDTO, Oficio.class);
        oficio = oficioService.save(oficio);
        oficioDTO = modelMapper.map(oficio, OficioDTO.class);
        return new ResponseEntity<>(oficioDTO, HttpStatus.OK);
    }

    @PutMapping("/oficio")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody OficioDTO oficioDTO){
        ModelMapper modelMapper = new ModelMapper();
        Oficio oficio = modelMapper.map(oficioDTO, Oficio.class);
        oficioService.save(oficio);
    }

    @GetMapping("/oficios")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<OficioDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<OficioDTO> ofi = Arrays.asList(
                modelMapper.map(oficioService.list(),
                        OficioDTO[].class));
        return new ResponseEntity<>(ofi, HttpStatus.OK);
    }

    @DeleteMapping("/oficio/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        oficioService.delete(id);
    }

    @GetMapping("/oficio/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<OficioDTO> listarId(@PathVariable("id") Long id){
        ModelMapper modelMapper = new ModelMapper();
        OficioDTO oficioDTO = modelMapper.map(oficioService.listarId(id), OficioDTO.class);
        return new ResponseEntity<>(oficioDTO, HttpStatus.OK);
    }




}
