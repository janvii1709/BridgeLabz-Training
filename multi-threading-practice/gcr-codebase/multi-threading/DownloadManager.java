import java.util.*;
class FileDownloaderRunnable implements Runnable {
    private String fileName;
    FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int progress = 0; progress <= 100; progress += 25) {
            try {
                Thread.sleep(500 + random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + progress + "%");
        }
    }
}
public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of files to download: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] files = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name " + (i + 1) + ": ");
            files[i] = sc.nextLine();
        }
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(
                    new FileDownloaderRunnable(files[i]),
                    "Thread-" + (i + 1)
            );
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All downloads complete!");
    }
}
