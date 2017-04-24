package alexanders.mods.skyutil.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DetectionFixerItem extends SUItem
{

    public DetectionFixerItem(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack target = playerIn.getHeldItem(hand == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
        NBTTagCompound tag;
        if (target != null && (tag = target.getTagCompound()) != null && !tag.hasNoTags())
        {
            if (tag.hasKey("agri_strength") && tag.hasKey("agri_gain") && tag.hasKey("agri_growth"))
            {
                if (target.getUnlocalizedName().substring(5).equals("agricraft:agri_seed"))
                {
                    tag.setByte("agri_analyzed", (byte) 0);
                    tag.setByte("agri_strength", (byte) 1);
                    tag.setByte("agri_gain", (byte) 1);
                    tag.setByte("agri_growth", (byte) 1);
                } else
                {
                    tag.removeTag("agri_analyzed");
                    tag.removeTag("agri_strength");
                    tag.removeTag("agri_gain");
                    tag.removeTag("agri_growth");
                    if(tag.hasNoTags())
                        //noinspection ConstantConditions
                        target.setTagCompound(null);
                }
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    }
}
