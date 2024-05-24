package lk.ijse.springboot.service;

import lk.ijse.springboot.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<CustomerDTO> getAllCustomers();

    CustomerDTO searchCustomer(String id);

    void saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String id);
}
