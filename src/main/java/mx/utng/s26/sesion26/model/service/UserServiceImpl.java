package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.IUserDao;
import mx.utng.s26.sesion26.model.entity.User;

@Service
public class UserServiceImpl implements IUserService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private IUserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public List<User> list() {
       return userDao.list();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly=true)
    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }


    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }





    
}
