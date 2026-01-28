import java.util.PriorityQueue;
public class FileBackupScheduler {
    private PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();
    public void addBackupTask(String path, int priority, String time)
            throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        backupQueue.add(new BackupTask(path, priority, time));
        System.out.println(" Backup task added successfully!");
        }
    public void executeBackups() {
        if (backupQueue.isEmpty()) {
            System.out.println(" No backup tasks to execute!");
            return;
        }
        System.out.println("\nExecuting Backup Tasks (High Priority First):");
        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            System.out.println("Backing up folder: " + task.getFolderPath() + " | Priority: " + task.getPriority() + " | Time: " + task.getTime());
        }
    }
}
