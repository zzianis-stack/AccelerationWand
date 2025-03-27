package net.zz.wand;

import net.fabricmc.api.ModInitializer;
import net.zz.wand.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wand implements ModInitializer {
    public static final String MOD_ID = "wand";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}
