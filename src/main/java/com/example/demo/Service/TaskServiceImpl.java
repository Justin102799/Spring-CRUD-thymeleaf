package com.example.demo.Service;

import com.example.demo.Entity.TaskEntity;
import com.example.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(TaskEntity taskEntity) {
        this.taskRepository.save(taskEntity);
    }

    @Override
    public TaskEntity getTaskId(long id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);
        TaskEntity taskEntity = null;
        if (optional.isPresent()) {
            taskEntity = optional.get();
        } else {
            throw new RuntimeException(" Task not found for id :: " + id);
        }
        return taskEntity;
    }

    @Override
    public void deleteTaskById(long id) {
        this.taskRepository.deleteById(id);
    }

}