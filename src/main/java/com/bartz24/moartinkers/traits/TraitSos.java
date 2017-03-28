package com.bartz24.moartinkers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSos extends AbstractTrait {

	public TraitSos() {
		super("sos", 0x3F06CF);
	}

	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (!entity.world.isRemote && ToolHelper.getCurrentDurability(tool) >= 200 && entity instanceof EntityLivingBase
				&& isSelected
				&& ((EntityLivingBase) entity).getHealth() / ((EntityLivingBase) entity).getMaxHealth() <= 0.25f) {
			int durability = ToolHelper.getCurrentDurability(tool);
			int level = Math.floorDiv(durability, 4000);
			((EntityLivingBase) entity).clearActivePotions();
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, durability, level));
			((EntityLivingBase) entity)
					.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, durability, level));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, durability, level));
			((EntityLivingBase) entity).heal(Integer.MAX_VALUE);
			tool.setItemDamage(tool.getMaxDamage());
			ToolHelper.breakTool(tool, (EntityLivingBase) entity);
		}
	}
}
