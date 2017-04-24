package alexanders.mods.skyutil;

import alexanders.mods.skyutil.item.SUItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class SkyUtilCreativeTab extends CreativeTabs
{
    public SkyUtilCreativeTab()
    {
        super("SkyUtil");
    }

    @Override
    public Item getTabIconItem()
    {
        return SUItems.grinding_wheel == null ? Item.getItemFromBlock(Blocks.GRASS) : SUItems.grinding_wheel;
    }
}
