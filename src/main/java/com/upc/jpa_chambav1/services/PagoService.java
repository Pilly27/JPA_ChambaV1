package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.entities.Pago;
import com.upc.jpa_chambav1.repositories.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Transactional
    public Pago save(Pago pago){
        return pagoRepository.save(pago);
    }

    public List<Pago> list(){
        return pagoRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        pagoRepository.deleteById(id);
    }

    public Pago listarId(Long id){
        return pagoRepository.findById(id).orElse(new Pago());
    }

    public List<Pago> obtenerPagosPorMonto(Float monto) {
        return pagoRepository.obtenerPagosPorMonto(monto);
    }
}
