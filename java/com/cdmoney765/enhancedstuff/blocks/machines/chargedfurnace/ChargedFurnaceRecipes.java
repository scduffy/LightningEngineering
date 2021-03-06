package com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import com.cdmoney765.enhancedstuff.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ChargedFurnaceRecipes 
{
	private static final ChargedFurnaceRecipes INSTANCE = new ChargedFurnaceRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static ChargedFurnaceRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private ChargedFurnaceRecipes() 
	{
		//addChargedRecipe(new ItemStack(ModBlocks.BLOCK_COPPER), new ItemStack(ModBlocks.ORE_OVERWORLD), new ItemStack(Blocks.ACACIA_FENCE), 5.0F);
		addChargedRecipe(new ItemStack(Blocks.FURNACE), new ItemStack(Blocks.OBSIDIAN), new ItemStack(ModBlocks.CHARGED_FURNACE), 5.0F);
	}

	
	public void addChargedRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getChargedResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getChargedResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getChargedExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
}
}
