package toystore.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloTest {

    @Test public void shouldReturnName(){
        Hello h = new Hello("name");

        assertEquals("name", h.getMessage());
    }
}