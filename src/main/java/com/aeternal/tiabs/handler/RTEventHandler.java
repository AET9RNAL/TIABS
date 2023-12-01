package com.aeternal.tiabs.handler;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class RTEventHandler
{
    static Random rng = new Random();

    public static int clientAnimationCounter;


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void tick(TickEvent tickEvent) {
        if (tickEvent.type == TickEvent.Type.WORLD && tickEvent.phase == TickEvent.Phase.START) {
            World world = ((WorldTickEvent) tickEvent).world;
        }

        if ((tickEvent.type == TickEvent.Type.CLIENT)) {
            clientAnimationCounter++;
        }
    }
}
