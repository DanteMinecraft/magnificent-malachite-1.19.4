package net.dantemc.magnificent_malachite.item;

import net.dantemc.magnificent_malachite.MagnificentMalachite;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MMBlocks {

    //blocks
    public static final Block MALACHITE_ORE = registerBlock("malachite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), MMItemGroup.MAGNIFICENT_MALACHITE);
    public static final Block DEEPSLATE_MALACHITE_ORE = registerBlock("deepslate_malachite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), MMItemGroup.MAGNIFICENT_MALACHITE);
    public static final Block MALACHITE_BLOCK = registerBlock("malachite_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), MMItemGroup.MAGNIFICENT_MALACHITE);

    //calling
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MagnificentMalachite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }
    private static Block registerBlock(String name, Block block, ItemGroup group) {registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(MagnificentMalachite.MOD_ID, name), block);
    }
    public static void registerMMBlocks() {
        MagnificentMalachite.LOGGER.info("Registering Magnificent Malachite Blocks for" + MagnificentMalachite.MOD_ID);
    }
}
