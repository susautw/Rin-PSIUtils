package me.susautw.rin_psiutils.spell.base;

import me.susautw.rin_psiutils.exception.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import vazkii.psi.api.spell.SpellPiece;

import java.util.Collection;

public interface BaseSpellPieceRegister {

    /**
     * Register with information of spell piece.
     */
    void register(
            @NotNull Class<? extends SpellPiece> pieceClass,
            @NotNull String pieceName,
            @NotNull String groupName,
            boolean isMain
    ) throws Exception;

    /**
     * Register with spell pieces' class
     */
    default void register(@NotNull Class<? extends SpellPiece> spellPieceClass) throws Exception{
        throw new NotImplementedException("void register(@NotNull Class<? extends SpellPiece> spellPieceClass)");
    }

    /**
     * Register multiple spell pieces using their own class.
     */
    default void registerAll(Collection<Class<? extends SpellPiece>> spellPiecesClasses)
            throws Exception {
        for (Class<? extends SpellPiece> spellPieceClass: spellPiecesClasses) {
            register(spellPieceClass);
        }
    }

    /**
     * Automatically register all of the spell pieces of this mod.
     */
    default void registerAll() throws Exception{
        throw new NotImplementedException("void registerAll()");
    }
}
