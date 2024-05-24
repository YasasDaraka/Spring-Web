package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    //Query methods
    List<Customer> findCustomerByAddress(String address);

    int countCustomerByAddress(String address);

    boolean existsCustomerByAddress(String address);

    void deleteCustomerByAddress(String address);

    //Custom Queries
    // 1. Native query
    @Query(value = "select * from Customer",nativeQuery = true)
    List<Customer> getAllCustomers1();

    // 2. JPQL
    @Query(value = "select c from Customer c")
    List<Customer> getAllCustomers2();

    // 3. HQL
    @Query(value = "from Customer c")
    List<Customer> getAllCustomers3();

    // named parameters
    @Query(value = "select * from Customer where name=:nm",nativeQuery = true)
    List<Customer> searchCustomerWithName(@Param("nm") String name);

    // Positional parameters
    @Query(value = "select * from Customer where name=?1 and address=?2 ",nativeQuery = true)
    List<Customer> searchCustomerWithName(String name, String address);
}
