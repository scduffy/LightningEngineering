package com.cdmoney765.enhancedstuff.init;

import com.cdmoney765.enhancedstuff.Main;
import com.cdmoney765.enhancedstuff.blocks.item.ItemBlockVariants;
import com.cdmoney765.enhancedstuff.util.IHasModel;
import com.cdmoney765.enhancedstuff.util.IMetaName;
import com.cdmoney765.enhancedstuff.util.handler.EnumHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOres extends Block implements IHasModel, IMetaName 
{
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
	
	private String name, dimension;
	
	public BlockOres(String name, String dimension)
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.LECHATELIERITE));
		setHardness(3.0F); 
		setResistance(20.0F);
		
		this.name = name;
		this.dimension = dimension;
		
		//Changing the hardness for specific ores
		//this.setHarvestLevel("pickaxe", 1, this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.COPPER));
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandler.EnumType variant : EnumHandler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + this.dimension + "_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
		
	}
}
