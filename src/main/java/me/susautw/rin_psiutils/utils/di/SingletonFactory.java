package me.susautw.rin_psiutils.utils.di;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static me.susautw.rin_psiutils.utils.reflection.ReflectionUtils.getMethod;

public class SingletonFactory {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T extends AbstractSingleton> T getInstanceOf(Class<T> cls)
            throws InvocationTargetException, IllegalAccessException {
        /**
         * Get the instance of class. get a new instance if not contains the instance.
         */
        if(!instances.containsKey(cls)){
            synchronized (SingletonFactory.class){
                Object instance = getMethod(cls, "createInstance", Class.class).invoke(null, cls);

                if(instance == null){
                    throw new NullPointerException(
                            String.format("%s.getInstance() returned null", cls.getName())
                    );
                }
                instances.put(cls, instance);
            }
        }
        Object instance = instances.get(cls);
        if(cls.isInstance(instance)){
            return cls.cast(instance);
        }else{
            throw new RuntimeException(
                    String.format(
                            "got unexpected instance (expected: %s, got: %s)",
                            cls.getName(), instance.getClass().getName()));
        }
    }
}
