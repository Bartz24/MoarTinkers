package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.MoarMaterialIntegration;
import com.bartz24.moartinkers.config.ConfigOptions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.ITrait;

class MaterialRegistration {
    private static boolean force = ModMaterials.force;

    protected String identifier, ore = null, oreSuffix = null, mod = null;
    protected Integer color = 0, temp = 0;
    protected Tuple<ITrait, String>[] traits = new Tuple[0];
    protected HeadMaterialStats head;
    protected HandleMaterialStats handle;
    protected ExtraMaterialStats extra;
    protected BowMaterialStats bow;
    protected BowStringMaterialStats bowstring;
    protected ResourceLocation castItem;
    protected int castItemMeta = 0;
    protected String castItemOre;

    MaterialRegistration() {
    }

    private boolean isRegistrable() {
        return ConfigOptions.materialIsAllowed(identifier) && TinkerRegistry.getMaterial(identifier).equals(Material.UNKNOWN);
    }

    protected ItemStack getCastItem() {
        Item item = Item.REGISTRY.getObject(castItem);
        if (item != null)
            return new ItemStack(item, 1, castItemMeta);
        else
            return ItemStack.EMPTY;
    }


    void register(boolean latePhase) {
        if (latePhase && getCastItem() != null) {
            Material material = TinkerRegistry.getMaterial(identifier);
            material.addItem(getCastItem(), 1, Material.VALUE_Ingot);

            material.setRepresentativeItem(getCastItem());
        } else if (!latePhase && isRegistrable() && (mod == null || Loader.isModLoaded(mod))) {
            Material material = ingotMaterial(StringUtils.capitalize(identifier), ore, color, temp, latePhase);
            for (Tuple<ITrait, String> trait : traits) {
                if (trait.getSecond() == null) {
                    material.addTrait(trait.getFirst());
                } else {
                    material.addTrait(trait.getFirst(), trait.getSecond());
                }
            }
            TinkerRegistry.addMaterialStats(material, head, handle, extra, bow);
            if (bowstring != null)
                TinkerRegistry.addMaterialStats(material, bowstring);
        }
    }

    static class MaterialRegistrationBuilder extends MaterialRegistration {

        public MaterialRegistrationBuilder setOre(String ore) {
            this.ore = ore;
            return this;
        }

        public MaterialRegistrationBuilder setOreSuffix(String suffix) {
            this.oreSuffix = suffix;
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

        MaterialRegistrationBuilder setBowString(float modifier) {
            this.bowstring = new BowStringMaterialStats(modifier);
            return this;
        }

        MaterialRegistrationBuilder setItemCast(ItemStack stack) {
            this.castItem = stack.getItem().getRegistryName();
            this.castItemMeta = stack.getMetadata();
            return this;
        }

        MaterialRegistrationBuilder setItemCast(ResourceLocation itemID, int meta) {
            castItem = itemID;
            castItemMeta = meta;
            return this;
        }

        MaterialRegistrationBuilder setItemCast(String oreDict) {
            this.castItemOre = oreDict;
            return this;
        }

        MaterialRegistration build() {
            return this;
        }
    }

    private Material ingotMaterial(String name, String oreName, int color, int temp, boolean latePhase) {
        Material material = new Material(name, color);

        if (castItem != null || castItemOre != null) {

            MoarMaterialIntegration m = new MoarMaterialIntegration(oreName, material, null, null);

            if (castItem == null) {
                material.addItem(castItemOre, 1, Material.VALUE_Ingot);
                m.setRepresentativeItem(castItemOre);
            }
            m.preInit(force);

            TinkerRegistry.integrate(m);
            material.setCraftable(true);

            force = false;
        } else {
            ModFluids.registerFluid(name.toLowerCase(), color, temp);
            MoarMaterialIntegration m;
            if (oreName == null) {
                String nameModified = oreSuffix == null ? name : oreSuffix;
                m = new MoarMaterialIntegration(material, FluidRegistry.getFluid(name.toLowerCase()), nameModified);
                m.setRepresentativeItem("ingot" + nameModified).toolforge();
                material.addItemIngot("ingot" + nameModified);
            } else {
                m = new MoarMaterialIntegration(oreName, material, FluidRegistry.getFluid(name), null);
                m.setRepresentativeItem(oreName).toolforge();
                material.addItemIngot(oreName);
            }
            m.preInit(force);
            TinkerRegistry.integrate(m);
            material.setCastable(true);
            force = false;
        }
        return material;
    }
}
