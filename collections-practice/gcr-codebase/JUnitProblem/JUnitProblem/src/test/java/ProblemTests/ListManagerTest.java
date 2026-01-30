package ProblemTests;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.ListManager;
public class ListManagerTest {
	    private ListManager listManager;
	    private List<Integer> testList;
	    @BeforeEach
	    void setUp() {
	        listManager = new ListManager();
	        testList = new ArrayList<>();
	    }
	    // Test adding elements
	    @Test
	    void testAddElement() {
	        listManager.addElement(testList, 10);
	        listManager.addElement(testList, 20);
	        assertEquals(2, testList.size());
	        assertTrue(testList.contains(10));
	        assertTrue(testList.contains(20));
	    }
	    // Test removing elements
	    @Test
	    void testRemoveElement() {
	        testList.add(5);
	        testList.add(15);
	        listManager.removeElement(testList, 5);
	        assertEquals(1, testList.size());
	        assertFalse(testList.contains(5));
	        assertTrue(testList.contains(15));
	    }
	    // Test removing an element not in list
	    @Test
	    void testRemoveNonExistingElement() {
	        testList.add(7);
	        listManager.removeElement(testList, 100);
	        assertEquals(1, testList.size()); // size should remain same
	        assertTrue(testList.contains(7));
	    }
	    // Test getSize method
	    @Test
	    void testGetSize() {
	        assertEquals(0, listManager.getSize(testList));
	        testList.add(1);
	        testList.add(2);
	        assertEquals(2, listManager.getSize(testList));
	    }
	    // Test null list handling
	    @Test
	    void testNullList() {
	        assertDoesNotThrow(() -> listManager.addElement(null, 5));
	        assertDoesNotThrow(() -> listManager.removeElement(null, 5));
	        assertEquals(0, listManager.getSize(null));
	    }
	}

