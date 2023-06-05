package net.dantemc.magnificent_malachite;

import net.dantemc.magnificent_malachite.item.MMBlocks;
import net.dantemc.magnificent_malachite.item.MMItemGroup;
import net.dantemc.magnificent_malachite.item.MMItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagnificentMalachite implements ModInitializer {

	//public mod_id logger
	public static final String MOD_ID = "magnificent_malachite";
	public static final Logger LOGGER = LoggerFactory.getLogger("magnificent_malachite");

	//worldgen
	public static final RegistryKey<PlacedFeature> MALACHITE_ORE_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
			new Identifier("magnificent_malachite","malachite_ore"));

	@Override
	public void onInitialize() {

		//Registering classes
		MMItemGroup.registerItemGroups();
		MMItems.registerMMItems();
		MMBlocks.registerMMBlocks();

		//worldgen
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MALACHITE_ORE_KEY);

	}
}