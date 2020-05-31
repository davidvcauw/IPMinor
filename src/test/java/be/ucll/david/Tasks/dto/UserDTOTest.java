package be.ucll.david.Tasks.dto;

import be.ucll.david.Tasks.model.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UserDTO.class)
public class UserDTOTest {

    private UserDTO user;

    @BeforeEach
    public void setUp() {
        this.user = new UserDTO();
    }

    @Test
    public void testSetName() {
        user.setUsername("jozef");
        assertEquals("jozef", user.getUsername());
    }

    @Test
    public void testSetRole() {
        user.setRole(UserRole.ADMIN);
        assertEquals(UserRole.ADMIN, user.getRole());
    }

    @Test
    public void testSetId() {
        user.setId((long)1234);
        assertEquals((long)1234, user.getId());
    }
}
