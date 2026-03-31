import java.io.*;
import java.util.Scanner;
class BackupData implements Serializable {
    String fileName;
    int fileSize;
    BackupData(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}
public class DataBackupSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String name = sc.nextLine();
        System.out.print("Enter file size (MB): ");
        int size = sc.nextInt();
        BackupData data = new BackupData(name, size);
        if (data instanceof Serializable) {
            try {
                ObjectOutputStream out =
                        new ObjectOutputStream(new FileOutputStream("backup.dat"));
                out.writeObject(data);
                out.close();
                System.out.println("Backup stored successfully!");
            } catch (IOException e) {
                System.out.println("Backup failed.");
            }
        } else {
            System.out.println("Class is not Serializable. Backup not allowed.");
        }
    }
}
