import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class CounterServletTest {
    public CounterServlet counter;
    @Before
    public void init() {
        counter = new CounterServlet();
    }
    
    @Test
    public void testGetTitle() {    
        String title = "<title>CounterServlet using doGet() to increment local variable</title>";
        assertEquals(title, counter.getTitle());
    }

    @Test
    public void testGetBody() {    
        assertEquals("<h1>You are our: </h1>", counter.getBody());
    }
    @Test
    public void testGetDocType() {    
        assertEquals("<!DOCTYPE html><html>", counter.getDocType());
    }

}
