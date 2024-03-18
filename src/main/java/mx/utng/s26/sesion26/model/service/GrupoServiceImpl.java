package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.GrupoDao;
import mx.utng.s26.sesion26.model.entity.Grupo;

@Service
public class GrupoServiceImpl implements GrupoService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private GrupoDao grupoDao;

    @Transactional(readOnly=true)
    @Override
    public List<Grupo> list() {
       return grupoDao.list();
    }

    @Transactional
    @Override
    public void save(Grupo grupo) {
        grupoDao.save(grupo);
    }

    @Transactional(readOnly=true)
    @Override
    public Grupo getById(Long id) {
        return grupoDao.getById(id);
    }


    @Transactional
    //(readOnly=true)
    @Override
    public void delete(long id) {
        grupoDao.delete(id);
    }





    
}
