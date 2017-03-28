package com.bartz24.moartinkers.registry;

import com.bartz24.moartinkers.traits.TraitConstant;
import com.bartz24.moartinkers.traits.TraitDarkness;
import com.bartz24.moartinkers.traits.TraitEnderMagnetic;
import com.bartz24.moartinkers.traits.TraitEnergyEater;
import com.bartz24.moartinkers.traits.TraitEnergyRepair;
import com.bartz24.moartinkers.traits.TraitExploit;
import com.bartz24.moartinkers.traits.TraitHealer;
import com.bartz24.moartinkers.traits.TraitInstantDeath;
import com.bartz24.moartinkers.traits.TraitLaunch;
import com.bartz24.moartinkers.traits.TraitLightboost;
import com.bartz24.moartinkers.traits.TraitManaEater;
import com.bartz24.moartinkers.traits.TraitManaRepair;
import com.bartz24.moartinkers.traits.TraitMoarWritable;
import com.bartz24.moartinkers.traits.TraitOP;
import com.bartz24.moartinkers.traits.TraitPayback;
import com.bartz24.moartinkers.traits.TraitPsiEater;
import com.bartz24.moartinkers.traits.TraitPsiRepair;
import com.bartz24.moartinkers.traits.TraitRadioactive;
import com.bartz24.moartinkers.traits.TraitReflect;
import com.bartz24.moartinkers.traits.TraitShock;
import com.bartz24.moartinkers.traits.TraitSling;
import com.bartz24.moartinkers.traits.TraitSos;
import com.bartz24.moartinkers.traits.TraitWeee;

import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ModTraits {
	public static AbstractTrait radioactive = new TraitRadioactive(1);
	public static AbstractTrait radioactive2 = new TraitRadioactive(2);
	public static AbstractTrait radioactive3 = new TraitRadioactive(3);
	public static AbstractTrait moarwritable = new TraitMoarWritable(1);
	public static AbstractTrait moarwritable2 = new TraitMoarWritable(2);
	public static AbstractTrait weee = new TraitWeee();
	public static AbstractTrait energyRepair = new TraitEnergyRepair();
	public static AbstractTrait energyEater = new TraitEnergyEater();
	public static AbstractTrait manaRepair = new TraitManaRepair();
	public static AbstractTrait manaEater = new TraitManaEater();
	public static AbstractTrait psiRepair = new TraitPsiRepair();
	public static AbstractTrait psiEater = new TraitPsiEater();
	public static AbstractTrait exploit = new TraitExploit();
	public static AbstractTrait sos = new TraitSos();
	public static AbstractTrait payback = new TraitPayback();
	public static AbstractTrait enderMagnetic = new TraitEnderMagnetic();
	public static AbstractTrait instantdeath = new TraitInstantDeath(1);
	public static AbstractTrait instantdeath2 = new TraitInstantDeath(2);
	public static AbstractTrait instantdeath3 = new TraitInstantDeath(3);
	public static AbstractTrait constant = new TraitConstant();
	public static AbstractTrait lightboost = new TraitLightboost();
	public static AbstractTrait op = new TraitOP();
	public static AbstractTrait reflect = new TraitReflect();
	public static AbstractTrait launch = new TraitLaunch();
	public static AbstractTrait shock = new TraitShock();
	public static AbstractTrait healer = new TraitHealer();
	public static AbstractTrait sling = new TraitSling();
	public static AbstractTrait darkness = new TraitDarkness();
}
