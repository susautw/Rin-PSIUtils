package me.susautw.rin_psiutils.utils.reflection;

import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * This class works as an adapter of Reflection-Related things.
 */
public class ReflectionsAdapter {

    private static Reflections reflections = null;

    protected ReflectionsAdapter(){
    }

    /**
     * method dependency injection of Reflections
     */
    public static void setReflections(@NotNull Reflections reflections){
        ReflectionsAdapter.reflections = reflections;
    }

    /**
     * the getter of Reflections class
     */
    public static Reflections getReflections() {
        loadReflectionsIfNotLoaded();
        return reflections;
    }

    public static void loadReflectionsIfNotLoaded(){
        if(reflections == null){
            // default Reflections
            synchronized (ReflectionsAdapter.class) {
                reflections = new Reflections();
            }
        }
    }

    public static void clearReflections(){
        reflections = null;
    }

    /**
     * Recursively get a method of a specified class with specified argument types.
     */
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

    /**
     * Get the classes that have been annotated as the specific type of annotation.
     */
    public static Set<Class<?>> getTypesAnnotatedWith(final Class<? extends Annotation> annotation){
        return ReflectionsAdapter.getReflections().getTypesAnnotatedWith(annotation);
    }
}
