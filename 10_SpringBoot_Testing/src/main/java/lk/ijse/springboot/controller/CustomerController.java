package lk.ijse.springboot.controller;

import lk.ijse.springboot.dto.CustomerDTO;
import lk.ijse.springboot.service.CustomerService;
import lk.ijse.springboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin // Enable Cross-Origin Resource Sharing (CORS) for this controller
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    public CustomerController() {
        System.out.println("CustomerController");
    }

    @ResponseStatus(HttpStatus.CREATED)
    // get all
    @GetMapping
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil("Ok", "Successfully Loaded", service.getAllCustomers());
    }

    // find
    @GetMapping(params = {"id"})
    public ResponseUtil findCustomer(String id) {
        return new ResponseUtil("Ok", "Successfully Searched", service.searchCustomer(id));
    }

    // add
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) {
        service.saveCustomer(dto);
        return new ResponseUtil("Ok", "Successfully Added", dto);
    }

    // update
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil("Ok", "Successfully Updated", dto);
    }

    // delete
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(String id) {
        service.deleteCustomer(id);
        return new ResponseUtil("Ok", "Successfully Deleted", id);
    }
}
