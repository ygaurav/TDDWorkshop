package com.demo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {
    private static final AtomicInteger count = new AtomicInteger(0);
    public HashMap<Integer,String> taskList=new HashMap<>();

    public int addTask(String taskName)
    {
        int id=count.incrementAndGet();
        taskList.put(id,taskName);
        return id;
    }
     public  String getTask(int id)
     {
         if(taskList.get(id)==null)
            return "No Task Added with that key";
         else
             return taskList.get(id);
     }

     public int getTaskCount()
     {
         return taskList.size();
     }
}
