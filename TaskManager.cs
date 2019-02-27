using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TDDWeb.Models
{
    public class Task
    {
        public int TaskID { get; set; }
        public string TaskName { get; set; }
    }

    public class TaskManager
    {

        Task task { get; set; }
        public bool AddTask(string task)
        {
            if (string.IsNullOrEmpty(task))
            {
                return false;
            }
            else
            {
                return true;
            }

        }


        public List<Task> SaveTask(string taskname)
        {
            task = new Task();
            List<Task> arrTasks = new List<Task>();

            if (!string.IsNullOrEmpty(taskname))
            {
                task.TaskID++;
                task.TaskName = taskname;
                arrTasks.Add(task);
            }
            else if (task.TaskID == -1 || task.TaskID == 0)
            {
                return arrTasks;
            }

            return arrTasks;
        }

        public int GetTaskCount(List<Task> list)
        {
            return list.Count;

        }

        public Task GetTaskById(int TaskId)
        {
            List<Task> taskList = new List<Task>();
            Task task = taskList.Where(x => x.TaskID == TaskId).FirstOrDefault();
            return task;
        }
        public bool DeleteTask(int TaskID)
        {
            List<Task> taskList = new List<Task>();
            Task task = taskList.Where(x => x.TaskID == TaskID).FirstOrDefault();
            if (task != null)
            {
                taskList.Remove(task);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

   
}