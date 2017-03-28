package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitConstant extends AbstractTrait {
	public TraitConstant() {
		super("constant", 0xC9BA47);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
		event.setNewSpeed(ToolHelper.getActualMiningSpeed(tool));
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		target.attackEntityFrom(
				DamageSource.causePlayerDamage((EntityPlayer) player).setDamageIsAbsolute().setDamageBypassesArmor(),
				newDamage);
		return -newDamage;
	}
}
