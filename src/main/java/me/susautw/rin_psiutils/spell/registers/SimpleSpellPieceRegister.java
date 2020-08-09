package me.susautw.rin_psiutils.spell.registers;

import me.susautw.rin_psiutils.exception.NotImplementedException;
import me.susautw.rin_psiutils.spell.base.BaseSpellPieceRegister;
import org.jetbrains.annotations.NotNull;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.spell.SpellPiece;

/**
 * The register just a simple register as a adapter of PsiAPI
 */
public class SimpleSpellPieceRegister implements BaseSpellPieceRegister {

    @Override
    public void register(
            @NotNull Class<? extends SpellPiece> pieceClass,
            @NotNull String pieceName,
            @NotNull String groupName,
            boolean isMain
    ) {
        PsiAPI.registerSpellPieceAndTexture(pieceName, pieceClass);
        PsiAPI.addPieceToGroup(pieceClass, pieceName, isMain);
    }
}
