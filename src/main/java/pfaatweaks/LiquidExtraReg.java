package pfaatweaks;

import blusunrize.immersiveengineering.api.energy.DieselHandler;
import buildcraft.api.fuels.BuildcraftFuelRegistry;
import cpw.mods.fml.common.Optional;
import ic2.api.recipe.IFluidHeatManager;
import ic2.api.recipe.Recipes;
import mods.railcraft.api.fuel.FuelManager;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Map;
import java.util.Set;

/**
 * Created by Harry on 2017-02-23.
 */
public class LiquidExtraReg {
public static Fluid lng = FluidRegistry.getFluid("lng");
public static Fluid lpg = FluidRegistry.getFluid("lpg");
public static Fluid methane = FluidRegistry.getFluid("methane");
public static Fluid methanenatural = FluidRegistry.getFluid("methanenatural");
public static Fluid ethane = FluidRegistry.getFluid("ethane");
public static Fluid propane = FluidRegistry.getFluid("propane");
public static Fluid butane = FluidRegistry.getFluid("butane");
public static Fluid syngas = FluidRegistry.getFluid("syngas");
public static Fluid kerosene = FluidRegistry.getFluid("kerosene");
//public static Fluid toluene = FluidRegistry.getFluid("toluene");
//public static Fluid carbonmonoxide = FluidRegistry.getFluid("carbonmonoxide");
public static Fluid crackinggas = FluidRegistry.getFluid("crackinggas");

public static Fluid hotsyngas = FluidRegistry.getFluid("hotsyngas");
public static Fluid hotethene = FluidRegistry.getFluid("hotethene");
public static Fluid hotpropene = FluidRegistry.getFluid("hotpropene");
public static Fluid hotbutene = FluidRegistry.getFluid("hotbutene");

    public static void modifyfluid()
    {
        hotsyngas.setTemperature(1700);
        hotethene.setTemperature(1700);
        hotpropene.setTemperature(1700);
        hotbutene.setTemperature(1700);
        //carbonmonoxide.setTemperature(1500);
        //toluene.setTemperature(1500);
        //crackinggas.setTemperature(3000);
    }

    @Optional.Method(modid="Railcraft")
    public static void registerRCFuels()
    {
        //Replace null with Fiuld created
        //Argunment fuel,heatValuePerBucket
        FuelManager.addBoilerFuel(lng, 55448);
        FuelManager.addBoilerFuel(lpg, 48000);
        FuelManager.addBoilerFuel(methane, 57414);
        FuelManager.addBoilerFuel(methanenatural, 57414);
        FuelManager.addBoilerFuel(ethane, 53586);
        FuelManager.addBoilerFuel(propane, 52034);
        FuelManager.addBoilerFuel(butane, 51207);
        FuelManager.addBoilerFuel(syngas, 32000);
        FuelManager.addBoilerFuel(kerosene, 45500);
    }

    @Optional.Method(modid="BuildCraft|Core")
    public static void registerBCFuels()
    {
        //Replace null with Fiuld created
        //Argunment fuel,i,i1
        //BuildcraftFuelRegistry.fuel.addFuel(lng, 80, 25000);
    }

    @Optional.Method(modid="ImmersiveEngineering")
    public static void registerIEFuels()
    {
        //Replace null with Fiuld created
        //Argunment fuel,time
        DieselHandler.registerFuel(lng, 433);
        DieselHandler.registerFuel(lng, 375);
        DieselHandler.registerFuel(methane, 449);
        DieselHandler.registerFuel(methanenatural, 449);
        DieselHandler.registerFuel(ethane, 419);
        DieselHandler.registerFuel(propane, 407);
        DieselHandler.registerFuel(butane, 400);
        DieselHandler.registerFuel(syngas, 250);
        DieselHandler.registerFuel(kerosene, 350);
    }

    @Optional.Method(modid="IC2")
    public static void registerICFuels()
    {
        //Replace null with
        //String fluidName, String fluidOutput, int huPerMB
        Recipes.liquidCooldownManager.addFluid("hotsyngas","syngas",100);
        Recipes.liquidCooldownManager.addFluid("hotethene","ethene",100);
        Recipes.liquidCooldownManager.addFluid("hotpropene","propene",100);
        Recipes.liquidCooldownManager.addFluid("hotbutene","butene",100);
    }
}
