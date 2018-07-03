package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

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
    public void saveTask(@RequestParam("task") String taskName,
                         HttpServletRequest request,
                         HttpServletResponse response) throws TaskEmptyException{

        if(StringUtils.isEmpty(taskName)){
            throw new TaskEmptyException("The task field should not be empty");
        }

        taskService.saveNewTask(taskName, new Date());

    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.GET})
    public Task getTaskById(@PathVariable("id") long id,
                            HttpServletRequest request,
                            HttpServletResponse response){

        Task foundTask = taskService.getTaskById(id);

        return foundTask;

    }


    @RequestMapping(path = "/{id}", method = {RequestMethod.DELETE})
    public void deleteTask(@PathVariable("id") long id){

        taskService.deleteTask(id);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT})
    public void updateTask(@PathVariable("id") long id,
                           @RequestParam String task){

        log.info("Updating task " + id + " with taskString " + task);

        taskService.updateTaskWithId(id, task);
    }


}
