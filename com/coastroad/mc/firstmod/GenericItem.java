package com.coastroad.mc.firstmod;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class GenericItem extends Item {


	public GenericItem() {
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("genericItem");
	}

	// TODO: texture isn't used yet
	public GenericItem(int maxStackSize, CreativeTabs tab, int texture,
			String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}

	
}
