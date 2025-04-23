package com.example.item;

import com.example.ExampleMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.ArrayList;

public class ModItemGroups {
    public static List<Item> item_includes = new ArrayList<>();;
    public static List<Block> block_includes = new ArrayList<>();;

    @SuppressWarnings("unused")
    private static final ItemGroup ORBERMC_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(ExampleMod.MOD_ID, "orbermc_items"), 
    FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.orber))
    .displayName(Text.translatable("itemgroup.orbermc.orbermc_items"))
    .entries((DisplayContext,entries) -> {
        if(block_includes.size() != 0) {
        for (Block block : block_includes) {
            entries.add(block);
            ExampleMod.LOGGER.info("added block to item group: " + block.getName());
        }
    }
    if(item_includes.size() != 0) {
        for (Item item : item_includes) {
            entries.add(item);
            ExampleMod.LOGGER.info("added item to item group: " + item.getName());
        }
    }
    })
    
    .build());


    public static void registerItemGroups() {
        ExampleMod.LOGGER.info("Registering ModItemGroups for " + ExampleMod.MOD_ID);
    }
}
