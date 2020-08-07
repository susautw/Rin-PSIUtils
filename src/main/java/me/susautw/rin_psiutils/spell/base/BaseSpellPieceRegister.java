package me.susautw.rin_psiutils.spell.base;

import me.susautw.rin_psiutils.exception.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import vazkii.psi.api.spell.SpellPiece;

import java.util.Collection;

public interface BaseSpellPieceRegister {
    void register(
            @NotNull Class<? extends SpellPiece> pieceClass,
            @NotNull String pieceName,
            @NotNull String groupName,
            boolean isMain
    ) throws Exception;

    default void register(@NotNull Class<? extends SpellPiece> spellPieceClass) throws Exception{
        throw new NotImplementedException("void register(@NotNull Class<? extends SpellPiece> spellPieceClass)");
    }

    default void registerAll(Collection<Class<? extends SpellPiece>> spellPiecesClasses)
            throws Exception {
        for (Class<? extends SpellPiece> spellPieceClass: spellPiecesClasses) {
            register(spellPieceClass);
        }
    }

    default void registerAll() throws Exception{
        throw new NotImplementedException("void registerAll()");
    }
}
