package com.bartz24.moartinkers.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

public class ModAlloys {
    private static void registerMelting(ItemStack itemStack, int amountNeeded, int amountMatched, String fluid, int temperature) {
        TinkerRegistry.registerMelting(new MeltingRecipe(new RecipeMatch.Item(itemStack, amountNeeded, amountMatched), FluidRegistry.getFluid(fluid), temperature));
    }

    private static void registerMelting(Item item, int amountNeeded, int amountMatched, String fluid, int temperature) {
        registerMelting(new ItemStack(item), amountNeeded, amountMatched, fluid, temperature);
    }

    private static void registerMelting(Block block, int amountNeeded, int amountMatched, String fluid, int temperature) {
        registerMelting(new ItemStack(block), amountNeeded, amountMatched, fluid, temperature);
    }

	public static void init() {
		registerAlloy("signalum*144", "redstone*250", "copper*108", "silver*36");
		registerAlloy("lumium*144", "glowstone*250", "tin*108", "silver*36");
		registerAlloy("invar*3", "iron*2", "nickel*1");
		if (!Loader.isModLoaded("immersiveengineering"))
			registerAlloy("constantan*2", "copper*1", "nickel*1");
		registerAlloy("enderium*144", "lead*108", "platinum*36", "ender*250");
		registerAlloy("electrumflux*144", "electrum*144", "redstone*500");
		if (Loader.isModLoaded("thermalfoundation")) {
			TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidRegistry.getFluid("pyrotheum"), 50), 400);

			registerMelting(Items.REDSTONE, 1, 100, "redstone", 800);
			registerMelting(Blocks.REDSTONE_BLOCK, 1, 900, "redstone", 1400);
			registerMelting(Items.GLOWSTONE_DUST, 1, 250, "glowstone", 1100);
			registerMelting(Blocks.GLOWSTONE, 1, 1000, "glowstone", 1500);
			registerMelting(Items.ENDER_PEARL, 1, 250, "ender", 1200);
		}

	}

	public static void registerAlloy(String out, String... in) {
		FluidStack sOut = getFluidLoaded(out);
		List<FluidStack> sIns = new ArrayList<FluidStack>();
		for (String s : in) {
			sIns.add(getFluidLoaded(s));
		}
		if (sOut != null && !sIns.contains(null))
			TinkerRegistry.registerAlloy(sOut, sIns.toArray(new FluidStack[sIns.size()]));

	}

	public static FluidStack getFluidLoaded(String fluid) {
		String[] result = fluid.split("\\*");
		if (result.length == 2 && FluidRegistry.getFluid(result[0]) != null) {
			return new FluidStack(FluidRegistry.getFluid(result[0]), Integer.parseInt(result[1]));
		}
		return null;
	}
}
