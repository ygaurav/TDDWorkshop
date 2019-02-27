import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		Date deadLine;
		List<Task> taskList;

		public int saveTask(String query) throws ParseException
		{
			String[] queryStrings;
			Task task = new Task();
			int countString = 0;
			task.id = ID_GENERATOR.getAndIncrement();
			queryStrings = query.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = new GregorianCalendar();
			Date date = new Date();
			for (String string : queryStrings) {
				if(string.contains("@")) {
					countString++;
				}
			}
			for (String string : queryStrings) {
				if(string.contains("@")) {
					countString++;
				}
				if(countString != 1) {
					countString--;
					break;
				} else {
					if(string.contains("@")) {
						if(string.length() == 1) {
							calendar.add(Calendar.DAY_OF_MONTH, 7);
							try {
								date = sdf.parse(calendar.getTime()+"");
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						else if(Character.isDigit(string.charAt(1))) {
							if(string.length() > 1) {
								try {
									date = sdf.parse(string);
								} catch (Exception e) {
									e.printStackTrace();
								}
							} else if(string.length() == 1) {
								calendar.add(Calendar.DAY_OF_MONTH, 7);
								try {
									date = sdf.parse(calendar.getTime()+"");
								} catch (Exception e) {
								}
							}
						}
						if((sdf.format(date).equals(sdf.format(new Date()))) || (date.after(new Date())))
							deadLine = date;
					}
				}
			}
			
			
			
			
			
			if(deadLine != null)
			{
				task.query = query;
				task.isActive = true;
				taskList.add(task);
				return task.id;
			}
			return -1;
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

	public boolean AddTask (String query) {
		if((query == "") || (query == null))
			return false;
		return true;
	}
	
	public int SaveTaskId(String query) throws ParseException {
		Task task = new Task();
		if(this.AddTask(query))
			if(task.saveTask(query) != -1) {
				return 1;
			}
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