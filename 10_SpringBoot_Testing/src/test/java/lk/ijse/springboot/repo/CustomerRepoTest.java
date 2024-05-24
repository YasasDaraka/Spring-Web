package lk.ijse.springboot.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepoTest {
    @Autowired
    private CustomerRepo repo;

    @Test
    public void testGetAll() {
        System.out.println(repo.findAll());
    }
}