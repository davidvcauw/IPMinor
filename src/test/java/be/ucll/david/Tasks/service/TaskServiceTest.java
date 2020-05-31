package be.ucll.david.Tasks.service;

import be.ucll.david.Tasks.dto.SubTaskDTO;
import be.ucll.david.Tasks.dto.TaskDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TasksService service;

    private TaskDTO taskdto;
    private SubTaskDTO subTask;


    @BeforeEach
    public void setUp() {
        taskdto = new TaskDTO();
        taskdto.setDescription("description");
        taskdto.setTitle("title");
        taskdto.setDate(LocalDateTime.of(2000,1,1,1,1,1));
        taskdto.setId(1);


        subTask = new SubTaskDTO();
        subTask.setDescription("subdescription");
        subTask.setTitle("subtitle");
    }

    @Test
    public void addTaskTest() {
        service.addTask(taskdto);

        TaskDTO dto = service.getTask((long)1);

        assertNotNull(dto);
        assertEquals(dto.getDescription(), "description");
        assertEquals(dto.getTitle(), "title");
        assertEquals(dto.getDate(), LocalDateTime.of(2000,1,1,1,1,1));
    }
    @Test
    public void editTaskTest() {
        service.addTask(taskdto);

        TaskDTO dto = new TaskDTO();
        dto.setTitle("title 2");
        dto.setDescription("description");
        dto.setDate(LocalDateTime.of(2000,1,1,1,1,1));

        service.editTask(1, dto);

        TaskDTO dto2 = service.getTask((long)1);


        assertNotNull(dto2);
        assertEquals(dto2.getDescription(), "description");
        assertEquals(dto2.getTitle(), "title 2");
        assertEquals(dto2.getDate(), LocalDateTime.of(2000,1,1,1,1,1));

    }
}
