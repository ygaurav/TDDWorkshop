package com.demo;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]){
        TaskManager taskManager=new TaskManager();

        System.out.println(taskManager.addTask("Bye @12/12/1111 @12/11/1111"));
        System.out.println();
    }
}
