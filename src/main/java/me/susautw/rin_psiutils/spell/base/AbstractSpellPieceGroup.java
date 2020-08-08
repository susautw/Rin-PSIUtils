package me.susautw.rin_psiutils.spell.base;

import me.susautw.rin_psiutils.utils.di.AbstractSingleton;
import me.susautw.rin_psiutils.utils.di.SingletonFactory;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractSpellPieceGroup extends AbstractSingleton {
    public static SingletonFactory instances = new SingletonFactory();

    abstract public int getRequiredLevel();

    @NotNull
    abstract public String getGroupName();

    @NotNull
    abstract public AbstractSpellPieceGroup[] getDependency();
}
