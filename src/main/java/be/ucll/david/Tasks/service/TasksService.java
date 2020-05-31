package be.ucll.david.Tasks.service;

import be.ucll.david.Tasks.model.SubTask;
import be.ucll.david.Tasks.model.Task;
import be.ucll.david.Tasks.repository.SubTaskRepo;
import be.ucll.david.Tasks.repository.TaskRepo;
import be.ucll.david.Tasks.dto.SubTaskDTO;
import be.ucll.david.Tasks.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TasksService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private SubTaskRepo subtaskRepo;


    public TasksService() {
        //this.taskRepo = taskRepo;
        //this.subtaskRepo = subtaskRepo;
    }

    /*@Override
	public List<HeadDTO> getHeads() {
		return repository.findAll().stream().map(h -> {
			HeadDTO dto = new HeadDTO();
			dto.setDateAndTimeOfBeheading(h.getDateAndTimeOfBeheading());
			dto.setDecapitated(h.isDecapitated());
			dto.setOwner(h.getOwner());
			return dto;
		}).collect(Collectors.toList());
	}
*/

    private TaskDTO makeTaskDTO(Task t) {
        TaskDTO dto = new TaskDTO();
        dto.setTitle(t.getTitle());
        dto.setDescription(t.getDescription());
        dto.setDate(t.getDate());
        dto.setId(t.getId());
        return dto;
    }

    private Task makeTask(TaskDTO dto) {
        Task t = new Task();
        t.setDate(dto.getDate());
        t.setDescription(dto.getDescription());
        t.setTitle(dto.getTitle());
        return t;
    }

    private SubTaskDTO makeSubTaskDTO(SubTask st) {
        SubTaskDTO dto = new SubTaskDTO();
        dto.setDescription(st.getDescription());
        dto.setSuperTaskId(st.getSuperTaskId());
        dto.setTitle(st.getTitle());
        return dto;
    }

    private SubTask makeSubTask(SubTaskDTO dto) {
        SubTask st = new SubTask();
        st.setTitle(dto.getTitle());
        st.setSuperTaskId(dto.getSuperTaskId());
        st.setDescription(dto.getDescription());
        return st;
    }



    public List<TaskDTO> getAllTasks() {
        return taskRepo.findAll().stream().map(h -> {
            return makeTaskDTO(h);
        }).collect(Collectors.toList());
    }

    public TaskDTO getTask(Long id) {
        Optional<Task> opt = taskRepo.findById(id);
        if (opt.isPresent()) {
            Task t =  taskRepo.findById(id).get();
            TaskDTO dto = makeTaskDTO(t);
            return dto;
        }
        return null;
    }

    public long addTask(TaskDTO dto) {
        return taskRepo.save(makeTask(dto)).getId();
    }

    public void editTask(int id, TaskDTO task) {
        taskRepo.UpdateTask(id, task.getTitle(), task.getDescription(), task.getDate());
    }

    public List<SubTaskDTO> getSubTasksById(int id) {
        return subtaskRepo.findAllBySuperTaskId(id).stream().map(h-> {
            return makeSubTaskDTO(h);
        }).collect(Collectors.toList());
    }

    public void addSubTask(SubTaskDTO dto) {
        SubTask st = makeSubTask(dto);
        subtaskRepo.save(st);
    }
}
