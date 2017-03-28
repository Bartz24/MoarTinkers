package com.bartz24.moartinkers.traits;

import com.bartz24.moartinkers.compat.CompatHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitPsiRepair extends AbstractTrait {

	public TraitPsiRepair() {
		super("psirepair", 0x61BDFF);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {

		if (entity.getEntityWorld().isRemote) {
			return 0;
		}

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			int psiNeeded = damage * ToolHelper.getMaxDurability(tool) / 30;
			int psiRecovered = CompatHelper.extractPsi(player, psiNeeded);
			int dmgRecovered = Math.floorDiv(psiRecovered, damage * ToolHelper.getMaxDurability(tool) / 30);
			psiRecovered -= dmgRecovered * damage * ToolHelper.getMaxDurability(tool) / 30;
			CompatHelper.insertPsi(player, psiRecovered);
			newDamage -= dmgRecovered;
		}
		return Math.max(0, newDamage);
	}
}
