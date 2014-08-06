package com.coastroad.mc.armormod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ArmorModID", name="ArmorMod", version="1.0.1")
 
public class ArmorMod {

        // The instance of your mod that Forge uses.
        @Instance(value = "ArmorModID")
        public static ArmorMod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.coastroad.mc.armormod.client.ClientProxy", serverSide="com.coastroad.mc.armormod.CommonProxy")
        public static CommonProxy proxy;

        // my generic items
    	public static Item genericItem;
    	public static Item genericIngot;
    	public static Item armorHelmet;
    	public static Item armorPlate;
    	public static Item armorLegs;
    	public static Item armorBoots;
        
    	public static ArmorMaterial armorMaterial;
        
    	public static CreativeTabs tabArmorMod;
    	
    	
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
        	
        	// In case we figure out how to use the configuration mechanism eventually
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        	
        	// set up our tab
        	// TODO: needs a proper label
        	tabArmorMod = new CreativeTabsArmorMod("ArmorMod");
         	
            // let's try simple crafting: 3 coal yields a diamond
            ItemStack coal = new ItemStack(Items.coal);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond), coal, coal, coal);        
  
            // smelting: 1 diamond smelts to 4 coal
            GameRegistry.addSmelting(Items.diamond, new ItemStack(Items.coal, 4), 0.3F);
        
            // some new items
            genericItem = new GenericItem().setTextureName("armormod:genericItem");
            genericIngot = new GenericItem().setMaxStackSize(16).setUnlocalizedName("genericIngot").setTextureName("armormod:genericIngot");
      
            // create armor
            
            // first, need new material that's going to be basis for loading textures
            // parameters: name, durability, reduction amounts, enchantability
            armorMaterial = EnumHelper.addArmorMaterial("MyArmor", 35, new int[]{4,9,7,6}, 15);

            armorHelmet = new ArmorHelmet(armorMaterial, 0, 0).setUnlocalizedName("ArmorHelmet");
            armorPlate = new ArmorPlate(armorMaterial, 0, 1).setUnlocalizedName("ArmorPlate");
            armorLegs = new ArmorLegs(armorMaterial, 0, 2).setUnlocalizedName("ArmorLegs");
            armorBoots = new ArmorBoots(armorMaterial, 0, 3).setUnlocalizedName("ArmorBoots");
            
            
            // The second parameter is an unique registry identifier (not the displayed name)
            GameRegistry.registerItem(genericItem, "genericItem");	
            GameRegistry.registerItem(genericIngot, "genericIngot");
            
            GameRegistry.registerItem(armorHelmet, "armorHelmet");
            GameRegistry.registerItem(armorPlate, "armorPlate");
            GameRegistry.registerItem(armorLegs, "armorLegs");
            GameRegistry.registerItem(armorBoots, "armorBoots");
        }
        
        @EventHandler // used in 1.6.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
        }
        
        @EventHandler // used in 1.6.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
