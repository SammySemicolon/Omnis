package com.sammy.omnis.core.registry.entity;

import com.sammy.omnis.OmnisMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.data.EntityTags;

public class OmnisEntityTags {

	public static final TagKey<EntityType<?>> SCRAP_HOLDER = omnisTag("scrap_holder");

	public static TagKey<EntityType<?>> entityTag(String path) {
		return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(path));
	}

	public static TagKey<EntityType<?>> omnisTag(String name) {
		return entityTag(OmnisMod.OMNIS + ":" + name);
	}
}