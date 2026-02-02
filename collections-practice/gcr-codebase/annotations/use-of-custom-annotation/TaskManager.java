public class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Admin")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}
