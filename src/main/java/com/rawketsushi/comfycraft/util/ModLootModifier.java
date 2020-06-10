package com.rawketsushi.comfycraft.util;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootModifier extends LootModifier{
	private final int numItemsToConvert;
	private final Item itemToCheck;
	private final Item itemReward;
	public ModLootModifier(ILootCondition[] conditionsIn, int numCheck, Item itemCheck, Item reward) {
		super(conditionsIn);
		numItemsToConvert = numCheck;
		itemToCheck = itemCheck;
		itemReward = reward;
	}

	@Nonnull
	@Override
	public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		int numCheck = 0;
		for(ItemStack stack : generatedLoot) {
			if(stack.getItem() == itemToCheck)
				numCheck+=stack.getCount();
		}
		if(numCheck >= numItemsToConvert) {
			generatedLoot.removeIf(x -> x.getItem() == itemToCheck);
			generatedLoot.add(new ItemStack(itemReward, (numCheck/numItemsToConvert)));
			numCheck = numCheck%numItemsToConvert;
			if(numCheck > 0)
				generatedLoot.add(new ItemStack(itemToCheck, numCheck));
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<ModLootModifier> {

		@Override
		public ModLootModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
			int numCheck = JSONUtils.getInt(object, "numCheck");
			Item checkItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation((JSONUtils.getString(object, "checkItem"))));
			Item newItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "addItem")));
			return new ModLootModifier(conditionsIn, numCheck, checkItem, newItem);
		}
	}
}
