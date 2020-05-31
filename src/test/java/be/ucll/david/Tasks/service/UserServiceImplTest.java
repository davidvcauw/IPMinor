package be.ucll.david.Tasks.service;


import be.ucll.david.Tasks.dto.CreateUserDTO;
import be.ucll.david.Tasks.dto.UserDTO;
import be.ucll.david.Tasks.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceImplTest {
    /*
    @Autowired
    private UserService service;

    private CreateUserDTO testdto;


    @BeforeEach
    public void setUp() {
        testdto = new CreateUserDTO();
        testdto.setUsername("banaan");
        testdto.setPassword("appel");
    }

    /*@Test
    public void testCreateUser() {
        UserDTO dto = service.createUser(testdto);

        assertEquals("banaan", dto.getUsername());
    }


    @Test
    public void testLoadUser() {



    }*/
}
