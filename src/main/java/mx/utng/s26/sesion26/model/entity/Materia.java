package mx.utng.s26.sesion26.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Materia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 90, nullable = false)
    @NotEmpty
     private String name;

     @Min(0)
     @Max(30)
     private int hoursPerClass;
     
     @Temporal(TemporalType.DATE)
     private Date recordAt;

     @PrePersist
     public void PrePersist(){
        recordAt = new Date();
     }

     @Column (length = 90, nullable = false)
     @NotEmpty
      private String nomUnidad;
     
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHoursPerClass() {
        return hoursPerClass;
    }
    public void setHoursPerClass(int hoursPerClass) {
        this.hoursPerClass = hoursPerClass;
    }
    public Date getRecordAt() {
        return recordAt;
    }
    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }
    public String getNomUnidad() {
        return nomUnidad;
    }
    public void setNomUnidad(String nomUnidad) {
        this.nomUnidad = nomUnidad;
    }

     
}
