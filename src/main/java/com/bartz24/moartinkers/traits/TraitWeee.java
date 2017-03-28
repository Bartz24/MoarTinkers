package com.bartz24.moartinkers.traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitWeee extends AbstractTrait {

	public TraitWeee() {
		super("weee", 0xFFFC30);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
		if (event.getState().getBlock().getHarvestLevel(event.getState()) < ToolHelper.getHarvestLevelStat(tool)) {
			event.setNewSpeed(ToolHelper.getActualMiningSpeed(tool) * 2.5f);
		}
	}
}
