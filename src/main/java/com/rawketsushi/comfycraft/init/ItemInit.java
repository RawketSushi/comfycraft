package com.rawketsushi.comfycraft.init;

import com.rawketsushi.comfycraft.ComfyCraft;
import com.rawketsushi.comfycraft.ComfyCraft.ComfyGear;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ComfyCraft.MOD_ID);

	public static final RegistryObject<Item> HOOF = ITEMS.register("hoof", () -> new Item(new Item.Properties().group(ComfyGear.instance)));
}
