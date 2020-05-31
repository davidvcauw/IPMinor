package be.ucll.david.Tasks.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Task.class)
public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        this.task = new Task();
    }

    @Test
    public void testConstructor() {
        Task t = new Task("a", "b", LocalDateTime.MIN);
        assertEquals("a", t.getTitle());
        assertEquals("b", t.getDescription());
        assertEquals(LocalDateTime.MIN, t.getDate());
    }



    @Test
    public void testSetTitle() {
        task.setTitle("test");
        assertEquals("test", task.getTitle());
    }

    @Test
    public void testSetDescription() {
        task.setDescription("test");
        assertEquals("test", task.getDescription());
    }

    @Test
    public void testSetDate() {
        task.setDate(LocalDateTime.MAX);
        assertEquals(LocalDateTime.MAX, task.getDate());
    }
}
