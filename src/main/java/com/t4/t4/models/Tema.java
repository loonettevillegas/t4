package com.t4.t4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;

import jakarta.persistence.EnumType;

/*class Temas(enum.Enum):
	música = 'música'
	deporte = 'deporte'
	ciencias = 'ciencias'
	religión = 'religión'
	política = 'politica'
	tecnología = 'tecnología'
	juegos = 'juegos'
	baile = 'baile'
	comida = 'comida'
	otro = 'otro'

class ActividadTema(Base):
	__tablename__ =  'actividad_tema'
	id = Column(Integer, primary_key=True, autoincrement=True)
	tema = Column(Enum(Temas), nullable=False)
	glosa_otro = Column(String(15), nullable=True)
	actividad_id = Column(Integer, ForeignKey('actividad.id'), primary_key=True) 
	actividad = relationship("Actividad", backref="temas") */


@Entity
@Table(name = "actividad_tema")
public class Tema {


     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Column(name = "actividad_id", nullable = false)
    private Integer actividadId; 

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tema", nullable = false)
    private TemaEnum tema;
    
    public Tema() {
    }


    
    public Tema(Integer id, 
                    Integer  actividad_id,
                    TemaEnum tema) {

        this.id = id;
        this.actividadId = actividad_id;
        this.tema = tema;
  
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

      public TemaEnum getTema() {
        return tema;
    }



    public enum TemaEnum {
    música("música"),
    deporte("deporte"),
    ciencias("ciencias"),
    religión("religión"),
    politica("política"),
    tecnología("tecnología"),
    juegos("juegos"),
    baile("baile"),
    comida("comida"),
    otro("otro");

    private final String value;

    TemaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
    
}
