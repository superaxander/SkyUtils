package alexanders.mods.skyutil;

import alexanders.mods.skyutil.item.SUItems;
import alexanders.mods.skyutil.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static alexanders.mods.skyutil.Reference.*;

@Mod (modid = MODID, name = MODNAME, version = VERSION, acceptedMinecraftVersions = "[1.10.2]", dependencies = "required-after:thermalfoundation;")
public class SkyUtilMod
{
    @Mod.Instance
    public static SkyUtilMod instance;

    @SidedProxy (modId = MODID, clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static IProxy proxy;

    public SkyUtilCreativeTab creativeTab;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        creativeTab = new SkyUtilCreativeTab();
        SUItems.init();
        SUItems.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        SUItems.registerRender();
        SUItems.registerRecipes();
    }
}
