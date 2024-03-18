package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.sesion26.model.entity.Materia;

@Repository
public class MateriaDaoImp implements MateriaDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete(long id) {
        Materia materia = getById(id);
        em.remove(materia);
    }

    @Override
    public Materia getById(long id) {
        return em.find(Materia.class, id);
    }

    @Override
    public List<Materia> list() {
        return em.createQuery("from Materia").getResultList();
    }




    
    @Override
    public void save(Materia materia) {
        if (materia.getId() != null && materia.getId()>0) {
           em.merge(materia);
        }else{
            em.persist(materia);
        }
    }
    
}
