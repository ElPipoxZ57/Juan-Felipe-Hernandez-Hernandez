package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.User;

public interface IUserService {
    List<User> list();
    void save(User user);
    User getById(Long id);
   void delete(long id);
    
}
