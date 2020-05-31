package be.ucll.david.Tasks.dto;


import be.ucll.david.Tasks.model.SubTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SubTaskDTO.class)
public class SubTaskDTOTest {
    private SubTaskDTO subTask;

    @BeforeEach
    public void setUp() {
        this.subTask = new SubTaskDTO();
    }

    @Test
    public void testSetTitle() {
        subTask.setTitle("test");
        assertEquals("test", subTask.getTitle());
    }
    @Test
    public void testSetDescription() {
        subTask.setDescription("test");
        assertEquals("test", subTask.getDescription());
    }

    @Test
    public void testSetSuperTaskId() {
        subTask.setSuperTaskId(17);
        assertEquals(17, subTask.getSuperTaskId());
    }
}
