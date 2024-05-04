package com.upc.jpa_chambav1.controller;

import com.upc.jpa_chambav1.dtos.ClienteDTO;
import com.upc.jpa_chambav1.dtos.TrabajadorDTO;
import com.upc.jpa_chambav1.dtos.TrabajadorOficioDTO;
import com.upc.jpa_chambav1.entities.Cliente;
import com.upc.jpa_chambav1.entities.Trabajador;
import com.upc.jpa_chambav1.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cliente")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO){
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteService.save(cliente);
        clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @PutMapping("/cliente")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public void modificar(@RequestBody ClienteDTO clienteDTO){
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteService.save(cliente);
    }

    @GetMapping("/clientes")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<ClienteDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<ClienteDTO> cli = Arrays.asList(
                modelMapper.map(clienteService.list(),
                        ClienteDTO[].class));
        return new ResponseEntity<>(cli, HttpStatus.OK);
    }

    @DeleteMapping("/cliente/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        clienteService.delete(id);
    }

    @GetMapping("/cliente/{id}")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<ClienteDTO> listarId(@PathVariable("id") Long id){
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO clienteDTO = modelMapper.map(clienteService.listarId(id), ClienteDTO.class);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @GetMapping("/clientes/{nombre}")
    @PreAuthorize("hasAuthority('MODERATOR') or hasAuthority('ADMIN')")
    public ResponseEntity<List<ClienteDTO>> obtenerNombreTrabajadores(@PathVariable(value = "nombre") String email){
        List<Cliente> list = clienteService.obtenerReportePorEmail(email);
        List<ClienteDTO> listDto = convertToListDto(list);
        return new ResponseEntity<List<ClienteDTO>>(listDto, HttpStatus.OK);
    }

    private ClienteDTO convertToDto(Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }

    private List<ClienteDTO> convertToListDto(List<Cliente> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
