package com.sammy.omnis.data;

import com.sammy.omnis.*;
import net.minecraft.data.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.registries.*;
import team.lodestar.lodestone.systems.datagen.providers.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static com.sammy.omnis.core.registry.block.BlockRegistry.BLOCKS;

public class OmnisBlockTags extends LodestoneBlockTagsProvider {
    public OmnisBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, OmnisMod.OMNIS, existingFileHelper);
    }

    @Override
    protected void addTags() {
        Set<RegistryObject<Block>> blocks = new HashSet<>(BLOCKS.getEntries());
        addTagsFromBlockProperties(blocks.stream().map(RegistryObject::get).collect(Collectors.toList()));
    }

    @Override
    public String getName() {
        return "Malum Block Tags";
    }
}