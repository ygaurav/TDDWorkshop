package com.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManager {
    private static final AtomicInteger count = new AtomicInteger(0);
    public ArrayList<Task> taskList =new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public int addTask(String taskName)
    {
        if(taskName!=null&&taskName!="") {
            Pattern pattern = Pattern.compile("@[^ ][\\w\\W][^ ]+");
            Matcher matcher = pattern.matcher(taskName);
            Task task = new Task();
            Date  deadline = null;
            List<Date> dates = new ArrayList<>();
            int invalidDateCount = 0,validDateCount=0;
            while (matcher.find()) {
                String parsedDate=matcher.group().substring(1);
                Date dateObj = null;
                try {
                    dateFormat.setLenient(false);
                    dateObj = dateFormat.parse(parsedDate);
                    dates.add(dateObj);
                    validDateCount++;
                } catch (Exception ex) {
                    invalidDateCount++;
                }
            }
            if (dates.size() > 0) {
                 deadline = dates.get(dates.size() - 1);
                task.setDeadline(deadline);
            }
             else {
                try {
                    String sevenDays = dateFormat.format(new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)));
                    task.setDeadline(dateFormat.parse(sevenDays));
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (invalidDateCount <= 0||validDateCount>0){
                int id = count.incrementAndGet();
                task.setId(id);
                task.setDescription(taskName);
                taskList.add(task);
                return id;
            }
            else {
                return -1;
            }
        }
        else
            return -1;
    }
     public  String getTaskById(int id) {
        String taskDesp;
         for (Task task : taskList) {
             if (task.getId() == id) {
                 taskDesp=task.getDescription();
                 return taskDesp+" Deadline "+dateFormat.format(task.getDeadline());
             }
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

    public List<Task> getDeadlinePastTask()
    {
        List<Task> passedTask=new ArrayList<>();
        for(Task task:taskList)
        {
            if(task.getDeadline().compareTo(new Date(System.currentTimeMillis()))<0)
            {
                passedTask.add(task);
            }
        }
        return passedTask;
    }
}
