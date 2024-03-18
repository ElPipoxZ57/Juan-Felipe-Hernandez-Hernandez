package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Grupo;

public interface GrupoService {
    List<Grupo> list();
    void save(Grupo grupo);
    Grupo getById(Long id);
   void delete(long id);
    
}
