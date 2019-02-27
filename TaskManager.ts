export class TaskManager {

   public TaskCreate: any[];
   public task_id: number = 1;

   AddTask(input: string): number {
      if (input === null && input == "")
         return 0;
      else {
         this.task_id += this.task_id;
         var TaskCreated = new Task();
         TaskCreated.index = this.task_id;
         TaskCreated.task = input;
         return this.task_id;
      }
   }
   GetTask(task_id: number) {
      console.log(task_id);
   }
}

export class Task {
   public index: number;
   public task: string;

}