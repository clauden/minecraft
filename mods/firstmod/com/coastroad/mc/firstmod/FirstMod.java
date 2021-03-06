package com.coastroad.mc.firstmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="FirstModID", name="FirstMod", version="1.0.2")
 
public class FirstMod {

        // The instance of your mod that Forge uses.
        @Instance(value = "FirstModID")
        public static FirstMod instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.coastroad.mc.firstmod.client.ClientProxy", serverSide="com.coastroad.mc.firstmod.CommonProxy")
        public static CommonProxy proxy;

        // my generic items
    	public static Item genericItem;
    	public static Item genericIngot;
        
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
        	   
            // let's try simple crafting: 3 coal yields a diamond
            ItemStack coal = new ItemStack(Items.coal);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond), coal, coal, coal);        
  
            // smelting: 1 diamond smelts to 4 coal
            GameRegistry.addSmelting(Items.diamond, new ItemStack(Items.coal, 4), 0.3F);
        
            // some new items
            genericItem = new GenericItem().setTextureName("firstmod:genericItem");
            genericIngot = new GenericItem().setMaxStackSize(16).setUnlocalizedName("genericIngot");
            
            
            // The second parameter is an unique registry identifier (not the displayed name)
            GameRegistry.registerItem(genericItem, "genericItem");	
            GameRegistry.registerItem(genericIngot, "genericIngot");	

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