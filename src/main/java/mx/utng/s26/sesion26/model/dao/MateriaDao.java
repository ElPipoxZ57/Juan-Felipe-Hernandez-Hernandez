package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Materia;


public interface MateriaDao {
    //Listar usuarios
   List<Materia> list();
   //Guardar un usuario
   void save(Materia materia);
   Materia getById(long id);
   void delete(long id);
}
