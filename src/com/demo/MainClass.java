package com.demo;

public class MainClass {
    public static void main(String args[]){
        TaskManager taskManager=new TaskManager();
        System.out.println(taskManager.addTask("hello"));
        System.out.println(taskManager.addTask("Hi"));
        System.out.println(taskManager.addTask("Bye"));
        System.out.println(taskManager.getTask(5));
    }
}
