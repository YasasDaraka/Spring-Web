package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/a")
public class CustomerController {
    @GetMapping
    public String getMappingTest() {
        return "getMappingTest invoked";
    }

    @PostMapping
    public String postMappingTest() {
        return "postMappingTest invoked";
    }

    @PutMapping
    public String putMappingTest() {
        return "putMappingTest invoked";
    }

    @DeleteMapping
    public String deleteMappingTest() {
        return "deleteMappingTest invoked";
    }

    /*@GetMapping
    public String getMappingTest(HttpServletRequest req, HttpServletResponse rsp) {
        String id = req.getParameter("id");
        System.out.println(id);
        return "Get" + id;
    }*/
}
