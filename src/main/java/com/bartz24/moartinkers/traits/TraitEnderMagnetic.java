package com.bartz24.moartinkers.traits;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.potion.TinkerPotion;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitEnderMagnetic extends AbstractTrait {

	public static TinkerPotion enderMagnetic = new EnderMagneticPotion();

	public TraitEnderMagnetic() {
		super("endermagnetic", 0x3E8269);
	}

	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player,
			boolean wasEffective) {
		ModifierNBT data = new ModifierNBT(TinkerUtil.getModifierTag(tool, identifier));
		enderMagnetic.apply(player, 30, 1);
	}

	@Override
	public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
			boolean isCritical) {
		ModifierNBT data = new ModifierNBT(TinkerUtil.getModifierTag(tool, identifier));
		enderMagnetic.apply(player, 30, 1);
	}

	private static class EnderMagneticPotion extends TinkerPotion {

		public EnderMagneticPotion() {
			super(Util.getResource("endermagnetic"), false, false);
		}

		@Override
		public boolean isReady(int duration, int strength) {
			return (duration & 1) == 0;
		}

		@Override
		public void performEffect(@Nonnull EntityLivingBase entity, int id) {
			if (!entity.world.isRemote) {
				double x = entity.posX;
				double y = entity.posY;
				double z = entity.posZ;
				double range = 4d;

				List<EntityItem> items = entity.getEntityWorld().getEntitiesWithinAABB(EntityItem.class,
						new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
				int pulled = 0;
				for (EntityItem item : items) {
					if (item.getItem().isEmpty() || item.isDead) {
						continue;
					}

					if (pulled > 200) {
						break;
					}
					entity.world.spawnEntity(new EntityItem(entity.world, x, y, z, item.getItem()));
					entity.world.removeEntity(item);
					pulled++;
				}
			}
		}
	}
}
