package io.biospartan.registry.weapontypes;

import com.google.common.collect.ImmutableList;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import com.oblivioussp.spartanweaponry.util.WeaponFactory;
import io.biospartan.registry.BSItemGroups;
import io.biospartan.registry.BSItems;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.BiFunction;

public class BSThrowingWeapons {
    public ThrowingWeaponItem fleignarite;
    public ThrowingWeaponItem reinforcedFleignarite;

    public BSThrowingWeapons(WeaponFactory.WeaponFunction<ThrowingWeaponItem> factory) {
        Item.Properties bpGroup = (new Item.Properties()).tab(BSItemGroups.BSItemsItemGroup);
        this.fleignarite = factory.create(BSItems.FLEIGNARITE, bpGroup, false);
        this.reinforcedFleignarite = factory.create(BSItems.REINFORCED_FLEIGNARITE, bpGroup, false);
    }

    public void registerItems(IForgeRegistry<Item> reg) {
        reg.registerAll(new Item[]{this.fleignarite, this.reinforcedFleignarite});
    }

    public void updateSettingsFromConfig(float baseDamage, float damageMultiplier, double speed) {
        this.fleignarite.setAttackDamage(baseDamage, damageMultiplier);
        this.fleignarite.setAttackSpeed(speed);
        this.reinforcedFleignarite.setAttackDamage(baseDamage, damageMultiplier);
        this.reinforcedFleignarite.setAttackSpeed(speed);
    }

    public ImmutableList<ThrowingWeaponItem> getAsList() {
        return ImmutableList.of(this.fleignarite, this.reinforcedFleignarite);
    }
}
