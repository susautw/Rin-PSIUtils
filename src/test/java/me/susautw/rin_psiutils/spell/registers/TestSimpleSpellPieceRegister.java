package me.susautw.rin_psiutils.spell.registers;

import me.susautw.rin_psiutils.exception.NotImplementedException;
import me.susautw.rin_psiutils.spell.FakeSpellPiece;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleSpellPieceRegister {
    private static SimpleSpellPieceRegister simpleSpellPieceRegister;

    @Before
    public void setup(){
        simpleSpellPieceRegister = new SimpleSpellPieceRegister();
    }

    @Test(expected = NotImplementedException.class)
    public void testRegister() throws Exception {
        simpleSpellPieceRegister.register(FakeSpellPiece.class);
    }
}
