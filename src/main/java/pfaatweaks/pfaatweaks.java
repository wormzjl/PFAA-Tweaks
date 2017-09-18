package pfaatweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Harry on 2017-02-23.
 */
@Mod(name = "PFAAtweaks",modid = "pfaatweaks",version = "1.0")
public class pfaatweaks {

    @EventHandler
    public void preInitEvent(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void initEvent(FMLInitializationEvent event){

    }

    @EventHandler
    public void postInitEvent(FMLPostInitializationEvent event){
        //LiquidExtraReg.modifyfluid();
        //Railcraft
        LiquidExtraReg.registerRCFuels();
        //BuildCraft
        LiquidExtraReg.registerBCFuels();
        //ImmersiveEngineering
        LiquidExtraReg.registerIEFuels();
        //IC2
        //LiquidExtraReg.registerICFuels();
    }


}
