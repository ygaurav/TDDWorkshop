export class TaskManager {

    AddTask (input:string): boolean {
        if (input === null && input == "")
           return false;
        else   
           return true;
    }
  
  }