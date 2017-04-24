package alexanders.mods.skyutil.proxy;

import alexanders.mods.skyutil.Reference;
import alexanders.mods.skyutil.item.SUItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements IProxy
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
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
