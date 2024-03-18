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
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Grupo {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (length = 90, nullable = false)
    @NotEmpty
    private String name;

    @Temporal(TemporalType.DATE)
    private Date recordAt;


    @Column (length = 90, nullable = false)
    @NotEmpty
    private String alumno;

    @PrePersist
    public void PrePersist(){
        recordAt = new Date();
    }

    @Column (length = 90, nullable = false)
    @NotEmpty
    private String docente;

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

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

    public Date getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    
}
