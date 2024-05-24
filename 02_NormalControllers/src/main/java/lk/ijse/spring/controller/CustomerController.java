package lk.ijse.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/a")
public class CustomerController {
    @GetMapping
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("/customer"); // view name in webapps
        mv.addObject("Id","C001");
        return mv;
    }
}
