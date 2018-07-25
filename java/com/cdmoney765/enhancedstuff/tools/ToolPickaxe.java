package com.cdmoney765.enhancedstuff.tools;

import com.cdmoney765.enhancedstuff.Main;
import com.cdmoney765.enhancedstuff.init.ModItems;
import com.cdmoney765.enhancedstuff.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
	public ToolPickaxe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
