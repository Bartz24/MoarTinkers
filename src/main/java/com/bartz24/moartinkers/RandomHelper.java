package com.bartz24.moartinkers;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableSet;

import joptsimple.internal.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.library.smeltery.OreCastingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class RandomHelper {

	public static String capatilizeString(String s) {
		return s == null ? null : (s.substring(0, 1).toUpperCase() + s.substring(1));
	}

	public static IBlockState getBlockStateFromStack(ItemStack stack) {
		int meta = stack.getMetadata();
		if (!(stack.getItem() instanceof ItemBlock))
			return null;

		Block block = ((ItemBlock) stack.getItem()).getBlock();

		return block.getStateFromMeta(meta);
	}

	public static boolean itemStacksEqualOD(ItemStack stack1, ItemStack stack2) {
		if (stack1.isItemEqual(stack2))
			return true;

		if (stack1.isEmpty() && !stack2.isEmpty() && stack1.getMetadata() == OreDictionary.WILDCARD_VALUE
				|| stack2.getMetadata() == OreDictionary.WILDCARD_VALUE) {
			return stack1.getItem() == stack2.getItem();
		}
		return false;
	}

	public static boolean canStacksMerge(ItemStack stack1, ItemStack stack2) {
		if (stack1.isEmpty() || stack2.isEmpty()) {
			return false;
		}
		if (!stack1.isItemEqual(stack2)) {
			return false;
		}
		if (!ItemStack.areItemStackTagsEqual(stack1, stack2)) {
			return false;
		}
		return true;

	}

	public static int mergeStacks(ItemStack mergeSource, ItemStack mergeTarget, boolean doMerge) {
		if (!canStacksMerge(mergeSource, mergeTarget)) {
			return 0;
		}
		int mergeCount = Math.min(mergeTarget.getMaxStackSize() - mergeTarget.getCount(), mergeSource.getCount());
		if (mergeCount < 1) {
			return 0;
		}
		if (doMerge) {
			mergeTarget.grow(mergeCount);
		}
		return mergeCount;
	}

	public static ItemStack fillInventory(IInventory inv, ItemStack stack) {
		if (!inv.isEmpty()) {
			for (int i = 0; i < inv.getSizeInventory(); i++) {
				if (stack.isEmpty())
					return ItemStack.EMPTY;
				ItemStack inside = inv.getStackInSlot(i);
				if (inside.isEmpty()) {
					inv.setInventorySlotContents(i, stack);
					return ItemStack.EMPTY;
				} else if (RandomHelper.canStacksMerge(inside, stack)) {
					stack.shrink(RandomHelper.mergeStacks(stack, inside, true));
				}
			}
		}
		return stack;

	}

	public static ItemStack fillInventory(IItemHandler inv, ItemStack stack) {
		if (inv != null) {
			for (int i = 0; i < inv.getSlots(); i++) {
				if (stack.isEmpty())
					return ItemStack.EMPTY;
				ItemStack inside = inv.getStackInSlot(i);
				if (inside.isEmpty()) {
					inv.insertItem(i, stack, false);
					return ItemStack.EMPTY;
				} else if (RandomHelper.canStacksMerge(inside, stack)) {
					stack.shrink(RandomHelper.mergeStacks(stack, inside, true));
				}
			}
		}
		return stack;

	}

	public static void noDustRegisterOredictMeltingCasting(Fluid fluid, String ore) {
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
