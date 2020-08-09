package me.susautw.rin_psiutils.spell.registers;

import me.susautw.rin_psiutils.spell.FakeSpellPiece;
import me.susautw.rin_psiutils.spell.FakeSpellPiece2;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FakeReflections extends Reflections {

    private Class<?>[] returnOfTypesAnnotatedWith = null;

    public FakeReflections(){

    }

    @Override
    public Set<Class<?>> getTypesAnnotatedWith(final Class<? extends Annotation> annotation) {
        Set<Class<?>> set = new HashSet<>();
        Collections.addAll(set, returnOfTypesAnnotatedWith);
        return set;
    }

    public void setReturnOfTypesAnnotatedWith(Class<?> ...classes){
        returnOfTypesAnnotatedWith = classes;
    }


}
