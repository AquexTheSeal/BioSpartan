package io.biospartan.integration;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.RangedCallbackWeaponTrait;
import io.biospartan.helpers.mixin.IAbstractArrowMixin;
import io.biospartan.helpers.mixin.WeaponMaterialTypes;
import io.biospartan.mixin.AbstractArrowMixin;
import net.minecraft.entity.projectile.AbstractArrowEntity;

public class FleignariteRangedProperty extends RangedCallbackWeaponTrait {

    public FleignariteRangedProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    @Override
    public float modifyLongbowDrawTime(WeaponMaterial material, float baseDraw) {
        return 0.1F;
    }

    @Override
    public int modifyHeavyCrossbowLoadTime(WeaponMaterial material, int baseLoad) {
        return 2;
    }

    @Override
    public int modifyHeavyCrossbowAimTime(WeaponMaterial material, int baseAim) {
        return 2;
    }

    @Override
    public void onProjectileSpawn(WeaponMaterial material, AbstractArrowEntity projectile) {
        projectile.setBaseDamage(projectile.getBaseDamage() + 2);
        ((IAbstractArrowMixin) projectile).setWeaponType(WeaponMaterialTypes.FLEIGNARITE);
    }

    @Override
    public boolean isMeleeTrait() {
        return false;
    }

    @Override
    public boolean isRangedTrait() {
        return true;
    }
}
