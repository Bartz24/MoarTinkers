package com.bartz24.moartinkers;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.common.config.Config;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class MaterialIntegrationNoDust extends MoarMaterialIntegration {

	public MaterialIntegrationNoDust(Material material, Fluid fluid, String oreSuffix) {
		super("ingot" + oreSuffix, material, fluid, oreSuffix);
	}

	public void integrateRecipes() {
		if (integrated || !force && oreRequirement != null && oreRequirement.length > 0 && !Config.forceRegisterAll) {
			for (String ore : oreRequirement) {
				if (OreDictionary.getOres(ore, false).isEmpty()) {
					return;
				}
			}
		}
		integrated = true;
		
	    // register melting and casting
	    if(fluid != null && oreSuffix != null) {
	      RandomHelper.noDustRegisterOredictMeltingCasting(fluid, oreSuffix);
	    }
	    if(material != null) {
	      TinkerSmeltery.registerToolpartMeltingCasting(material);
	    }
	  }
}
