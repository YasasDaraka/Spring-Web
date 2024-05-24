package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form")
public class B_X_WWW_Url_Encoded_Controller {
    //02 X-WWW-Form-Url-Encoded
    // @RequestParam
    @PostMapping("/a")
    public String receiveDataWithFormData(String id, String name, String address) {
        return "X-WWW-Form-URL-Encoded-Data : " + id + " " + name + " " + address;
    }

    // @Model Attribute
    @PostMapping
    public String receiveData(@ModelAttribute CustomerDTO dto) {
        return "X-WWW-Form-URL-Encoded-Data : " +dto;
    }
}
