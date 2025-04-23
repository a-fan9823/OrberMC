package com.example.item;

import com.example.ExampleMod;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item orber = registerItem(Registries.ITEM,"orber",new Item(new Item.Settings().fireproof()));
    public static final Item deepfried_orber = registerItem(Registries.ITEM,"deepfried_orber",new Item(new Item.Settings().fireproof().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(ExampleMod.DIVINE_PROTECTION_ENTRY, 600, 0), 1.0f).nutrition(13).saturationModifier(8).build())));
    public static final RegistryKey<JukeboxSong> diggy_key = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("sounds", "diggy"));
    public static final RegistryKey<JukeboxSong> mogu_key = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of("sounds", "mogu"));
    public static final Item mogu_disc = registerItem(Registries.ITEM,"mogu_disc", new Item(new Item.Settings().jukeboxPlayable(mogu_key).maxCount(1).rarity(Rarity.RARE)));
    public static final Item diggy_disc = registerItem(Registries.ITEM,"diggy_disc", new Item(new Item.Settings().jukeboxPlayable(diggy_key).maxCount(1).rarity(Rarity.RARE)));
    public static final Item squeaky_pick = registerItem(Registries.ITEM, "pickax", new PickaxeItem(new squeaekypixacematerial(), new Item.Settings()));
    public static final Item shove = registerItem(Registries.ITEM, "shove", new ShovelItem(new squeaekypixacematerial(), new Item.Settings()));
    public static final Item acks = registerItem(Registries.ITEM, "acks", new AxeItem(new squeaekypixacematerial(), new Item.Settings()));
    public static final Item hoe = registerItem(Registries.ITEM, "hoe", new HoeItem(new squeaekypixacematerial(), new Item.Settings()));
    public static final Item swerd = registerItem(Registries.ITEM, "swerd", new SwordItem(new squeaekypixacematerial(), new Item.Settings()));

    private static Item registerItem(DefaultedRegistry registry,String name,Item item) {
        ModItemGroups.item_includes.add(item);
        return Registry.register(registry, Identifier.of(ExampleMod.MOD_ID,name), item);
    }
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering ModItems for "+ ExampleMod.MOD_ID+"...");
    }
}
