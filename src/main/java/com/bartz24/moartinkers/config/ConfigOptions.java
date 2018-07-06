package com.bartz24.moartinkers.config;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.*;

public class ConfigOptions {
    public static Configuration config;
    private static Map<String, Boolean> materialsAllowed;

    public static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        list.addAll(new ConfigElement(config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());

        return list;
    }

    public static boolean materialIsAllowed(String material) {
        return materialsAllowed.containsKey(material) ? materialsAllowed.get(material) : false;
    }

    public static void loadConfigThenSave(FMLPreInitializationEvent e) {
        config = new Configuration(e.getSuggestedConfigurationFile());

        config.load();
        materialsAllowed = new HashMap();
        Map<String, String> types = getMaterialTypes();

        Iterator it = types.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            materialsAllowed.put(pair.getKey().toString(), config
                    .get(Configuration.CATEGORY_GENERAL, "Allow " + pair.getValue().toString() + " Material", true,
                            "Does not force the material, only allows it to be loaded. Other mods and requirements are still needed for this to load")
                    .getBoolean(true));
            it.remove();
        }
        config.save();
    }

    private static Map<String, String> getMaterialTypes() {
        Map<String, String> map = new HashMap();
        map.put("enderium", "Enderium");
        map.put("platinum", "Platinum");
        map.put("iridium", "Iridium");
        map.put("mithril", "Mithril");
        map.put("signalum", "Signalum");
        map.put("lumium", "Lumium");
        map.put("constantan", "Constantan");
        map.put("invar", "Invar");
        map.put("nickel", "Nickel");
        map.put("tin", "Tin");
        map.put("brass", "Brass");
        map.put("aluminum", "Aluminum");
        map.put("zinc", "Zinc");
        map.put("refinedglowstone", "Refined Glowstone");
        map.put("refinedobsidian", "Refined Obsidian");
        map.put("osmium", "Osmium");
        map.put("manasteel", "Manasteel");
        map.put("terrasteel", "Terrasteel");
        map.put("elvenelementium", "Elementium");
        map.put("gaia", "Gaia Spirit");
        map.put("electricalsteel", "Electrical Steel");
        map.put("energeticalloy", "Energetic Alloy");
        map.put("vibrantalloy", "Vibrant Alloy");
        map.put("redstonealloy", "Redstone Alloy");
        map.put("conductiveiron", "Conductive Iron");
        map.put("pulsatingiron", "Pulsating Iron");
        map.put("darksteel", "Dark Steel");
        map.put("soularium", "Soularium");
        map.put("yellorium", "Yellorium");
        map.put("cyanite", "Cyanite");
        map.put("blutonium", "Blutonium");
        map.put("ludicrite", "Ludicrite");
        map.put("quartzenrichediron", "Quartz Enriched Iron");
        map.put("draconium", "Draconium");
        map.put("wyverndraconium", "Wyvern Draconium");
        map.put("awakeneddraconium", "Awakened Draconium");
        map.put("chaoticdraconium", "Chaotic Draconium");
        map.put("magicalwood", "Magical Wood");
        map.put("enchantedmetal", "Enchanted Metal");
        map.put("psi", "Psimetal");
        map.put("psigem", "Psigem");
        map.put("ivorypsi", "Ivory Psimetal");
        map.put("ebonypsi", "Ebony Psimetal");
        map.put("darkmatter", "Dark Matter");
        map.put("redmatter", "Red Matter");
        map.put("electrumflux", "Fluxed Electrum");
        map.put("hardenedstone", "Hardened Stone");
        map.put("basalt", "Basalt");
        map.put("alabaster", "Alabaster");
        map.put("lonsdaleite", "Lonsdaleite");
        map.put("mica", "Mica");
        map.put("titanium", "Titanium");
        map.put("tungsten", "Tungsten");
        map.put("tungstensteel", "Tungstensteel");
        map.put("chrome", "Chrome");
        map.put("advancedalloy", "Advanced Alloy");
        map.put("refinediron", "Refined Iron");
        map.put("ruby", "Ruby");
        map.put("sapphire", "Sapphire");
        map.put("peridot", "Peridot");
        map.put("redgarnet", "Red Garnet");
        map.put("yellowgarnet", "Yellow Garnet");
        map.put("rubber", "Rubber");
        map.put("certus", "Certus Quartz");
        map.put("fluix", "Fluix");

        return map;
    }
}
