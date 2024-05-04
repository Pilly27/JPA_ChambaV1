package com.upc.jpa_chambav1.services;

import com.upc.jpa_chambav1.dtos.TrabajadorSolicitudDTO;
import com.upc.jpa_chambav1.entities.Solicitud;
import com.upc.jpa_chambav1.repositories.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Transactional
    public Solicitud save(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> list(){
        return solicitudRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        solicitudRepository.deleteById(id);
    }

    public Solicitud listarId(Long id){
        return solicitudRepository.findById(id).orElse(new Solicitud());
    }

    public List<TrabajadorSolicitudDTO> findTrajadorNumberoSolicitudes(){
        List<TrabajadorSolicitudDTO> solicitudDTOList = new ArrayList<>();
        for(Object[] p: solicitudRepository.findTrajadorNumberoSolicitudes()){
            TrabajadorSolicitudDTO dto = new TrabajadorSolicitudDTO();
            dto.setNombre((String) p[0]);
            dto.setNumeroSolicitudes((Long) p[1]);
            solicitudDTOList.add(dto);
        }
        return solicitudDTOList;
    }

    public List<Solicitud> listSolicitudesActivadas() {
        return solicitudRepository.findSolicitudesActivadas();
    }
}
