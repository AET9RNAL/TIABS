package com.aeternal.tiabs.proxy;

import com.aeternal.tiabs.client.model.ItemModels;
import com.aeternal.tiabs.client.render.RenderTimeAccelerator;
import com.aeternal.tiabs.entities.EntityTimeAccelerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    @Override
    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, new RenderTimeAccelerator(Minecraft.getMinecraft().getRenderManager()));
      //DON'T    RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, RenderTimeAccelerator::new);
    }

    @Override
    public void registerModels()
    {
        ItemModels.register();
    }

    @SubscribeEvent
    public void onToolTipRender(RenderTooltipEvent.PostText evt)
    {
        if(evt.getStack().isEmpty())
            return;

        ItemStack stack = evt.getStack();
        Minecraft mc = Minecraft.getMinecraft();
        int width = evt.getWidth();
        int height = 3;
        int tooltipX = evt.getX();
        int tooltipY = evt.getY() - 4;
        FontRenderer font = evt.getFontRenderer();

    }

}