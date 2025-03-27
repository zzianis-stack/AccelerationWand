package net.zz.wand.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import net.zz.wand.item.AccelerationWandItem;
import org.lwjgl.glfw.GLFW;

public class WandClient implements ClientModInitializer {

    public static class_304 cycleModeKey;

    @Override
    public void onInitializeClient() {
        cycleModeKey = KeyBindingHelper.registerKeyBinding(new class_304(
                "key.wand.cycle_mode",
                class_3675.class_307.field_1668,
                GLFW.GLFW_KEY_M,
                "category.wand"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (cycleModeKey.method_1436()) {
                if (client.field_1724 != null) {
                    class_1799 stack = client.field_1724.method_5998(class_1268.field_5808);
                    if (stack.method_7909() instanceof AccelerationWandItem wand) {
                        wand.toggleMode(client.field_1724, stack);
                        String mode = wand.getMode(stack);
                        client.field_1724.method_7353(class_2561.method_43470("Wand Mode: §b" + mode), true);
                    }
                }
            }
        });

    }
}

