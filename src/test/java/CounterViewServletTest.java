import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class CounterViewServletTest {
    public CounterViewServlet counter;
    @Before
    public void init() {
        counter = new CounterViewServlet();
    }
    
    @Test
    public void testGetTitle() {    
        String title = "<title>CounterViewServlet using doGet() to view counter value</title>";
        assertEquals(title, counter.getTitle());
    }

    @Test
    public void testGetDocType() {    
        assertEquals("<!DOCTYPE html><html>", counter.getDocType());
    }

    @Test
    public void testGetVisitors() {    
        assertEquals("<h1>Total number of visitors is </h1>", counter.getVisitors());
    }

}
