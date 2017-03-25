package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.MaterialIntegrationNoDust;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerFluids;

public class ModMaterials {
	public static Material matEnderium;
	public static Material matPlatinum;
	public static Material matIridium;
	public static Material matMithril;
	public static Material matSignalum;
	public static Material matLumium;
	public static Material matConstantan;
	public static Material matInvar;
	public static Material matNickel;
	public static Material matTin;

	public static Material matRefGlowstone;
	public static Material matRefObsidian;
	public static Material matOsmium;

	public static Material matManasteel;
	public static Material matTerrasteel;
	public static Material matElementium;

	public static Material matElecSteel;
	public static Material matEnerAlloy;
	public static Material matVibrAlloy;
	public static Material matRedAlloy;
	public static Material matCondIron;
	public static Material matPulsIron;
	public static Material matDarkSteel;
	public static Material matSoularium;

	public static Material matYellorium;
	public static Material matCyanite;
	public static Material matBlutonium;
	public static Material matLudicrite;

	public static Material matQuartzIron;

	public static Material matDraconium;
	public static Material matWyvDraconium;
	public static Material matAwaDraconium;
	public static Material matChaDraconium;

	public static void preInit() {
		FluidRegistry.enableUniversalBucket();

		matEnderium = ingotMaterialNoDust("Enderium", 0x006E61, 1200);
		TinkerRegistry.addMaterialStats(matEnderium, new HeadMaterialStats(1020, 8.31f, 10.19f, HarvestLevels.COBALT),
				new HandleMaterialStats(0.42f, 400), new ExtraMaterialStats(60), new BowMaterialStats(1.22f, 1.1f, 5f));

		matPlatinum = ingotMaterial("Platinum", 0x39CAFA, 900);
		TinkerRegistry.addMaterialStats(matPlatinum, new HeadMaterialStats(1410, 9.47f, 7.39f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.78f, 600), new ExtraMaterialStats(120),
				new BowMaterialStats(0.67f, 0.6f, 3f));

		matIridium = ingotMaterial("Iridium", 0xEBEBEB, 1500);
		TinkerRegistry.addMaterialStats(matIridium, new HeadMaterialStats(1910, 11.02f, 9.95f, HarvestLevels.COBALT),
				new HandleMaterialStats(0.83f, 500), new ExtraMaterialStats(200),
				new BowMaterialStats(0.23f, 1.44f, 5f));

		matMithril = ingotMaterial("Mithril", 0x2095B0, 1350);
		TinkerRegistry.addMaterialStats(matMithril, new HeadMaterialStats(1160, 13.02f, 7.03f, HarvestLevels.COBALT),
				new HandleMaterialStats(0.49f, 200), new ExtraMaterialStats(30),
				new BowMaterialStats(1.87f, 1.12f, 3f));

		matSignalum = ingotMaterial("Signalum", 0xE65B10, 950);
		TinkerRegistry.addMaterialStats(matSignalum, new HeadMaterialStats(740, 13.42f, 6.37f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.52f, 100), new ExtraMaterialStats(40),
				new BowMaterialStats(3.24f, 0.78f, 3f));

		matLumium = ingotMaterial("Lumium", 0xFFFCB0, 1000);
		TinkerRegistry.addMaterialStats(matLumium, new HeadMaterialStats(600, 9.60f, 9.34f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.44f, 90), new ExtraMaterialStats(20), new BowMaterialStats(2.89f, 2.36f, 9f));

		if (!Loader.isModLoaded("ImmersiveEngineering")) {
			matConstantan = ingotMaterial("Constantan", 0xD9B34A, 500);
			TinkerRegistry.addMaterialStats(matConstantan,
					new HeadMaterialStats(300, 4.45f, 5.03f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(0.34f, 135), new ExtraMaterialStats(13),
					new BowMaterialStats(2.31f, 1.43f, 4f));
		}

		matInvar = ingotMaterial("Invar", 0xC4C4C4, 1040);
		TinkerRegistry.addMaterialStats(matInvar, new HeadMaterialStats(700, 7.22f, 6.22f, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.64f, 220), new ExtraMaterialStats(32),
				new BowMaterialStats(0.92f, 0.76f, 7f));

		matNickel = ingotMaterialExist(TinkerFluids.nickel, "Nickel", 0xDEDEA9);
		TinkerRegistry.addMaterialStats(matNickel, new HeadMaterialStats(20, 3.63f, 5.10f, HarvestLevels.IRON),
				new HandleMaterialStats(0.14f, 30), new ExtraMaterialStats(7), new BowMaterialStats(0.24f, 1.34f, 3f));

		matTin = ingotMaterialExist(TinkerFluids.tin, "Tin", 0xA5C3C4);
		TinkerRegistry.addMaterialStats(matTin, new HeadMaterialStats(300, 1.85f, 2.27f, HarvestLevels.IRON),
				new HandleMaterialStats(1.34f, 120), new ExtraMaterialStats(40),
				new BowMaterialStats(2.59f, 0.87f, 1f));

		if (Loader.isModLoaded("Mekanism")) {

			matRefObsidian = ingotMaterialNoDust("RefinedObsidian", 0x732668, 1600);
			TinkerRegistry.addMaterialStats(matRefObsidian,
					new HeadMaterialStats(1400, 5.24f, 14.04f, HarvestLevels.COBALT),
					new HandleMaterialStats(2.19f, 400), new ExtraMaterialStats(340),
					new BowMaterialStats(0.11f, 0.43f, 12f));

			matRefGlowstone = ingotMaterial("RefinedGlowstone", 0xF0EC29, 1300);
			TinkerRegistry.addMaterialStats(matRefGlowstone,
					new HeadMaterialStats(900, 10.43f, 9.43f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(0.84f, 140), new ExtraMaterialStats(100),
					new BowMaterialStats(2.31f, 1.99f, 8f));

			matOsmium = ingotMaterial("Osmium", 0x87A5FF, 600);
			TinkerRegistry.addMaterialStats(matOsmium, new HeadMaterialStats(500, 3.73f, 4.01f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(1.19f, 98), new ExtraMaterialStats(48),
					new BowMaterialStats(0.98f, 1.09f, 4f));
		}

		if (Loader.isModLoaded("Botania")) {
			matManasteel = ingotMaterial("Manasteel", 0x62E1F5, 500);
			TinkerRegistry.addMaterialStats(matManasteel,
					new HeadMaterialStats(400, 6.21f, 3.87f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(1.07f, 120), new ExtraMaterialStats(71),
					new BowMaterialStats(1.33f, 1.44f, 5f));

			matTerrasteel = ingotMaterial("Terrasteel", 0x4EE823, 1400);
			TinkerRegistry.addMaterialStats(matTerrasteel,
					new HeadMaterialStats(960, 9.53f, 12.03f, HarvestLevels.COBALT),
					new HandleMaterialStats(1.45f, 200), new ExtraMaterialStats(136),
					new BowMaterialStats(0.76f, 0.97f, 7f));

			matElementium = ingotMaterial("Elementium", 0xED3BD8, 1400);
			TinkerRegistry.addMaterialStats(matElementium,
					new HeadMaterialStats(200, 8.01f, 7.04f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(3.01f, -50), new ExtraMaterialStats(-20),
					new BowMaterialStats(4.01f, 0.53f, 2f));
		}

		if (Loader.isModLoaded("EnderIO")) {
			matElecSteel = ingotMaterialExist(FluidRegistry.getFluid("electricalsteel"), "ElectricalSteel", 0xD1D1D1);
			TinkerRegistry.addMaterialStats(matElecSteel, new HeadMaterialStats(350, 5.87f, 2.42f, HarvestLevels.IRON),
					new HandleMaterialStats(0.76f, -10), new ExtraMaterialStats(10),
					new BowMaterialStats(0.97f, 2.10f, 7f));

			matEnerAlloy = ingotMaterialExist(FluidRegistry.getFluid("energeticalloy"), "EnergeticAlloy", 0xF5C011);
			TinkerRegistry.addMaterialStats(matEnerAlloy,
					new HeadMaterialStats(420, 7.84f, 1.07f, HarvestLevels.DIAMOND), new HandleMaterialStats(1.00f, 20),
					new ExtraMaterialStats(50), new BowMaterialStats(1.54f, 1.52f, 6f));

			matVibrAlloy = ingotMaterialExist(FluidRegistry.getFluid("vibrantalloy"), "VibrantAlloy", 0x2DFA3E);
			TinkerRegistry.addMaterialStats(matVibrAlloy,
					new HeadMaterialStats(970, 9.88f, 3.41f, HarvestLevels.COBALT), new HandleMaterialStats(1.85f, 200),
					new ExtraMaterialStats(150), new BowMaterialStats(2.12f, 2.41f, 7f));

			matRedAlloy = ingotMaterialExist(FluidRegistry.getFluid("redstonealloy"), "RedstoneAlloy", 0xD61818);
			TinkerRegistry.addMaterialStats(matRedAlloy, new HeadMaterialStats(114, 15.53f, 1.41f, HarvestLevels.IRON),
					new HandleMaterialStats(0.11f, -70), new ExtraMaterialStats(-40),
					new BowMaterialStats(6.42f, 0.67f, 0.5f));

			matCondIron = ingotMaterialExist(FluidRegistry.getFluid("conductiveiron"), "ConductiveIron", 0xE87676);
			TinkerRegistry.addMaterialStats(matCondIron,
					new HeadMaterialStats(347, 8.03f, 3.43f, HarvestLevels.DIAMOND), new HandleMaterialStats(0.46f, 10),
					new ExtraMaterialStats(5), new BowMaterialStats(1.99f, 1.00f, 3f));

			matPulsIron = ingotMaterialExist(FluidRegistry.getFluid("pulsatingiron"), "PulsatingIron", 0x15D474);
			TinkerRegistry.addMaterialStats(matPulsIron,
					new HeadMaterialStats(362, 7.10f, 5.10f, HarvestLevels.DIAMOND), new HandleMaterialStats(1.01f, 99),
					new ExtraMaterialStats(76), new BowMaterialStats(1.65f, 10.98f, 7f));

			matDarkSteel = ingotMaterialExist(FluidRegistry.getFluid("darksteel"), "DarkSteel", 0x292828);
			TinkerRegistry.addMaterialStats(matDarkSteel,
					new HeadMaterialStats(1100, 9.87f, 10.91f, HarvestLevels.COBALT),
					new HandleMaterialStats(1.87f, 300), new ExtraMaterialStats(400),
					new BowMaterialStats(1.34f, 2.67f, 6f));

			matSoularium = ingotMaterialExist(FluidRegistry.getFluid("soularium"), "Soularium", 0x613E16);
			TinkerRegistry.addMaterialStats(matSoularium,
					new HeadMaterialStats(870, 4.32f, 12.66f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(1.11f, 100), new ExtraMaterialStats(125),
					new BowMaterialStats(0.76f, 1.25f, 10f));
		}

		if (Loader.isModLoaded("bigreactors")) {
			matYellorium = ingotMaterialExist(FluidRegistry.getFluid("yellorium"), "Yellorium", 0xFAF748);
			TinkerRegistry.addMaterialStats(matYellorium,
					new HeadMaterialStats(660, 7.52f, 5.08f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(0.76f, -40), new ExtraMaterialStats(-20),
					new BowMaterialStats(0.97f, 0.79f, 3f));

			matCyanite = ingotMaterialExist(FluidRegistry.getFluid("cyanite"), "Cyanite", 0x25C9DB);
			TinkerRegistry.addMaterialStats(matCyanite,
					new HeadMaterialStats(300, 6.53f, 4.83f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(1.53f, 20), new ExtraMaterialStats(60),
					new BowMaterialStats(2.51f, 1.11f, 8f));

			matBlutonium = ingotMaterial("Blutonium", 0x2918C4, 1500);
			TinkerRegistry.addMaterialStats(matBlutonium,
					new HeadMaterialStats(800, 8.09f, 6.23f, HarvestLevels.COBALT), new HandleMaterialStats(1.06f, 90),
					new ExtraMaterialStats(50), new BowMaterialStats(1.25f, 1.02f, 12f));

			matLudicrite = ingotMaterial("Ludicrite", 0xD42CD4, 1700);
			TinkerRegistry.addMaterialStats(matLudicrite,
					new HeadMaterialStats(1400, 11.21f, 12.42f, HarvestLevels.COBALT),
					new HandleMaterialStats(2.34f, 400), new ExtraMaterialStats(300),
					new BowMaterialStats(4.52f, 3.21f, 13f));
		}

		if (Loader.isModLoaded("refinedstorage")) {
			Item quartzIron = Item.REGISTRY.getObject(new ResourceLocation("refinedstorage", "quartz_enriched_iron"));
			matQuartzIron = new Material("quartzenrichediron", 0xE6E6E6);
			matQuartzIron.addItem(quartzIron, 1, Material.VALUE_Ingot);
			matQuartzIron.setCastable(true);
			matQuartzIron.setRepresentativeItem(quartzIron);
			TinkerIntegration.integrate(matQuartzIron, registerFluid(matQuartzIron, 900)).integrate();
			TinkerRegistry.registerMelting(quartzIron, FluidRegistry.getFluid("quartzenrichediron"), 144);
			TinkerRegistry.addMaterialStats(matQuartzIron,
					new HeadMaterialStats(500, 7.65f, 8.83f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(1.22f, 140), new ExtraMaterialStats(70),
					new BowMaterialStats(0.64f, 0.86f, 4f));
		}

		if (Loader.isModLoaded("draconicevolution")) {
			Item dracCore = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "draconic_core"));
			matDraconium = new Material("draconium", 0x7A2EC7);
			matDraconium.addItem(dracCore, 1, Material.VALUE_Ingot);
			matDraconium.setCraftable(true);
			matDraconium.setRepresentativeItem(dracCore);
			TinkerIntegration.integrate(matDraconium).integrate();
			TinkerRegistry.addMaterialStats(matDraconium,
					new HeadMaterialStats(1400, 12.04f, 13.53f, HarvestLevels.COBALT),
					new HandleMaterialStats(1.86f, 400), new ExtraMaterialStats(300),
					new BowMaterialStats(2.56f, 1.62f, 10f));

			Item wyvCore = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "wyvern_core"));
			matWyvDraconium = new Material("wyverndraconium", 0x181333);
			matWyvDraconium.addItem(wyvCore, 1, Material.VALUE_Ingot);
			matWyvDraconium.setCraftable(true);
			matWyvDraconium.setRepresentativeItem(wyvCore);
			TinkerIntegration.integrate(matWyvDraconium).integrate();
			TinkerRegistry.addMaterialStats(matWyvDraconium, new HeadMaterialStats(1700, 16.35f, 19.76f, 5),
					new HandleMaterialStats(2.76f, 600), new ExtraMaterialStats(450),
					new BowMaterialStats(4.06f, 2.98f, 14f));

			Item awaCore = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "awakened_core"));
			matAwaDraconium = new Material("awakeneddraconium", 0xFFBB00);
			matAwaDraconium.addItem(awaCore, 1, Material.VALUE_Ingot);
			matAwaDraconium.setCraftable(true);
			matAwaDraconium.setRepresentativeItem(awaCore);
			TinkerIntegration.integrate(matAwaDraconium).integrate();
			TinkerRegistry.addMaterialStats(matAwaDraconium, new HeadMaterialStats(2000, 19.64f, 21.52f, 6),
					new HandleMaterialStats(3.12f, 800), new ExtraMaterialStats(600),
					new BowMaterialStats(5.60f, 3.76f, 20f));

			Item chaCore = Item.REGISTRY.getObject(new ResourceLocation("draconicevolution", "chaotic_core"));
			matChaDraconium = new Material("chaoticdraconium", 0x171717);
			matChaDraconium.addItem(chaCore, 1, Material.VALUE_Ingot);
			matChaDraconium.setCraftable(true);
			matChaDraconium.setRepresentativeItem(chaCore);
			TinkerIntegration.integrate(matChaDraconium).integrate();
			TinkerRegistry.addMaterialStats(matChaDraconium, new HeadMaterialStats(3000, 32.73f, 50.76f, 7),
					new HandleMaterialStats(5.31f, 1200), new ExtraMaterialStats(1000),
					new BowMaterialStats(8.96f, 5.14f, 40f));
		}
	}

	private static Material ingotMaterial(String name, int color, int temp) {
		Material material = new Material(name.toLowerCase(), color);
		material.addItemIngot("ingot" + name);
		material.setCastable(true);
		TinkerIntegration.integrate(material, registerFluid(material, temp), name).toolforge().integrate();
		return material;
	}

	private static Material ingotMaterialNoDust(String name, int color, int temp) {
		Material material = new Material(name.toLowerCase(), color);
		material.addItemIngot("ingot" + name);
		material.setCastable(true);
		MaterialIntegrationNoDust m = new MaterialIntegrationNoDust(material, registerFluid(material, temp), name);
		TinkerIntegration.integrationList.add(m);
		m.toolforge().integrate();
		return material;
	}

	private static Material ingotMaterialExist(Fluid fluid, String name, int color) {
		Material material = new Material(name.toLowerCase(), color);
		material.addItemIngot("ingot" + name);
		TinkerIntegration.integrate(material, fluid, name).toolforge().integrate();
		return material;
	}

	private static Fluid registerFluid(Material material, int temp) {
		FluidMolten fluid = new FluidMolten(material.getIdentifier(), material.materialTextColor);
		FluidRegistry.registerFluid(fluid);
		fluid.setTemperature(temp);
		return fluid;
	}
}
