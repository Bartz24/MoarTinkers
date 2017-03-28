package com.bartz24.moartinkers.traits;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.TinkerEvent;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitOP extends AbstractTraitLeveled {

	public TraitOP() {
		super("op", String.valueOf(1), 0x545454, 2, 1);
	}

	@SubscribeEvent
	public void onToolBuilding(TinkerEvent.OnItemBuilding event) {
		if (TinkerUtil.hasTrait(event.tag, this.getIdentifier())) {
			ToolNBT data = TagUtil.getToolStats(event.tag);
			data.attackSpeedMultiplier *= 0.3f;
			NBTTagCompound toolTag = data.get();
			toolTag.setInteger(Tags.FREE_MODIFIERS, 0);
			TagUtil.setToolTag(event.tag, data.get());
		}
	}

	@Override
	public void applyModifierEffect(NBTTagCompound rootCompound) {
	    NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
	    toolTag.setInteger(Tags.FREE_MODIFIERS, 0);
	    TagUtil.setToolTag(rootCompound, toolTag);
	}
}
