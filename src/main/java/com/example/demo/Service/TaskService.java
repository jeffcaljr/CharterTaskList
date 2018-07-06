package com.example.demo.Service;


import com.example.demo.Model.Task;
import com.example.demo.Exception.TaskNotFoundException;
import com.example.demo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskService {

    public TaskService(){}

    @Autowired
    private TaskRepository repository;

    public Iterable<Task> getAllTasks(){
         return repository.findAll();
    }

    public void deleteTask(long taskId){
        repository.deleteById(taskId);
    }

    public Task getTaskById(long id) throws TaskNotFoundException {

        Task foundTask = repository.findById(id).orElseThrow(TaskNotFoundException::new);

        return foundTask;
    }

    public void updateTaskWithId(long id, Task task) throws TaskNotFoundException{

        Task foundTask = repository.findById(id).orElseThrow(TaskNotFoundException::new);

        foundTask.setTask(task.getTask());

        repository.save(foundTask);
    }

    public Task saveNewTask(String taskString, Date date){
        Task newTask = new Task(taskString, date);
        repository.save(newTask);

        return newTask;
    }
}
