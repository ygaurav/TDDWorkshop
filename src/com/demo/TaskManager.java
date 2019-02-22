package com.demo;

public class TaskManager {

    public boolean addTask(String taskName)
    {
        if(taskName!=null&&taskName!="")
            return true;
        else
            return false;
    }
}
