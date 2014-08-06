package com.coastroad.mc.armormod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor.ArmorMaterial;
// import net.minecraftforge.Item.IArmorTextureProvider;

public class ArmorPlate extends ItemArmor {

	public ArmorPlate(ArmorMaterial p2,int p3, int p4 ) {
		super(p2, p3, p4);
		this.setCreativeTab(ArmorMod.tabArmorMod);

	}
	
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		// return "textures/armor/Armor_1.png";
		return "armormod:textures/armor/Armor_1a.png";

	}
	
	
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("armormod:armorPlate");
	}
}
