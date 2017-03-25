package com.bartz24.moartinkers.registry;

import javax.annotation.Nonnull;

import com.bartz24.moartinkers.References;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

public class ModRenderers {

	public static void preInit() {
		if (ModMaterials.matEnderium != null)
			mapFluidState(ModMaterials.matEnderium.getFluid());
		if (ModMaterials.matPlatinum != null)
			mapFluidState(ModMaterials.matPlatinum.getFluid());
		if (ModMaterials.matIridium != null)
			mapFluidState(ModMaterials.matIridium.getFluid());
		if (ModMaterials.matMithril != null)
			mapFluidState(ModMaterials.matMithril.getFluid());
		if (ModMaterials.matSignalum != null)
			mapFluidState(ModMaterials.matSignalum.getFluid());
		if (ModMaterials.matLumium != null)
			mapFluidState(ModMaterials.matLumium.getFluid());
		if (ModMaterials.matInvar != null)
			mapFluidState(ModMaterials.matInvar.getFluid());
		if (ModMaterials.matConstantan != null)
			mapFluidState(ModMaterials.matConstantan.getFluid());
		if (ModMaterials.matRefGlowstone != null)
			mapFluidState(ModMaterials.matRefGlowstone.getFluid());
		if (ModMaterials.matRefObsidian != null)
			mapFluidState(ModMaterials.matRefObsidian.getFluid());
		if (ModMaterials.matOsmium != null)
			mapFluidState(ModMaterials.matOsmium.getFluid());
		if (ModMaterials.matManasteel != null)
			mapFluidState(ModMaterials.matManasteel.getFluid());
		if (ModMaterials.matTerrasteel != null)
			mapFluidState(ModMaterials.matTerrasteel.getFluid());
		if (ModMaterials.matElementium != null)
			mapFluidState(ModMaterials.matElementium.getFluid());
		if (ModMaterials.matBlutonium != null)
			mapFluidState(ModMaterials.matBlutonium.getFluid());
		if (ModMaterials.matLudicrite != null)
			mapFluidState(ModMaterials.matLudicrite.getFluid());
		if (ModMaterials.matQuartzIron != null)
			mapFluidState(ModMaterials.matQuartzIron.getFluid());
	}

	private static void mapFluidState(Fluid fluid) {
		Block block = fluid.getBlock();
		Item item = Item.getItemFromBlock(block);
		FluidStateMapper mapper = new FluidStateMapper(fluid);
		if (item != null) {
			ModelLoader.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, mapper);
		}
		ModelLoader.setCustomStateMapper(block, mapper);
	}

	static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {
		public final ModelResourceLocation location;

		public FluidStateMapper(Fluid fluid) {
			this.location = new ModelResourceLocation(References.ModID + ":fluid_block", fluid.getName());
		}

		@Nonnull
		@Override
		protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
			return location;
		}

		@Nonnull
		@Override
		public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
			return location;
		}
	}

}
