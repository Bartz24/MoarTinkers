package com.bartz24.moartinkers.traits;

import java.util.ArrayList;
import java.util.List;

import com.bartz24.moartinkers.compat.CompatHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitPsiEater extends AbstractTrait {

	public TraitPsiEater() {
		super("psieater", 0x2C88C9);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {

		if (event.getEntityPlayer().world.isRemote) {
			return;
		}

		int maxPsi = (int) (event.getNewSpeed() * 3f);
		int psi = CompatHelper.extractPsi(event.getEntityPlayer(), maxPsi);
		event.setNewSpeed(event.getNewSpeed() * (1f + (float) psi / (float) maxPsi * 2.3f));
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {

		if (player.world.isRemote) {
			return newDamage;
		}

		if (player instanceof EntityPlayer) {
			EntityPlayer actualPlayer = (EntityPlayer) player;
			int maxPsi = (int) Math.pow(ToolHelper.getActualDamage(tool, actualPlayer) * .2f, 2.5f);
			int psi = CompatHelper.extractMana(tool, actualPlayer, maxPsi);
			return newDamage * (1f + (float) psi / (float) maxPsi * 1.4f);
		}

		return newDamage;
	}
}
