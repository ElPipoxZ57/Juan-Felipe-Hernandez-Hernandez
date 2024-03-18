package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Materia;

public interface MateriaService {
    List<Materia> list();
    void save(Materia materia);
    Materia getById(Long id);
   void delete(long id);
    
}
