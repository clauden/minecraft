package com.coastroad.mc.armormod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;


public class CreativeTabsArmorMod extends CreativeTabs {

	public CreativeTabsArmorMod(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {

		// Should maybe be something more interesting?
		return Item.getItemFromBlock(Blocks.dirt);
	}

}
