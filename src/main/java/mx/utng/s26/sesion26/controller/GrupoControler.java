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
import mx.utng.s26.sesion26.model.entity.Grupo;
import mx.utng.s26.sesion26.model.service.GrupoService;

@Controller
@SessionAttributes("grupo")
public class GrupoControler {
    //inyectamos un a dependencias del servicio 
    @Autowired
    private GrupoService grupoService;

    //Manda llamar este metodo en una petición GET
    //Que cocntenga como final de la querystring "","/", "/list"
    @GetMapping({"/grupo/list","/grupo","/grupo/"})
    public String list(Model model){
        model.addAttribute("Title", "Listado de Grupos");
        model.addAttribute("grupos", grupoService.list());
        return "glist";
    }

    //Petición que contenga al final de la url /form
    @GetMapping("/grupo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Registrar Grupos");
        model.addAttribute("grupo", new Grupo());
        return "gform";
    }

    @GetMapping("/grupo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Grupo grupo = null;
        if(id>0){
            grupo = grupoService.getById(id);
        }else{
            return "redirect:/grupo/list";
        }
        model.addAttribute("title", "Editar Grupo");
        model.addAttribute("grupo", grupo);
        return "gform";
    }

    @PostMapping("/grupo/form")
    public String save(@Valid Grupo grupo, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Registrar Grupos");
            return "gform";
        }
        grupoService.save(grupo);
        return "redirect:/grupo/list";
    }

    @GetMapping("/grupo/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0) {
            grupoService.delete(id);
        }
        return "redirect:/grupo/list";
    }
}