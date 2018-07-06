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

public class TraitEnergyEater extends AbstractTrait {

	public TraitEnergyEater() {
		super("energyeater", 0x9C0000);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {

		if (event.getEntityPlayer().world.isRemote) {
			return;
		}

		int maxEnergy = (int) Math.pow(event.getNewSpeed(), 2.4f);
		int energy = 0;
		List<ItemStack> items = new ArrayList<>();
		items.addAll(CompatHelper.findItemsWithEnergy(event.getEntityPlayer().inventory.armorInventory));
		items.addAll(CompatHelper.findItemsWithEnergy(event.getEntityPlayer().inventory.mainInventory));
		items.addAll(CompatHelper.findItemsWithEnergy(event.getEntityPlayer().inventory.offHandInventory));
		for (ItemStack stack : items) {
			if (energy >= maxEnergy)
				break;
			energy += CompatHelper.extractEnergy(stack, maxEnergy - energy, false);
			event.getEntityPlayer().inventory.markDirty();
		}
		event.setNewSpeed(event.getNewSpeed() * (1f + (float) energy / (float) maxEnergy * 2.3f));
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {

		if (player.world.isRemote) {
			return newDamage;
		}

		if (player instanceof EntityPlayer) {
			EntityPlayer actualPlayer = (EntityPlayer) player;
			int maxEnergy = (int) Math.pow(ToolHelper.getActualDamage(tool, actualPlayer) * 1.3f, 2.5f);
			int energy = 0;
			List<ItemStack> items = new ArrayList<>();
			items.addAll(CompatHelper.findItemsWithEnergy(actualPlayer.inventory.armorInventory));
			items.addAll(CompatHelper.findItemsWithEnergy(actualPlayer.inventory.mainInventory));
			items.addAll(CompatHelper.findItemsWithEnergy(actualPlayer.inventory.offHandInventory));
			for (ItemStack stack : items) {
				if (energy >= maxEnergy)
					break;
				energy += CompatHelper.extractEnergy(stack, maxEnergy - energy, false);
				actualPlayer.inventory.markDirty();
			}
			return newDamage * (1f + (float) energy / (float) maxEnergy * 1.4f);
		}

		return newDamage;
	}
}
