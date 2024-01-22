package com.sebastian.adv_ore_find.init;

import com.sebastian.adv_ore_find.Mod;
import com.sebastian.adv_ore_find.util.Findables;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Iterator;
import java.util.List;

public class MetalDetector extends RootItem {
    public Findables can;
    public MetalDetector(Findables canFind) {
        setCreativeTab(CreativeTabs.TOOLS);
        this.can = canFind;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        EnumHand playersOppositeHand = handIn == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
        ItemStack offHandStack = playerIn.getHeldItem(playersOppositeHand);
        ItemStack stackHand = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote) {
            if (offHandStack.getItem() instanceof Battery) {
                offHandStack.setItemDamage(offHandStack.getItemDamage() - 1);
                use(worldIn, playerIn, handIn);
            }
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stackHand);
    }

    private void use(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        boolean foundBlock = false;


        for (int i = 0; i <= playerIn.getPosition().getY() + 64; i++) {
            if (blockMatchesMDLevel(playerIn.getPosition().down(i), worldIn)) {
                playerIn.sendStatusMessage(new TextComponentString("Found " +  worldIn.getBlockState(playerIn.getPosition().down(i)).getBlock().getLocalizedName()), false);
                playerIn.sendStatusMessage(new TextComponentString("Found " +  worldIn.getBlockState(playerIn.getPosition().down(i)).getBlock().getLocalizedName()), true);
            }
        }
    }

    private boolean isBlockAOre(BlockPos pPos, World pLevel) {
        return isOre(pLevel.getBlockState(pPos).getBlock());
    }

    private boolean isBlock(BlockPos pPos, World pLevel, Block block) {
        return pLevel.getBlockState(pPos).getBlock().equals(block);
    }

    public boolean isOre(Block block) {
        return !OreDictionary.getOres(block.getRegistryName().toString()).isEmpty();
    }




    private boolean blockMatchesMDLevel(BlockPos pPos, World pLevel) {
        if (can == Findables.CAN_FIND_ALL) {
            return isBlockAOre(pPos, pLevel);
        }
        if (can == Findables.CAN_FIND_COAL) {
            return isBlock(pPos, pLevel, Blocks.COAL_ORE);
        }
        if (can == Findables.CAN_FIND_IRON) {
            return isBlock(pPos, pLevel, Blocks.IRON_ORE);
        }
        if (can == Findables.CAN_FIND_DIAMOND) {
            return isBlock(pPos, pLevel, Blocks.DIAMOND_ORE);
        }
        if (can == Findables.CAN_FIND_GOLD) {
            return isBlock(pPos, pLevel, Blocks.GOLD_ORE);
        }
        if (can == Findables.CAN_FIND_LAPIS) {
            return isBlock(pPos, pLevel, Blocks.LAPIS_ORE);
        }
        if (can == Findables.CAN_FIND_REDSTONE) {
            return isBlock(pPos, pLevel, Blocks.REDSTONE_ORE);
        }
        return false;
    }
}
