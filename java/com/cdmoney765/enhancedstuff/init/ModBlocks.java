package com.cdmoney765.enhancedstuff.init;

import java.util.ArrayList;
import java.util.List;

import com.cdmoney765.enhancedstuff.blocks.BlockBase;
import com.cdmoney765.enhancedstuff.blocks.EnhancedMetalBlock;
import com.cdmoney765.enhancedstuff.blocks.EnhancedOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_ENHANCED_IRON = new EnhancedMetalBlock("block_enhanced_iron", Material.IRON);
	public static final Block BLOCK_ENHANCED_GOLD = new EnhancedMetalBlock("block_enhanced_gold", Material.IRON);
	public static final Block BLOCK_ENHANCED_DIAMOND = new EnhancedMetalBlock("block_enhanced_diamond", Material.IRON);
	
	public static final Block BLOCK_LECHATELIERITE = new EnhancedOre("block_lechatelierite", Material.IRON);
	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
}
