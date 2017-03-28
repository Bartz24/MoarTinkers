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

public class TraitManaEater extends AbstractTrait {

	public TraitManaEater() {
		super("manaeater", 0x023DBF);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {

		if (event.getEntityPlayer().world.isRemote) {
			return;
		}

		int maxMana = (int) (event.getNewSpeed() * 5f);
		int mana = CompatHelper.extractMana(tool, event.getEntityPlayer(), maxMana);
		event.setNewSpeed(event.getNewSpeed() * (1f + (float) mana / (float) maxMana * 2.3f));
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {

		if (player.world.isRemote) {
			return newDamage;
		}

		if (player instanceof EntityPlayer) {
			EntityPlayer actualPlayer = (EntityPlayer) player;
			int maxMana = (int) Math.pow(ToolHelper.getActualDamage(tool, actualPlayer) * .25f, 2.5f);
			int mana = CompatHelper.extractMana(tool, actualPlayer, maxMana);
			return newDamage * (1f + (float) mana / (float) maxMana * 1.4f);
		}

		return newDamage;
	}
}
