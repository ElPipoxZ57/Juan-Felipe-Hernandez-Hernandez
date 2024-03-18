package mx.utng.s26.sesion26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactoController {
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}
