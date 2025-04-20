package net.dejvid.tutorialmod.block;

import net.dejvid.tutorialmod.TutorialMod;

import net.dejvid.tutorialmod.block.custom.SoundBlock;
import net.dejvid.tutorialmod.itam.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registryBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> BLOCK_OF_RAW_TITANIUM = registryBlock("block_of_raw_titanium",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final RegistryObject<Block> TITANIUM_ORE = registryBlock("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block>DEEPSLATE_TITANIUM_ORE = registryBlock("deepslate_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> SOUND_BLOCK = registryBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBlockItam(name,toReturn);
        return  toReturn;

    }

    public static <T extends Block> RegistryObject<Item> RegisterBlockItam(String name, RegistryObject<T> Block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
         }

}
