import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager
{
	List<String> taskList;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	
	public boolean AddTask (String query)
	{
		if((query == "") || (query == null))
			return false;
		return true;
	}
	
	public int SaveTaskId(String query) {
		if(this.AddTask(query)) {
			taskList.add(query);
			return ID_GENERATOR.getAndIncrement();
		}
		return -1;
	}
}