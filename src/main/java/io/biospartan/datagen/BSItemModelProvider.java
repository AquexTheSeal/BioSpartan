package io.biospartan.datagen;

import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.api.data.ModelGenerator;
import io.biospartan.Biospartan;
import io.biospartan.datagen.helpers.BSItemModelHelper;
import io.biospartan.registry.BSItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.List;

public class BSItemModelProvider extends ItemModelProvider {

    public final BSItemModelHelper swDataGen;

    public BSItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Biospartan.MODID, existingFileHelper);
        swDataGen = new BSItemModelHelper(this);
    }

    @Override
    public void registerModels() {
        defaultHandheldItem(BSItems.handleFlt);
        defaultHandheldItem(BSItems.poleFlt);

        for (Item item : BSItems.daggers.getAsList()) swDataGen.createThrowingKnifeModels(item);
        for (Item item : BSItems.parryingDaggers.getAsList()) swDataGen.createParryingDaggerModels(item);
        for (Item item : BSItems.longswords.getAsList()) swDataGen.createLongswordModel(item);
        for (Item item : BSItems.katanas.getAsList()) swDataGen.createKatanaModel(item);
        for (Item item : BSItems.sabers.getAsList()) swDataGen.createSaberModel(item);
        for (Item item : BSItems.rapiers.getAsList()) swDataGen.createRapierModel(item);
        for (Item item : BSItems.greatswords.getAsList()) swDataGen.createGreatswordModel(item);
        for (Item item : BSItems.battleHammers.getAsList()) swDataGen.createBattleHammerModel(item);
        for (Item item : BSItems.warhammers.getAsList()) swDataGen.createWarhammerModel(item);
        for (Item item : BSItems.spears.getAsList()) swDataGen.createSpearModel(item);
        for (Item item : BSItems.halberds.getAsList()) swDataGen.createHalberdModel(item);
        for (Item item : BSItems.pikes.getAsList()) swDataGen.createPikeModel(item);
        for (Item item : BSItems.lances.getAsList()) swDataGen.createLanceModel(item);

        for (Item item : BSItems.longbows.getAsList()) swDataGen.createLongbowModels(item);
        for (Item item : BSItems.heavyCrossbows.getAsList()) swDataGen.createHeavyCrossbowModels(item);

        for (Item item : BSItems.throwingKnives.getAsList()) swDataGen.createThrowingKnifeModels(item);
        for (Item item : BSItems.tomahawks.getAsList()) swDataGen.createTomahawkModels(item);
        for (Item item : BSItems.javelins.getAsList()) swDataGen.createJavelinModels(item);
        for (Item item : BSItems.boomerangs.getAsList()) swDataGen.createBoomerangModels(item);

        for (Item item : BSItems.battleaxes.getAsList()) swDataGen.createBattleaxeModel(item);
        for (Item item : BSItems.flangedMaces.getAsList()) swDataGen.createFlangedMaceModel(item);
        for (Item item : BSItems.glaives.getAsList()) swDataGen.createGlaiveModel(item);
        for (Item item : BSItems.quarterstaves.getAsList()) swDataGen.createQuarterstaffModel(item);
        for (Item item : BSItems.scythes.getAsList()) swDataGen.createScytheModel(item);
    }

    @Nonnull
    @Override
    public String getName() {
        return Biospartan.MODNAME + " Item models";
    }

    public void defaultHandheldItem(Item item) {
        ResourceLocation datagenLoc = new ResourceLocation(Biospartan.MODID, "item/" + item.getRegistryName().getPath());
        if (!existingFileHelper.exists(datagenLoc, TEXTURE) || existingFileHelper.exists(datagenLoc, MODEL)) {
            String name = item.getRegistryName().getPath();
            this.getBuilder(name).parent(getMcLoc("handheld")).texture("layer0", ITEM_FOLDER + "/" + name);
        }
    }

    public ModelFile.ExistingModelFile getMcLoc(String mcModel) {
        return getExistingFile(mcLoc(mcModel));
    }

    public ModelFile.ExistingModelFile getSwLoc(String mcModel) {
        return getExistingFile(swLoc(mcModel));
    }

    public ModelFile.ExistingModelFile getBsLoc(String mcModel) {
        return getExistingFile(bsLoc(mcModel));
    }

    public ResourceLocation swLoc(String name) {
        return new ResourceLocation(ModSpartanWeaponry.ID, name);
    }

    public ResourceLocation bsLoc(String name) {
        return new ResourceLocation(Biospartan.MODID, name);
    }
}
