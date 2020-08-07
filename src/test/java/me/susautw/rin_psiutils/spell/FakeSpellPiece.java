package me.susautw.rin_psiutils.spell;

import me.susautw.rin_psiutils.spell.base.MarkSpellPiece;
import vazkii.psi.api.spell.*;

@MarkSpellPiece(getSpellPieceName = "fake", getSpellGroupName = "fake_group", isMain = true)
public class FakeSpellPiece extends SpellPiece {
    public FakeSpellPiece(Spell spell) {
        super(spell);
    }

    @Override
    public EnumPieceType getPieceType() {
        return null;
    }

    @Override
    public Class<?> getEvaluationType() {
        return null;
    }

    @Override
    public Object evaluate() throws SpellCompilationException {
        return null;
    }

    @Override
    public Object execute(SpellContext spellContext) throws SpellRuntimeException {
        return null;
    }
}
