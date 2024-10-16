package com.example.item;

import com.example.ExampleMod;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    
    public static final Item orber = registerItem("orber",new Item(new Item.Settings().fireproof()));
    public static final Item deepfried_orber = registerItem("deepfried_orber",new Item(new Item.Settings().fireproof().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(ExampleMod.DIVINE_PROTECTION_ENTRY, 600, 0), 1.0f).nutrition(13).saturationModifier(8).build())));

    private static Item registerItem(String name,Item item) {
        ModItemGroups.item_includes.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID,name), item);
    }
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering ModItems for "+ ExampleMod.MOD_ID+"...");
    }
}
