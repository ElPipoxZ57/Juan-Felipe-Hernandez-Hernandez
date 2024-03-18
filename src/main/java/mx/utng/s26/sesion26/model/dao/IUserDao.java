package mx.utng.s26.sesion26.model.dao;
import java.util.List;

import mx.utng.s26.sesion26.model.entity.User;


public interface IUserDao {
    //Listar usuarios
   List<User> list();
   //Guardar un usuario
   void save(User user);
   User getById(long id);
   void delete(long id);
}
