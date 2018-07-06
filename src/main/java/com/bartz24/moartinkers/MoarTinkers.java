package com.bartz24.moartinkers;

import org.apache.logging.log4j.Logger;

import com.bartz24.moartinkers.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.ModID, name = References.ModName, dependencies = "required-after:tconstruct;after:appliedenergistics2;after:bigreactors;after:refinedstorage;after:draconicevolution;after:extrautils2;after:projecte;after:environmentaltech", useMetadata = true, guiFactory = "com.bartz24.moartinkers.config.ConfigGuiFactory")
public class MoarTinkers {
	@SidedProxy(clientSide = "com.bartz24.moartinkers.proxy.ClientProxy", serverSide = "com.bartz24.moartinkers.proxy.ServerProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static MoarTinkers instance;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
