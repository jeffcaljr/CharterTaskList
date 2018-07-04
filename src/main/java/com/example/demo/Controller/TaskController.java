package com.example.demo.Controller;


import com.example.demo.Exception.TaskEmptyException;
import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/todo/v1")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(method ={RequestMethod.GET})
    public Iterable<Task> getAllTasks(){

        Iterable<Task> tasks = taskService.getAllTasks();

        return tasks;
    }


    //TODO: Accept date param and use it to configure Task
    @RequestMapping(method ={ RequestMethod.POST})
    public void saveTask(@RequestParam("task") String taskName) throws TaskEmptyException {

        if(StringUtils.isEmpty(taskName)){
            throw new TaskEmptyException("The task field should not be empty");
        }

        taskService.saveNewTask(taskName, new Date());

    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.GET})
    public Task getTaskById(@PathVariable("id") long id){

        Task foundTask = taskService.getTaskById(id);

        return foundTask;

    }


    @RequestMapping(path = "/{id}", method = {RequestMethod.DELETE})
    public void deleteTask(@PathVariable("id") long id){

        taskService.deleteTask(id);

        log.info("Deleting task with id" + id);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT})
    public void updateTask(@PathVariable("id") long id,
                           @RequestBody Task task){

        log.info("Updating task " + id + " with date " + task.getDate());

        taskService.updateTaskWithId(id, task);
    }


}
