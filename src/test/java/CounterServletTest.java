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

}
