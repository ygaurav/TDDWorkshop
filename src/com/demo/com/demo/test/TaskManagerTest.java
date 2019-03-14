package com.demo.com.demo.test;

import com.demo.TaskManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {
    TaskManager taskManager;
    @Test
    public void testAddTaskForNull(){
        taskManager=new TaskManager();
        Assert.assertEquals(-1,taskManager.addTask(null));
    }

    @Test
    public void testAddTaskForEmpty(){
        taskManager=new TaskManager();
        Assert.assertEquals(-1,taskManager.addTask(""));
    }

    @Test
    public void testAddTaskWithCorrectInput(){
        taskManager=new TaskManager();
        Assert.assertEquals(1,taskManager.addTask("Commit Code"));
    }

    //Test for getTask
    @Test
    public void testGetTaskWithCorrectId(){
        taskManager=new TaskManager();
        taskManager.addTask("test");
        Assert.assertEquals("test",taskManager.getTaskById(1));
    }

    @Test
    public void testGetTaskWithInCorrectId(){
        taskManager=new TaskManager();
        taskManager.addTask("test");
        Assert.assertEquals("No Task Added with that key",taskManager.getTaskById(2));
    }

    //Test
}

