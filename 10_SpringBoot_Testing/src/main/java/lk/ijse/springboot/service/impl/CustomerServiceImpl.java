package lk.ijse.springboot.service.impl;

import lk.ijse.springboot.dto.CustomerDTO;
import lk.ijse.springboot.entity.Customer;
import lk.ijse.springboot.repo.CustomerRepo;
import lk.ijse.springboot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {}.getType());
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (!repo.existsById(id)) throw new RuntimeException("Id not exists !");
        return mapper.map(repo.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getId())) throw new RuntimeException("Error, Already added!");
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) throw new RuntimeException("Id not exists !");
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {
        if (!repo.existsById(id)) throw new RuntimeException("Id not exists !");
        repo.deleteById(id);
    }
}
