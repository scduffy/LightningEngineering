package com.cdmoney765.enhancedstuff;

import com.cdmoney765.enhancedstuff.proxy.CommonProxy;
import com.cdmoney765.enhancedstuff.util.Reference;
import com.cdmoney765.enhancedstuff.util.handler.ModEventHandler;
import com.cdmoney765.enhancedstuff.util.handler.RegistryHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.otherRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
	}
}
