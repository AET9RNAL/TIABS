package com.aeternal.tiabs.lib;

import com.aeternal.tiabs.Constants;
import com.aeternal.tiabs.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public final class TiabsCreativeTab extends CreativeTabs {

    public static final TiabsCreativeTab INSTANCE = new TiabsCreativeTab();

    public TiabsCreativeTab() {
        super(Constants.MOD_ID);
        setNoTitle();
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.timeInABottle);
    }

    @Override
    public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
        super.displayAllRelevantItems(list);
    }
}
