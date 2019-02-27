export class TaskManager {

   public TaskCreate: Task[] = [];
   public task_id: number = 1;

   AddTask(input: string): number {
      if (input === null && input == "")
         return 0;
      else {
         this.task_id += this.task_id;
         var TaskCreated = new Task();
         TaskCreated.index = this.task_id;
         TaskCreated.task = input;
         if (this.task_id == 1) {
            this.TaskCreate.push(TaskCreated);
         }
         else
            this.TaskCreate.push(TaskCreated);

         return this.task_id;
      }
   }

   GetTaskCount() {
      console.log('this.TaskCreate.length', this.TaskCreate.length);
      return this.TaskCreate.length;
   }

   removeTask(index) {
      this.TaskCreate.splice(index);
      return 1;
   }

}

export class Task {
   public index: number;
   public task: string;

}