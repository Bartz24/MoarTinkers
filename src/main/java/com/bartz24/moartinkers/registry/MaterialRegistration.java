package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.MoarMaterialIntegration;
import com.bartz24.moartinkers.config.ConfigOptions;
import net.minecraft.util.Tuple;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.ITrait;

class MaterialRegistration {
    private static boolean force = ModMaterials.force;

    private String identifier, ore, mod;
    private Integer color, temp;
    private Tuple<ITrait, String>[]  traits;
    private HeadMaterialStats head;
    private HandleMaterialStats handle;
    private ExtraMaterialStats extra;
    private BowMaterialStats bow;

    MaterialRegistration() {
    }

    private boolean isRegistrable () {
        return ConfigOptions.materialIsAllowed(identifier)  && TinkerRegistry.getMaterial(identifier).equals(Material.UNKNOWN);
    }

    void register() {
        if (isRegistrable() && (mod == null || Loader.isModLoaded(mod))) {
            Material material = ingotMaterial(StringUtils.capitalize(identifier), color, temp);
            for (Tuple<ITrait, String> trait : traits) {
                if (trait.getSecond() == null) {
                    material.addTrait(trait.getFirst());
                }
                else {
                    material.addTrait(trait.getFirst(), trait.getSecond());
                }
            }
            TinkerRegistry.addMaterialStats(material, head, handle, extra, bow);
        }
    }

    static class MaterialRegistrationBuilder extends MaterialRegistration {
        private String identifier, ore = null, mod = null;
        private Integer color, temp;
        private Tuple<ITrait, String>[] traits = null;
        private HeadMaterialStats head;
        private HandleMaterialStats handle;
        private ExtraMaterialStats extra;
        private BowMaterialStats bow;

        public MaterialRegistrationBuilder setOre(String ore) {
            this.ore = ore;
            return this;
        }

        public MaterialRegistrationBuilder setMod(String mod) {
            this.mod = mod;
            return this;
        }

        MaterialRegistrationBuilder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        MaterialRegistrationBuilder setColor(Integer color) {
            this.color = color;
            return this;
        }

        MaterialRegistrationBuilder setTemp(Integer temp) {
            this.temp = temp;
            return this;
        }

        public MaterialRegistrationBuilder setTraits(Tuple<ITrait, String>[] traits) {
            this.traits = traits;
            return this;
        }

        MaterialRegistrationBuilder setHead(int durability, float miningSpeed, float attack, int harvestLevel) {
            this.head = new HeadMaterialStats(durability, miningSpeed, attack, harvestLevel);
            return this;
        }

        MaterialRegistrationBuilder setHandle(float modifier, int durability) {
            this.handle = new HandleMaterialStats(modifier, durability);
            return this;
        }

        MaterialRegistrationBuilder setExtra(int durability) {
            this.extra = new ExtraMaterialStats(durability);
            return this;
        }

        MaterialRegistrationBuilder setBow(float drawSpeed, float range, float bonusDamage) {
            this.bow = new BowMaterialStats(drawSpeed, range, bonusDamage);
            return this;
        }

        MaterialRegistration build() {
            return this;
        }
    }

    private static Material ingotMaterial(String name, int color, int temp) {
        return ingotMaterial(name, null, color, temp);
    }

    private static Material ingotMaterial(String name, String oreName, int color, int temp) {
        Material material = new Material(name, color);
        ModFluids.registerFluid(name, color, temp);

        MoarMaterialIntegration m;
        if (oreName == null) {
            m = new MoarMaterialIntegration(material, FluidRegistry.getFluid(name.toLowerCase()), name);
            m.setRepresentativeItem("ingot" + name).toolforge();
            material.addItemIngot("ingot" + name);
        }
        else {
            m = new MoarMaterialIntegration(oreName, material, FluidRegistry.getFluid(name), null);
            m.setRepresentativeItem(oreName).toolforge();
            material.addItemIngot(oreName);
        }
        m.preInit(force);
        TinkerRegistry.integrate(m);
        material.setCastable(true);
        force = false;
        return material;
    }
}
