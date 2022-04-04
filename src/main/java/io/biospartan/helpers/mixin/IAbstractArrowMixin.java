package io.biospartan.helpers.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public interface IAbstractArrowMixin {

    WeaponMaterialTypes getWeaponType();

    void setWeaponType(WeaponMaterialTypes type);

    boolean shouldHit(WeaponMaterialTypes type);

    void hitEntity(WeaponMaterialTypes type, LivingEntity owner, LivingEntity target);
}
