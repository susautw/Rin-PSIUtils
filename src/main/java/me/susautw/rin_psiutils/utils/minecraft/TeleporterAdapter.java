package me.susautw.rin_psiutils.utils.minecraft;

import me.susautw.rin_psiutils.exception.TeleportationFailedException;
import me.susautw.rin_psiutils.utils.minecraft.base.BaseTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;

public class TeleporterAdapter implements BaseTeleporter, ITeleporter {

    private ITeleporter teleporter;

    public TeleporterAdapter(ITeleporter teleporter){
        setTeleporter(teleporter);
    }

    public TeleporterAdapter(){
        setTeleporter(this);
    }

    @Override
    public void teleport(@NotNull Entity entity,@NotNull  BlockPos position)
            throws TeleportationFailedException {
        checkEntityCanTeleport(entity);
        entity.moveToBlockPosAndAngles(position, entity.rotationYaw, entity.rotationPitch);
        entity.motionX = entity.motionY = entity.motionZ = 0.0;
    }

    @Override
    public void teleport(@NotNull Entity entity,@NotNull  BlockPos position, int dimension_id)
            throws TeleportationFailedException {
        checkEntityCanTeleport(entity);
        try {
            if (shouldChangeDimension(entity, dimension_id)){
                if(!isDimensionRegistered(dimension_id)){
                    throw new IllegalArgumentException("the dimension " + dimension_id + "is not exists.");
                }
                entity.changeDimension(dimension_id, this.teleporter);
            }
            teleport(entity, position);
        } catch (Exception e) {
            throw new TeleportationFailedException(e);
        }
    }

    private void checkEntityCanTeleport(Entity entity) throws TeleportationFailedException {
        if (shouldNotTeleportEntity(entity)){
            throw new TeleportationFailedException(
                    new IllegalArgumentException("Invalid entity.")
            );
        }
    }

    private boolean shouldNotTeleportEntity(Entity entity){
        // use vanilla portal logic, try to avoid doing anything too silly
        return entity.isRiding() || entity.isBeingRidden() || !entity.isNonBoss();
    }

    private boolean shouldChangeDimension(Entity entity, int dimension_id){
        return entity.dimension != dimension_id;
    }

    private boolean isDimensionRegistered(int dimension_id){
        return DimensionManager.isDimensionRegistered(dimension_id);
    }

    public void setTeleporter(ITeleporter teleporter) {
        this.teleporter = teleporter;
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw) {
        // do nothing after teleport
    }
}
