package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Grupo;


public interface GrupoDao {
    //Listar usuarios
   List<Grupo> list();
   //Guardar un usuario
   void save(Grupo grupo);
   Grupo getById(long id);
   void delete(long id);
}
