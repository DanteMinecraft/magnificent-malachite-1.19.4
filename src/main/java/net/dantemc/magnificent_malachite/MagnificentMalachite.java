package net.dantemc.magnificent_malachite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MagnificentMalachite implements ModInitializer {

	//creative tab
	private static final ItemGroup MAGNIFICENT_MALACHITE = FabricItemGroup.builder(
			new Identifier("magnificent_malachite", "magnificent_malachite"))
			.icon(() -> new ItemStack(MagnificentMalachite.RAW_MALACHITE)).build();

	//items
	public static final Item RAW_MALACHITE =
			Registry.register(Registries.ITEM, new Identifier("magnificent_malachite", "raw_malachite"),
					new Item(new FabricItemSettings()));


	//blocks

	@Override
	public void onInitialize() {

		//item to item group
		ItemGroupEvents.modifyEntriesEvent(MAGNIFICENT_MALACHITE).register(content -> {
			content.add(RAW_MALACHITE);
		});

		//continue
	}
}