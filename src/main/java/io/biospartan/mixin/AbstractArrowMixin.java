package io.biospartan.mixin;

import io.biospartan.helpers.mixin.IAbstractArrowMixin;
import io.biospartan.helpers.mixin.WeaponMaterialTypes;
import io.github.bioplethora.item.weapons.fleignarite_set.FleignariteAbilities;
import io.github.bioplethora.item.weapons.reinforced_fleignarite_set.ReinforcedFleignariteAbilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractArrowEntity.class)
public class AbstractArrowMixin implements IAbstractArrowMixin {

    public WeaponMaterialTypes type = WeaponMaterialTypes.NULL;

    @Override
    public void hitEntity(WeaponMaterialTypes type, LivingEntity owner, LivingEntity target) {
        switch (type) {
            case FLEIGNARITE:
                FleignariteAbilities.defaultHitSkill(target, owner);
            case REINFORCED_FLEIGNARITE:
                ReinforcedFleignariteAbilities.defaultHitSkill(target, owner);
        }
    }

    @Override
    public WeaponMaterialTypes getWeaponType() {
        return type;
    }

    @Override
    public void setWeaponType(WeaponMaterialTypes type) {
        this.type = type;
    }

    @Override
    public boolean shouldHit(WeaponMaterialTypes type) {
        return true;
    }
}
