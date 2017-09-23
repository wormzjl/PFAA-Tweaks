package pfaatweaks.asm;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

public class CoreContainer extends DummyModContainer {
    public CoreContainer() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "PFAACore";
        meta.name = "PFAA tweaks Core";
        meta.version = "1.0";
        meta.authorList = Arrays.asList("wormz");
        meta.description = "A CoreMod to tweaks stuffs for this pack";
        meta.url = "http://mcmod.cn";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}
