package be.ucll.david.Tasks.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = User.class)
public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        this.user = new User();
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
    public void testSetPassword() {
        user.setPassword("test");
        assertEquals("test", user.getPassword());
    }

    @Test
    public void testSetId() {
        user.setId((long)1234);
        assertEquals((long)1234, user.getId());
    }
}
