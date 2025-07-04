package com.t4.t4.services;

import java.time.LocalDateTime;

import com.t4.t4.models.Actividad;
import com.t4.t4.models.ActividadRepository;
import com.t4.t4.models.notasRepository;

import com.t4.t4.models.TemaRepository;
import com.t4.t4.models.Tema;
import com.t4.t4.models.Notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AppService {
    //aqui recupero las actividades y calculo el promedio de  notas
        private final ActividadRepository actividadRepository;
        private final notasRepository notaRepository;
        private final TemaRepository temaRepository;

        @Autowired
        public AppService(ActividadRepository actividadRepository, notasRepository notaRepository, TemaRepository temaRepository) {
        this.actividadRepository = actividadRepository;
        this.notaRepository = notaRepository;
        this.temaRepository = temaRepository;

    }
        public List<Map<String, String>> getActividades() {
        List<Map<String, String>> actividadesData = new ArrayList<>();

        List<Actividad> actividades = actividadRepository.findByDiaHoraTerminoBefore(LocalDateTime.now());
        
        //recuperamos las actividades , función del aux para recuperar confesiones adaptada
        for (Actividad actividad : actividades) {
            
            Map<String, String> actData = new HashMap<>();

            actData.put("id", actividad.getId() != null ? actividad.getId().toString() : null);
            actData.put("sector", actividad.getSector());
            actData.put("nombre", actividad.getNombre());
            actData.put("email", actividad.getEmail());
            actData.put("celular", actividad.getCelular());
            actData.put("dia_hora_inicio", actividad.getDiaHoraInicio() != null ? 
                actividad.getDiaHoraInicio().toString() : null);
            actData.put("dia_hora_termino", actividad.getDiaHoraTermino() != null ? 
                actividad.getDiaHoraTermino().toString() : null);
            actData.put("descripcion", actividad.getDescripcion());
            actData.put("comuna_id", actividad.getComunaId() != null ? 
                actividad.getComunaId().toString() : null);
            actData.put("tema", getTema(actividad.getId()));
           

                //recuperamos las notas de cada actividad por su id
            List<Notas> notasDeActividad = notaRepository.findByActividadId(actividad.getId());



            //calcularemos el promedio de las actividades

            String promedioStr = calcularPromedio(notasDeActividad);
            actData.put("nota_promedio", promedioStr);
            actividadesData.add(actData);
             


             }
             return actividadesData;
           
            
       



            }
             private String calcularPromedio(List<Notas> notas) {
                    if (notas != null && !notas.isEmpty()) {
                        double promedio = notas.stream()
                            .mapToInt(Notas::getNota)
                            .average()
                            .orElse(0.0);
                        return String.format("%.1f", promedio);
                    } else {
                        return "-";
                    }

        
        
        }

        public String getTema(Integer actividadId) {
        Tema tema =  temaRepository.findByActividadId(actividadId);
        return tema.getTema().getValue();
 
        }

        
    }