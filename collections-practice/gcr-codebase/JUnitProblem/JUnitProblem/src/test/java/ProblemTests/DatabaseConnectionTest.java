package ProblemTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import Problems.DatabaseConnection;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    // Test 1: Connection should be established before each test
    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(),
                "Database should be connected before test");
    }

    // Test 2: Calling connect() again should still keep connection true
    @Test
    void testMultipleConnectCalls() {
        dbConnection.connect();
        assertTrue(dbConnection.isConnected());
    }

    // Test 3: Disconnect should close the connection
    @Test
    void testDisconnect() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(),
                "Database should be disconnected");
    }

    // Test 4: AfterEach ensures cleanup
    @Test
    void testConnectionDuringTest() {
        assertTrue(dbConnection.isConnected());
    }
}
