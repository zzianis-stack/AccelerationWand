package net.zz.wand.util;

public enum WandMode {
    LOW(1),
    NORMAL(2),
    FAST(3),
    LUDICROUS(4);

    private final int multiplier;

    WandMode(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public WandMode next() {
        return switch (this) {
            case LOW -> NORMAL;
            case NORMAL -> FAST;
            case FAST -> LUDICROUS;
            case LUDICROUS -> LOW;
        };
    }
}
