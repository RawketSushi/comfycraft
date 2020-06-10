package com.rawketsushi.comfycraft.util;

import javax.annotation.Nonnull;

import com.rawketsushi.comfycraft.ComfyCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ComfyCraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ForgeEventBusSubscriber {
	private static final boolean ENABLE = true;

	@SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        if (ENABLE) {
            event.getRegistry().register(new ModLootModifier.Serializer().setRegistryName(new ResourceLocation(ComfyCraft.MOD_ID,"pig_add")));
        }
    }
}
