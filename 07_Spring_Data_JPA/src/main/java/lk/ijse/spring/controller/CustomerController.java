package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin // Enable Cross-Origin Resource Sharing (CORS) for this controller
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepo repo;

    public CustomerController() {
        System.out.println("CustomerController");
    }

    // get all
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer c : all) {
            customerDTOS.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress()));
        }
        return customerDTOS;
    }

    // find
    @GetMapping(params = {"id"})
    public CustomerDTO findCustomer(String id) {
        Customer c = repo.findById(id).get();
        return new CustomerDTO(c.getId(), c.getName(), c.getAddress());
    }

    // add
    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO dto) {
        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        repo.save(customer);
    }

    // update
    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO dto) {
        if (repo.findById(dto.getId()).isPresent()) { // check if customer exists
            Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
            repo.save(customer);
        }
    }

    // delete
    @DeleteMapping(params = {"id"})
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }
}
