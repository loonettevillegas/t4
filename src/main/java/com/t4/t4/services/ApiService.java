package com.t4.t4.services;

import com.t4.t4.models.Actividad;
import com.t4.t4.models.Notas;
import com.t4.t4.models.ActividadRepository;
import com.t4.t4.models.notasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ApiService {

    
    private final ActividadRepository actividadRepository;
    private final notasRepository notaRepository; 

    
    @Autowired
    public ApiService(ActividadRepository actividadRepository, notasRepository notaRepository) {
        this.actividadRepository = actividadRepository;
        this.notaRepository = notaRepository;
    }

    
    public void agregarNota(Integer actividadId, Integer valorNota) {
        if (valorNota == null || valorNota < 1 || valorNota > 7) {
            throw new IllegalArgumentException("La nota debe ser un número entero entre 1 y 7.");
        }

        Optional<Actividad> actividadOptional = actividadRepository.findById(actividadId);

        if (actividadOptional.isEmpty()) {
            throw new RuntimeException("Actividad no encontrada con ID: " + actividadId);
        }


        Notas nuevaNota = new Notas();
        nuevaNota.setActividadId(actividadId);
        nuevaNota.setNota(valorNota);

        notaRepository.save(nuevaNota);
    }

    public List<Notas> getNotas(Integer actividadId) {

        //recuperamos las notas de cada actividad por su id
            List<Notas> notasDeActividad = notaRepository.findByActividadId(actividadId);
                return notasDeActividad;
    }
    
}