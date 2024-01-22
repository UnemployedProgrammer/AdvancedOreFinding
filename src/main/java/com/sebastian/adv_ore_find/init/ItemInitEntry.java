package com.sebastian.adv_ore_find.init;

import net.minecraft.item.Item;

public class ItemInitEntry {
    private RootItem i;
    private String n;
    public ItemInitEntry(RootItem item, String regName) {
        this.i = item;
        this.n = regName;
    }
    public RootItem item() {
        return i;
    }

    public String getName() {
        return n;
    }
}
