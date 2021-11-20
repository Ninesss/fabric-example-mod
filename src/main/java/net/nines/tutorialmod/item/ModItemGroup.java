package net.nines.tutorialmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nines.tutorialmod.TutorialMod;

/**
 * @Auther:Nines
 * @Date：2021/11/20 23:28
 */
public class ModItemGroup {
    public static final ItemGroup RUBY = FabricItemGroupBuilder.build(new Identifier(TutorialMod.MOD_ID,"ruby"),
            () -> new ItemStack(ModItems.RUBY));
}
