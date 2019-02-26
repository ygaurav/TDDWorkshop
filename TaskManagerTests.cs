using System;
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
            Assert.IsNotNull(result);
        }
    }
}
