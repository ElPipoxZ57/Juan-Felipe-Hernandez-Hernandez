package mx.utng.s26.sesion26.model.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotEmpty
    // se borro email y se cambio de materia.
    private String materia;


    @Column (length = 40, nullable = false)
    @NotEmpty
    // se borro email y se cambio a docente.
    private String docente;
    
    private String login;

    @Temporal(TemporalType.DATE)
    private Date recordAt;

    @PrePersist
    public void PrePersist(){
        recordAt = new Date();
    }





    @Column (length = 40, nullable = false)
    @NotEmpty
    // se borro email y se cambio a docente.
    private String grupo;






    public void setMateria(String materia) {
        this.materia = materia;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setDocente(String docente) {
        this.docente = docente;
    }
    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }
    public String getMateria() {
        return materia;
    }



    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getGrupo() {
        return grupo;
    } 


    
    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getDocente() {
        return docente;
    }
    public Date getRecordAt() {
        return recordAt;
    }
}

//Falta y getter y setter de Grupo y constructor asi como sus adornos