package net.dantemc.magnificent_malachite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
	public static final Block MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f));
	public static final Block DEEPSLATE_MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f));
	public static final Block MALACHITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	@Override
	public void onInitialize() {

		//item to item group
		ItemGroupEvents.modifyEntriesEvent(MAGNIFICENT_MALACHITE).register(content -> {
			content.add(MALACHITE_ORE);
			content.add(DEEPSLATE_MALACHITE_ORE);
			content.add(MALACHITE_BLOCK);
			content.add(RAW_MALACHITE);
		});

		//register blocks
		Registry.register(Registries.BLOCK, new Identifier("magnificent_malachite", "malachite_ore"), MALACHITE_ORE);
		Registry.register(Registries.ITEM, new Identifier("magnificent_malachite", "malachite_ore"),
				new BlockItem(MALACHITE_ORE, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier("magnificent_malachite", "deepslate_malachite_ore"), DEEPSLATE_MALACHITE_ORE);
		Registry.register(Registries.ITEM, new Identifier("magnificent_malachite", "deepslate_malachite_ore"),
				new BlockItem(DEEPSLATE_MALACHITE_ORE, new FabricItemSettings()));

		Registry.register(Registries.BLOCK, new Identifier("magnificent_malachite", "malachite_block"), MALACHITE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("magnificent_malachite", "malachite_block"),
				new BlockItem(MALACHITE_BLOCK, new FabricItemSettings()));
	}
}