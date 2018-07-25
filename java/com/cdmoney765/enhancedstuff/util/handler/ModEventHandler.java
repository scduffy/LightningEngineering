package com.cdmoney765.enhancedstuff.util.handler;

import com.cdmoney765.enhancedstuff.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler 
{
	
	/**
	 * Crafting event thing for turning Lechatelierite into its dust form.
	 * @param event
	 */
	@SubscribeEvent
	public void onItemUse(PlayerInteractEvent.RightClickBlock event)
	{
		//Turns Lechatelierite into its dust equivalent for crafting purposes. 
		EntityPlayer player = event.getEntityPlayer();
		if(player.getHeldItemMainhand().getItem() == ModItems.LECHATELIERITE)
		{
			RayTraceResult pos = player.rayTrace(4, 10);
			BlockPos blockPos = pos.getBlockPos();
			
			World world = Minecraft.getMinecraft().world;
			
			IBlockState iblockstate = world.getBlockState(blockPos);
			
			if(iblockstate.getMaterial() == Material.ROCK)
			{
				if(event.getHand() == player.getActiveHand())
				{
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					player.inventory.addItemStackToInventory(new ItemStack(ModItems.LECHATELIERITE_DUST));
				}
			}
		}
	}
	
	/**
	 * Shoots a lightning bolt at the block a player is looking at when using handheld lightning rod. Consumes Lechatelierite.
	 * @param event
	 */
	@SubscribeEvent
	public void onRodUse(PlayerInteractEvent.RightClickItem event)
	{
		EntityPlayer player = event.getEntityPlayer();
		if(player.getHeldItemMainhand().getItem() == ModItems.HANDHELD_LIGHTNING_ROD)
		{
			RayTraceResult pos = player.rayTrace(200, 10);
			BlockPos blockPos = pos.getBlockPos();
			
			if(player.inventory.hasItemStack(new ItemStack(ModItems.LECHATELIERITE)))
			{
				if(event.getHand() == player.getActiveHand())
				{
					//Credit to https://www.suppergerrie2.com/minecraft-1-12-modding-with-forge-14-custom-enchantments/
					player.world.addWeatherEffect(new EntityLightningBolt
							(player.world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), false));
					
					player.inventory.clearMatchingItems(ModItems.LECHATELIERITE, -1, 1, null);
				}
			}
		}
	}
}
