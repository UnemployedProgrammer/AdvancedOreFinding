package com.sebastian.adv_ore_find.init;

import com.sebastian.adv_ore_find.Mod;
import com.sebastian.adv_ore_find.util.Findables;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MetalDetector extends RootItem {
    public MetalDetector(Findables canFind) {
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
