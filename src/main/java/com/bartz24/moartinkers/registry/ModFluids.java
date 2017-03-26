package com.bartz24.moartinkers.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class ModFluids {
	public static List<Fluid> moarFluids = new ArrayList<Fluid>();

	public static void registerFluid(String name, int color, int temp) {
		FluidMolten fluid = new FluidMolten(name, color);
		FluidRegistry.registerFluid(fluid);
		fluid.setTemperature(temp);
		moarFluids.add(fluid);
	}
}
