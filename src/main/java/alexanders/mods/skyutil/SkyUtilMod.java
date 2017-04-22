package alexanders.mods.skyutil;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collections;

import static alexanders.mods.skyutil.Reference.*;

@Mod (modid = MODID, name = MODNAME, version = VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class SkyUtilMod// extends DummyModContainer
{
    /*public SkyUtilMod()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = MODID;
        meta.version = VERSION;
        meta.authorList = Collections.singletonList("superaxander");
        meta.description = "Simple additions for my modpack";
    }*/


    @Mod.Instance
    public static SkyUtilMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        /*
        InputStream inputStream = getClass().getResourceAsStream("skyutil.info");
        MetadataCollection mc = MetadataCollection.from(inputStream, MODID);
        Loader.instance().activeModContainer().bindMetadata(mc);*/
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(Blocks.STONE, 1), 0.5f);
    }
}
