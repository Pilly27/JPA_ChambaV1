package com.upc.jpa_chambav1.controller;

import com.upc.jpa_chambav1.dtos.TrabajadorDTO;
import com.upc.jpa_chambav1.dtos.TrabajadorOficioDTO;
import com.upc.jpa_chambav1.entities.Trabajador;
import com.upc.jpa_chambav1.services.TrabajadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @PostMapping("/trabajador")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<TrabajadorDTO> save(@RequestBody TrabajadorDTO trabajadorDTO){
        ModelMapper modelMapper = new ModelMapper();
        Trabajador trabajador = modelMapper.map(trabajadorDTO, Trabajador.class);
        trabajador = trabajadorService.save(trabajador);
        trabajadorDTO = modelMapper.map(trabajador, TrabajadorDTO.class);
        return new ResponseEntity<>(trabajadorDTO, HttpStatus.OK);
    }

    @PutMapping("/trabajador")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody TrabajadorDTO trabajadorDTO){
        ModelMapper modelMapper = new ModelMapper();
        Trabajador trabajador = modelMapper.map(trabajadorDTO, Trabajador.class);
        trabajadorService.save(trabajador);
    }

    @GetMapping("/trabajadores")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<TrabajadorDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<TrabajadorDTO> tra = Arrays.asList(
                modelMapper.map(trabajadorService.list(),
                        TrabajadorDTO[].class));
        return new ResponseEntity<>(tra, HttpStatus.OK);
    }

    @DeleteMapping("/trabajador/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        trabajadorService.delete(id);
    }

    @GetMapping("/trabajador/{id}")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<TrabajadorDTO> listarId(@PathVariable("id") Long id){
        ModelMapper modelMapper = new ModelMapper();
        TrabajadorDTO trabajadorDTO = modelMapper.map(trabajadorService.listarId(id), TrabajadorDTO.class);
        return new ResponseEntity<>(trabajadorDTO, HttpStatus.OK);
    }

    @GetMapping("/trabajadores/{nombre}")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<TrabajadorDTO>> obtenerNombreTrabajadores(@PathVariable(value = "nombre") String nombre){
        List<Trabajador> list = trabajadorService.obtenerNombreTrabajadores(nombre);
        List<TrabajadorDTO> listDto = convertToListDto(list);
        return new ResponseEntity<List<TrabajadorDTO>>(listDto, HttpStatus.OK);
     }

     private TrabajadorDTO convertToDto(Trabajador trabajador){
        ModelMapper modelMapper = new ModelMapper();
        TrabajadorDTO trabajadorDTO = modelMapper.map(trabajador, TrabajadorDTO.class);
        return trabajadorDTO;
     }

     private List<TrabajadorDTO> convertToListDto(List<Trabajador> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
     }

    @GetMapping("/trabajadoresOficio")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<TrabajadorOficioDTO>> obtenerNumeroTrabajadoresPorOficio() {
        List<Object[]> numeroTrabajadoresPorOficio = trabajadorService.obtenerNumeroTrabajadoresPorOficio();
        List<TrabajadorOficioDTO> trabajadoresPorOficioDTO = numeroTrabajadoresPorOficio.stream()
                .map(obj -> new TrabajadorOficioDTO((String) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
        return new ResponseEntity<>(trabajadoresPorOficioDTO, HttpStatus.OK);
    }
}
