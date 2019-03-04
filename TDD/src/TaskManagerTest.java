import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.util.List;

public class TaskManagerTest {
	@Test
	public void testTaskManagerWithBlank() {
		TaskManager task = new TaskManager();
		boolean flag = task.AddTask("");
		assertEquals(false, flag);
	}

	@Test
	public void testTaskManagerWithNull() {
		TaskManager task = new TaskManager();
		boolean flag = task.AddTask(null);
		assertEquals(false, flag);
	}
	
	@Test
	public void testTaskManagerWithString() {
		TaskManager task = new TaskManager();
		boolean flag = task.AddTask("Bhavesh");
		assertEquals(true, flag);
	}
	
	@Test
	public void testSaveTaskFailed() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("");
		assertEquals(-1, val);
	}
	
	@Test
	public void testSaveTaskFailedNoDateSrtring() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh");
		assertEquals(-1, val);
	}
	
	@Test
	public void testSaveTaskDateFieldWithAlpha() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @abc");
		assertEquals(-1, val);
	}
	
	@Test
	public void testSaveTaskFailedWrongDate() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @22/22/2019");
		assertEquals(-1, val);
	}
	
	@Test
	public void testSaveTaskPassedNoDate() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @02/05/2019");
		boolean testVal = task.getTaskByTaskIdFlag(val);
		assertEquals(testVal, true);
	}
	
	@Test
	public void testSaveTaskPassedRigthDate() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @02/02/2019");
		boolean testVal = task.getTaskByTaskIdFlag(val);
		assertEquals(testVal, true);
	}
	
	@Test
	public void testSaveTaskPassedMulitpleDate() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @02/02/2019 @ xyz @22/22/2019");
		boolean testVal = task.getTaskByTaskIdFlag(val);
		assertEquals(testVal, true);
	}
	
	@Test
	public void testSaveTaskPassedMulitpleWrongDates() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @xyz @22/22/2019");
		boolean testVal = task.getTaskByTaskIdFlag(val);
		assertEquals(testVal, false);
	}
	
	@Test
	public void testSaveTaskPassedMulitpleWrongRightDate() throws ParseException {
		TaskManager task = new TaskManager();
		int val = task.SaveTaskId("bhavesh @02/02/2019 @xyz @22/22/2019");
		boolean testVal = task.getTaskByTaskIdFlag(val);
		assertEquals(testVal, true);
	}
	
	@Test
	public void testGetDeadLinePassedTasks() {
		TaskManager task = new TaskManager();
		List<TaskManager.Task> val = task.getDeadLinePassedTasks();
		assertEquals(val.size(), 0);
	}
}