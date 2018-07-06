package com.bartz24.moartinkers.compat;

import net.minecraft.entity.player.EntityPlayer;
import vazkii.psi.api.cad.ICAD;
import vazkii.psi.common.core.handler.PlayerDataHandler;

public class PsiHelper {
	public static int extractPsi(EntityPlayer player, int maxExtract) {
		if (PlayerDataHandler.get(player) != null && !PlayerDataHandler.get(player).getCAD().isEmpty()) {
			int amount = PlayerDataHandler.get(player).getAvailablePsi();
			PlayerDataHandler.get(player).deductPsi(Math.min(maxExtract, amount), 20, true);
			return Math.min(maxExtract, amount);
		}
		return 0;
	}

	public static void insertPsi(EntityPlayer player, int amount) {
		if (PlayerDataHandler.get(player) != null && !PlayerDataHandler.get(player).getCAD().isEmpty()) {
			ICAD cad = (ICAD) PlayerDataHandler.get(player).getCAD().getItem();
			cad.regenPsi(PlayerDataHandler.get(player).getCAD(), amount);
		}
	}
}
