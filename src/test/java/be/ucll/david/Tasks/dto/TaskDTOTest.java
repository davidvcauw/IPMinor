package be.ucll.david.Tasks.dto;

import be.ucll.david.Tasks.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SubTaskDTO.class)
public class TaskDTOTest {
    private TaskDTO task;

    @BeforeEach
    public void setUp() {
        this.task = new TaskDTO();
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
