package com.bartz24.moartinkers;

import com.bartz24.moartinkers.registry.ModMaterials;
import org.apache.logging.log4j.Logger;

import com.bartz24.moartinkers.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.softc.armoryexpansion.ArmoryExpansion;
import org.softc.armoryexpansion.common.integration.aelib.integration.JsonIntegration;

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
public class MoarTinkers extends JsonIntegration{
	@SidedProxy(clientSide = "com.bartz24.moartinkers.proxy.ClientProxy", serverSide = "com.bartz24.moartinkers.proxy.ServerProxy")
	private static CommonProxy proxy;

//	@Mod.Instance
//	public static MoarTinkers instance;

	private static Logger logger;

	public MoarTinkers() {
		super(References.ModID, References.ModID, References.ModID);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
//		super.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
//		super.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		ModMaterials.exportMaterialsFromCode(this.configDir + "/" + References.ModID + "/" + References.ModID + "-exported-materials.json");
//		super.postInit(event);
	}
}
