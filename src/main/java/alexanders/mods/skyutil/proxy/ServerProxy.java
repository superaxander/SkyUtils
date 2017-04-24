package alexanders.mods.skyutil.proxy;

import alexanders.mods.skyutil.item.SUItem;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements IProxy
{
    @Override
    public void registerItem(SUItem item)
    {
        item.setRegistryName(item.getUnlocalizedName().substring(5));
        GameRegistry.register(item);
    }

    @Override
    public void registerItemRender(SUItem item)
    {
    }
}
