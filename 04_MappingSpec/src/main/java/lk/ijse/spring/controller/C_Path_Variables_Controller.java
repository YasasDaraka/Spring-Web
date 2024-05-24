package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathVariable")
public class C_Path_Variables_Controller {
    //@PathVariable -> required annotation
    @GetMapping(path = "/{name}")
    public String getMapping1(@PathVariable String name){
        return "Get Mapping Invoked 1 "+name;
    }

    @GetMapping(path = "/id/{name}")
    public String getMapping2(@PathVariable String name){
        return "Get Mapping Invoked 2 "+name;
    }

    @GetMapping(path = "/{id}/{name}")
    public String getMapping3(@PathVariable String id,@PathVariable String name){
        return "Get Mapping Invoked 3 "+id+" "+name;
    }

   /* @GetMapping(path = "/{id}")
    public String getMapping(@PathVariable("id") String ids){ //alias
        return "Get Mapping Invoked "+ids;
    }*/
}
