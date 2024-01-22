package com.sebastian.adv_ore_find.init;

import com.sebastian.adv_ore_find.Mod;
import com.sebastian.adv_ore_find.util.BatteryLifes;
import com.sebastian.adv_ore_find.util.Findables;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

    public static ArrayList<ItemInitEntry> inititems = new ArrayList<ItemInitEntry>();
    public static RootItem METAL_DETECTOR = addInitItem(new ItemInitEntry(new MetalDetector(Findables.CAN_FIND_ALL), "metal_detector")).item();
    public static RootItem  POTATO_BATTERY = addInitItem(new ItemInitEntry(new Battery(BatteryLifes.POTATO_BATTERY), "potato_battery")).item();
    public static RootItem  LEMON_BATTERY = addInitItem(new ItemInitEntry(new Battery(BatteryLifes.LEMON_BATTERY), "lemon_battery")).item();
    public static RootItem  IRON_BATTERY = addInitItem(new ItemInitEntry(new Battery(BatteryLifes.IRON_BATTERY), "iron_battery")).item();
    public static RootItem  COPPER_BATTERY = addInitItem(new ItemInitEntry(new Battery(BatteryLifes.COPPER_BATTERY), "copper_battery")).item();
    public static RootItem  WOODEN_POLE = addInitItem(new ItemInitEntry(new Pole(),"wood_pole")).item();

    public static ItemInitEntry addInitItem(ItemInitEntry iItem) {
        inititems.add(iItem);
        return iItem;
    }

    public static void init() {
        for (ItemInitEntry entry : inititems) {
            entry.item().setName(entry.getName(), entry.getName());
        }
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        for (ItemInitEntry entry : inititems) {
            registry.register(entry.item());
            ModelLoader.setCustomModelResourceLocation(entry.item(), 0, new ModelResourceLocation(entry.item().getRegistryName(), "inventory"));
        }
    }
}
