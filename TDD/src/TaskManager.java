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
	List<Task> taskList = new ArrayList<TaskManager.Task>();
	
	public class Task 
	{
		int id;
		String query;
		boolean isActive;
		Date deadLine;

		public int saveTask(String query) throws ParseException
		{
			String[] queryStrings;
			Task task = new Task();
			task.id = ID_GENERATOR.getAndIncrement();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			queryStrings = query.split(" ");
			task.query = queryStrings[0];
			for(String string : queryStrings) {
				Calendar calendar = new GregorianCalendar();
				boolean flag = true;
				if(string.contains("@")) {
					if(string.length() == 1) {
						calendar.add(Calendar.DAY_OF_MONTH, 7);
						try {
							date = calendar.getTime();
							task.deadLine = date;
							flag = false;
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(Character.isDigit(string.charAt(1))) {
					    string = string.substring(1);
						String[] fullMonths = {"1", "3", "5", "7", "8", "10", "12"};
						string = string.substring(1);
						if(string.length() > 1) {
					    	String[] splitDate = string.split("/");
							if(Integer.parseInt(splitDate[1]) > 13) {
								flag = false;
							} else {
								for (String month : fullMonths) {
									if(splitDate[1].equals(month)) {
										if(Integer.parseInt(splitDate[0]) > 31) {
											flag = false;
										}
									}
									else if(splitDate[1].equals("2")) {
										if(Integer.parseInt(splitDate[0]) < 29) {
											if ((Integer.parseInt(splitDate[2]) % 4 != 0) && (Integer.parseInt(splitDate[0]) == 29)) {
												flag = false;
											} else {
												flag = true;
											}
										} else {
											flag = false;
										}
									} else {
										if(Integer.parseInt(splitDate[0]) > 30) {
											flag = false;
										}
									}
								}
								if(flag) {
									try {
										date = sdf.parse(string);
										if((sdf.format(date).equals(sdf.format(new Date()))) || (date.after(new Date()))) {
											task.deadLine = date;
										}
										else {
											calendar.add(Calendar.DAY_OF_MONTH, 7);
											try {
												date = calendar.getTime();
												task.deadLine = date;
											} catch (Exception e) {
												e.printStackTrace();
											};
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
			if(task.deadLine != null)
			{
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

		public List<Task> getDeadLinePassedTasks() {
			List<Task> taskDatePassedList = new ArrayList<>();
			for (Task task : taskList) {
				if((task.isActive) && (task.deadLine.before(new Date())))
					taskDatePassedList.add(task);
			}
			return taskDatePassedList;
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
			return task.saveTask(query);
		return -1;
	}

	public Task getTaskByTaskId(int taskId) {
		Task task = new Task();
		return task.getTaskById(taskId);
	}

	public boolean getTaskByTaskIdFlag(int taskId) {
		Task task = new Task();
		if(task.getTaskById(taskId) != null)
			return true;
		return false;
	}

	public int getTaskCount() {
		Task task = new Task();
		return task.getTaskCount();
	}

	public boolean deleteTaskById(int id) {
		Task task = new Task();
		return task.deleteTaskById(id);
	}
	
	public List<Task> getDeadLinePassedTasks() {
		Task task = new Task();
		return task.getDeadLinePassedTasks();
	}
}