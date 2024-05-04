package com.upc.jpa_chambav1.controller;

import com.upc.jpa_chambav1.dtos.PagoDTO;
import com.upc.jpa_chambav1.entities.Pago;
import com.upc.jpa_chambav1.services.PagoService;
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
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @PostMapping("/pago")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<PagoDTO> save(@RequestBody PagoDTO pagoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago = pagoService.save(pago);
        pagoDTO = modelMapper.map(pago, PagoDTO.class);
        return new ResponseEntity<>(pagoDTO, HttpStatus.OK);
    }

    @PutMapping("/pago")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody PagoDTO pagoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pagoService.save(pago);
    }

    @GetMapping("/pagos")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('EMPLOYEE') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<PagoDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<PagoDTO> pag = Arrays.asList(
                modelMapper.map(pagoService.list(),
                        PagoDTO[].class));
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @DeleteMapping("/pago/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        pagoService.delete(id);
    }

    @GetMapping("/pago/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('EMPLOYEE') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<PagoDTO> listarId(@PathVariable("id") Long id){
        ModelMapper modelMapper = new ModelMapper();
        PagoDTO pagoDTO = modelMapper.map(pagoService.listarId(id), PagoDTO.class);
        return new ResponseEntity<>(pagoDTO, HttpStatus.OK);
    }

    @GetMapping("/pagos/{monto}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('EMPLOYEE') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<Pago>> obtenerPagosPorMonto(@PathVariable Float monto) {
        List<Pago> pagos = pagoService.obtenerPagosPorMonto(monto);
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }
}
