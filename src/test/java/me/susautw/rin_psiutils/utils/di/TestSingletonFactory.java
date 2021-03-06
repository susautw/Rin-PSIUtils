package me.susautw.rin_psiutils.utils.di;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

public class TestSingletonFactory {
    private SingletonFactory factory;
    @Before
    public void createSingletonFactory(){
        factory = new SingletonFactory();
    }

    @Test
    public void testSingletonGetInstanceOf()
            throws IllegalAccessException, InvocationTargetException {
        FakeSingleton expected = factory.getInstanceOf(FakeSingleton.class);
        FakeSingleton actual = factory.getInstanceOf(FakeSingleton.class);
        assertSame(expected, actual);
    }
}
