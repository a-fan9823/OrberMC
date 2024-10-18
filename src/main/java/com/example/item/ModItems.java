package com.example.item;

import com.example.ExampleMod;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item orber = registerItem("orber",new Item(new Item.Settings().fireproof()));
    public static final Item deepfried_orber = registerItem("deepfried_orber",new Item(new Item.Settings().fireproof().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(ExampleMod.DIVINE_PROTECTION_ENTRY, 600, 0), 1.0f).nutrition(13).saturationModifier(8).build())));
    public static final RegistryKey<JukeboxSong> diggy_key = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("sounds", "diggy"));
    public static final RegistryKey<JukeboxSong> mogu_key = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("sounds", "mogu"));
    public static final Item mogu_disc = registerItem("mogu_disc", new Item(new Item.Settings().jukeboxPlayable(mogu_key).maxCount(1).rarity(Rarity.RARE)));
    public static final Item diggy_disc = registerItem("diggy_disc", new Item(new Item.Settings().jukeboxPlayable(diggy_key).maxCount(1).rarity(Rarity.RARE)));


    private static Item registerItem(String name,Item item) {
        ModItemGroups.item_includes.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID,name), item);
    }
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering ModItems for "+ ExampleMod.MOD_ID+"...");
    }
}
