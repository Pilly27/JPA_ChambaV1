package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.Cliente;
import com.upc.jpa_chambav1.entities.Trabajador;
import com.upc.jpa_chambav1.repositories.ClienteRepository;
import com.upc.jpa_chambav1.repositories.TrabajadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente listarId(Long id){
        return clienteRepository.findById(id).orElse(new Cliente());
    }

    public List<Cliente> obtenerReportePorEmail(String prefijo){
        return clienteRepository.obtenerReportePorEmail(prefijo);
    }



}
