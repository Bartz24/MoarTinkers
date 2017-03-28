package com.bartz24.moartinkers.traits;

import com.bartz24.moartinkers.compat.CompatHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitManaRepair extends AbstractTrait {

	public TraitManaRepair() {
		super("manarepair", 0x4D85FF);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {

		if (entity.getEntityWorld().isRemote) {
			return 0;
		}

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			int manaNeeded = damage * ToolHelper.getMaxDurability(tool) / 25;
			int manaRecovered = CompatHelper.extractMana(tool, player, manaNeeded);
			int dmgRecovered = Math.floorDiv(manaRecovered, damage * ToolHelper.getMaxDurability(tool) / 25);
			manaRecovered -= dmgRecovered * damage * ToolHelper.getMaxDurability(tool) / 25;
			CompatHelper.dispatchMana(tool, player, manaRecovered);
			newDamage -= dmgRecovered;
		}
		return Math.max(0, newDamage);
	}
}
