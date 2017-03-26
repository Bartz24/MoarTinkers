package com.bartz24.moartinkers;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTools;

public class MoarMaterialIntegration extends MaterialIntegration {
	private boolean integrated;
	private boolean toolforge;

	public MoarMaterialIntegration(Material material) {
		super(material, null);
	}

	public MoarMaterialIntegration(Material material, Fluid fluid) {
		super(null, material, fluid, null);
	}

	public MoarMaterialIntegration(Material material, Fluid fluid, String oreSuffix) {
		super("ingot" + oreSuffix, material, fluid, oreSuffix);
	}

	public MoarMaterialIntegration(String oreRequirement, Material material, Fluid fluid, String oreSuffix) {
		super(material, fluid, oreSuffix, oreRequirement);
	}

	public MoarMaterialIntegration(Material material, Fluid fluid, String oreSuffix, String... oreRequirement) {
		super(material, fluid, oreSuffix, oreRequirement);

		this.integrated = false;
	}

	public void registerFluidBlock() {
		TinkerFluids.registerMoltenBlock(fluid);
		MoarTinkers.proxy.registerFluidModel(fluid);
	}

	public void integrate() {
		if (integrated) {
			return;
		}

		if (oreRequirement != null && oreRequirement.length > 0 && !Config.forceRegisterAll) {
			int found = 0;
			for (String ore : OreDictionary.getOreNames()) {
				for (int i = 0; i < oreRequirement.length; i++) {
					if (oreRequirement[i].equals(ore)) {
						if(OreDictionary.getOres(ore).size() > 0)
						{
						if (++found == oreRequirement.length) {
							break;
						}
						}
					}
				}
			}
			// prerequisite not fulfilled
			if (found < oreRequirement.length) {
				return;
			}
		}

		integrated = true;

		// decativate fluids if smeltery isn't loaded
		if (!TConstruct.pulseManager.isPulseLoaded(TinkerSmeltery.PulseId)) {
			fluid = null;
		}

		// fluid first.
		if (fluid != null) {
			Fluid registeredFluid = FluidRegistry.getFluid(fluid.getName());
			// we only register blocks and buckets if it's our own fluid
			if (registeredFluid == fluid && fluid.getBlock() == null) {
				registerFluidBlock();
			}

			// we register a bucket for the fluid if it's not done because we
			// need it
			if (!FluidRegistry.getBucketFluids().contains(registeredFluid)) {
				FluidRegistry.addBucketForFluid(registeredFluid);
			}
		}

		// register material
		if (material != null) {
			TinkerRegistry.addMaterial(material);
			if (fluid != null) {
				material.setFluid(fluid);
				material.setCastable(true);
			} else {
				material.setCraftable(true);
			}
		}

		// add toolforge recipe
		if (toolforge && oreSuffix != null && !oreSuffix.isEmpty()) {
			TinkerTools.registerToolForgeBlock("block" + oreSuffix);
		}
	}

	public boolean isIntegrated() {
		return integrated;
	}

	public void integrateRecipes() {
		if (!integrated) {
			return;
		}
		// register melting and casting
		if (fluid != null && oreSuffix != null) {
			TinkerSmeltery.registerOredictMeltingCasting(fluid, oreSuffix);
		}
		if (material != null) {
			TinkerSmeltery.registerToolpartMeltingCasting(material);
		}
	}

	public MaterialIntegration toolforge() {
		super.toolforge();
		toolforge = true;
		return this;
	}
}
