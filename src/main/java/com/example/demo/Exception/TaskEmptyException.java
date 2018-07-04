package com.example.demo.Exception;

public class TaskEmptyException extends TaskNotFoundException {

    public TaskEmptyException(){
        super();
    }

    public TaskEmptyException(String msg){
        super(msg);
    }
}
