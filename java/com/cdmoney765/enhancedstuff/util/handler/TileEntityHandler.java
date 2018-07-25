package com.cdmoney765.enhancedstuff.util.handler;

import com.cdmoney765.enhancedstuff.blocks.machines.chargedfurnace.TileEntityChargedFurnace;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		//May cause problems
		GameRegistry.registerTileEntity(TileEntityChargedFurnace.class, new ResourceLocation("charged_furnace"));
		//GameRegistry.registerTileEntity(TileEntityChargedFurnace.class, "charged_furnace");
	}
}
