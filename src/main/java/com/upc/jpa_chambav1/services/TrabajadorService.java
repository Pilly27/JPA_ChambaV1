package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.Trabajador;
import com.upc.jpa_chambav1.repositories.TrabajadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Transactional
    public Trabajador save(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public List<Trabajador> list(){
        return trabajadorRepository.findAll();
    }

    @Transactional
    public void delete (Long id){
        trabajadorRepository.deleteById(id);
    }

    public Trabajador listarId(Long id){
        return  trabajadorRepository.findById(id).orElse(new Trabajador());
    }

    public List<Trabajador> obtenerNombreTrabajadores(String prefijo){
        return trabajadorRepository.obtenerReportePorNombre(prefijo);
    }

    public List<Object[]> obtenerNumeroTrabajadoresPorOficio() {
        return trabajadorRepository.findNumeroTrabajadoresPorOficio();
    }
}
