package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/segment")
public class B_Path_Segments_Controller {
    //request narrow downing using path segments
    //localhost:8080/mapping/segment/two
    @GetMapping(path = "/two")
    public String getMapping2(){
        return "Get Mapping Invoked 2";
    }

    //localhost:8080/mapping/segment/three
    @GetMapping(path = "/three")
    public String getMapping3(){
        return "Get Mapping Invoked 3";
    }

    //localhost:8080/mapping/segment/three/four
    @GetMapping(path = "/three/four")
    public String getMapping4(){
        return "Get Mapping Invoked 3/4";
    }
}
