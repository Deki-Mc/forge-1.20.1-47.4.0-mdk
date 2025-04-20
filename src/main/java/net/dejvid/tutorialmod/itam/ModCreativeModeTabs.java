package net.dejvid.tutorialmod.itam;

import net.dejvid.tutorialmod.TutorialMod;
import net.dejvid.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister <CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_MOD = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.TITANIUM.get()))
                    .title(Component.translatable("creative.tutorial_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TITANIUM.get());
                        output.accept(ModItems.RAW_TITANIUM.get());
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
                        output.accept(ModBlocks.BLOCK_OF_RAW_TITANIUM.get());
                        output.accept(ModItems.TITANIUM_TRAP.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}


