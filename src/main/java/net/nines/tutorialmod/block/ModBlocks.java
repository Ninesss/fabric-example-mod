package net.nines.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nines.tutorialmod.TutorialMod;
import net.nines.tutorialmod.item.ModItemGroup;

/**
 * @Auther:Nines
 * @Date：2021/11/19 21:51
 */
public class ModBlocks {

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(4.0f)
                    .breakByTool(FabricToolTags.PICKAXES,2)
                    .requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.RUBY)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
