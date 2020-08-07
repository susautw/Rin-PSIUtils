package me.susautw.rin_psiutils.spell.registers;

import me.susautw.rin_psiutils.exception.NotImplementedException;
import me.susautw.rin_psiutils.spell.base.BaseSpellPieceRegister;
import org.jetbrains.annotations.NotNull;
import vazkii.psi.api.spell.SpellPiece;

import java.util.HashSet;

public class FakeSpellPieceRegister implements BaseSpellPieceRegister {
    public HashSet<Class<? extends SpellPiece>> pieceClasses = new HashSet<>();
    public HashSet<String> pieceNames = new HashSet<>();
    public HashSet<String> groupNames = new HashSet<>();
    public HashSet<Boolean> isMains = new HashSet<>();

    @Override
    public void register(
            @NotNull Class<? extends SpellPiece> pieceClass,
            @NotNull String pieceName,
            @NotNull String groupName,
            boolean isMain
    ) throws Exception {
        pieceClasses.add(pieceClass);
        pieceNames.add(pieceName);
        groupNames.add(groupName);
        isMains.add(isMain);
    }

    @Override
    public void register(@NotNull Class<? extends SpellPiece> spellPieceClass) throws Exception {
        throw new NotImplementedException("register");
    }
}
