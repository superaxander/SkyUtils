package alexanders.mods.skyutil.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrindingWheelItem extends SUItem
{
    public GrindingWheelItem(String unlocalizedName)
    {
        super(unlocalizedName);
        this.setMaxStackSize(1);
        this.setMaxDamage(128);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack)
    {
        ItemStack newStack = new ItemStack(stack.getItem(), 1);
        newStack.setItemDamage(stack.getItemDamage()+1);
        return newStack;
    }
}
