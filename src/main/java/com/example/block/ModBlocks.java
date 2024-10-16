package com.example.block;

import com.example.ExampleMod;
import com.example.item.ModItemGroups;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
public static final String[] COLORS = {"black","blue","cyan","gray","green","magenta","red","white","yellow"};

    public static void registerBouncy() {
        for (String color : COLORS) {
            // Create a single instance of BouncyBlock for each color
            Block bouncyBlock = new bouncycastle();
            ExampleMod.LOGGER.info("Loading bouncy block: " + color + " " + bouncyBlock);

            // Register block and block item dynamically using the color in the identifier
            registerBlock((color + "_bouncy_castle"), bouncyBlock);
        }
    }
    public static final Block VOID = registerBlock("pure_void_block",
            new Block(AbstractBlock.Settings.create().strength(0f)
                    .requiresTool().hardness(50f).sounds(BlockSoundGroup.GLASS)));
    public static final Block CRYING_VOID = registerBlock("crying_void",
            new Block(AbstractBlock.Settings.create().strength(0f)
            .requiresTool().luminance(state -> 10).hardness(50f).sounds(BlockSoundGroup.GLASS)));
    public static final Block LIGHT = registerBlock("pure_light_block",
            new Block(AbstractBlock.Settings.create().strength(0f)
            .requiresTool().luminance(state -> 15).hardness(50f).sounds(BlockSoundGroup.GLASS)));
    public static final Block OREBER = registerBlock("oreber",
            new Block(AbstractBlock.Settings.create().strength(0f)
            .requiresTool().hardness(3f).sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_OREBER = registerBlock("deepslate_oreber",
            new Block(AbstractBlock.Settings.create().strength(0f)
            .requiresTool().hardness(4.5f).sounds(BlockSoundGroup.DEEPSLATE)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        ModItemGroups.block_includes.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering ModBlocks for " + ExampleMod.MOD_ID);
        registerBouncy();
    }
}