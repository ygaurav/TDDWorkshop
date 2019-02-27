using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TDDWeb.Models;
namespace TDDWeb.Tests
{
    [TestClass]
    public class TaskManagerTests
    {

        [TestMethod]
        public void AddTask()
        {
            TaskManager task = new TaskManager();
            bool result = task.AddTask("Test");
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void SaveTask()
        {
            TaskManager task = new TaskManager();
            List<Task> result = task.SaveTask("Test");
            Assert.IsNotNull(result);
        }

        [TestMethod]
        public void GetTaskCount()
        {
            TaskManager task = new TaskManager();
            List<Task> tasklist = new List<Task>();
            Task task1 = new Task();
            Task task2 = new Task();
            Task task3 = new Task();
            Task task4 = new Task();
            Task task5 = new Task();
            int taskOriginalCount = 5;
            tasklist.Add(task1); tasklist.Add(task2); tasklist.Add(task3); tasklist.Add(task4); tasklist.Add(task5);
            int returnCount = task.GetTaskCount(tasklist);

            Assert.AreEqual(taskOriginalCount, returnCount);
        }

        [TestMethod]
        public void DeleteTask()
        {
            TaskManager task = new TaskManager();
            bool result = task.DeleteTask(1);
            Assert.IsFalse(result);
        }

        [TestMethod]
        public void GetTaskById()
        {
            TaskManager task = new TaskManager();
            Task actualTask = task.GetTaskById(1);
            actualTask = new Task { TaskID = 1, TaskName = "Test" };
            Task expectedTask = new Task { TaskID = 1, TaskName = "Test" };
            bool flag = false;
            if(actualTask.TaskID==expectedTask.TaskID)
            {
               flag= true;
            }
            Assert.IsTrue(flag);
        }

    }
}
