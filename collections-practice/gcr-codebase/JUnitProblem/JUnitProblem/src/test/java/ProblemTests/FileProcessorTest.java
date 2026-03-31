package ProblemTests;
import org.junit.jupiter.api.Test;
import Problems.FileProcessor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
public class FileProcessorTest {
    FileProcessor processor = new FileProcessor();
    String filename = "testfile.txt";
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Test";
        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);
        assertEquals(content, result);
    }
    @Test
    void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(filename, "File exists test");
        assertTrue(Files.exists(Path.of(filename)));
    }
    @Test
    void testReadNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}
