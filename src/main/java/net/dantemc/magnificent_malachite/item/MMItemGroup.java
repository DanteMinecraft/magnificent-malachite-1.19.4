package net.dantemc.magnificent_malachite.item;

import net.dantemc.magnificent_malachite.MagnificentMalachite;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MMItemGroup {
    public static ItemGroup MAGNIFICENT_MALACHITE;

    public static void registerItemGroups() {
        MAGNIFICENT_MALACHITE = FabricItemGroup.builder(new Identifier(MagnificentMalachite.MOD_ID, "magnificent_malachite"))
                .displayName(Text.literal("Magnificent Malachite"))
                .icon(() -> new ItemStack(MMItems.MALACHITE)).build();
    }
}
