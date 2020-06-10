package com.rawketsushi.comfycraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rawketsushi.comfycraft.init.ItemInit;

@Mod("comfycraft")
@Mod.EventBusSubscriber(modid = ComfyCraft.MOD_ID, bus = Bus.MOD)
public class ComfyCraft
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "comfycraft";
    
    public static ComfyCraft instance;
    
    public ComfyCraft() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
        
        ItemInit.ITEMS.register(modEventBus);
        
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        
    }
   

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    	
    }
    
    public static class ComfyGear extends ItemGroup {
    	public static final ComfyGear instance = new ComfyGear(ItemGroup.GROUPS.length, "comfygear");
    	
    	private ComfyGear (int index, String label){
    		super (index, label);
    	}
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.HOOF.get());
    	}
    }
}
