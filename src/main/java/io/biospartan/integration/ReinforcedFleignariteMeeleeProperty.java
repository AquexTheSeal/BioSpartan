package io.biospartan.integration;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import io.github.bioplethora.item.weapons.fleignarite_set.FleignariteAbilities;
import io.github.bioplethora.item.weapons.reinforced_fleignarite_set.ReinforcedFleignariteAbilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReinforcedFleignariteMeeleeProperty extends MeleeCallbackWeaponTrait {

    public ReinforcedFleignariteMeeleeProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    @Override
    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        ReinforcedFleignariteAbilities.hitSkill(stack, target, attacker);
    }

    @Override
    public void onItemUpdate(WeaponMaterial material, ItemStack stack, World world, LivingEntity entity, int itemSlot, boolean isSelected) {
        ReinforcedFleignariteAbilities.regenerateItem(stack, entity);
    }

    @Override
    public boolean isMeleeTrait() {
        return true;
    }

    @Override
    public boolean isRangedTrait() {
        return false;
    }
}
