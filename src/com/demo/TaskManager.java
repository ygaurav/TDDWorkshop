package com.demo;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {
    private static final AtomicInteger count = new AtomicInteger(0);
    public ArrayList<Task> taskList =new ArrayList<>();

    public int addTask(String taskName)
    {
        if(taskName!=null&&taskName!="") {
           String parsedDates= taskName.substring(taskName.indexOf("@"),taskName.length());
            String[] dates=parsedDates.split("@");
            Task task=new Task();
            int id=0;
            for(int i=1;i<dates.length;i++)
            {
                Date dateObj = null;
                try {
                    dateObj = new SimpleDateFormat("dd/MM/yyyy").parse(dates[i]);
                    if(i==dates.length)
                    {
                        task.setDeadline(dateObj);
                    }


                } catch (Exception ex) {
                    return -1;
                }
            }
            id=count.incrementAndGet();
            task.setId(id);
            task.setDescription(taskName);
            if(taskList.add(task))
                return id;
            else {
                count.decrementAndGet();
                return -1;
            }
        }
        else
            return -1;
    }
     public  Task getTask(int id)
     {
         for(Task task:taskList) {
             if (task.getId() == id)
                 return task;
         }
         return null;
     }

     public int getTaskCount()
     {
         return taskList.size();
     }

     public String deleteTaskById(int id)
     {
       for(Task task:taskList){
           if(task.getId()==id)
               taskList.remove(task);
       }
         return "Cannot task with id "+id+" as not added";
     }


}
