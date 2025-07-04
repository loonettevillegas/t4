package com.t4.t4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import com.t4.t4.services.AppService;

@Controller
public class AppController {
    
    private final AppService appService;
    public AppController(AppService appService) {
        this.appService = appService;
    }

//retornamos la pagina de las evaluaciones
    @GetMapping("/eval")
    public String evalRoute(Model model) {
        List<Map<String, String>> modelData = appService.getActividades();
        model.addAttribute("data", modelData);
        return "eval";
    }
 
}
