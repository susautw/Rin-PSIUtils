package me.susautw.rin_psiutils.exception;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestNotImplementedException{

    @Test
    public void testMessage(){
        String expected = "Method method was not implemented.";
        String method = "method";

        assertEquals(new NotImplementedException(method).getMessage(), expected);
    }
}
