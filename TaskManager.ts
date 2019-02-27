export class TaskManager {

   public TaskCreate: Task[] = [];
   public task_id: number = 1;

   AddTask(input: string): number {
      if (input === null && input == "")
         return 0;
      else {
         let input_format = input.split('@');
         var string_length = input_format.length;
         if (input_format[string_length - 1].length > 10) {
            return 0;
         }
         else if (input_format[string_length - 1].length == 10) {
            var date_format = input_format[string_length - 1].split('/')
            if (date_format[0].length > 2) {
               return 0;
            }
            else {
               this.task_id += this.task_id;
               var TaskCreated = new Task();
               TaskCreated.index = this.task_id;
               TaskCreated.task = input;
               TaskCreated.deadline = new Date(input_format[1]);
               this.TaskCreate.push(TaskCreated);
            }
         }
         else if (input_format[string_length - 1].length == 0) {
            this.task_id += this.task_id;
            var TaskCreated = new Task();
            TaskCreated.index = this.task_id;
            TaskCreated.task = input;
            var today_date = new Date();
            var seven_days_ahead = today_date.getDate() + 7;
            TaskCreated.deadline = new Date(seven_days_ahead + '/' + today_date.getMonth() + '/' + today_date.getFullYear());
            this.TaskCreate.push(TaskCreated);
         }
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

   getPastTask() {
      var arrayOfTask = [];
      this.TaskCreate.forEach(task => {
         var today_date = new Date();
         if (task.deadline.getDate() < today_date.getDate() || task.deadline.getFullYear() < today_date.getFullYear() || task.deadline.getMonth() < today_date.getMonth()) {
            arrayOfTask.push(task);
         }
      })
      console.log('Array List --- ',arrayOfTask);
      return arrayOfTask;
   }
}

export class Task {
   public index: number;
   public task: string;
   public deadline: Date;

}