package io.biospartan.registry;

import io.biospartan.Biospartan;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BSItemGroups {

    public static ItemGroup BSItemsItemGroup = new ItemGroup(Biospartan.MODID + ".item_item_group") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BSItems.battleaxes.fleignarite);
        }
    };
}
