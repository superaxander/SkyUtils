package alexanders.mods.skyutil.item;

import alexanders.mods.skyutil.SkyUtilMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class SUItems
{
    public static SUItem grinding_wheel;
    public static SUItem detection_fixer;
    public static SUItem dustCharcoal;
    public static SUItem dustCoal;
    public static SUItem dustWood;
    public static SUItem dustSaltpeter;

    public static void init()
    {
        grinding_wheel = (SUItem) new GrindingWheelItem("grinding_wheel");
        detection_fixer = (SUItem) new DetectionFixerItem("detection_fixer");
        dustCharcoal = new SUItem("dustCharcoal");
        dustCoal = new SUItem("dustCoal");
        dustWood = new SUItem("dustWood");
        dustSaltpeter = new SUItem("dustSaltpeter");
    }

    public static void register()
    {
        SkyUtilMod.proxy.registerItem(grinding_wheel);
        SkyUtilMod.proxy.registerItem(detection_fixer);
        SkyUtilMod.proxy.registerItem(dustCharcoal);
        SkyUtilMod.proxy.registerItem(dustCoal);
        SkyUtilMod.proxy.registerItem(dustWood);
        SkyUtilMod.proxy.registerItem(dustSaltpeter);
        OreDictionary.registerOre("dustCharcoal", dustCharcoal);
        OreDictionary.registerOre("dustCoal", dustCoal);
        OreDictionary.registerOre("dustWood", dustWood);
        OreDictionary.registerOre("dustSaltpeter", dustSaltpeter);
    }

    public static void registerRender()
    {
        SkyUtilMod.proxy.registerItemRender(grinding_wheel);
        SkyUtilMod.proxy.registerItemRender(detection_fixer);
        SkyUtilMod.proxy.registerItemRender(dustCharcoal);
        SkyUtilMod.proxy.registerItemRender(dustCoal);
        SkyUtilMod.proxy.registerItemRender(dustWood);
        SkyUtilMod.proxy.registerItemRender(dustSaltpeter);
    }

    public static void registerRecipes()
    {
        GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(Blocks.STONE, 1), 0.5f);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(grinding_wheel), "SSS", "CCC", "SSS", 'S', "stone", 'C', "cobblestone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(detection_fixer), " G ", "GCG", " G ", 'G', "blockGlass", 'C', Blocks.CLAY));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(dustCharcoal, 1), new ItemStack(grinding_wheel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.COAL, 1, 1)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(dustCoal, 1), new ItemStack(grinding_wheel, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.COAL, 1, 0)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(dustWood, 1), new ItemStack(grinding_wheel, 1, OreDictionary.WILDCARD_VALUE), "logWood"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(dustSaltpeter, 1), new ItemStack(grinding_wheel, 1, OreDictionary.WILDCARD_VALUE), "sand"));
    }
}
