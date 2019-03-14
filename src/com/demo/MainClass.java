package com.demo;

import java.util.Scanner;

public class MainClass {

    public static void main(String args[]){
        TaskManager taskManager=new TaskManager();
        System.out.println(taskManager.addTask("Dinner @abc"));
        System.out.println(taskManager.addTask("Dinner @22/01/2019 @21/01/2019"));
        System.out.println(taskManager.addTask("Dinner @22-22-2019"));
        System.out.println(taskManager.addTask("Dinner with XYZ @01/01/2019"));
        System.out.println(taskManager.getTaskById(1));
        System.out.println(taskManager.getDeadlinePastTask());

    }
}
