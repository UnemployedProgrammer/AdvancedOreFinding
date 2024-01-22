package com.sebastian.adv_ore_find.init;

import com.sebastian.adv_ore_find.util.BatteryLifes;
import net.minecraft.creativetab.CreativeTabs;

public class Battery extends RootItem {
    public Battery(int maxDamage) {
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(1);
        setMaxDamage(maxDamage);
    }
}
