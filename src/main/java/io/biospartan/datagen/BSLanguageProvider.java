package io.biospartan.datagen;

import com.google.common.collect.ImmutableList;
import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.item.HeavyCrossbowItem;
import io.biospartan.Biospartan;
import io.biospartan.registry.BSItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

public class BSLanguageProvider extends LanguageProvider {

    public BSLanguageProvider(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        addBSWeapons(BSItems.daggers.getAsList());
        addBSWeapons(BSItems.parryingDaggers.getAsList());
        addBSWeapons(BSItems.longswords.getAsList());
        addBSWeapons(BSItems.katanas.getAsList());
        addBSWeapons(BSItems.sabers.getAsList());
        addBSWeapons(BSItems.rapiers.getAsList());
        addBSWeapons(BSItems.greatswords.getAsList());
        addBSWeapons(BSItems.battleHammers.getAsList());
        addBSWeapons(BSItems.warhammers.getAsList());
        addBSWeapons(BSItems.spears.getAsList());
        addBSWeapons(BSItems.halberds.getAsList());
        addBSWeapons(BSItems.pikes.getAsList());
        addBSWeapons(BSItems.lances.getAsList());

        addSWWeapons(BSItems.longbows.getAsList());
        addSWWeapons(BSItems.heavyCrossbows.getAsList());
        addSWWeapons(BSItems.throwingKnives.getAsList());
        addSWWeapons(BSItems.tomahawks.getAsList());
        addSWWeapons(BSItems.javelins.getAsList());
        addSWWeapons(BSItems.boomerangs.getAsList());

        addBSWeapons(BSItems.battleaxes.getAsList());
        addBSWeapons(BSItems.flangedMaces.getAsList());
        addBSWeapons(BSItems.glaives.getAsList());
        addBSWeapons(BSItems.quarterstaves.getAsList());
        addBSWeapons(BSItems.scythes.getAsList());
    }

    public void addNormalItem(Item item) {
        add("item." + Biospartan.MODID + "." + item.getRegistryName().getPath(), swString(item));
    }

    public void addBSWeapons(ImmutableList<? extends Item> items) {
        for (Item item : items) {
            add("item." + Biospartan.MODID + "." + item.getRegistryName().getPath(), swString(item));
        }
    }

    public void addSWWeapons(ImmutableList<? extends Item> items) {
        for (Item item : items) {
            add("item." + ModSpartanWeaponry.ID + "." + item.getRegistryName().getPath(), swString(item));
        }
    }

    public String swString(Item item) {
        String capText = capitalizedSpacedText(item.getRegistryName().getPath());
        String[] split = capText.split(" ");

        if (split.length == 1) {
            return split[0];

        } else if (split.length == 2) {
            return split[1] + " " + split[0];

        } else if (split.length == 3) {
            if (twoStringBase(item)) {
                String firstWord = split[2];
                String secondWord = split[0] + " " + split[1];
                return firstWord + " " + secondWord;
            } else {
                String firstWord = split[1] + " " + split[2];
                String secondWord = split[0];
                return firstWord + " " + secondWord;
            }

        } else if (split.length == 4) {
                String firstWord = split[2] + " " + split[3];
                String secondWord = split[0] + " " + split[1];
                return firstWord + " " + secondWord;

        } else {
            return capText;
        }
    }

    public boolean twoStringBase(Item item) {
        List<? extends Item> heavyCrossbowsAsList = BSItems.heavyCrossbows.getAsList();
        List<? extends Item> throwingKnivesAsList = BSItems.throwingKnives.getAsList();
        return heavyCrossbowsAsList.contains(item) || throwingKnivesAsList.contains(item);
    }

    public String capitalizedSpacedText(String string) {
        return WordUtils.capitalize(string.replace("_", " "));
    }
}
