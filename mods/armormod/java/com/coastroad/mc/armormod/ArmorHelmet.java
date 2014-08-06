package com.coastroad.mc.armormod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor.ArmorMaterial;
// import net.minecraftforge.Item.IArmorTextureProvider;

public class ArmorHelmet extends ItemArmor {

	public ArmorHelmet(ArmorMaterial p2,int p3, int p4 ) {
		super(p2, p3, p4);
		this.setCreativeTab(ArmorMod.tabArmorMod);

	}
	
	
	// public String getArmorTextureFile(ItemStack stack) {
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		// slot will tell us helmet vs. boots
        // type will be either null or overlay (cloth armor)
        // can use stack.stackTagCompound.getString("matName") for material, etc.
		
		return "armormod:textures/armor/Armor_1.png";
	}
	
	
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("armormod:armorHelmet");
	}
}
