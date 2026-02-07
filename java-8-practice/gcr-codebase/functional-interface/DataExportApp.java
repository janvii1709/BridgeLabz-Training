import java.util.Scanner;
interface ReportExporter {
    void export();
    default void exportToJSON() {
        System.out.println("Exporting report in JSON format (default support).");
    }
}
class CSVExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting report in CSV format.");
    }
}
class PDFExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting report in PDF format.");
    }
}
public class DataExportApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose export format:");
        System.out.println("1. CSV");
        System.out.println("2. PDF");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        ReportExporter exporter;
        if (choice == 1) {
            exporter = new CSVExporter();
        } else {
            exporter = new PDFExporter();
        }
        exporter.export();
        System.out.print("Export as JSON also? (true/false): ");
        boolean jsonChoice = sc.nextBoolean();
        if (jsonChoice) {
            exporter.exportToJSON();
        }
    }
}
