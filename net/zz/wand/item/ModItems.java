package net.zz.wand.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.class_1792;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7706;
import net.minecraft.class_7923;
import net.zz.wand.Wand;

public class ModItems {
    public static final AccelerationWandItem ACCELERATION_WAND =
            registerItem("accelerationwand", new AccelerationWandItem());

    private static <T extends class_1792> T registerItem(String name, T item) {
        return class_2378.method_10230(class_7923.field_41178, class_2960.method_60655(Wand.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Wand.LOGGER.info("Registering Mod Items for " + Wand.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(class_7706.field_41060).register(entries -> {
            entries.method_45421(ACCELERATION_WAND);
        });
    }
}
