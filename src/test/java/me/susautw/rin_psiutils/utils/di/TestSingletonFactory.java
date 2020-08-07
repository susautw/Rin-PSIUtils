package me.susautw.rin_psiutils.utils.di;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestSingletonFactory {
    private SingletonFactory factory;
    @Before
    public void createSingletonFactory(){
        factory = new SingletonFactory();
    }

    @Test
    public void testSingletonGetInstanceOf()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Arrays.toString(FakeSingleton.class.getMethods()));
        FakeSingleton expected = factory.getInstanceOf(FakeSingleton.class);
        FakeSingleton actual = factory.getInstanceOf(FakeSingleton.class);
        assertSame(expected, actual);
    }
}
