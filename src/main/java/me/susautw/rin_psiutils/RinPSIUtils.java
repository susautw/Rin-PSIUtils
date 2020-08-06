package me.susautw.rin_psiutils;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = RinPSIUtils.MODID,
        name = RinPSIUtils.NAME,
        version = RinPSIUtils.VERSION,
        dependencies = "required-after:psi@[${psi_version},);" +
                "required-after:forge@[${forge_version},);",
        useMetadata = true
)
public class RinPSIUtils
{
    public static final String MODID = "${mod_id}";
    public static final String NAME = "${mod_name}";
    public static final String VERSION = "${mod_version}";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
