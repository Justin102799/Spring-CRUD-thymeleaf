package com.example.demo.Controller;

import com.example.demo.Entity.TaskEntity;
import com.example.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    //    @GetMapping("/")
//    public String viewHomePage(Model model){
//        return findPaginated(1, "title", "asc", model);
//    }
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listTasks", taskService.getAllTasks());
        return "/index/index";
    }



    @GetMapping("/showTaskForm")
    public String showTaskForm(Model model){
        TaskEntity taskEntity = new TaskEntity();
        model.addAttribute("task", taskEntity);
        return "/index/add_task";
    }

    @PostMapping("/saveTask")//@PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") TaskEntity taskEntity){
        taskService.saveTask(taskEntity);
        return "redirect:/";
    }

    @GetMapping("/showUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        TaskEntity taskEntity = taskService.getTaskId(id);
        model.addAttribute("task", taskEntity);
        return "index/update_task";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable(value = "id") long id){
        this.taskService.deleteTaskById(id);
        return "redirect:/";
    }

//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDir") String sortDir,
//                                Model model){
//        int pageSize = 5;
//
//        Page <TaskEntity> page = taskService.findPaginated(pageNo, pageSize, sortField, sortDir);
//        List <TaskEntity> listTasks = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sorDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("listTasks", listTasks);
//        return "index";
    //}

}
