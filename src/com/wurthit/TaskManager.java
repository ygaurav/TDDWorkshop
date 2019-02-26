package com.wurthit;

public class TaskManager {

    public boolean addTask(String taskString) {

        return taskString != null && !taskString.equals("");

    }

}
