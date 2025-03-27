package net.zz.wand.item;

import net.minecraft.class_124;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_5819;
import net.minecraft.class_9279;
import net.minecraft.class_9334;

public class AccelerationWandItem extends class_1792 {

    private static final int MAX_DURABILITY = 7200;
    private static final String FAST_MODE = "fast";
    private static final String NORMAL_MODE = "normal";
    private static final String SLOW_MODE = "slow";
    private static final String NBT_KEY = "wand_mode";

    public AccelerationWandItem() {
        super(new class_1792.class_1793().method_7889(1).method_7895(MAX_DURABILITY));
    }

    private void setMode(class_1799 stack, String mode) {
        class_2487 nbt = stack.method_57825(class_9334.field_49628, class_9279.method_57456(new class_2487())).method_57461();
        nbt.method_10582(NBT_KEY, mode);
        stack.method_57379(class_9334.field_49628, class_9279.method_57456(nbt));

        System.out.println("[SERVER] Set mode to: " + mode);
        System.out.println("[SERVER] Saved NBT: " + nbt.method_10714());

        if (stack.method_27319() instanceof class_3222 serverPlayer) {
            serverPlayer.field_7512.method_7623();
        }
    }


    public String getMode(class_1799 stack) {
        class_9279 nbtComponent = stack.method_57824(class_9334.field_49628);

        if (nbtComponent != null) {
            class_2487 nbt = nbtComponent.method_57461();
            if (nbt.method_10545(NBT_KEY)) {
                String mode = nbt.method_10558(NBT_KEY);
                return mode;
            }
        }

        return NORMAL_MODE;
    }


    public void toggleMode(class_1657 player, class_1799 stack) {
        if (!player.method_37908().method_8608()) {
            String currentMode = getMode(stack);
            String newMode = switch (currentMode) {
                case "normal" -> "fast";
                case "fast" -> "slow";
                case "slow" -> "normal";
                default -> "normal";
            };

            setMode(stack, newMode);
            System.out.println("[SERVER] Mode switched to: " + newMode);

            player.method_7353(class_2561.method_43470("Mode changed to: " + newMode), true);
        }
    }


    @Override
    public class_1269 method_7884(class_1838 context) {
        class_1937 world = context.method_8045();
        class_2338 pos = context.method_8037();
        class_1799 stack = context.method_8041();
        class_1657 player = context.method_8036();

        if (player == null) return class_1269.field_5811;

        String mode = getMode(stack);

        // Original ActionResult logic before durability handling
        if (stack.method_7919() < MAX_DURABILITY) {
            accelerateBlockTick(world, pos, mode);
            return class_1269.method_29236(world.field_9236);
        } else {
            if (!world.field_9236) {
                player.method_7353(class_2561.method_43470("Wand is broken!").method_27692(class_124.field_1061), true);
            }
            return class_1269.field_5814;
        }
    }


    private void accelerateBlockTick(class_1937 world, class_2338 pos, String mode) {
        if (world.field_9236 || !(world instanceof class_3218 serverWorld)) return;

        class_2680 state = world.method_8320(pos);
        class_5819 random = world.field_9229;

        int totalTicks;
        switch (mode) {
            case FAST_MODE -> totalTicks = 10;
            case SLOW_MODE -> totalTicks = 2;
            default -> totalTicks = 5;
        }

        for (int i = 0; i < totalTicks; i++) {
            if (state.method_26229()) {
                state.method_26199(serverWorld, pos, random);
            } else {
                serverWorld.method_39279(pos, state.method_26204(), 1);
            }
        }

        world.method_8413(pos, state, state, class_2248.field_31036);

        if (mode.equals(FAST_MODE)) {
            world.method_20290(2005, pos, 0);
        }
    }

    //WORK IN PROGRESS
   /* 
    public static void registerRecipe() {
        Identifier id = new Identifier("wand_mod", "acceleration_wand");
        ShapedRecipe recipe = new ShapedRecipe(id, "", 3, 3,
                List.of(
                        Ingredient.ofItems(Items.DIAMOND), Ingredient.ofItems(Items.NETHER_STAR), Ingredient.ofItems(Items.DIAMOND),
                        Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(Items.STICK), Ingredient.ofItems(Items.GOLD_INGOT),
                        Ingredient.ofItems(Items.REDSTONE_BLOCK), Ingredient.ofItems(Items.EMERALD), Ingredient.ofItems(Items.REDSTONE_BLOCK)
                ),
                new ItemStack(ModItems.ACCELERATION_WAND));

        Registry.register(Registry.RECIPE_SERIALIZER, id, RecipeSerializer.SHAPED);
    }
    */
}
