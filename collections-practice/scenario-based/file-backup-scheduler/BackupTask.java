public class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority;
    private String time;
    public BackupTask(String folderPath, int priority, String time) {
        this.folderPath = folderPath;
        this.priority = priority;
        this.time = time;
    }
    public String getFolderPath() {
        return folderPath;
    }
    public int getPriority() {
        return priority;
    }
    public String getTime() {
        return time;
    }
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }
}
