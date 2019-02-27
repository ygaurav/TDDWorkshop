/*using System;
using System.Collections.Generic;

namespace ConsoleApp1
{
    class TaskManager
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hi");
            Console.Read();


            //TaskManager S1 = new TaskManager();
            // bool b1 = S1.AddTask("");

            //Console.WriteLine(b1);

            //List<string> AuthorList = new List<string>();
            /*Boolean AddTask(String s)
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
            Int64 Task_01()
            {
                Int64 var = 0;


                return -1;
            }*/


        

        /* void NewTask()
         {
             TaskManager s2 = new TaskManager();

         }

         int public CheckTaskId(int var)
         {

             List<int> Task = new List<int>();
             for (int runs = 0; runs < 10; runs++)
             {
                 Task.Add(runs);
                 Console.Read();
             }
             return -1;
         }

         // You can convert it back to an array if you would like to


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
   

using System;
using System.Collections;

namespace ConsoleApp1
{
    class Program
    {
        static void Main()
        {// Program Obj1 = new Program();
            ArrayList ar = new ArrayList();
            String Task_01()
            {
                return "one";
            }
            String Task_02()
            {
                return "two";
            }
            String Task_03()
            {
                return "three";
            }
            ar.Add(Task_01());
            ar.Add(Task_02());
            ar.Add(Task_03());
           

            // Count the elements in the ArrayList.
            int c = ar.Count;
            Console.WriteLine(c);
           Console.WriteLine("Enter one, two , three");
           String s1= Console.ReadLine();
           FindTask(s1);
            Console.WriteLine("Enter a task(one ,two, three) to delete");
            String Userinput = Console.ReadLine();
            int i = FindTask(Userinput);
            DeleteTask(i);
            
            

            void DeleteTask(int taskid)
                {
               
                ar.RemoveAt(taskid + 1);
                for (int j = 0; j < ar.Count; j++)
                {
                    Console.WriteLine(ar[j]);
                }
            }
            int FindTask(string s2)
            {

                if (ar.Contains(s1))
                { //int pos = ar.IndexOf(ar, s1);
                    Console.WriteLine("TaskId");
                   
                    int index= ar.IndexOf(s1);
                    Console.WriteLine(index+1);
                    Console.Read();
                    return index;
                } 
                else
                return -1;
                
            }
         
        }
       
    }
}