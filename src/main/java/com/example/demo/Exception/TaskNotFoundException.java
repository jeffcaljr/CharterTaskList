package com.example.demo.Exception;

public class TaskNotFoundException extends RuntimeException {


    public TaskNotFoundException(){
        super();
    }

    public TaskNotFoundException(String msg){
        super(msg);
    }


}
