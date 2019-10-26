package com.bartz24.moartinkers;

import com.bartz24.moartinkers.registry.ModAlloys;
import com.bartz24.moartinkers.registry.ModTraits;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.softc.armoryexpansion.ArmoryExpansion;
import org.softc.armoryexpansion.common.integration.aelib.integration.StandaloneJsonIntegration;

@Mod(
		modid = References.ModID,
		name = References.ModName,
		dependencies =
				"required-after:" + ArmoryExpansion.MODID + ";" +
				"after:appliedenergistics2;" +
				"after:bigreactors;" +
				"after:refinedstorage;" +
				"after:draconicevolution;" +
				"after:extrautils2;" +
				"after:projecte;" +
				"after:environmentaltech;" +
				"after:botania",
		useMetadata = true,
		guiFactory = "com.bartz24.moartinkers.config.ConfigGuiFactory")
public class MoarTinkers extends StandaloneJsonIntegration {
	public MoarTinkers() {
		super(References.ModID, References.ModID, References.ModID);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		this.configDir = event.getModConfigurationDirectory().getPath();
		new ModTraits();
		super.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModAlloys.init();
		super.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
