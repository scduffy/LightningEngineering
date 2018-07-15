package com.cdmoney765.enhancedstuff.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnhancedOre extends BlockBase
{

	public EnhancedOre(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(45.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(10.0F);
		//setOpacity(1);
		//setBlockUnbreakable();
	}

}
