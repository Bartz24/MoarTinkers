package com.bartz24.moartinkers.traits;

import java.util.ArrayList;
import java.util.List;

import com.bartz24.moartinkers.compat.CompatHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitEnergyRepair extends AbstractTrait {

	public TraitEnergyRepair() {
		super("energyrepair", 0xFC1C1C);
	}

	@Override
	public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {

		if (entity.getEntityWorld().isRemote) {
			return 0;
		}

		if (entity instanceof EntityPlayer) {
			int energyNeeded = damage * ToolHelper.getMaxDurability(tool) / 5;
			int energyRecovered = 0;
			EntityPlayer player = (EntityPlayer) entity;
			List<ItemStack> items = new ArrayList<>();
			items.addAll(CompatHelper.findItemsWithEnergy(player.inventory.armorInventory));
			items.addAll(CompatHelper.findItemsWithEnergy(player.inventory.mainInventory));
			items.addAll(CompatHelper.findItemsWithEnergy(player.inventory.offHandInventory));
			for (ItemStack stack : items) {
				if (energyRecovered >= energyNeeded)
					break;
				energyRecovered += CompatHelper.extractEnergy(stack, energyNeeded - energyRecovered, false);
				player.inventory.markDirty();
			}
			int dmgRecovered = Math.floorDiv(energyRecovered, damage * ToolHelper.getMaxDurability(tool) / 5);
			energyRecovered -= dmgRecovered * damage * ToolHelper.getMaxDurability(tool) / 5;
			for (ItemStack stack : items) {
				if (energyRecovered <= 0)
					break;
				energyRecovered -= CompatHelper.receiveEnergy(stack, energyRecovered, false);
				player.inventory.markDirty();
			}
			newDamage -= dmgRecovered;
		}
		return Math.max(0, newDamage);
	}
}
