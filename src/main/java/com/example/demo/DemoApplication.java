package com.example.demo;

import com.example.demo.Model.Task;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(TaskRepository repository){

        return (args) -> {


            //save some sample data
            repository.save(new Task("Learn Spring Boot", new Date()));
            repository.save(new Task("Re-learn React", new Date()));
            repository.save(new Task("Learn reflux", new Date()));

            //query sample data

            log.info("All saved tasks:\n");

            for(Task task: repository.findAll()){
                log.info(task.toString());
            }

            log.info("\n");

            //find a task by id

            Optional<Task> foundTask = repository.findById(1L);

            foundTask.ifPresent(task -> {
                log.info("Found task:\n" + task.toString());
            });


        };
    }
}
