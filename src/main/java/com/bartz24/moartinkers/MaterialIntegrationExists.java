package com.bartz24.moartinkers;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.materials.Material;

public class MaterialIntegrationExists extends MoarMaterialIntegration {
	public MaterialIntegrationExists(Material material) {
		super(material, null);
	}

	public MaterialIntegrationExists(Material material, Fluid fluid) {
		super(null, material, fluid, null);
	}

	public MaterialIntegrationExists(Material material, Fluid fluid, String oreSuffix) {
		super("ingot" + oreSuffix, material, fluid, oreSuffix);
	}

	public MaterialIntegrationExists(String oreRequirement, Material material, Fluid fluid, String oreSuffix) {
		super(material, fluid, oreSuffix, oreRequirement);
	}

	public MaterialIntegrationExists(Material material, Fluid fluid, String oreSuffix, String... oreRequirement) {
		super(material, fluid, oreSuffix, oreRequirement);
	}

	public void registerFluidBlock(IForgeRegistry<Block> registry) {
	}
}
