package com.t4.t4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

import com.t4.t4.services.ApiService;
import org.springframework.web.bind.annotation.RestController;

import com.t4.t4.models.Notas;


@RestController
@RequestMapping("/api") 
public class ApiController {
    
    private final ApiService apiService;
    public ApiController(ApiService apiService) {
        this.apiService = apiService;

    }

     @PostMapping("/post-eval")
    public void postEvalRoute(
        @RequestParam("actividadId") Integer id,
        @RequestParam("eval") Integer nota
        ) throws Exception {
        
        apiService.agregarNota(
            id,
            nota
            
            
        );
    }


    @GetMapping("/actividad/{actividadId}/promedio")
    public Map<String, List<Notas>> getNotasParaPromedio(@PathVariable("actividadId") Integer actividadId) {

        List<Notas> notas;
        notas = apiService.getNotas(actividadId);
        return Map.of("notas", notas); 
    }

}
