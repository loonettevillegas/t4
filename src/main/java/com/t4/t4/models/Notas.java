package com.t4.t4.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull; 


@Entity
@Table(name = "nota")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name = "actividad_id", nullable = false)
    private Integer actividadId; 

    @NotNull
    private Integer  nota;
    
    public Notas() {
    }

    public Notas(Integer id, 
                    Integer  actividad_id,
                    Integer  nota) {

        this.id = id;
        this.actividadId = actividad_id;
        this.nota = nota;
  
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getActividadId() {
        return actividadId;
    }
    public void setActividadId(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) { this.nota = nota; }

      public static Boolean validateNota(Integer notita) {
        if (notita >= 1 && notita <=7){
             return true;

        }
        else{
            return false;
        }
       
       
    }
}


