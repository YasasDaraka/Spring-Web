package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/http")
public class A_HTTP_Methods_Controller {
    @GetMapping
    public String getMapping1() {
        return "Get1";
    }

    // තව  @GetMapping එකක් දැම්මොත් Ambiguous mapping
   /* @GetMapping
    public String getMapping2() {
        return "Get2";
    }*/

    @PostMapping
    public String postMapping() {
        return "Post";
    }

    @PutMapping
    public String putMapping() {
        return "Put";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "Delete";
    }
}