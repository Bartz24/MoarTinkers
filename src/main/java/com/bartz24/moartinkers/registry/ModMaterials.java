package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.MaterialIntegrationNoDust;
import com.bartz24.moartinkers.MoarMaterialIntegration;
import com.bartz24.moartinkers.traits.TraitMoarWritable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
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
	public static Material matAluminum;
	public static Material matBrass;
	public static Material matZinc;

	public static Material matRefGlowstone;
	public static Material matRefObsidian;
	public static Material matOsmium;

	public static Material matManasteel;
	public static Material matTerrasteel;
	public static Material matElementium;
	public static Material matGaia;

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

	public static Material matEnchMetal;
	public static Material matMagWood;

	public static Material matPsimetal;
	public static Material matIvoryPsimetal;
	public static Material matEbonyPsimetal;

	public static Material matDarkMatter;
	public static Material matRedMatter;

	public static Material matFluxElec;

	public static Material matHardStone;
	public static Material matAlabaster;
	public static Material matBasalt;
	public static Material matLonsdaleite;
	public static Material matMica;

	public static Material matTitanium;
	public static Material matTungsten;
	public static Material matTungstensteel;
	public static Material matChrome;
	public static Material matRefinedIron;
	public static Material matAdvAlloy;
	public static Material matRuby;
	public static Material matSapphire;
	public static Material matPeridot;
	public static Material matRedGarnet;
	public static Material matYellowGarnet;
	public static Material matRubber;

	public static Material matCertus;
	public static Material matFluix;

	private static boolean force = false;

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

		if (!Loader.isModLoaded("immersiveengineering")) {
			force = true;
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

		matNickel = ingotMaterialExist(TinkerFluids.nickel, "Nickel", TinkerFluids.nickel.color);
		TinkerRegistry.addMaterialStats(matNickel, new HeadMaterialStats(20, 3.63f, 5.10f, HarvestLevels.IRON),
				new HandleMaterialStats(0.14f, 30), new ExtraMaterialStats(7), new BowMaterialStats(0.24f, 1.34f, 3f));

		matTin = ingotMaterialExist(TinkerFluids.tin, "Tin", TinkerFluids.tin.color);
		TinkerRegistry.addMaterialStats(matTin, new HeadMaterialStats(300, 1.85f, 2.27f, HarvestLevels.IRON),
				new HandleMaterialStats(1.34f, 120), new ExtraMaterialStats(40),
				new BowMaterialStats(2.59f, 0.87f, 1f));

		matBrass = ingotMaterialExist(TinkerFluids.brass, "Brass", TinkerFluids.brass.color);
		TinkerRegistry.addMaterialStats(matBrass, new HeadMaterialStats(260, 2.98f, 1.76f, HarvestLevels.IRON),
				new HandleMaterialStats(1.11f, 10), new ExtraMaterialStats(4), new BowMaterialStats(1.32f, 1.63f, 3f));

		matAluminum = ingotMaterialExist(TinkerFluids.aluminum, "Aluminum", TinkerFluids.aluminum.color);
		TinkerRegistry.addMaterialStats(matAluminum, new HeadMaterialStats(80, 1.23f, 0.85f, HarvestLevels.IRON),
				new HandleMaterialStats(0.21f, -20), new ExtraMaterialStats(-10),
				new BowMaterialStats(0.21f, 0.34f, 0.6f));

		matZinc = ingotMaterialExist(TinkerFluids.zinc, "Zinc", TinkerFluids.zinc.color);
		TinkerRegistry.addMaterialStats(matZinc, new HeadMaterialStats(40, 1.76f, 0.53f, HarvestLevels.IRON),
				new HandleMaterialStats(0.19f, -25), new ExtraMaterialStats(-12),
				new BowMaterialStats(0.32f, 0.43f, 0.4f));

		matRefObsidian = ingotMaterialNoDust("RefinedObsidian", 0x732668, 1600);
		TinkerRegistry.addMaterialStats(matRefObsidian,
				new HeadMaterialStats(1400, 5.24f, 14.04f, HarvestLevels.COBALT), new HandleMaterialStats(2.19f, 400),
				new ExtraMaterialStats(340), new BowMaterialStats(0.11f, 0.43f, 12f));

		matRefGlowstone = ingotMaterial("RefinedGlowstone", 0xF0EC29, 1300);
		TinkerRegistry.addMaterialStats(matRefGlowstone,
				new HeadMaterialStats(900, 10.43f, 9.43f, HarvestLevels.OBSIDIAN), new HandleMaterialStats(0.84f, 140),
				new ExtraMaterialStats(100), new BowMaterialStats(2.31f, 1.99f, 8f));

		matOsmium = ingotMaterial("Osmium", 0x87A5FF, 600);
		TinkerRegistry.addMaterialStats(matOsmium, new HeadMaterialStats(500, 3.73f, 4.01f, HarvestLevels.DIAMOND),
				new HandleMaterialStats(1.19f, 98), new ExtraMaterialStats(48), new BowMaterialStats(0.98f, 1.09f, 4f));
		if (!Loader.isModLoaded("botanicaladdons")) {
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

			matElementium = ingotMaterial("ElvenElementium", 0xED3BD8, 1400);
			TinkerRegistry.addMaterialStats(matElementium,
					new HeadMaterialStats(200, 8.01f, 7.04f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(3.01f, -50), new ExtraMaterialStats(-20),
					new BowMaterialStats(4.01f, 0.53f, 2f));

			matGaia = ingotMaterial("gaia", "gaiaIngot", 0x9157B5, 1600);
			TinkerRegistry.registerMelting("gaiaIngot", FluidRegistry.getFluid("gaia"), 144);
			TinkerRegistry.addMaterialStats(matGaia, new HeadMaterialStats(1600, 14.52f, 19.62f, HarvestLevels.COBALT),
					new HandleMaterialStats(1.63f, 260), new ExtraMaterialStats(180),
					new BowMaterialStats(1.54f, 6.45f, 15f));
		}

		if (Loader.isModLoaded("EnderIO")) {
			matElecSteel = ingotMaterialExist(FluidRegistry.getFluid("electricalsteel"), "ElectricalSteel", 0xD1D1D1);
			TinkerRegistry.addMaterialStats(matElecSteel, new HeadMaterialStats(350, 5.87f, 2.42f, HarvestLevels.IRON),
					new HandleMaterialStats(0.76f, -10), new ExtraMaterialStats(10),
					new BowMaterialStats(0.97f, 2.10f, 7f));

			matEnerAlloy = ingotMaterialExist(FluidRegistry.getFluid("energeticalloy"), "EnergeticAlloy", 0xFFB300);
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
			force = true;
			matYellorium = ingotMaterialExist(FluidRegistry.getFluid("yellorium"), "Yellorium", 0xFAF748);
			TinkerRegistry.addMaterialStats(matYellorium,
					new HeadMaterialStats(660, 7.52f, 5.08f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(0.76f, -40), new ExtraMaterialStats(-20),
					new BowMaterialStats(0.97f, 0.79f, 3f));

			force = true;
			matCyanite = ingotMaterialExist(FluidRegistry.getFluid("cyanite"), "Cyanite", 0x25C9DB);
			TinkerRegistry.addMaterialStats(matCyanite,
					new HeadMaterialStats(300, 6.53f, 4.83f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(1.53f, 20), new ExtraMaterialStats(60),
					new BowMaterialStats(2.51f, 1.11f, 8f));
		}

		if (Loader.isModLoaded("bigreactors"))
			force = true;
		matBlutonium = ingotMaterial("Blutonium", 0x2918C4, 1500);
		TinkerRegistry.addMaterialStats(matBlutonium, new HeadMaterialStats(800, 8.09f, 6.23f, HarvestLevels.COBALT),
				new HandleMaterialStats(1.06f, 90), new ExtraMaterialStats(50),
				new BowMaterialStats(1.25f, 1.02f, 12f));

		if (Loader.isModLoaded("bigreactors"))
			force = true;
		matLudicrite = ingotMaterial("Ludicrite", 0xD42CD4, 1700);
		TinkerRegistry.addMaterialStats(matLudicrite, new HeadMaterialStats(1400, 11.21f, 12.42f, HarvestLevels.COBALT),
				new HandleMaterialStats(2.34f, 400), new ExtraMaterialStats(300),
				new BowMaterialStats(4.52f, 3.21f, 13f));

		ModFluids.registerFluid("quartzenrichediron", 0xE6E6E6, 900);
		if (Loader.isModLoaded("refinedstorage")) {
			force = true;
			Item quartzIron = Item.REGISTRY.getObject(new ResourceLocation("refinedstorage", "quartz_enriched_iron"));
			matQuartzIron = new Material("quartzenrichediron", 0xE6E6E6);
			matQuartzIron.addItem(quartzIron, 1, Material.VALUE_Ingot);
			matQuartzIron.setCastable(true);
			matQuartzIron.setRepresentativeItem(quartzIron);
			TinkerIntegration.integrate(matQuartzIron, FluidRegistry.getFluid("quartzenrichediron")).integrate();
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
			matAwaDraconium = new Material("awakeneddraconium", 0xFFC929);
			matAwaDraconium.addItem(awaCore, 1, Material.VALUE_Ingot);
			matAwaDraconium.setCraftable(true);
			matAwaDraconium.setRepresentativeItem(awaCore);
			TinkerIntegration.integrate(matAwaDraconium).integrate();
			TinkerRegistry.addMaterialStats(matAwaDraconium, new HeadMaterialStats(2000, 25.43f, 29.52f, 6),
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

		if (Loader.isModLoaded("extrautils2")) {
			Item magWood = Item.REGISTRY.getObject(new ResourceLocation("extrautils2", "decorativesolidwood"));
			matMagWood = new Material("magicalwood", 0xB7C752);
			matMagWood.addItem(new ItemStack(magWood, 1, 1), 1, Material.VALUE_Ingot);
			matMagWood.setCraftable(true);
			matMagWood.setRepresentativeItem(new ItemStack(magWood, 1, 1));
			matMagWood.addTrait(new TraitMoarWritable(1));
			matMagWood.addTrait(new TraitMoarWritable(2), MaterialTypes.HEAD);
			TinkerIntegration.integrate(matMagWood).integrate();
			TinkerRegistry.addMaterialStats(matMagWood, new HeadMaterialStats(120, 1.23f, 1.65f, HarvestLevels.STONE),
					new HandleMaterialStats(0.78f, 10), new ExtraMaterialStats(20),
					new BowMaterialStats(0.96f, 0.87f, 0.5f));
		}

		matEnchMetal = ingotMaterial("EnchantedMetal", 0x80F222, 1500);
		matEnchMetal.addTrait(new TraitMoarWritable(1));
		matEnchMetal.addTrait(new TraitMoarWritable(2), MaterialTypes.HEAD);
		TinkerRegistry.addMaterialStats(matEnchMetal, new HeadMaterialStats(360, 7.53f, 8.52f, HarvestLevels.COBALT),
				new HandleMaterialStats(1.25f, 80), new ExtraMaterialStats(50), new BowMaterialStats(1.12f, 1.35f, 6f));

		matPsimetal = ingotMaterial("Psi", 0x0CE8DD, 800);
		TinkerRegistry.addMaterialStats(matPsimetal, new HeadMaterialStats(450, 9.04f, 8.01f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(1.12f, 140), new ExtraMaterialStats(80),
				new BowMaterialStats(1.45f, 1.26f, 5f));

		matIvoryPsimetal = ingotMaterial("IvoryPsi", 0xF5F5F5, 1700);
		TinkerRegistry.addMaterialStats(matIvoryPsimetal,
				new HeadMaterialStats(980, 14.06f, 11.07f, HarvestLevels.COBALT), new HandleMaterialStats(1.53f, 300),
				new ExtraMaterialStats(170), new BowMaterialStats(2.74f, 1.75f, 6f));

		matEbonyPsimetal = ingotMaterial("EbonyPsi", 0x0A0A0A, 1700);
		TinkerRegistry.addMaterialStats(matEbonyPsimetal,
				new HeadMaterialStats(1210, 11.76f, 14.06f, HarvestLevels.COBALT), new HandleMaterialStats(1.98f, 400),
				new ExtraMaterialStats(290), new BowMaterialStats(1.64f, 2.56f, 10f));

		if (Loader.isModLoaded("ProjectE")) {
			Item matter = Item.REGISTRY.getObject(new ResourceLocation("projecte", "item.pe_matter"));
			matDarkMatter = new Material("darkmatter", 0x270133);
			matDarkMatter.addItem(new ItemStack(matter, 1, 0), 1, Material.VALUE_Ingot);
			matDarkMatter.setCraftable(true);
			matDarkMatter.setRepresentativeItem(new ItemStack(matter, 1, 0));
			TinkerIntegration.integrate(matDarkMatter).integrate();
			TinkerRegistry.addMaterialStats(matDarkMatter,
					new HeadMaterialStats(1200, 13.62f, 9.04f, HarvestLevels.COBALT),
					new HandleMaterialStats(2.03f, 350), new ExtraMaterialStats(200),
					new BowMaterialStats(1.87f, 3.54f, 8f));

			matRedMatter = new Material("redmatter", 0xE30000);
			matRedMatter.addItem(new ItemStack(matter, 1, 1), 1, Material.VALUE_Ingot);
			matRedMatter.setCraftable(true);
			matRedMatter.setRepresentativeItem(new ItemStack(matter, 1, 1));
			TinkerIntegration.integrate(matRedMatter).integrate();
			TinkerRegistry.addMaterialStats(matRedMatter,
					new HeadMaterialStats(1900, 16.74f, 15.07f, HarvestLevels.COBALT),
					new HandleMaterialStats(3.86f, 500), new ExtraMaterialStats(500),
					new BowMaterialStats(2.98f, 5.06f, 16f));
		}

		matFluxElec = ingotMaterial("ElectrumFlux", 0xFFF56B, 1800);
		TinkerRegistry.addMaterialStats(matFluxElec, new HeadMaterialStats(1100, 13.52f, 14.06f, HarvestLevels.COBALT),
				new HandleMaterialStats(2.43f, 240), new ExtraMaterialStats(230),
				new BowMaterialStats(2.26f, 3.41f, 8f));

		matHardStone = materialPart("hardenedstone", "stoneHardened", 0x595959);
		TinkerRegistry.addMaterialStats(matHardStone, new HeadMaterialStats(200, 3.74f, 2.56f, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.53f, 90), new ExtraMaterialStats(50), new BowMaterialStats(0.83f, 0.21f, 1f));

		matBasalt = materialPart("basalt", "stoneBasalt", 0x292929);
		TinkerRegistry.addMaterialStats(matBasalt, new HeadMaterialStats(272, 5.07f, 4.86f, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.96f, 100), new ExtraMaterialStats(60),
				new BowMaterialStats(0.64f, 0.42f, 2f));

		matAlabaster = materialPart("alabaster", "stoneAlabaster", 0xFFFFFF);
		TinkerRegistry.addMaterialStats(matAlabaster, new HeadMaterialStats(225, 4.63f, 4.21f, HarvestLevels.IRON),
				new HandleMaterialStats(1.21f, 70), new ExtraMaterialStats(70), new BowMaterialStats(0.88f, 0.78f, 3f));

		matLonsdaleite = materialPart("lonsdaleite", "blockLonsdaleite", 0x1A1A1A);
		TinkerRegistry.addMaterialStats(matLonsdaleite, new HeadMaterialStats(1200, 0.97f, 1.54f, HarvestLevels.COBALT),
				new HandleMaterialStats(3.41f, 100), new ExtraMaterialStats(200),
				new BowMaterialStats(0.12f, 0.04f, 0.2f));

		if (Loader.isModLoaded("environmentaltech")) {
			Item mica = Item.REGISTRY.getObject(new ResourceLocation("environmentaltech", "mica"));

			matMica = new Material("mica", 0xDEDEDE);
			matMica.addItem(mica, 1, Material.VALUE_Ingot);
			matMica.setCraftable(true);
			matMica.setRepresentativeItem(mica);
			TinkerIntegration.integrate(matMica).integrate();
			TinkerRegistry.addMaterialStats(matMica, new HeadMaterialStats(703, 5.62f, 6.32f, HarvestLevels.OBSIDIAN),
					new HandleMaterialStats(2.13f, 100), new ExtraMaterialStats(250),
					new BowMaterialStats(3.04f, 4.06f, 5f));
		}

		matRefinedIron = ingotMaterial("RefinedIron", 0xE0E0E0, 780);
		TinkerRegistry.addMaterialStats(matRefinedIron,
				new HeadMaterialStats(450, 7.86f, 9.53f, HarvestLevels.OBSIDIAN), new HandleMaterialStats(1.23f, 140),
				new ExtraMaterialStats(120), new BowMaterialStats(0.56f, 1.45f, 7f));

		matTungsten = ingotMaterial("Tungsten", 0x464659, 1800);
		TinkerRegistry.addMaterialStats(matTungsten, new HeadMaterialStats(680, 8.42f, 11.52f, HarvestLevels.COBALT),
				new HandleMaterialStats(1.73f, 220), new ExtraMaterialStats(115),
				new BowMaterialStats(0.98f, 5.17f, 9.5f));

		matTungstensteel = ingotMaterial("Tungstensteel", 0x464659, 2100);
		TinkerRegistry.addMaterialStats(matTungstensteel,
				new HeadMaterialStats(1120, 8.97f, 14.53f, HarvestLevels.COBALT), new HandleMaterialStats(2.42f, 320),
				new ExtraMaterialStats(200), new BowMaterialStats(0.65f, 4.12f, 13f));

		matTitanium = ingotMaterial("Titanium", 0xBABABA, 1400);
		TinkerRegistry.addMaterialStats(matTitanium, new HeadMaterialStats(590, 7.63f, 10.41f, HarvestLevels.COBALT),
				new HandleMaterialStats(1.52f, 180), new ExtraMaterialStats(95),
				new BowMaterialStats(1.0f, 3.52f, 7.6f));

		matChrome = ingotMaterial("Chrome", 0xD6D6D6, 1600);
		TinkerRegistry.addMaterialStats(matChrome, new HeadMaterialStats(800, 9.16f, 7.83f, HarvestLevels.COBALT),
				new HandleMaterialStats(0.74f, 250), new ExtraMaterialStats(140),
				new BowMaterialStats(1.52f, 2.15f, 5f));

		matAdvAlloy = ingotMaterial("AdvancedAlloy", 0xFFBBA8, 1500);
		TinkerRegistry.addMaterialStats(matAdvAlloy, new HeadMaterialStats(1600, 13.63f, 13.23f, HarvestLevels.COBALT),
				new HandleMaterialStats(2.65f, 400), new ExtraMaterialStats(500),
				new BowMaterialStats(0.75f, 0.98f, 16f));

		matRuby = materialPart("ruby", "gemRuby", 0xCF0000);
		TinkerRegistry.addMaterialStats(matRuby, new HeadMaterialStats(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.74f, 100), new ExtraMaterialStats(80),
				new BowMaterialStats(1.97f, 2.26f, 6f));

		matSapphire = materialPart("sapphire", "gemSapphire", 0x0B33D6);
		TinkerRegistry.addMaterialStats(matSapphire, new HeadMaterialStats(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.74f, 100), new ExtraMaterialStats(80),
				new BowMaterialStats(1.97f, 2.26f, 6f));

		matPeridot = materialPart("peridot", "gemPeridot", 0x15E835);
		TinkerRegistry.addMaterialStats(matPeridot, new HeadMaterialStats(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.74f, 100), new ExtraMaterialStats(80),
				new BowMaterialStats(1.97f, 2.26f, 6f));

		matYellowGarnet = materialPart("yellowgarnet", "gemYellowGarnet", 0xF5F51B);
		TinkerRegistry.addMaterialStats(matYellowGarnet,
				new HeadMaterialStats(800, 11.54f, 7.42f, HarvestLevels.OBSIDIAN), new HandleMaterialStats(0.82f, 120),
				new ExtraMaterialStats(95), new BowMaterialStats(1.67f, 2.41f, 7f));

		matRedGarnet = materialPart("redgarnet", "gemRedGarnet", 0xED2424);
		TinkerRegistry.addMaterialStats(matRedGarnet, new HeadMaterialStats(800, 11.54f, 7.42f, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.82f, 120), new ExtraMaterialStats(95),
				new BowMaterialStats(1.67f, 2.41f, 7f));

		matRubber = materialPart("rubber", "itemRubber", 0x5C4F4F);
		TinkerRegistry.addMaterialStats(matRubber, new HeadMaterialStats(14, 0.95f, 0.12f, HarvestLevels.IRON),
				new HandleMaterialStats(0.87f, 10), new ExtraMaterialStats(3), new BowMaterialStats(6.42f, 1.42f, 0.3f),
				new BowStringMaterialStats(2.65f));

		if (Loader.isModLoaded("appliedenergistics2")) {
			Item material = Item.REGISTRY.getObject(new ResourceLocation("appliedenergistics2", "material"));
			matCertus = new Material("certus", 0xCCE4F0);
			matCertus.addItem(new ItemStack(material, 1, 0), 1, Material.VALUE_Ingot);
			matCertus.setCraftable(true);
			matCertus.setRepresentativeItem(new ItemStack(material, 1, 0));
			TinkerIntegration.integrate(matCertus).integrate();
			TinkerRegistry.addMaterialStats(matCertus, new HeadMaterialStats(490, 7.45f, 10.45f, HarvestLevels.IRON),
					new HandleMaterialStats(0.74f, 30), new ExtraMaterialStats(26),
					new BowMaterialStats(2.31f, 1.23f, 12f));

			matFluix = new Material("fluix", 0xB04EDE);
			matFluix.addItem(new ItemStack(material, 1, 7), 1, Material.VALUE_Ingot);
			matFluix.setCraftable(true);
			matFluix.setRepresentativeItem(new ItemStack(material, 1, 7));
			TinkerIntegration.integrate(matFluix).integrate();
			TinkerRegistry.addMaterialStats(matFluix, new HeadMaterialStats(680, 13.32f, 12.65f, HarvestLevels.DIAMOND),
					new HandleMaterialStats(0.45f, 10), new ExtraMaterialStats(40),
					new BowMaterialStats(2.87f, 4.53f, 14f));
		}
	}

	private static Material ingotMaterial(String name, int color, int temp) {
		Material material = new Material(name.toLowerCase(), color);
		ModFluids.registerFluid(name.toLowerCase(), color, temp);
		if (force)
			material.addItemIngot("ingot" + name);

		MoarMaterialIntegration m = new MoarMaterialIntegration(material, FluidRegistry.getFluid(name.toLowerCase()),
				name);
		m.setRepresentativeItem("ingot" + name).toolforge();
		m.integrate();
		TinkerIntegration.integrationList.add(m);

		if (!force)
			material.addItemIngot("ingot" + name);
		material.setCastable(true);
		force = false;
		return material;
	}

	private static Material ingotMaterial(String name, String oreName, int color, int temp) {
		Material material = new Material(name, color);
		ModFluids.registerFluid(name, color, temp);
		if (force)
			material.addItemIngot(oreName);

		MoarMaterialIntegration m = new MoarMaterialIntegration(oreName, material, FluidRegistry.getFluid(name), null);
		m.setRepresentativeItem(oreName).toolforge();
		m.integrate();
		TinkerIntegration.integrationList.add(m);

		if (!force)
			material.addItemIngot(oreName);
		material.setCastable(true);
		force = false;
		return material;
	}

	private static Material materialPart(String name, String oreName, int color) {
		Material material = new Material(name, color);
		if (force)
			material.addItemIngot(oreName);

		MoarMaterialIntegration m = new MoarMaterialIntegration(oreName, material, null, null);
		m.setRepresentativeItem(oreName);
		m.integrate();
		TinkerIntegration.integrationList.add(m);

		if (!force)
			material.addItemIngot(oreName);
		material.setCraftable(true);
		force = false;
		return material;
	}

	private static Material ingotMaterialNoDust(String name, int color, int temp) {
		Material material = new Material(name.toLowerCase(), color);
		ModFluids.registerFluid(name.toLowerCase(), color, temp);
		if (force)
			material.addItemIngot("ingot" + name);

		MaterialIntegrationNoDust m = new MaterialIntegrationNoDust(material,
				FluidRegistry.getFluid(name.toLowerCase()), name);
		m.toolforge();
		m.integrate();
		TinkerIntegration.integrationList.add(m);

		if (!force)
			material.addItemIngot("ingot" + name);
		material.setCastable(true);
		force = false;
		return material;
	}

	private static Material ingotMaterialExist(Fluid fluid, String name, int color) {
		Material material = new Material(name.toLowerCase(), color);
		if (force)
			material.addItemIngot("ingot" + name);
		TinkerIntegration.integrate(material, fluid, name).toolforge().integrate();
		if (!force)
			material.addItemIngot("ingot" + name);
		force = false;
		return material;
	}
}
