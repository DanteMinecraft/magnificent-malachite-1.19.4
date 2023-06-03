package net.dantemc.magnificent_malachite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagnificentMalachite implements ModInitializer {

	//ITEMS
	public static final Item MALACHITE =
			Registry.register(Registries.ITEM, new Identifier("magnificent_malachite", "malachite"),
					new Item(new FabricItemSettings()));

	//BLOCKS

	@Override
	public void onInitialize() {
	}
}