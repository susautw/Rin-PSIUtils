package me.susautw.rin_psiutils.spell.registers;

import vazkii.psi.api.spell.SpellPiece;
import me.susautw.rin_psiutils.spell.base.BaseSpellPieceRegister;
import me.susautw.rin_psiutils.spell.base.MarkSpellPiece;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static me.susautw.rin_psiutils.utils.reflection.ReflectionsAdapter.*;


/**
 * This class use the annotation(MarkSpellPiece) to automatically find this mods' spell pieces
 * by reflection.
 */
public class ReflectionSpellPieceRegister implements BaseSpellPieceRegister {

    private BaseSpellPieceRegister spellPieceRegister;

    /**
     * Constructor for dependency injection
     */
    public ReflectionSpellPieceRegister(BaseSpellPieceRegister spellPieceRegister){
        setSpellPieceRegister(spellPieceRegister);
    }

    public ReflectionSpellPieceRegister(){
        this(new SimpleSpellPieceRegister());
    }

    @Override
    public void register(
            @NotNull Class<? extends SpellPiece> pieceClass,
            @NotNull String pieceName,
            @NotNull String groupName,
            boolean isMain
    ) throws Exception {
        getSpellPieceRegister().register(pieceClass, pieceName, groupName, isMain);
    }

    @Override
    public void register(@NotNull Class<? extends SpellPiece> spellPieceClass) throws Exception {
        MarkSpellPiece annotation = spellPieceClass.getAnnotation(MarkSpellPiece.class);
        register(
                spellPieceClass,
                annotation.getSpellPieceName(),
                annotation.getSpellGroupName(),
                annotation.isMain()
        );
    }

    @Override
    public void registerAll() throws Exception {
        Set<Class<?>> classes = getTypesAnnotatedWith(MarkSpellPiece.class);
        Set<Class<? extends SpellPiece>> check_classes = new HashSet<>();
        for(Class<?> cls: classes){
            if(!SpellPiece.class.isAssignableFrom(cls)){
                throw new RuntimeException("The marked spell piece isn't a Spell Piece");
            }
            check_classes.add((Class<? extends SpellPiece>) cls);
        }
        registerAll(check_classes);
    }

    public BaseSpellPieceRegister getSpellPieceRegister() {
        return spellPieceRegister;
    }

    public void setSpellPieceRegister(BaseSpellPieceRegister spellPieceRegister) {
        this.spellPieceRegister = spellPieceRegister;
    }


}
