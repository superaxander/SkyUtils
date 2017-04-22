package alexanders.mods.skyutil;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import squeek.asmhelper.alexanders.mods.skyutil.ObfHelper;

import java.io.InputStream;
import java.util.Map;

import static alexanders.mods.skyutil.Reference.*;

@IFMLLoadingPlugin.TransformerExclusions ({"alexanders.mods.skyutil", "squeek.asmhelper"})
@IFMLLoadingPlugin.Name (MODNAME)
@IFMLLoadingPlugin.MCVersion ("1.10.2")
@Mod (modid = MODID, name = MODNAME, version = VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class SkyUtil implements IFMLLoadingPlugin
{
    @Mod.Instance
    public static SkyUtil instance;

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

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"alexanders.mods.skyutil.SkyUtilClassTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
        ObfHelper.setObfuscated((Boolean) data.get("runtimeDeobfuscationEnabled"));
        ObfHelper.setRunsAfterDeobfRemapper(true);
    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
