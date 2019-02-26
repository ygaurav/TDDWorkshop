package com.wurthit;

import junit.framework.TestCase;

public class TaskManagerTest extends TestCase {

    TaskManager taskManager;

    public void setUp() throws Exception {
        super.setUp();
        taskManager = new TaskManager();
    }

    public void testShouldReturnFalseForNullString() {
        assertFalse(taskManager.addTask(null));
    }

    public void testShouldReturnFalseForEmptyString() {
        assertFalse(taskManager.addTask(""));
    }

    public void testShouldReturnTrueForNonNullNonEmptyString() {
        assertTrue(taskManager.addTask("abc"));
    }
}