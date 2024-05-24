package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {
    @Autowired
    CustomerRepo repo;

    // ======== testing a method ========
    @Test
    public void testGetAllCustomers() {
        List<Customer> all = repo.findAll();
        System.out.println(all);
    }

    // ======== testing query methods ========
    @Test
    public void test1() {
        // find customers by address
        System.out.println(repo.findCustomerByAddress("Galle"));
    }

    @Test
    public void test2() {
        // find customers count by address
        int count = repo.countCustomerByAddress("Galle");
        System.out.println(count);
    }

    @Test
    public void test3() {
        // find is exist customers by given address
        boolean isExist = repo.existsCustomerByAddress("Galle");
        System.out.println(isExist);
    }

    @Test
    public void test4() {
        // delete customers by given address
        repo.deleteCustomerByAddress("Galle");
    }

    // ======== testing custom queries ========
    @Test
    public void queryTest1() {
        // Native query
        System.out.println(repo.getAllCustomers1());

        // JPQL
        System.out.println(repo.getAllCustomers2());

        // HQL
        System.out.println(repo.getAllCustomers3());
    }

    // Named Parameters
    @Test
    public void namedParametersTest(){
        System.out.println(repo.searchCustomerWithName("John"));
    }

    // Positional Parameters
    @Test
    public void positionalParametersTest(){
        System.out.println(repo.searchCustomerWithName("John","Galle"));
    }
}