package me.susautw.rin_psiutils.spell.registers;

import me.susautw.rin_psiutils.spell.FakeSpellPiece;

import static org.junit.Assert.*;

import me.susautw.rin_psiutils.spell.FakeSpellPiece2;
import me.susautw.rin_psiutils.utils.reflection.ReflectionsAdapter;
import org.junit.Before;
import org.junit.Test;
import vazkii.psi.api.spell.SpellPiece;

import java.util.LinkedList;

public class TestReflectionSpellRegister {

    protected FakeSpellPieceRegister fakeSpellPieceRegister;
    protected ReflectionSpellPieceRegister reflectionSpellPieceRegister;
    protected Class<?> expectedPieceClass = FakeSpellPiece.class;
    protected Class<?> expectedPieceClass2 = FakeSpellPiece2.class;
    protected String expectedPieceName = "fake";
    protected String expectedPieceName2 = "fake2";
    protected String expectedGroupName = "fake_group";
    protected boolean expectedIsMain = true;
    protected boolean expectedIsMain2 = false;

    @Before
    public void setup(){
        fakeSpellPieceRegister = new FakeSpellPieceRegister();
        reflectionSpellPieceRegister = new ReflectionSpellPieceRegister(fakeSpellPieceRegister);
    }

    @Test
    public void testRegisterWithClass() throws Exception {
        reflectionSpellPieceRegister.register(FakeSpellPiece.class);
        fakeSpellPieceAssertions();
    }

    @Test
    public void testRegisterAllSpellPiecesWithCollection() throws Exception {
        LinkedList<Class<? extends SpellPiece>> list = new LinkedList<>();
        list.add(FakeSpellPiece.class);
        list.add(FakeSpellPiece2.class);

        reflectionSpellPieceRegister.registerAll(list);
        fakeSpellPieceAssertions();
        fakeSpellPiece2Assertions();
    }

    @Test
    public void testRegisterAllSpellPieces() throws Exception{
        ReflectionsAdapter.setReflections(new FakeReflections());
        reflectionSpellPieceRegister.registerAll();
        fakeSpellPieceAssertions();
        fakeSpellPiece2Assertions();
    }

    private void fakeSpellPieceAssertions(){
        assertTrue(fakeSpellPieceRegister.pieceClasses.contains(expectedPieceClass));
        assertTrue(fakeSpellPieceRegister.pieceNames.contains(expectedPieceName));
        assertTrue(fakeSpellPieceRegister.groupNames.contains(expectedGroupName));
        assertTrue(fakeSpellPieceRegister.isMains.contains(expectedIsMain));
    }
    private void fakeSpellPiece2Assertions(){
        assertTrue(fakeSpellPieceRegister.pieceClasses.contains(expectedPieceClass2));
        assertTrue(fakeSpellPieceRegister.pieceNames.contains(expectedPieceName2));
        assertTrue(fakeSpellPieceRegister.groupNames.contains(expectedGroupName));
        assertTrue(fakeSpellPieceRegister.isMains.contains(expectedIsMain2));
    }


}
