package me.susautw.rin_psiutils.utils.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

import static me.susautw.rin_psiutils.utils.reflection.ReflectionsAdapter.*;

public class TestReflectionUtils {
    static Method staticMethodA;
    static Method staticMethodB;
    static Method methodAA;
    static Method methodBA;
    static Method methodBB;

    @Before
    public void setup() throws NoSuchMethodException {
        staticMethodA = FakeClassA.class.getDeclaredMethod("staticMethodA");
        staticMethodB = FakeClassB.class.getDeclaredMethod("staticMethodB");
        methodAA = FakeClassA.class.getDeclaredMethod("methodA");
        methodBA = FakeClassA.class.getDeclaredMethod("methodB");
        methodBB = FakeClassB.class.getDeclaredMethod("methodB");

    }

    @Test
    public void testGetStaticMethodTheSubClassDidNotOverride(){
        assertEquals(getMethod(FakeClassB.class, "staticMethodA"), staticMethodA);
    }

    @Test
    public void testGetStaticMethodTheSubClassDidOverride(){
        assertEquals(getMethod(FakeClassB.class, "staticMethodB"), staticMethodB);
    }

    @Test
    public void testGetMethodTheSubClassDidNotOverride(){
        assertEquals(getMethod(FakeClassB.class, "methodA"), methodAA);
    }

    @Test
    public void testGetMethodTheSubClassDidOverride(){
        assertEquals(getMethod(FakeClassB.class, "methodB"), methodBB);
    }

    @Test(expected = NoSuchMethodError.class)
    public void testGetMethodNoSuchMethod(){
        getMethod(FakeClassB.class, "methodC");
    }

    @Test
    public void testGetMethodWithArgumentClass(){
        getMethod(FakeClassB.class, "methodD", String.class);
    }
}
