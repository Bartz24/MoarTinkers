package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.MaterialIntegrationExists;
import com.bartz24.moartinkers.MaterialIntegrationNoDust;
import com.bartz24.moartinkers.MoarMaterialIntegration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.softc.armoryexpansion.common.integration.aelib.plugins.constructs_armory.material.ArmorToolRangedMaterial;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

public class ModMaterials {
    static boolean force = false;

    private static MaterialRegistration[] materials = new MaterialRegistration[]{
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("enderium").setColor(0x006E61).setTemp(1200)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.enderference, null),
                                    new Tuple<ITrait, String>(ModTraits.enderMagnetic, MaterialTypes.HEAD)
                            })
                    .setHead(1020, 8.31f, 10.19f, HarvestLevels.COBALT)
                    .setHandle(0.42f, 600).setExtra(60)
                    .setBow(1.22f, 1.1f, 5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("platinum").setColor(0x39CAFA).setTemp(900)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.dense, null)
                            })
                    .setHead(1410, 9.47f, 7.39f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.78f, 600).setExtra(120)
                    .setBow(0.67f, 0.6f, 3f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("iridium").setColor(0xEBEBEB).setTemp(1500)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.weee, MaterialTypes.HEAD)
                            })
                    .setHead(1910, 11.02f, 9.95f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.83f, 500).setExtra(200)
                    .setBow(0.23f, 1.44f, 5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("mithril").setColor(0x2095B0).setTemp(1350)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.sos, null)
                            })
                    .setHead(1160, 13.02f, 7.03f, HarvestLevels.COBALT)
                    .setHandle(0.49f, 200).setExtra(30)
                    .setBow(1.87f, 1.23f, 3f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("signalum").setColor(0xE65B10).setTemp(950)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.unnatural, null)
                            })
                    .setHead(740, 12.42f, 6.37f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.52f, 100).setExtra(40)
                    .setBow(3.24f, 0.78f, 3f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("lumium").setColor(0xFFFCB0).setTemp(1000)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.lightboost, null)
                            })
                    .setHead(600, 0.6f, 8.34f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.44f, 90).setExtra(20)
                    .setBow(2.89f, 2.36f, 9f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("constantan").setColor(0xD9B34A).setTemp(500)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.constant, null)
                            })
                    .setHead(300, 4.45f, 5.03f, HarvestLevels.DIAMOND)
                    .setHandle(0.34f, 135).setExtra(13)
                    .setBow(2.31f, 1.43f, 4f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("invar").setColor(0xC4C4C4).setTemp(1040)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.magnetic, null),
                                    new Tuple<ITrait, String>(TinkerTraits.magnetic2, MaterialTypes.HEAD)
                            })
                    .setHead(700, 7.22f, 6.22f, HarvestLevels.DIAMOND)
                    .setHandle(0.64f, 220).setExtra(32)
                    .setBow(0.92f, 0.76f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("nickel").setColor(TinkerFluids.nickel.color)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.exploit, MaterialTypes.HEAD)
                            })
                    .setHead(20, 3.63f, 5.10f, HarvestLevels.IRON)
                    .setHandle(0.14f, 30).setExtra(7)
                    .setBow(0.92f, 0.76f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("tin").setColor(TinkerFluids.tin.color)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.sos, null)
                            })
                    .setHead(300, 1.85f, 2.27f, HarvestLevels.IRON)
                    .setHandle(1.34f, 120).setExtra(40)
                    .setBow(2.59f, 0.87f, 1f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("brass").setColor(TinkerFluids.brass.color)
                    .setHead(260, 2.98f, 1.76f, HarvestLevels.IRON)
                    .setHandle(1.11f, 10).setExtra(4)
                    .setBow(1.32f, 1.63f, 3f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("aluminum").setColor(TinkerFluids.aluminum.color)
                    .setHead(80, 1.23f, 0.85f, HarvestLevels.IRON)
                    .setHandle(0.21f, -20).setExtra(-10)
                    .setBow(0.21f, 0.34f, 0.6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("zinc").setColor(TinkerFluids.zinc.color)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.crumbling, null)
                            })
                    .setHead(40, 1.76f, 0.53f, HarvestLevels.IRON)
                    .setHandle(0.19f, -25).setExtra(-12)
                    .setBow(0.32f, 0.43f, 0.4f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("refinedobsidian").setOreSuffix("RefinedObsidian").setColor(0x732668).setTemp(1600)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.duritos, null),
                                    new Tuple<ITrait, String>(ModTraits.darkness, null)
                            })
                    .setHead(1400, 5.24f, 11.04f, HarvestLevels.COBALT)
                    .setHandle(2.19f, 400).setExtra(340)
                    .setBow(0.11f, 0.43f, 12f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("refinedglowstone").setOreSuffix("RefinedGlowstone").setColor(0xF0EC29).setTemp(1300)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.lightboost, null)
                            })
                    .setHead(900, 9.43f, 8.88f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.84f, 140).setExtra(100)
                    .setBow(2.31f, 1.99f, 8f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("osmium").setColor(0x87A5FF).setTemp(600)
                    .setHead(500, 3.73f, 4.01f, HarvestLevels.DIAMOND)
                    .setHandle(1.19f, 98).setExtra(48)
                    .setBow(0.98f, 1.09f, 4f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("manasteel").setColor(0x62E1F5).setTemp(500)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.manaRepair, null)
                            })
                    .setHead(400, 6.21f, 3.87f, HarvestLevels.DIAMOND)
                    .setHandle(1.07f, 120).setExtra(71)
                    .setBow(1.33f, 1.44f, 5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("terrasteel").setColor(0x4EE823).setTemp(1400)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.manaEater, null)
                            })
                    .setHead(960, 9.53f, 12.03f, HarvestLevels.COBALT)
                    .setHandle(1.45f, 200).setExtra(136)
                    .setBow(0.76f, 0.97f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("elvenelementium").setOreSuffix("ElvenElementium").setColor(0xED3BD8).setTemp(1400)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.manaRepair, null)
                            })
                    .setHead(200, 8.01f, 7.04f, HarvestLevels.OBSIDIAN)
                    .setHandle(3.01f, -50).setExtra(-20)
                    .setBow(4.01f, 0.53f, 2f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("gaia").setOre("gaiaIngot").setColor(0x9157B5).setTemp(1600)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.alien, null),
                                    new Tuple<ITrait, String>(ModTraits.payback, null)
                            })
                    .setHead(1600, 14.52f, 19.62f, HarvestLevels.COBALT)
                    .setHandle(1.63f, 260).setExtra(180)
                    .setBow(1.54f, 6.45f, 15f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("yellorium").setColor(0xFAF748).setTemp(1400)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.radioactive2, null)
                            })
                    .setHead(660, 7.52f, 5.08f, HarvestLevels.DIAMOND)
                    .setHandle(0.76f, -40).setExtra(-20)
                    .setBow(0.97f, 0.79f, 3f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("cyanite").setColor(0x25C9DB).setTemp(1400)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.radioactive, null)
                            })
                    .setHead(300, 6.53f, 4.83f, HarvestLevels.OBSIDIAN)
                    .setHandle(1.53f, 20).setExtra(60)
                    .setBow(2.51f, 1.11f, 8f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("blutonium").setColor(0x2918C4).setTemp(1500)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.radioactive3, null)
                            })
                    .setHead(800, 8.09f, 6.23f, HarvestLevels.COBALT)
                    .setHandle(1.06f, 90).setExtra(50)
                    .setBow(1.25f, 1.02f, 12f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("ludicrite").setColor(0xD42CD4).setTemp(1700)
                    .setHead(1400, 11.21f, 12.42f, HarvestLevels.COBALT)
                    .setHandle(2.34f, 400).setExtra(300)
                    .setBow(4.52f, 3.21f, 13f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("quartzenrichediron").setColor(0xE6E6E6)
                    .setItemCast(new ResourceLocation("refinedstorage", "quartz_enriched_iron"), 0)
                    .setHead(500, 7.65f, 6.83f, HarvestLevels.OBSIDIAN)
                    .setHandle(1.22f, 140).setExtra(70)
                    .setBow(0.64f, 0.86f, 4f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("draconium").setColor(0x7A2EC7)
                    .setItemCast(new ResourceLocation("draconicevolution", "draconic_core"), 0)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, null),
                                    new Tuple<ITrait, String>(ModTraits.energyEater, MaterialTypes.HEAD),
                                    new Tuple<ITrait, String>(ModTraits.op, null)
                            })
                    .setHead(1400, 12.04f, 13.53f, HarvestLevels.COBALT)
                    .setHandle(1.86f, 400).setExtra(300)
                    .setBow(2.56f, 1.62f, 10f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("wyverndraconium").setColor(0x7A2EC7)
                    .setItemCast(new ResourceLocation("draconicevolution", "wyvern_core"), 0)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, null),
                                    new Tuple<ITrait, String>(ModTraits.energyEater, MaterialTypes.HEAD),
                                    new Tuple<ITrait, String>(ModTraits.op, null)
                            })
                    .setHead(1700, 16.35f, 19.76f, 5)
                    .setHandle(2.76f, 600).setExtra(450)
                    .setBow(4.06f, 2.98f, 14f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("awakeneddraconium").setColor(0xFFC929)
                    .setItemCast(new ResourceLocation("draconicevolution", "awakened_core"), 0)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, null),
                                    new Tuple<ITrait, String>(ModTraits.energyEater, MaterialTypes.HEAD),
                                    new Tuple<ITrait, String>(ModTraits.op, null)
                            })
                    .setHead(2000, 25.43f, 29.52f, 6)
                    .setHandle(3.12f, 800).setExtra(600)
                    .setBow(5.60f, 3.76f, 20f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("chaoticdraconium").setColor(0x171717)
                    .setItemCast(new ResourceLocation("draconicevolution", "chaotic_core"), 0)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, null),
                                    new Tuple<ITrait, String>(ModTraits.energyEater, MaterialTypes.HEAD),
                                    new Tuple<ITrait, String>(ModTraits.op, null)
                            })
                    .setHead(3000, 32.73f, 1400.76f, 7)
                    .setHandle(5.31f, 1200).setExtra(1000)
                    .setBow(8.96f, 5.14f, 800f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("psi").setColor(0x2C88C9).setTemp(800)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.psiRepair, null)
                            })
                    .setHead(450, 9.04f, 8.01f, HarvestLevels.OBSIDIAN)
                    .setHandle(1.12f, 140).setExtra(80)
                    .setBow(1.45f, 1.26f, 5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("psigem").setColor(0x0CE8DD)
                    .setItemCast("gemPsi")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.psiEater, null)
                            })
                    .setHead(800, 8.25f, 7.12f, HarvestLevels.OBSIDIAN)
                    .setHandle(1.54f, 100).setExtra(100)
                    .setBow(1.21f, 0.85f, 4f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("ivorypsi").setOreSuffix("IvoryPsi").setColor(0x2C88C9).setTemp(800)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.psiRepair, null),
                                    new Tuple<ITrait, String>(TinkerTraits.holy, MaterialTypes.HEAD)
                            })
                    .setHead(980, 14.06f, 11.07f, HarvestLevels.COBALT)
                    .setHandle(1.53f, 300).setExtra(170)
                    .setBow(2.74f, 1.75f, 6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("ebonypsi").setOreSuffix("EbonyPsi").setColor(0x0A0A0A).setTemp(1700)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.psiEater, null),
                                    new Tuple<ITrait, String>(ModTraits.darkness, MaterialTypes.HEAD)
                            })
                    .setHead(1210, 11.76f, 14.06f, HarvestLevels.COBALT)
                    .setHandle(1.98f, 400).setExtra(290)
                    .setBow(1.64f, 2.56f, 10f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("darkmatter").setColor(0x270133)
                    .setItemCast(new ResourceLocation("projecte:item.pe_matter"), 0)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.darkness, null),
                                    new Tuple<ITrait, String>(ModTraits.instantdeath, MaterialTypes.HEAD)
                            })
                    .setHead(1200, 13.62f, 9.04f, HarvestLevels.COBALT)
                    .setHandle(2.03f, 350).setExtra(200)
                    .setBow(1.87f, 3.54f, 8f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("redmatter").setColor(0xE30000)
                    .setItemCast(new ResourceLocation("projecte:item.pe_matter"), 1)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.weee, MaterialTypes.HEAD)
                            })
                    .setHead(1900, 16.74f, 15.07f, HarvestLevels.COBALT)
                    .setHandle(3.86f, 500).setExtra(500)
                    .setBow(2.98f, 5.06f, 16f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("electrumflux").setOreSuffix("ElectrumFlux").setColor(0xFFF56B).setTemp(1800)
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, MaterialTypes.EXTRA),
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, MaterialTypes.HANDLE),
                                    new Tuple<ITrait, String>(ModTraits.energyRepair, MaterialTypes.SHAFT),
                                    new Tuple<ITrait, String>(ModTraits.energyEater, MaterialTypes.HEAD)
                            })
                    .setHead(1100, 13.52f, 14.06f, HarvestLevels.COBALT)
                    .setHandle(2.43f, 240).setExtra(230)
                    .setBow(2.26f, 3.41f, 8f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("refinediron").setOreSuffix("RefinedIron").setColor(0xE0E0E0).setTemp(780)
                    .setHead(450, 7.86f, 9.53f, HarvestLevels.OBSIDIAN)
                    .setHandle(1.23f, 140).setExtra(120)
                    .setBow(0.56f, 1.45f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("tungsten").setColor(0x464659).setTemp(1800)
                    .setHead(680, 8.42f, 11.52f, HarvestLevels.COBALT)
                    .setHandle(1.73f, 220).setExtra(115)
                    .setBow(0.98f, 5.17f, 9.5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("tungsten").setColor(0x464659).setTemp(2100)
                    .setHead(1120, 8.97f, 14.53f, HarvestLevels.COBALT)
                    .setHandle(2.42f, 320).setExtra(200)
                    .setBow(0.65f, 4.12f, 13f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("titanium").setColor(0xBABABA).setTemp(1400)
                    .setHead(590, 7.63f, 10.41f, HarvestLevels.COBALT)
                    .setHandle(1.52f, 180).setExtra(95)
                    .setBow(1.0f, 3.52f, 7.6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("chrome").setColor(0xD6D6D6).setTemp(1600)
                    .setHead(800, 9.16f, 7.83f, HarvestLevels.COBALT)
                    .setHandle(0.74f, 250).setExtra(140)
                    .setBow(1.52f, 2.15f, 5f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("advancedalloy").setOreSuffix("AdvancedAlloy").setColor(0xFFBBA8).setTemp(1500)
                    .setHead(1600, 13.63f, 13.23f, HarvestLevels.COBALT)
                    .setHandle(1.85f, 400).setExtra(500)
                    .setBow(0.75f, 0.98f, 16f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("ruby").setColor(0xCF0000)
                    .setItemCast("gemRuby")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.reflect, MaterialTypes.HEAD)
                            })
                    .setHead(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.74f, 100).setExtra(80)
                    .setBow(1.97f, 2.26f, 6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("sapphire").setColor(0x0B33D6)
                    .setItemCast("gemSapphire")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.launch, MaterialTypes.HEAD)
                            })
                    .setHead(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.74f, 100).setExtra(80)
                    .setBow(1.97f, 2.26f, 6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("peridot").setColor(0x15E835)
                    .setItemCast("gemPeridot")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.shock, MaterialTypes.HEAD)
                            })
                    .setHead(600, 10.12f, 6.84f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.74f, 100).setExtra(80)
                    .setBow(1.97f, 2.26f, 6f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("yellowgarnet").setColor(0xF5F51B)
                    .setItemCast("gemYellowGarnet")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.autosmelt, null),
                                    new Tuple<ITrait, String>(TinkerTraits.superheat, MaterialTypes.HEAD)
                            })
                    .setHead(800, 11.54f, 7.42f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.82f, 120).setExtra(95)
                    .setBow(1.67f, 2.41f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("redgarnet").setColor(0xED2424)
                    .setItemCast("gemRedGarnet")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.healer, MaterialTypes.HEAD)
                            })
                    .setHead(800, 11.54f, 7.42f, HarvestLevels.OBSIDIAN)
                    .setHandle(0.82f, 120).setExtra(95)
                    .setBow(1.67f, 2.41f, 7f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("rubber").setColor(0x5C4F4F)
                    .setItemCast("itemRubber")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(ModTraits.sling, null)
                            })
                    .setHead(14, 0.95f, 0.12f, HarvestLevels.IRON)
                    .setHandle(0.87f, 10).setExtra(3)
                    .setBow(6.42f, 1.42f, 0.3f)
                    .setBowString(2.65f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("certus").setColor(0xCCE4F0)
                    .setItemCast("crystalCertusQuartz")
                    .setTraits(
                            new Tuple[]{
                                    new Tuple<ITrait, String>(TinkerTraits.shocking, null)
                            })
                    .setHead(490, 7.45f, 10.45f, HarvestLevels.IRON)
                    .setHandle(0.74f, 30).setExtra(26)
                    .setBow(2.31f, 1.23f, 12f)
                    .build(),
            new MaterialRegistration.MaterialRegistrationBuilder()
                    .setIdentifier("fluix").setColor(0xB04EDE)
                    .setItemCast("crystalFluix")
                    .setHead(680, 13.32f, 12.65f, HarvestLevels.DIAMOND)
                    .setHandle(0.45f, 10).setExtra(40)
                    .setBow(2.87f, 4.53f, 14f)
                    .build()
    };

    public static void preInit() {
        for (MaterialRegistration materialRegistration : materials) {
            materialRegistration.register(false);
        }
    }

    public static void init() {
        for (MaterialRegistration materialRegistration : materials) {
            materialRegistration.register(true);
        }
    }

    private static Material materialPart(String name, String oreName, int color) {
        Material material = new Material(name, color);

        MoarMaterialIntegration m = new MoarMaterialIntegration(oreName, material, null, null);
        m.setRepresentativeItem(oreName);
        m.preInit(force);
        TinkerRegistry.integrate(m);

        material.addItemIngot(oreName);
        material.setCraftable(true);
        force = false;
        return material;
    }

    private static Material ingotMaterialNoDust(String name, int color, int temp) {
        Material material = new Material(name.toLowerCase(), color);
        material.addCommonItems(org.apache.commons.lang3.StringUtils.capitalize(name));
        ModFluids.registerFluid(name.toLowerCase(), color, temp);

        MaterialIntegrationNoDust m = new MaterialIntegrationNoDust(material,
                FluidRegistry.getFluid(name.toLowerCase()), name);
        m.toolforge();
        m.preInit(force);
        TinkerRegistry.integrate(m);

        material.addItemIngot("ingot" + name);
        material.setCastable(true);
        force = false;
        return material;
    }

    private static Material ingotMaterialExist(Fluid fluid, String name, int color) {
        Material material = new Material(name.toLowerCase(), color);
        material.addCommonItems(org.apache.commons.lang3.StringUtils.capitalize(name));

        MaterialIntegrationExists m = new MaterialIntegrationExists(material, fluid, name);
        m.setRepresentativeItem("ingot" + name).toolforge();
        m.preInit(force);
        TinkerRegistry.integrate(m);

        material.addItemIngot("ingot" + name);
        force = false;
        return material;
    }

    public static void exportMaterialsFromCode(String path) {
        writeJsonMaterials(generateJsonMaterials(), path);
    }

    private static void writeJsonMaterials(List<ArmorToolRangedMaterial> list, String path) {
        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        try {
            Writer writer = new FileWriter(new File(path));
            writer.write(gson.toJson(list.toArray()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<ArmorToolRangedMaterial> generateJsonMaterials(){
        List<ArmorToolRangedMaterial> armorToolRangedMaterialList = new LinkedList<>();
        for (MaterialRegistration material:materials) {
            armorToolRangedMaterialList.add(generateMaterial(material));
        }
        return armorToolRangedMaterialList;
    }

    private static ArmorToolRangedMaterial generateMaterial(MaterialRegistration materialRegistration){
        ArmorToolRangedMaterial armorToolRangedMaterial = new ArmorToolRangedMaterial(materialRegistration.identifier, materialRegistration.color);

        for (Tuple<ITrait, String> trait: materialRegistration.traits) {
            if(trait.getSecond().equals(null)){
                armorToolRangedMaterial.addGlobalToolTrait(trait.getFirst().getIdentifier());
            }
            else {
                armorToolRangedMaterial.addTrait(trait.getFirst().getIdentifier(), trait.getSecond());
            }
        }

        return armorToolRangedMaterial;
    }
}