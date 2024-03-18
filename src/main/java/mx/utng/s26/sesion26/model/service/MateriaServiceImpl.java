package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.sesion26.model.dao.MateriaDao;
import mx.utng.s26.sesion26.model.entity.Materia;

@Service
public class MateriaServiceImpl implements MateriaService{

    //Inyecta una interfaz para utilizar sus metodos 
    @Autowired
    private MateriaDao materiaDao;

    @Transactional(readOnly=true)
    @Override
    public List<Materia> list() {
       return materiaDao.list();
    }

    @Transactional
    @Override
    public void save(Materia materia) {
        materiaDao.save(materia);
    }

    @Transactional(readOnly=true)
    @Override
    public Materia getById(Long id) {
        return materiaDao.getById(id);
    }


    @Transactional
    //(readOnly=true)
    @Override
    public void delete(long id) {
        materiaDao.delete(id);
    }





    
}
