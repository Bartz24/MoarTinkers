package com.bartz24.moartinkers.proxy;

import com.bartz24.moartinkers.config.ConfigOptions;
import com.bartz24.moartinkers.registry.ModAlloys;
import com.bartz24.moartinkers.registry.ModMaterials;
import com.bartz24.moartinkers.registry.ModTraits;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	//EventHandler events = new EventHandler();

	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigOptions.loadConfigThenSave(e);
		new ModTraits();
		ModMaterials.preInit();

	}

	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(ModTraits.op);
		ModAlloys.init();
		ModMaterials.init();
	}

	public void postInit(FMLPostInitializationEvent e)
	{
	}

}
