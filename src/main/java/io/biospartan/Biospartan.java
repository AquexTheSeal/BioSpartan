package io.biospartan;

import io.biospartan.datagen.BSItemModelProvider;
import io.biospartan.datagen.BSLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("biospartan")
public class Biospartan {

    public static final String MODID = "biospartan";
    public static final String MODNAME = "BioSpartan";
    private static final Logger LOGGER = LogManager.getLogger();

    public Biospartan() {
        GeckoLib.initialize();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::gatherData);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(this);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        final ExistingFileHelper efh = event.getExistingFileHelper();

        if (event.includeServer()) {
            dataGenerator.addProvider(new BSLanguageProvider(dataGenerator, MODID, "en_us"));
            dataGenerator.addProvider(new BSItemModelProvider(dataGenerator, efh));
        }
    }
}
