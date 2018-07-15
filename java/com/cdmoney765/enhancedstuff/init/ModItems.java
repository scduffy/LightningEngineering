package com.cdmoney765.enhancedstuff.init;

import java.util.ArrayList;
import java.util.List;

import com.cdmoney765.enhancedstuff.items.ItemBase;
import com.cdmoney765.enhancedstuff.tools.ToolAxe;
import com.cdmoney765.enhancedstuff.tools.ToolHoe;
import com.cdmoney765.enhancedstuff.tools.ToolPickaxe;
import com.cdmoney765.enhancedstuff.tools.ToolShovel;
import com.cdmoney765.enhancedstuff.tools.ToolSword;
import com.cdmoney765.enhancedstuff.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Materials
	public static final ToolMaterial TOOL_ENHANCED_IRON = 
			EnumHelper.addToolMaterial("tool_enhanced_iron", 4, 3122, 12.0F, 6.0F, 22);
	public static final ToolMaterial TOOL_ENHANCED_GOLD = 
			EnumHelper.addToolMaterial("tool_enhanced_gold", 3, 64, 12.0F, 8.0F, 34);
	public static final ToolMaterial TOOL_ENHANCED_DIAMOND = 
			EnumHelper.addToolMaterial("tool_enhanced_diamond", 5, 6000, 18.0F, 8.0F, 28);
	
	public static final ArmorMaterial ARMOR_ENHANCED_IRON = 
			EnumHelper.addArmorMaterial("armor_enhanced_iron", Reference.MOD_ID + ":enhanced_iron", 30, new int[]{3, 6, 8, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOR_ENHANCED_GOLG = 
			EnumHelper.addArmorMaterial("armor_enhanced_gold", Reference.MOD_ID + ":enhanced_gold", 20, new int[]{2, 5, 6, 2}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static final ArmorMaterial ARMOR_ENHANCED_DIAMOND = 
			EnumHelper.addArmorMaterial("armor_enhanced_diamond", Reference.MOD_ID + ":enhanced_diamond", 45, new int[]{5, 10, 11, 6}, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	
	
	//Items
	public static final Item LECHATELIERITE = new ItemBase("lechatelierite");
	public static final Item LECHATELIERITE_DUST = new ItemBase("lechatelierite_dust");
	public static final Item INGOT_ENHANCED_IRON = new ItemBase("ingot_enhanced_iron");
	public static final Item ENHANCED_DIAMOND = new ItemBase("enhanced_diamond");
	public static final Item INGOT_ENHANCED_GOLD = new ItemBase("ingot_enhanced_gold");
	
	public static final Item HANDHELD_LIGHTNING_ROD = new ItemBase("handheld_lightning_rod");
	
	//Tools
	public static final Item PICKAXE_ENHANCED_IRON = new ToolPickaxe("pickaxe_enhanced_iron", TOOL_ENHANCED_IRON);
	public static final Item PICKAXE_ENHANCED_DIAMOND = new ToolPickaxe("pickaxe_enhanced_diamond", TOOL_ENHANCED_DIAMOND);
	public static final Item PICKAXE_ENHANCED_GOLD = new ToolPickaxe("pickaxe_enhanced_gold", TOOL_ENHANCED_GOLD);
	
	public static final Item AXE_ENHANCED_IRON = new ToolAxe("axe_enhanced_iron", TOOL_ENHANCED_IRON);
	public static final Item AXE_ENHANCED_DIAMOND = new ToolAxe("axe_enhanced_diamond", TOOL_ENHANCED_DIAMOND);
	public static final Item AXE_ENHANCED_GOLD = new ToolAxe("axe_enhanced_gold", TOOL_ENHANCED_GOLD);
	
	public static final Item SHOVEL_ENHANCED_IRON = new ToolShovel("shovel_enhanced_iron", TOOL_ENHANCED_IRON);
	public static final Item SHOVEL_ENHANCED_DIAMOND = new ToolShovel("shovel_enhanced_diamond", TOOL_ENHANCED_DIAMOND);
	public static final Item SHOVEL_ENHANCED_GOLD = new ToolShovel("shovel_enhanced_gold", TOOL_ENHANCED_GOLD);
	
	public static final Item SWORD_ENHANCED_IRON = new ToolSword("sword_enhanced_iron", TOOL_ENHANCED_IRON);
	public static final Item SWORD_ENHANCED_DIAMOND = new ToolSword("sword_enhanced_diamond", TOOL_ENHANCED_DIAMOND);
	public static final Item SWORD_ENHANCED_GOLD = new ToolSword("sword_enhanced_gold", TOOL_ENHANCED_GOLD);
	
	public static final Item HOE_ENHANCED_IRON = new ToolHoe("hoe_enhanced_iron", TOOL_ENHANCED_IRON);
	public static final Item HOE_ENHANCED_DIAMOND = new ToolHoe("hoe_enhanced_diamond", TOOL_ENHANCED_DIAMOND);
	public static final Item HOE_ENHANCED_GOLD = new ToolHoe("hoe_enhanced_gold", TOOL_ENHANCED_GOLD);
}
