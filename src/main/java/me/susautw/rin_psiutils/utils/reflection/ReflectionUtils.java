package me.susautw.rin_psiutils.utils.reflection;

import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.reflect.Method;

public class ReflectionUtils {

    private static Reflections reflections = null;

    protected ReflectionUtils(){
    }

    @NotNull
    public static Method getMethod(Class<?> cls, String methodName, Class<?>... argClasses)
        throws NoSuchMethodError{

        Method found = null;
        Class<?> current = cls;
        while (current != Object.class){
            try {
                found = current.getDeclaredMethod(methodName, argClasses);
                break;
            } catch (NoSuchMethodException ignored){
                current = current.getSuperclass();
            }
        }

        if(found == null)
            throw new NoSuchMethodError(String.format("%s.%s()", cls.getName(), methodName));
        return found;
    }

    public static void setReflections(Reflections reflections){
        ReflectionUtils.reflections = reflections;
    }

    public static Reflections getReflections() {
        if(reflections == null){
            // default Reflections
            synchronized (ReflectionUtils.class) {
                reflections = new Reflections();
            }
        }
        return reflections;
    }
}
