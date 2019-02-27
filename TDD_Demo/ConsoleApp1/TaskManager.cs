using System;
namespace ConsoleApp1
{
    class TaskManager
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hi");
      
            TaskManager S1 = new TaskManager();
            bool b1 = S1.AddTask("");

            Console.WriteLine(b1);
        }
        Boolean AddTask(String s)
        {
            // Console.WriteLine("Hi");
            if (String.IsNullOrEmpty(s))
            {
                Console.WriteLine("string is empty");
                Console.Read();
                return false;
            }
            else
            {
                Console.WriteLine("string is not empty");
                Console.Read();
                return true;
            }

        }
        
    }
}
/*public class TaskManager
{
   public Boolean AddTask(String s)
    {
        if (String.IsNullOrEmpty(s))
        { return false; }
        else
        {
            Console.WriteLine("string is not empty");
            return true;
        }
            
    }
}*/
