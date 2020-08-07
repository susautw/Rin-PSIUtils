package me.susautw.rin_psiutils.spell;

import me.susautw.rin_psiutils.spell.base.MarkSpellPiece;
import vazkii.psi.api.spell.Spell;

@MarkSpellPiece(getSpellPieceName = "fake2", getSpellGroupName = "fake_group", isMain = false)
public class FakeSpellPiece2 extends FakeSpellPiece{
    public FakeSpellPiece2(Spell spell) {
        super(spell);
    }
}
