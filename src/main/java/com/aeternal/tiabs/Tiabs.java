package com.aeternal.tiabs;

import com.aeternal.tiabs.entities.ModEntities;
import com.aeternal.tiabs.item.ModItems;
import com.aeternal.tiabs.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EventBusSubscriber
@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION, dependencies = "")

public class Tiabs
{
    @Mod.Instance(Constants.MOD_ID)
    public static Tiabs instance;
    public static Logger log;
    @SidedProxy(serverSide = "com.aeternal.tiabs.proxy.CommonProxy", clientSide = "com.aeternal.tiabs.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final Logger LOG = LogManager.getLogger(Constants.MOD_ID);


    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(proxy);
        proxy.preInit();
        ModItems.load(e);
        ModEntities.init();
        proxy.registerModels();
        Config.loadNormalConfig(e.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent e){
        proxy.registerRenderers();
        proxy.postInit();
    }
    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent e)
    {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e)
    {

    }



}