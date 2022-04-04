package io.biospartan.registry;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.init.ModItems;
import com.oblivioussp.spartanweaponry.item.BasicItem;
import com.oblivioussp.spartanweaponry.merchant.villager.VillagerTrades;
import com.oblivioussp.spartanweaponry.util.WeaponFactory;
import io.biospartan.Biospartan;
import io.biospartan.integration.FleignariteMeeleeProperty;
import io.biospartan.integration.FleignariteRangedProperty;
import io.biospartan.integration.ReinforcedFleignariteMeeleeProperty;
import io.biospartan.integration.ReinforcedFleignariteRangedProperty;
import io.biospartan.registry.weapontypes.BSRangedWeapons;
import io.biospartan.registry.weapontypes.BSStandardWeapons;
import io.biospartan.registry.weapontypes.BSThrowingWeapons;
import io.github.bioplethora.enums.BPItemTier;
import io.github.bioplethora.registry.BPItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BSItems {

    public static final WeaponMaterial FLEIGNARITE = addMaterial("fleignarite", BPItemTier.FLEIGNARITE, 1,  "fleignarite_scales", new FleignariteMeeleeProperty("fleignarite_meelee", Biospartan.MODID), new FleignariteRangedProperty("fleignarite_ranged", Biospartan.MODID));
    public static final WeaponMaterial REINFORCED_FLEIGNARITE = addMaterial("reinforced_fleignarite", BPItemTier.REINFORCED_FLEIGNARITE, 3, "reinforced_fleignarite", new ReinforcedFleignariteMeeleeProperty("reinforced_fleignarite_meelee", Biospartan.MODID), new ReinforcedFleignariteRangedProperty("reinforced_fleignarite_ranged", Biospartan.MODID));

    public static Item handleFlt;
    public static Item poleFlt;

    public static BSStandardWeapons daggers;
    public static BSStandardWeapons parryingDaggers;
    public static BSStandardWeapons longswords;
    public static BSStandardWeapons katanas;
    public static BSStandardWeapons sabers;
    public static BSStandardWeapons rapiers;
    public static BSStandardWeapons greatswords;
    public static BSStandardWeapons battleHammers;
    public static BSStandardWeapons warhammers;
    public static BSStandardWeapons spears;
    public static BSStandardWeapons halberds;
    public static BSStandardWeapons pikes;
    public static BSStandardWeapons lances;
    public static BSRangedWeapons longbows;
    public static BSRangedWeapons heavyCrossbows;
    public static BSThrowingWeapons throwingKnives;
    public static BSThrowingWeapons tomahawks;
    public static BSThrowingWeapons javelins;
    public static BSThrowingWeapons boomerangs;
    public static BSStandardWeapons battleaxes;
    public static BSStandardWeapons flangedMaces;
    public static BSStandardWeapons glaives;
    public static BSStandardWeapons quarterstaves;
    public static BSStandardWeapons scythes;

    static {
        Item.Properties prop = (new Item.Properties()).tab(BSItemGroups.BSItemsItemGroup);
        handleFlt = new BasicItem("fleignarite_handle", prop);
        poleFlt = new BasicItem("fleignarite_pole", prop);

        daggers = new BSStandardWeapons(WeaponFactory.DAGGER);
        parryingDaggers = new BSStandardWeapons(WeaponFactory.PARRYING_DAGGER);
        longswords = new BSStandardWeapons(WeaponFactory.LONGSWORD);
        katanas = new BSStandardWeapons(WeaponFactory.KATANA);
        sabers = new BSStandardWeapons(WeaponFactory.SABER);
        rapiers = new BSStandardWeapons(WeaponFactory.RAPIER);
        greatswords = new BSStandardWeapons(WeaponFactory.GREATSWORD);
        battleHammers = new BSStandardWeapons(WeaponFactory.BATTLE_HAMMER);
        warhammers = new BSStandardWeapons(WeaponFactory.WARHAMMER);
        spears = new BSStandardWeapons(WeaponFactory.SPEAR);
        halberds = new BSStandardWeapons(WeaponFactory.HALBERD);
        pikes = new BSStandardWeapons(WeaponFactory.PIKE);
        lances = new BSStandardWeapons(WeaponFactory.LANCE);
        longbows = new BSRangedWeapons(WeaponFactory.LONGBOW);
        heavyCrossbows = new BSRangedWeapons(WeaponFactory.HEAVY_CROSSBOW);
        throwingKnives = new BSThrowingWeapons(WeaponFactory.THROWING_KNIFE);
        tomahawks = new BSThrowingWeapons(WeaponFactory.TOMAHAWK);
        javelins = new BSThrowingWeapons(WeaponFactory.JAVELIN);
        boomerangs = new BSThrowingWeapons(WeaponFactory.BOOMERANG);
        battleaxes = new BSStandardWeapons(WeaponFactory.BATTLEAXE);
        flangedMaces = new BSStandardWeapons(WeaponFactory.FLANGED_MACE);
        glaives = new BSStandardWeapons(WeaponFactory.GLAIVE);
        quarterstaves = new BSStandardWeapons(WeaponFactory.QUARTERSTAFF);
        scythes = new BSStandardWeapons(WeaponFactory.SCYTHE);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> reg = event.getRegistry();

        reg.registerAll(handleFlt, poleFlt);

        daggers.registerItems(reg);
        parryingDaggers.registerItems(reg);
        longswords.registerItems(reg);
        katanas.registerItems(reg);
        sabers.registerItems(reg);
        rapiers.registerItems(reg);
        greatswords.registerItems(reg);
        battleHammers.registerItems(reg);
        warhammers.registerItems(reg);
        spears.registerItems(reg);
        halberds.registerItems(reg);
        pikes.registerItems(reg);
        lances.registerItems(reg);
        longbows.registerItems(reg);
        heavyCrossbows.registerItems(reg);
        throwingKnives.registerItems(reg);
        tomahawks.registerItems(reg);
        javelins.registerItems(reg);
        boomerangs.registerItems(reg);
        battleaxes.registerItems(reg);
        flangedMaces.registerItems(reg);
        glaives.registerItems(reg);
        quarterstaves.registerItems(reg);
        scythes.registerItems(reg);
    }

    public static WeaponMaterial addMaterial(Item material, IItemTier tier, int additionalDmg, WeaponTrait... traits) {
        return new WeaponMaterial(material.getRegistryName().getPath(), Biospartan.MODID, 0, 0, tier.getLevel(), tier.getUses(), tier.getSpeed(), additionalDmg + tier.getAttackDamageBonus(), tier.getEnchantmentValue(), material.getRegistryName(), traits);
    }

    public static WeaponMaterial addMaterial(String material, IItemTier tier, int additionalDmg, String resLoc, WeaponTrait... traits) {
        return new WeaponMaterial(material, Biospartan.MODID, 0, 0, tier.getLevel(), tier.getUses(), tier.getSpeed(), additionalDmg + tier.getAttackDamageBonus(), tier.getEnchantmentValue(),  new ResourceLocation("bioplethora:" + resLoc), traits);
    }

    public static WeaponMaterial addMaterial(Item material, int harvestLevel, int maxUses, float efficiency, float baseDmg, int enchantability, WeaponTrait... traits) {
        return new WeaponMaterial(material.getRegistryName().getPath(), Biospartan.MODID, 0, 0, harvestLevel, maxUses, efficiency, baseDmg,  enchantability, material.getRegistryName(), traits);
    }

    public static WeaponMaterial addMaterial(String material, int harvestLevel, int maxUses, float efficiency, float baseDmg, int enchantability, ResourceLocation resloc, WeaponTrait... traits) {
        return new WeaponMaterial(material, Biospartan.MODID, 0, 0, harvestLevel, maxUses, efficiency, baseDmg,  enchantability, resloc, traits);
    }
}
