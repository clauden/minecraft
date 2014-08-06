package com.coastroad.mc.armormod;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class GenericItem extends Item {


	public GenericItem() {
		setMaxStackSize(64);
		setUnlocalizedName("genericItem");
		this.setCreativeTab(ArmorMod.tabArmorMod);
	}

	// TODO: texture isn't used yet
	public GenericItem(int maxStackSize, CreativeTabs tab, int texture, String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}

	
}
