package me.susautw.rin_psiutils.utils.minecraft.base;

import me.susautw.rin_psiutils.exception.TeleportationFailedException;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public interface BaseTeleporter {

    /**
     * Teleport an entity to a position in same dimension.
     */
    void teleport(@NotNull Entity entity, @NotNull BlockPos position) throws TeleportationFailedException ;

    /**
     * Teleport an entity to a position in the specified dimension.
     */
    void teleport(@NotNull Entity entity, @NotNull BlockPos position, int dimension_id) throws TeleportationFailedException;
}
