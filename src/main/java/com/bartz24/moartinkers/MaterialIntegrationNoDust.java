package com.bartz24.moartinkers;

import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class MaterialIntegrationNoDust extends MoarMaterialIntegration {
	public MaterialIntegrationNoDust(Material material) {
		super(material, null);
	}

	public MaterialIntegrationNoDust(Material material, Fluid fluid) {
		super(null, material, fluid, null);
	}

	public MaterialIntegrationNoDust(Material material, Fluid fluid, String oreSuffix) {
		super("ingot" + oreSuffix, material, fluid, oreSuffix);
	}

	public MaterialIntegrationNoDust(String oreRequirement, Material material, Fluid fluid, String oreSuffix) {
		super(material, fluid, oreSuffix, oreRequirement);
	}

	public MaterialIntegrationNoDust(Material material, Fluid fluid, String oreSuffix, String... oreRequirement) {
		super(material, fluid, oreSuffix, oreRequirement);
	}
	
	public void integrateRecipes() {
	    if(!isIntegrated()) {
	      return;
	    }
	    // register melting and casting
	    if(fluid != null && oreSuffix != null) {
	      RandomHelper.noDustRegisterOredictMeltingCasting(fluid, oreSuffix);
	    }
	    if(material != null) {
	      TinkerSmeltery.registerToolpartMeltingCasting(material);
	    }
	  }
}
