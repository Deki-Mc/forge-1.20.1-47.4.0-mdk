package net.dejvid.tutorialmod.itam;

import io.netty.util.Attribute;
import net.dejvid.tutorialmod.TutorialMod;
import net.dejvid.tutorialmod.itam.custom.TitaniumTrapItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_TRAP = ITEMS.register("titanium_trap",
            () -> new TitaniumTrapItem(new Item.Properties().durability(100)));
    public static Attribute<Object> titanium;

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
