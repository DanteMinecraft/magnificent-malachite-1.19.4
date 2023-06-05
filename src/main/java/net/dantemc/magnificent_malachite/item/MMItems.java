package net.dantemc.magnificent_malachite.item;

import net.dantemc.magnificent_malachite.MagnificentMalachite;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MMItems {

    //items
    public static final Item RAW_MALACHITE = registerItem("raw_malachite", new Item(new FabricItemSettings()));
    public static final Item MALACHITE = registerItem("malachite", new Item(new FabricItemSettings()));
    public static final Item MALACHITE_HORSE_ARMOR = registerItem("malachite_horse_armor", new HorseArmorItem(7, "malachite",
            new FabricItemSettings().maxCount(1)));


    public static final Item MALACHITE_HELMET = registerItem("malachite_helmet", new ArmorItem(MMArmorMaterials.MALACHITE, ArmorItem.Type.HELMET,
            new FabricItemSettings()));

    public static final Item MALACHITE_CHESTPLATE = registerItem("malachite_chestplate", new ArmorItem(MMArmorMaterials.MALACHITE, ArmorItem.Type.CHESTPLATE,
            new FabricItemSettings()));

    public static final Item MALACHITE_LEGGINGS = registerItem("malachite_leggings", new ArmorItem(MMArmorMaterials.MALACHITE, ArmorItem.Type.LEGGINGS,
            new FabricItemSettings()));

    public static final Item MALACHITE_BOOTS = registerItem("malachite_boots", new ArmorItem(MMArmorMaterials.MALACHITE, ArmorItem.Type.BOOTS,
            new FabricItemSettings()));

    //tools
    public static final Item MALACHITE_SHOVEL = registerItem("malachite_shovel", new ShovelItem(MMToolMaterial.MALACHITE, 1.5f, 0,
            new FabricItemSettings()));
    public static final Item MALACHITE_PICKAXE = registerItem("malachite_pickaxe", new PickaxeItem(MMToolMaterial.MALACHITE, 1, 0,
            new FabricItemSettings()));
    public static final Item MALACHITE_AXE = registerItem("malachite_axe", new AxeItem(MMToolMaterial.MALACHITE, 5, -2,
            new FabricItemSettings()));
    public static final Item MALACHITE_HOE = registerItem("malachite_hoe", new HoeItem(MMToolMaterial.MALACHITE, -4, 2,
            new FabricItemSettings()));
    public static final Item MALACHITE_SWORD = registerItem("malachite_sword", new SwordItem(MMToolMaterial.MALACHITE, 3, 0,
            new FabricItemSettings()));

    //item group
    public static void addItemsToItemGroup() {
        //mod item group
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, RAW_MALACHITE);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_HORSE_ARMOR);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_SHOVEL);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_PICKAXE);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_AXE);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_HOE);
        addToItemGroup(MMItemGroup.MAGNIFICENT_MALACHITE, MALACHITE_SWORD);

        //vanilla item groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {content.addAfter(Items.RAW_GOLD, RAW_MALACHITE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {content.addAfter(Items.DIAMOND, MALACHITE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {content.addAfter(Items.DIAMOND_HORSE_ARMOR, MALACHITE_HORSE_ARMOR);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {content.addAfter(Items.DIAMOND_AXE, MALACHITE_AXE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {content.addAfter(Items.DIAMOND_SWORD, MALACHITE_SWORD);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {content.addAfter(Items.DEEPSLATE_DIAMOND_ORE, MMBlocks.MALACHITE_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {content.addAfter(MMBlocks.MALACHITE_ORE, MMBlocks.DEEPSLATE_MALACHITE_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {content.addAfter(Items.DIAMOND_BLOCK, MMBlocks.MALACHITE_BLOCK);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {content.addAfter(Items.DIAMOND_HOE, MALACHITE_SHOVEL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {content.addAfter(MALACHITE_SHOVEL, MALACHITE_PICKAXE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {content.addAfter(MALACHITE_PICKAXE, MALACHITE_AXE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {content.addAfter(MALACHITE_AXE, MALACHITE_HOE);});
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    //calling
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MagnificentMalachite.MOD_ID, name), item);
    }

    public static void registerMMItems() {
        MagnificentMalachite.LOGGER.info("Registering Magnificent Malachite Items for" + MagnificentMalachite.MOD_ID);

        addItemsToItemGroup();
    }
}
