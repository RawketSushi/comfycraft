package com.rawketsushi.comfycraft.util;

import com.rawketsushi.comfycraft.ComfyCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ComfyCraft.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	public static final boolean ENABLE = true;
	
	@SubscribeEvent
	public static void doClientStuff(FMLClientSetupEvent event) {
    }
	
}
