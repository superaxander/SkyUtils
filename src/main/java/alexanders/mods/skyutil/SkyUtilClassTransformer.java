package alexanders.mods.skyutil;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.*;
import squeek.asmhelper.alexanders.mods.skyutil.ASMHelper;
import squeek.asmhelper.alexanders.mods.skyutil.ObfHelper;

import static org.objectweb.asm.Opcodes.*;

public class SkyUtilClassTransformer implements IClassTransformer
{
    private final String ICItemStack = ASMHelper.toInternalClassName("net.minecraft.item.ItemStack");
    private final String ICItems = ASMHelper.toInternalClassName("net.minecraft.init.Items");
    private final String ICTileEntityFurnace = ASMHelper.toInternalClassName("net.minecraft.tileentity.TileEntityFurnace");
    private final String ICBlocks = ASMHelper.toInternalClassName("net.minecraft.init.Blocks");
    private final String ICItem = ASMHelper.toInternalClassName("net.minecraft.item.Item");
    private final String AGetItem = ObfHelper.isObfuscated() ? "func_77973_b" : "getItem";
    private final String AFurnaceItemStacks = ObfHelper.isObfuscated() ? "field_145957_n" : "furnaceItemStacks";
    private final String AGetItemFromBlock = ObfHelper.isObfuscated() ? "func_150898_a" : "getItemFromBlock";
    private final String AObsidian = ObfHelper.isObfuscated() ? "field_150343_Z" : "OBSIDIAN";
    private final String ABucket = ObfHelper.isObfuscated() ? "field_151133_ar" : "BUCKET";
    private final String ALavaBucket = ObfHelper.isObfuscated() ? "field_151129_at" : "LAVA_BUCKET";
    private final String AGetMetadata = ObfHelper.isObfuscated() ? "func_77960_j" : "getMetadata";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass)
    {
        ClassNode classNode = ASMHelper.readClassFromBytes(basicClass);
        if (transformedName.equals("net.minecraft.tileentity.TileEntityFurnace"))
        {
            MethodNode methodNode = ASMHelper.findMethodNodeOfClass(classNode, "func_145949_j", "smeltItem", "()V");

            if (methodNode != null)
            {
                addSmeltingHook(classNode, methodNode);
            }
        }
        return ASMHelper.writeClassToBytes(classNode);
    }

    private void addSmeltingHook(ClassNode classNode, MethodNode methodNode)
    {
        InsnList needle = new InsnList();
        needle.add(new MethodInsnNode(INVOKESPECIAL, ICItemStack, "<init>", "(Lnet/minecraft/item/Item;)V", false));
        needle.add(new InsnNode(AASTORE));
        AbstractInsnNode found = ASMHelper.find(methodNode.instructions, needle).getNext().getNext().getNext();

        methodNode.instructions.insert(found, found = new VarInsnNode(ALOAD, 0));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETFIELD, ICTileEntityFurnace, AFurnaceItemStacks, "[Lnet/minecraft/item/ItemStack;"));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_0));
        methodNode.instructions.insert(found, found = new InsnNode(AALOAD));
        methodNode.instructions.insert(found, found = new MethodInsnNode(INVOKEVIRTUAL, ICItemStack, AGetItem, "()Lnet/minecraft/item/Item;", false));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETSTATIC, ICBlocks, AObsidian, "Lnet/minecraft/block/Block;"));
        methodNode.instructions.insert(found, found = new MethodInsnNode(INVOKESTATIC, ICItem, AGetItemFromBlock, "(Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;", false));
        LabelNode label_1 = new LabelNode(new Label());
        methodNode.instructions.insert(found, found = new JumpInsnNode(IF_ACMPNE, label_1));
        methodNode.instructions.insert(found, found = new VarInsnNode(ALOAD, 0));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETFIELD, ICTileEntityFurnace, AFurnaceItemStacks, "[Lnet/minecraft/item/ItemStack;"));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_0));
        methodNode.instructions.insert(found, found = new InsnNode(AALOAD));
        methodNode.instructions.insert(found, found = new MethodInsnNode(INVOKEVIRTUAL, ICItemStack, AGetMetadata, "()I", false));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_0));
        methodNode.instructions.insert(found, found = new JumpInsnNode(IF_ICMPNE, label_1));
        methodNode.instructions.insert(found, found = new VarInsnNode(ALOAD, 0));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETFIELD, ICTileEntityFurnace, AFurnaceItemStacks, "[Lnet/minecraft/item/ItemStack;"));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_1));
        methodNode.instructions.insert(found, found = new InsnNode(AALOAD));
        methodNode.instructions.insert(found, found = new JumpInsnNode(IFNULL, label_1));
        methodNode.instructions.insert(found, found = new VarInsnNode(ALOAD, 0));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETFIELD, ICTileEntityFurnace, AFurnaceItemStacks, "[Lnet/minecraft/item/ItemStack;"));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_1));
        methodNode.instructions.insert(found, found = new InsnNode(AALOAD));
        methodNode.instructions.insert(found, found = new MethodInsnNode(INVOKEVIRTUAL, ICItemStack, AGetItem, "()Lnet/minecraft/item/Item;", false));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETSTATIC, ICItems, ABucket, "Lnet/minecraft/item/Item;"));
        methodNode.instructions.insert(found, found = new JumpInsnNode(IF_ACMPNE, label_1));
        LabelNode label_2 = new LabelNode(new Label());
        methodNode.instructions.insert(found, found = label_2);
        methodNode.instructions.insert(found, found = new VarInsnNode(ALOAD, 0));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETFIELD, ICTileEntityFurnace, AFurnaceItemStacks, "[Lnet/minecraft/item/ItemStack;"));
        methodNode.instructions.insert(found, found = new InsnNode(ICONST_1));
        methodNode.instructions.insert(found, found = new TypeInsnNode(NEW, ICItemStack));
        methodNode.instructions.insert(found, found = new InsnNode(DUP));
        methodNode.instructions.insert(found, found = new FieldInsnNode(GETSTATIC, ICItems, ALavaBucket, "Lnet/minecraft/item/Item;"));
        methodNode.instructions.insert(found, found = new MethodInsnNode(INVOKESPECIAL, ICItemStack, "<init>", "(Lnet/minecraft/item/Item;)V", false));
        methodNode.instructions.insert(found, found = new InsnNode(AASTORE));
        methodNode.instructions.insert(found, label_1);
    }
}
