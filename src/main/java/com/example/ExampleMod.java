package com.example;
import com.example.block.ModBlocks;
import com.example.effect.DivineProtectionStatusEffect;
import com.example.item.ModItemGroups;
import com.example.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "orbermc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
public static final StatusEffect DIVINE_PROT = new DivineProtectionStatusEffect();
public static RegistryEntry<StatusEffect> DIVINE_PROTECTION_ENTRY;
public static final RegistryKey<PlacedFeature> CUSTOM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID,"ore_custom"));

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		//effect definition
		Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "divine_protection"), DIVINE_PROT);
		DIVINE_PROTECTION_ENTRY = Registries.STATUS_EFFECT.getEntry(DIVINE_PROT);
		//ore gen definition
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CUSTOM_ORE_PLACED_KEY);
		
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}