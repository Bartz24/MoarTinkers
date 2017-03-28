package com.bartz24.moartinkers.compat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.ManaItemHandler;

public class BotaniaHelper {
	public static int extractMana(ItemStack stack, EntityPlayer player, int maxExtract) {
		return ManaItemHandler.requestManaForTool(stack, player, maxExtract, true);
	}
	
	public static int dispatchMana(ItemStack stack, EntityPlayer player, int dispatch) {
		return ManaItemHandler.dispatchMana(stack, player, dispatch, true);
	}
}
