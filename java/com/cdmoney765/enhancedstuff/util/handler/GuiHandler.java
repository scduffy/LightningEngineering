package com.cdmoney765.enhancedstuff.util.handler;

import com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.ContainerChargedFurnace;
import com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.GUIChargedFurnace;
import com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.TileEntityChargedFurnace;
import com.cdmoney765.enhancedstuff.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_CHARGED_FURNACE)
			return new ContainerChargedFurnace(player.inventory, (TileEntityChargedFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_CHARGED_FURNACE)
			return new GUIChargedFurnace(player.inventory, (TileEntityChargedFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		
		return null;
	}
}
