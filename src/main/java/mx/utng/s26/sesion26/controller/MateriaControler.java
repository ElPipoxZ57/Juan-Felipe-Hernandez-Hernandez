package mx.utng.s26.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.Materia;
import mx.utng.s26.sesion26.model.service.MateriaService;

@Controller
@SessionAttributes("materia")
public class MateriaControler {
    //inyectamos un a dependencias del servicio 
    @Autowired
    private MateriaService materiaService;

    //Manda llamar este metodo en una petición GET
    //Que cocntenga como final de la querystring "","/", "/list"
    @GetMapping({"/materia/list","/materia","/materia/"})
    public String list(Model model){
        model.addAttribute("Title", "Listado de Materias");
        model.addAttribute("materias", materiaService.list());
        return "tlist";
    }

    //Petición que contenga al final de la url /form
    @GetMapping("/materia/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registrar Materias");
        model.addAttribute("materia", new Materia());
        return "tform";
    }

    @GetMapping("/materia/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Materia materia = null;
        if(id>0){
            materia = materiaService.getById(id);
        }else{
            return "redirect:/materia/list";
        }
        model.addAttribute("title", "Editar Materia");
        model.addAttribute("materia", materia);
        return "tform";
    }

    @PostMapping("/materia/form")
    public String save(@Valid Materia materia, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registrar Materias");
            return "tform";
        }
        materiaService.save(materia);
        return "redirect:/materia/list";
    }

    @GetMapping("/materia/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0) {
            materiaService.delete(id);
        }
        return "redirect:/materia/list";
    }
}