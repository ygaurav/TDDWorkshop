using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TDDWeb.Models
{
    public class TaskManager
    {
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
    }
}