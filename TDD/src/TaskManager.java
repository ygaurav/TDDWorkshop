public class TaskManager
{
	public boolean AddTask (String query)
	{
		if((query == "") || (query == null))
			return false;
		return true;
	}
}