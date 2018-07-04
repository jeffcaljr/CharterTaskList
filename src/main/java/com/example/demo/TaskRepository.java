package com.example.demo;


import com.example.demo.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TaskRepository extends CrudRepository<Task, Long> {

}
