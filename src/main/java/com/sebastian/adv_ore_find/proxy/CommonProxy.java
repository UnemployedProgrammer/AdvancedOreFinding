package com.sebastian.adv_ore_find.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import com.sebastian.adv_ore_find.init.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta, String id)
    {

    }

    public void render()
    {

    }

    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule)
    {
        throw new IllegalStateException("This should only be called from client side");
    }

    public EntityPlayer getClientPlayer()
    {
        throw new IllegalStateException("This should only be called from client side");
    }

    public void preinit(FMLPreInitializationEvent event) {
        ItemInit.init();

        MinecraftForge.EVENT_BUS.register(ItemInit.class);
    }

    public void init(FMLInitializationEvent event) {

    }
}