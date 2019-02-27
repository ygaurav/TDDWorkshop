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
        public DateTime Deadline { get; set; }
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


        public List<Task> SaveTask(string TaskName)
        {
            task = new Task();
            List<Task> arrTasks = new List<Task>();
            try
            {
                if (!string.IsNullOrEmpty(TaskName))
                {

                    task.TaskID++;
                    task.TaskName = TaskName;
                    DateTime filtereddate = FilterDate(TaskName);
                    if (filtereddate != DateTime.MinValue)
                        task.Deadline = filtereddate;
                    else
                    {

                        return arrTasks;
                    }

                    arrTasks.Add(task);
                }
                else if (task.TaskID == -1 || task.TaskID == 0)
                {
                    return arrTasks;
                }
            }
            catch { }
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

        public List<Task> TaskDeadLinePassed()
        {
            List<Task> actualListofTask = new List<Task>();
            List<Task> deadlinePassed = new List<Task>();
            deadlinePassed = actualListofTask.Where(t => t.Deadline > DateTime.Now).ToList<Task>();
            return deadlinePassed;
        }

        private DateTime FilterDate(string stringdate)
        {
            string date = stringdate.Substring(stringdate.LastIndexOf('@') + 1);

            DateTime dateTime2;
            if (DateTime.TryParse(date, out dateTime2))
            {
                Console.WriteLine(dateTime2);
                DateTime dt = DateTime.Parse(date);
            }
            else
            {
                return DateTime.MinValue;
            }
            return Convert.ToDateTime(date);
        }
    }

   
}