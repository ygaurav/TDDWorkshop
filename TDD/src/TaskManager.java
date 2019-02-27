import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager
{
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	public class Task 
	{
		int id;
		String query;
		boolean isActive;
		List<Task> taskList;

		public int saveTask(String query)
		{
			Task task = new Task();
			task.id = ID_GENERATOR.getAndIncrement();
			task.query = query;
			task.isActive = true;
			taskList.add(task);
			return task.id;
		}
		
		public Task getTaskById(int id)
		{
			for (Task task : taskList) {
				if((task.id == id) && task.isActive)
					return task;
			}
			return null;
		}

		public int getTaskCount() {
			int count = 0;
			for (Task task : taskList) {
				if(task.isActive)
					count++;
			}
			return count;
		}

		public boolean deleteTaskById(int id) {
			Task task = new Task();
			if(!(taskList.isEmpty()) || (taskList.size() > 0)) {
				task = getTaskById(id);
				task.isActive = false;
			}
			return false;
		}
	}

	public boolean AddTask (String query)
	{
		if((query == "") || (query == null))
			return false;
		return true;
	}
	
	public int SaveTaskId(String query) {
		Task task = new Task();
		if(this.AddTask(query))
			return task.saveTask(query);
		return -1;
	}

	public Task getTaskByTaskId(int taskId) {
		Task task = new Task();
		return task.getTaskById(taskId);
	}
	

	public int getTaskCount() {
		Task task = new Task();
		return task.getTaskCount();
	}

	public boolean deleteTaskById(int id) {
		Task task = new Task();
		return task.deleteTaskById(id);
	}
}