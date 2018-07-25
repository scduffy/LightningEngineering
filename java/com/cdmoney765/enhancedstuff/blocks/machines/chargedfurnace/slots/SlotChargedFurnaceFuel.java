package com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.slots;

import com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.TileEntityChargedFurnace;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotChargedFurnaceFuel extends Slot
{

	public SlotChargedFurnaceFuel(IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return TileEntityChargedFurnace.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) 
	{
		return super.getItemStackLimit(stack);
	}
	
}
