package com.bartz24.moartinkers.compat;

import java.util.ArrayList;
import java.util.List;

import cofh.redstoneflux.api.IEnergyContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fml.common.Loader;

public class CompatHelper {
	public static List<ItemStack> findItemsWithEnergy(NonNullList<ItemStack> inventory) {
		List<ItemStack> stacks = new ArrayList<>();
		for (ItemStack stack : inventory) {
			if (!stack.isEmpty() && ((stack.hasCapability(CapabilityEnergy.ENERGY, null)
					&& stack.getCapability(CapabilityEnergy.ENERGY, null).getEnergyStored() > 0)
					|| (stack.getItem() instanceof IEnergyContainerItem
					&& ((IEnergyContainerItem) stack.getItem()).getEnergyStored(stack) > 0))) {
				stacks.add(stack);
			}
		}
		return stacks;
	}

	public static int extractEnergy(ItemStack stack, int maxExtract, boolean simulate) {
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).extractEnergy(maxExtract, simulate);
		} else if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).extractEnergy(stack, maxExtract, simulate);
		}
		return 0;
	}

	public static int receiveEnergy(ItemStack stack, int maxInsert, boolean simulate) {
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).receiveEnergy(maxInsert, simulate);
		} else if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).receiveEnergy(stack, maxInsert, simulate);
		}
		return 0;
	}
	
	public static int extractMana(ItemStack stack, EntityPlayer player, int maxExtract) {

		if(Loader.isModLoaded("botania"))
		{
			return BotaniaHelper.extractMana(stack, player, maxExtract);
		}
		return 0;
	}
	
	public static int dispatchMana(ItemStack stack, EntityPlayer player, int dispatch) {

		if(Loader.isModLoaded("botania"))
		{
			return BotaniaHelper.dispatchMana(stack, player, dispatch);
		}
		return 0;
	}
	
	public static int extractPsi(EntityPlayer player, int maxExtract) {

		if(Loader.isModLoaded("psi"))
		{
			return PsiHelper.extractPsi(player, maxExtract);
		}
		return 0;
	}
	
	public static void insertPsi(EntityPlayer player, int amount) {

		if(Loader.isModLoaded("psi"))
		{
			PsiHelper.insertPsi(player, amount);
		}
	}
}
