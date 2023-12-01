package com.aeternal.tiabs.item;

import java.util.ArrayList;
import java.util.List;
import com.aeternal.tiabs.Tiabs;
import com.aeternal.tiabs.lib.TiabsCreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemBase extends Item
{
    public static List<Item> rtItemList = new ArrayList<>(30);

    public ItemBase(String name)
    {
        registerItem(name, this);
        Tiabs.proxy.scheduleColor(this);
    }

    public void registerItem(String name, Item item)
    {
        item.setRegistryName(name);
        setCreativeTab(TiabsCreativeTab.INSTANCE);
        item.setUnlocalizedName(name);

        ForgeRegistries.ITEMS.register(item);

        rtItemList.add(item);
    }
}
