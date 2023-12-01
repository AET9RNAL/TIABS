package com.aeternal.tiabs.handler.integration;

import com.aeternal.tiabs.Tiabs;
import com.aeternal.tiabs.item.ItemBase;
import com.aeternal.tiabs.lib.TiabsCreativeTab;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

public class DescriptionHandler {
    static IModRegistry registry;

    public static void addDescriptions(IModRegistry registry) {
        DescriptionHandler.registry = registry;

        Map<Object, String> overrideMap = new HashMap<>();

        ItemBase.rtItemList.stream().forEach(item -> {
            NonNullList<ItemStack> subItems = NonNullList.create();

            if (item instanceof Item) {
                Item currentItem = (Item) item;

                if (currentItem.getCreativeTab() == TiabsCreativeTab.INSTANCE) {
                    currentItem.getSubItems(TiabsCreativeTab.INSTANCE, subItems);
                }
            }

            if (!subItems.isEmpty()) {
                if (overrideMap.containsKey(item)) {
                    String override = overrideMap.get(item);

                    if (override != null) {
                        if (item instanceof Item) {
                            registry.addDescription(new ItemStack((Item) item, 1, OreDictionary.WILDCARD_VALUE), override);
                        }
                    }
                    return;
                }

                for (ItemStack is : subItems) {
                    registry.addDescription(is, is.getUnlocalizedName() + ".info");
                }
            }
        });
    }

    private static void add(Item item, String key) {
        registry.addDescription(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE), key);
    }

    private static void add(ItemStack stack, String key) {
        registry.addDescription(stack, key);
    }

    private static void removeDes(Map<Object, String> overrideMap, Object... toRemove) {
        for (Object o : toRemove) {
            overrideMap.put(o, null);
        }
    }
}
