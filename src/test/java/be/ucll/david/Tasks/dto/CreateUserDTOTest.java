package be.ucll.david.Tasks.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CreateUserDTO.class)
public class CreateUserDTOTest {
    private CreateUserDTO dto;

    @BeforeEach
    public void setUp() {
        this.dto = new CreateUserDTO();
    }


    @Test
    public void testSetUsername() {
        dto.setUsername("test");
        assertEquals("test", dto.getUsername());
    }
    @Test
    public void testSetPassword() {
        dto.setPassword("test");
        assertEquals("test", dto.getPassword());
    }
}
