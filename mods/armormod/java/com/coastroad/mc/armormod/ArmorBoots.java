package com.coastroad.mc.armormod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor.ArmorMaterial;


public class ArmorBoots extends ItemArmor {

	public ArmorBoots(ArmorMaterial p2,int p3, int p4 ) {
		super(p2, p3, p4);
		this.setCreativeTab(ArmorMod.tabArmorMod);

	}
	
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		// return "/assets/armormod/textures/armor/Armor_1.png";
		return "armormod:textures/armor/Armor_1.png";

	}
	
	
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("armormod:armorBoots");
	}
}
