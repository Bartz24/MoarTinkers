package com.bartz24.moartinkers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.Pair;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.library.smeltery.OreCastingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.List;
import java.util.Set;

class RandomHelper {

	static void noDustRegisterOredictMeltingCasting(Fluid fluid, String ore) {
		ImmutableSet.Builder<Pair<List<ItemStack>, Integer>> builder = ImmutableSet.builder();
		Pair<List<ItemStack>, Integer> nuggetOre = Pair.of(OreDictionary.getOres("nugget" + ore),
				Material.VALUE_Nugget);
		Pair<List<ItemStack>, Integer> ingotOre = Pair.of(OreDictionary.getOres("ingot" + ore), Material.VALUE_Ingot);
		Pair<List<ItemStack>, Integer> blockOre = Pair.of(OreDictionary.getOres("block" + ore), Material.VALUE_Block);
		Pair<List<ItemStack>, Integer> oreOre = Pair.of(OreDictionary.getOres("ore" + ore), Material.VALUE_Ore());
		Pair<List<ItemStack>, Integer> oreNetherOre = Pair.of(OreDictionary.getOres("oreNether" + ore),
				(int) (2 * Material.VALUE_Ingot * Config.oreToIngotRatio));
		Pair<List<ItemStack>, Integer> oreDenseOre = Pair.of(OreDictionary.getOres("denseore" + ore),
				(int) (3 * Material.VALUE_Ingot * Config.oreToIngotRatio));
		Pair<List<ItemStack>, Integer> orePoorOre = Pair.of(OreDictionary.getOres("orePoor" + ore),
				(int) (Material.VALUE_Nugget * Config.oreToIngotRatio));
		Pair<List<ItemStack>, Integer> plateOre = Pair.of(OreDictionary.getOres("plate" + ore), Material.VALUE_Ingot);
		Pair<List<ItemStack>, Integer> gearOre = Pair.of(OreDictionary.getOres("gear" + ore), Material.VALUE_Ingot * 4);

		builder.add(nuggetOre, ingotOre, blockOre, oreOre, oreNetherOre, oreDenseOre, orePoorOre, plateOre, gearOre);
		Set<Pair<List<ItemStack>, Integer>> knownOres = builder.build();

		// register oredicts
		for (Pair<List<ItemStack>, Integer> pair : knownOres) {
			TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(pair.getLeft(), pair.getRight()), fluid));
		}

		// register oredict castings!
		// ingot casting
		TinkerRegistry.registerTableCasting(new OreCastingRecipe(ingotOre.getLeft(),
				RecipeMatch.ofNBT(TinkerSmeltery.castIngot), fluid, ingotOre.getRight()));
		// nugget casting
		TinkerRegistry.registerTableCasting(new OreCastingRecipe(nuggetOre.getLeft(),
				RecipeMatch.ofNBT(TinkerSmeltery.castNugget), fluid, nuggetOre.getRight()));
		// block casting
		TinkerRegistry.registerBasinCasting(new OreCastingRecipe(blockOre.getLeft(), null, // no
																							// cast
				fluid, blockOre.getRight()));
		// plate casting
		TinkerRegistry.registerTableCasting(new OreCastingRecipe(plateOre.getLeft(),
				RecipeMatch.ofNBT(TinkerSmeltery.castPlate), fluid, plateOre.getRight()));
		// gear casting
		TinkerRegistry.registerTableCasting(new OreCastingRecipe(gearOre.getLeft(),
				RecipeMatch.ofNBT(TinkerSmeltery.castGear), fluid, gearOre.getRight()));

		// and also cast creation!
		for (FluidStack fs : TinkerSmeltery.castCreationFluids) {
			TinkerRegistry.registerTableCasting(
					new CastingRecipe(TinkerSmeltery.castIngot, RecipeMatch.of(ingotOre.getLeft()), fs, true, true));
			TinkerRegistry.registerTableCasting(
					new CastingRecipe(TinkerSmeltery.castNugget, RecipeMatch.of(nuggetOre.getLeft()), fs, true, true));
			TinkerRegistry.registerTableCasting(
					new CastingRecipe(TinkerSmeltery.castPlate, RecipeMatch.of(plateOre.getLeft()), fs, true, true));
			TinkerRegistry.registerTableCasting(
					new CastingRecipe(TinkerSmeltery.castGear, RecipeMatch.of(gearOre.getLeft()), fs, true, true));
		}
	}
}
