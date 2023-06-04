package net.dantemc.magnificent_malachite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MagnificentMalachite implements ModInitializer {

	//creative tab
	private static final ItemGroup MAGNIFICENT_MALACHITE = FabricItemGroup.builder(
			new Identifier("magnificent_malachite", "magnificent_malachite"))
			.icon(() -> new ItemStack(MagnificentMalachite.RAW_MALACHITE)).build();

	//items
	public static final Item RAW_MALACHITE = Registry.register(Registries.ITEM,
			new Identifier("magnificent_malachite", "raw_malachite"), new Item(new FabricItemSettings()));
	public static final Item MALACHITE = Registry.register(Registries.ITEM,
			new Identifier("magnificent_malachite", "malachite"), new Item(new FabricItemSettings()));

	public static final Item MALACHITE_HORSE_ARMOR = Registry.register(Registries.ITEM,
			new Identifier("magnificent_malachite", "malachite_horse_armor"), new HorseArmorItem(7, "malachite",
			new FabricItemSettings().maxCount(1)));

	//blocks
	public static final Block MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f));
	public static final Block DEEPSLATE_MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f));
	public static final Block MALACHITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	//worldgen
	public static final RegistryKey<PlacedFeature> MALACHITE_ORE_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
			new Identifier("magnificent_malachite","malachite_ore"));

	@Override
	public void onInitialize() {

		//item to item group
		ItemGroupEvents.modifyEntriesEvent(MAGNIFICENT_MALACHITE).register(content -> {
			content.add(MALACHITE_ORE);
			content.add(DEEPSLATE_MALACHITE_ORE);
			content.add(MALACHITE_BLOCK);
			content.add(RAW_MALACHITE);
			content.add(MALACHITE);
			content.add(MALACHITE_HORSE_ARMOR);
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

		//worldgen
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MALACHITE_ORE_KEY);

	}
}