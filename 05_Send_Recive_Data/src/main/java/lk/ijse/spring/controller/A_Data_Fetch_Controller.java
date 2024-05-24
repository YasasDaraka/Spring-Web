package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fetch")
public class A_Data_Fetch_Controller {
    //01 Query String
    // @RequestParam
    @GetMapping(params = {"id","name"})
    public String receiveDataWithQueryString(String id,@RequestParam String name){
        return "Query String data : "+id+", "+name;
    }
}
