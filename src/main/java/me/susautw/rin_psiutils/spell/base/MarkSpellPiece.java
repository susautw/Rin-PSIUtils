package me.susautw.rin_psiutils.spell.base;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The annotation use to mark own-mod-spell classes
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MarkSpellPiece {
    @NotNull String getSpellPieceName();

    @NotNull String getSpellGroupName();

    boolean isMain();
}

