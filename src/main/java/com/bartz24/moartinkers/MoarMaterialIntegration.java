package com.bartz24.moartinkers;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class MoarMaterialIntegration extends MaterialIntegration {
	protected boolean integrated;
	private boolean preInit;
	protected boolean force;

	public MoarMaterialIntegration(Material material, Fluid fluid, String oreSuffix) {
		this("ingot" + oreSuffix, material, fluid, oreSuffix);
	}

	public MoarMaterialIntegration(String oreRequirement, Material material, Fluid fluid, String oreSuffix) {
		this(material, fluid, oreSuffix, oreRequirement);
	}

	private MoarMaterialIntegration(Material material, Fluid fluid, String oreSuffix, String... oreRequirement) {
		super(material, fluid, RandomHelper.capatilizeString(oreSuffix), oreRequirement);

		this.integrated = false;
		this.preInit = false;
	}

	public void preInit() {
		preInit(false);
	}

	public void preInit(boolean force) {
		if (preInit) {
			return;
		}
		this.force = force;

		preInit = true;

		// decativate fluids if smeltery isn't loaded
		if (!TConstruct.pulseManager.isPulseLoaded(TinkerSmeltery.PulseId)) {
			fluid = null;
		}

		// fluid first.
		if (fluid != null) {
			Fluid registeredFluid = FluidRegistry.getFluid(fluid.getName());

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
	}

	public boolean isIntegrated() {
		return integrated;
	}

	public void integrateRecipes() {
		if (integrated) {
			return;
		}

		if (!force && oreRequirement != null && oreRequirement.length > 0 && !Config.forceRegisterAll) {
			for (String ore : oreRequirement) {
				if (OreDictionary.getOres(ore, false).isEmpty()) {
					return;
				}
			}
		}
		integrated = true;
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
		return this;
	}
}
