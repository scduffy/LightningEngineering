package com.cdmoney765.enhancedstuff.tools;

import com.cdmoney765.enhancedstuff.Main;
import com.cdmoney765.enhancedstuff.init.ModItems;
import com.cdmoney765.enhancedstuff.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel
{
	public ToolSword(String name, ToolMaterial material)
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
