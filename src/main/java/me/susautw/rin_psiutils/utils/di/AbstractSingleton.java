package me.susautw.rin_psiutils.utils.di;

public abstract class AbstractSingleton {
    static <T> T getInstance(Class<T> cls)
            throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }
}