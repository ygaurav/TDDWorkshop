import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}