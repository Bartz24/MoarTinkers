package com.bartz24.moartinkers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitReflect extends AbstractTrait {
	public TraitReflect() {
		super("reflect", 0x908AFF);
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		if (!player.world.isRemote && random.nextFloat() <= 0.4f) {
			Entity entity = event.getSource().getTrueSource();
			if (entity instanceof EntityLivingBase && entity.isEntityAlive()) {
				((EntityLivingBase) entity).attackEntityFrom(new EntityDamageSource("reflect", player),
						event.getAmount());
			}
		}
	}
}
