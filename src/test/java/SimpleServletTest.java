import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class SimpleServletTest {
    public SimpleServlet counter;
    @Before
    public void init() {
        counter = new SimpleServlet();
    }
    
    @Test
    public void testGetTitle() {    
        String title = "<title>SimpleServlet using doGet() to generate simple website</title>";
        assertEquals(title, counter.getTitle());
    }

    @Test
    public void testGetDocType() {    
        assertEquals("<!DOCTYPE html><html>", counter.getDocType());
    }

    @Test
    public void testGetYear() {    
        assertEquals("2018", counter.getYear());
    }

}
