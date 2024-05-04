package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.Oficio;
import com.upc.jpa_chambav1.repositories.OficioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficioService {
    @Autowired
    private OficioRepository oficioRepository;

    @Transactional
    public Oficio save(Oficio oficio){
        return oficioRepository.save(oficio);
    }

    public List<Oficio> list(){
        return oficioRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        oficioRepository.deleteById(id);
    }

    public Oficio listarId(Long id){
        return oficioRepository.findById(id).orElse(new Oficio());
    }
}
