package io.biospartan.event;

import com.oblivioussp.spartanweaponry.entity.projectile.JavelinEntity;
import io.biospartan.helpers.mixin.IAbstractArrowMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerworldEvents {

    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        Entity entity = event.getEntity();
        World level = entity.level;
        double x = entity.getX(), y = entity.getY(), z = entity.getZ();

        if (entity instanceof AbstractArrowEntity && entity instanceof IAbstractArrowMixin && event.getRayTraceResult() instanceof EntityRayTraceResult) {
            AbstractArrowEntity arrow = (AbstractArrowEntity) entity;
            IAbstractArrowMixin mxArrow = (IAbstractArrowMixin) arrow;

            if (arrow.getOwner() instanceof LivingEntity && ((EntityRayTraceResult) event.getRayTraceResult()).getEntity() instanceof LivingEntity) {

                mxArrow.hitEntity(mxArrow.getWeaponType(), (LivingEntity) arrow.getOwner(), (LivingEntity) ((EntityRayTraceResult) event.getRayTraceResult()).getEntity());
            }
        }
    }
}
