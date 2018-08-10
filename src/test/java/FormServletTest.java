import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class FormServletTest {
    public FormServlet counter;
    @Before
    public void init() {
        counter = new FormServlet();
    }
    
    @Test
    public void testGetTitle() {    
        String title = "<title>FormServlet using doGet() to read form data</title>";
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
