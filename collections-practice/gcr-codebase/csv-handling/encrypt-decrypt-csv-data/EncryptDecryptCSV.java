import java.io.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class EncryptDecryptCSV {
    // AES key (16 bytes = 128-bit key)
    private static final String SECRET_KEY = "1234567890abcdef";
    // Encrypt a string using AES
    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
    // Decrypt a string using AES
    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }
    // Encrypt CSV file
    public static void encryptCSV(String inputCsv, String outputCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsv));
        FileWriter fw = new FileWriter(outputCsv)) {
            String header = br.readLine();
            fw.write(header + "\n"); // write header
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                // Encrypt Salary (index 3) and Email (index 4)
                cols[3] = encrypt(cols[3]);
                cols[4] = encrypt(cols[4]);
                fw.write(String.join(",", cols) + "\n");
            }
            System.out.println("CSV encrypted: " + outputCsv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Decrypt CSV file
    public static void decryptCSV(String encryptedCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(encryptedCsv))) {
            String header = br.readLine();
            System.out.println(header); // print header
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                cols[3] = decrypt(cols[3]);
                cols[4] = decrypt(cols[4]);
                System.out.println(String.join(",", cols));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Main method
    public static void main(String[] args) {
        String inputCsv = "employees.csv";
        String encryptedCsv = "employees_encrypted.csv";
        // Encrypt CSV
        encryptCSV(inputCsv, encryptedCsv);

        // Decrypt and print CSV
        System.out.println("\nDecrypted CSV Data:");
        decryptCSV(encryptedCsv);
    }
}
