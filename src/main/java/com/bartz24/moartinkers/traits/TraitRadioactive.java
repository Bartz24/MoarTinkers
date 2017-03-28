package com.bartz24.moartinkers.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;

public class TraitRadioactive extends AbstractTraitLeveled {

	public TraitRadioactive(int levels) {
		super("radioactive", String.valueOf(levels), 0x30FF37, 4, levels);
	}

	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player,
			boolean wasEffective) {
		if (!world.isRemote) {
			if (player.world.rand.nextFloat() < 0.09f * levels)
				player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 101, 1));
			if (player.world.rand.nextFloat() < 0.02f * levels)
				player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 1));
		}
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (wasHit && !player.world.isRemote) {
			if (player.world.rand.nextFloat() < 0.09f * levels)
				player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 101, 1));
			if (player.world.rand.nextFloat() < 0.02f * levels)
				player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 1));
			if (target.isEntityAlive() && player.world.rand.nextFloat() < 0.02f * levels)
				target.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 1));
		}
	}
}
