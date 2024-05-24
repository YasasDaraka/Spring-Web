package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/json")
public class C_JSON_Controller {
    //03 JSON
    //@RequestBody -> HTTP Converters
    @PostMapping
    public String receiveDataWithJson(@RequestBody CustomerDTO dto){
        return "Json Data : "+dto.toString();
    }

    @GetMapping
    public ArrayList<CustomerDTO> sendJsonData(){
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO("C001","John","Galle",5000,"0771234567",null));
        allCustomers.add(new CustomerDTO("C002","Tommy","Matara",1000,"0777654321",null));
        return allCustomers;
    }

    /*@PutMapping
    public CustomerDTO receiveDataWithJson(@RequestBody CustomerDTO dto) {
        return dto;
    }*/
}
