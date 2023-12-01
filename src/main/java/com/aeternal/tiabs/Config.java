package com.aeternal.tiabs;

import net.minecraftforge.common.config.Configuration;

import java.io.File;


public final class Config {
    public static int TIME_IN_A_BOTTLE_SECOND = 20;

    public static void loadNormalConfig(final File configFile) {
        final Configuration config = new Configuration(configFile);
        try {
            config.load();
            TIME_IN_A_BOTTLE_SECOND = config.getInt("TimeInABottlePerSecond", "Numbers", 20, 0, Integer.MAX_VALUE, "How many ticks have to pass for a Time in a Bottle to gain 1 second (20 = 1 Second)");

        } catch (Exception e) {
            Tiabs.log.fatal("Fatal error reading config file.", e);
            throw new RuntimeException(e);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

}


