package com.bartz24.moartinkers.proxy;

import com.bartz24.moartinkers.registry.ModAlloys;
import com.bartz24.moartinkers.registry.ModMaterials;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	//EventHandler events = new EventHandler();

	public void preInit(FMLPreInitializationEvent e)
	{
	//	ConfigOptions.loadConfigThenSave(e);
		//ModBlocks.init();
		//ModItems.init();
		ModMaterials.preInit();
		//new ModGuiHandler();

	}

	public void init(FMLInitializationEvent e)
	{
		//NetworkRegistry.INSTANCE.registerGuiHandler(RefinedExchange.instance, new ModGuiHandler());
		//ModCrafting.initOreDict();
		ModAlloys.init();
	}

	public void postInit(FMLPostInitializationEvent e)
	{
		//ModCrafting.init();
	}
	
	public void registerFluidModel(Fluid fluid)
	{
		
	}
}
