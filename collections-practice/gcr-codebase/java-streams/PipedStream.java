import java.io.*;
import java.util.Scanner;
public class PipedStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            Thread writer = new Thread(() -> {
                try {
                    System.out.print("Enter message to send through pipe: ");
                    String message = sc.nextLine();

                    System.out.println("Writer: Writing data...");
                    pos.write(message.getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Writer IOException: " + e.getMessage());
                }
            });
            Thread reader = new Thread(() -> {
                try {
                    int data;
                    System.out.println("Reader: Reading data...");
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    System.out.println("\nReader: Finished reading.");
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader IOException: " + e.getMessage());
                }
            });
            reader.start();
            writer.start();
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
