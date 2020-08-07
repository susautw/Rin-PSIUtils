package me.susautw.rin_psiutils.utils.reflection;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Stack;

public class ReflectionUtils {
    protected ReflectionUtils(){}

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
}
