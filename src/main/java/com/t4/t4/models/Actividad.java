package com.t4.t4.models;
import java.util.List;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actividad")
public class Actividad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "sector", length = 100)
    private String sector;
    
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    
    @Column(name = "celular", length = 15)
    private String celular;
    
    @Column(name = "dia_hora_inicio", nullable = false)
    private LocalDateTime diaHoraInicio;
    
    @Column(name = "dia_hora_termino")
    private LocalDateTime diaHoraTermino;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Column(name = "comuna_id", nullable = false)
    private Integer comunaId;
    
    
    
    public Actividad() {}
    
    public Actividad(String nombre, String email, LocalDateTime diaHoraInicio, Integer comunaId) {
        this.nombre = nombre;
        this.email = email;
        this.diaHoraInicio = diaHoraInicio;
        this.comunaId = comunaId;
    }
    
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSector() {
        return sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public LocalDateTime getDiaHoraInicio() {
        return diaHoraInicio;
    }
    
    public void setDiaHoraInicio(LocalDateTime diaHoraInicio) {
        this.diaHoraInicio = diaHoraInicio;
    }
    
    public LocalDateTime getDiaHoraTermino() {
        return diaHoraTermino;
    }
    
    public void setDiaHoraTermino(LocalDateTime diaHoraTermino) {
        this.diaHoraTermino = diaHoraTermino;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getComunaId() {
        return comunaId;
    }
    
    public void setComunaId(Integer comunaId) {
        this.comunaId = comunaId;
    }
    
}