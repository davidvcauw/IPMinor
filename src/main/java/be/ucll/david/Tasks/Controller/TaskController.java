package be.ucll.david.Tasks.Controller;


import be.ucll.david.Tasks.service.TasksService;
import be.ucll.david.Tasks.dto.SubTaskDTO;
import be.ucll.david.Tasks.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TasksService taskService;


    /*@RequestMapping("/")
    public String temp(Model model) {
        return tasks(model);
    }*/

    @RequestMapping("tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks",taskService.getAllTasks());
        return "tasks";
    }


    @GetMapping("tasks/{id}")
    public String individualTask (@PathVariable("id") long id, Model model) {

        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("idnr", id);
        model.addAttribute("subtasks", taskService.getSubTasksById((int)id));
        return "individualTask";
    }

    @GetMapping("tasks/new")
    public String newTask(Model model) {
        return "newTask";
    }

    @PostMapping("tasks/new")
    public String newTaskPost(@ModelAttribute TaskDTO task, BindingResult result) {

          if (result.hasErrors()) {
              return "newTask";
          } else {
            long id = taskService.addTask(task);
            return "redirect:/tasks/"+id;
          }
    }

    @GetMapping("tasks/edit/{id}")
    public String getEditform(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("idnr", id);

        return "editTask";

    }

    @PostMapping("tasks/edit")
    public String EditTask(@ModelAttribute TaskDTO task, int id, Model model) {
        taskService.editTask(id, task);

        return "redirect:/tasks/" + id;
    }

    @GetMapping("tasks/{id}/sub/create")
    public String getCreateSubTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("idnr", id);
        return "newSubTask";
    }

    @PostMapping("tasks/sub/create")
    public String CreateNewSubTask(@ModelAttribute @Valid SubTaskDTO subtask) {
        taskService.addSubTask(subtask);
        return "redirect:/tasks/" + subtask.getSuperTaskId();
    }
}
