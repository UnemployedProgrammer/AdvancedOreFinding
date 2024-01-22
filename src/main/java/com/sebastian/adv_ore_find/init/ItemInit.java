package com.sebastian.adv_ore_find.init;

import com.sebastian.adv_ore_find.Mod;
import com.sebastian.adv_ore_find.util.Findables;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
