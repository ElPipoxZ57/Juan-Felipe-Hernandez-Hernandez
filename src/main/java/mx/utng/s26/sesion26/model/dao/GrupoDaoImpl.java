package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.sesion26.model.entity.Grupo;

@Repository
public class GrupoDaoImpl implements GrupoDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(long id) {
        Grupo Materia = getById(id);
        em.remove(Materia);
    }

    @Override
    public Grupo getById(long id) {
        return em.find(Grupo.class, id);
    }

    @Override
    public List<Grupo> list() {
        return em.createQuery("from Grupo").getResultList();
    }




    
    @Override
    public void save(Grupo grupo) {
        if (grupo.getId() != null && grupo.getId()>0) {
           em.merge(grupo);
        }else{
            em.persist(grupo);
        }
    }
    
}
