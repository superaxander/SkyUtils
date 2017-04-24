package alexanders.mods.skyutil.item;

import alexanders.mods.skyutil.SkyUtilMod;
import net.minecraft.item.Item;

public class SUItem extends Item
{
    public SUItem(String unlocalizedName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(SkyUtilMod.instance.creativeTab);
    }
}
