package com.example.demo.Service;

import com.example.demo.Entity.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> getAllTasks();
    void saveTask(TaskEntity taskEntity);
    TaskEntity getTaskId(long id);
    void deleteTaskById(long id);
//    Page <TaskEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
