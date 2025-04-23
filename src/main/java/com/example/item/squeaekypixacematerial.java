package com.example.item;


import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class squeaekypixacematerial implements ToolMaterial {
	public static final ToolMaterial INSTANCE = null;
    @Override
    public int getDurability() {
	    return 2032;
}
    @Override
    public float getMiningSpeedMultiplier() {
	    return 9.0F;
}
@Override
public float getAttackDamage() {
	return 6.0F;
}
@Override
public TagKey<Block> getInverseTag() {
	return BlockTags.NEEDS_DIAMOND_TOOL;
}
@Override
public int getEnchantability() {
	return 15;
}
@Override
public Ingredient getRepairIngredient() {
	return Ingredient.ofItems(ModItems.orber);
}

}
