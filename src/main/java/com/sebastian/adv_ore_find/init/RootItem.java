package com.sebastian.adv_ore_find.init;

import net.minecraft.item.Item;

public class RootItem extends Item {
    public void setName(String reg, String unname) {
        setUnlocalizedName(unname);
        setRegistryName(reg);
    }
}
