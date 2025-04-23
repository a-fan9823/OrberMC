package com.example.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class bouncycastle extends Block {

    public bouncycastle() {
        super(AbstractBlock.Settings.create().strength(0.8f).hardness(0.8f).velocityMultiplier(0.73f).sounds(BlockSoundGroup.WOOL));
    }
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(0, 0.0F, world.getDamageSources().fall());
     }
  
     public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
           super.onEntityLand(world, entity);
        } else {
           this.bounce(entity);
        }
  
     }
  
     private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
           double d = entity instanceof LivingEntity ? 1 : 0.8;
           entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }
  
     }
  
     public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        double d = Math.abs(entity.getVelocity().y);
        if (d < 0.1 && !entity.bypassesSteppingEffects()) {
           double e = 0.4 + d * 0.2;
           entity.setVelocity(entity.getVelocity().multiply(e, 1, e));
        }
  
        super.onSteppedOn(world, pos, state, entity);
     }
    
}
