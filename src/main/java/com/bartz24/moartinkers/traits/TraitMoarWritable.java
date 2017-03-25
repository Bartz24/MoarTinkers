package com.bartz24.moartinkers.traits;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;

public class TraitMoarWritable extends AbstractTraitLeveled {

	public TraitMoarWritable(int levels) {
		super("moarwritable", String.valueOf(levels), 0xffffff, 5, 1);
	}

	@Override
	public void applyModifierEffect(NBTTagCompound rootCompound) {
		NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
		int modifiers = toolTag.getInteger(Tags.FREE_MODIFIERS) + levels * 3;
		toolTag.setInteger(Tags.FREE_MODIFIERS, Math.max(0, modifiers));
		TagUtil.setToolTag(rootCompound, toolTag);
	}
}
