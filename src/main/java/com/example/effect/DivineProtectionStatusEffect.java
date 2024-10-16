package com.example.effect;

import com.example.ExampleMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DivineProtectionStatusEffect extends StatusEffect {
  private LivingEntity affectedEntity = null;
  public DivineProtectionStatusEffect() {
    super(
      StatusEffectCategory.BENEFICIAL,
      0x744eba); 
  }
 
  // This method is called every tick to check whether it should apply the status effect or not
  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    return true;
  }
 
  // This method is called when it applies the status effect. We implement custom functionality here.
  @Override
  public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
      entity.setInvulnerable(true);
      entity.setGlowing(true);
      ExampleMod.LOGGER.info("invulnerable? id: {}  {}",entity.getId(),entity.isInvulnerable());
      affectedEntity = entity;
    return true;
  }
  @Override
  public void onRemoved(AttributeContainer attributeContainer) {
    affectedEntity.setInvulnerable(false);
    affectedEntity.setGlowing(false);
    ExampleMod.LOGGER.info("effect remove, id: {} success? {}",affectedEntity.getId(),affectedEntity.isInvulnerable());
  }

}