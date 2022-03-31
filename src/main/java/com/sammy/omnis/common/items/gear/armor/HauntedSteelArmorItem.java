package com.sammy.omnis.common.items.gear.armor;

import com.google.common.collect.ImmutableMultimap;
import com.sammy.omnis.client.model.HauntedArmorModel;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.UUID;

import static com.sammy.omnis.core.registry.item.ArmorTierRegistry.ArmorTierEnum.HAUNTED_ARMOR;


public class HauntedSteelArmorItem extends OmnisArmorItem {
    public HauntedSteelArmorItem(EquipmentSlot slot, Item.Properties builder) {
        super(HAUNTED_ARMOR, slot, builder);
    }

    @Override
    public ImmutableMultimap.Builder<Attribute, AttributeModifier> createExtraAttributes(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = new ImmutableMultimap.Builder<>();
        UUID uuid = ARMOR_MODIFIER_UUID_PER_SLOT[slot.getIndex()];
        builder.put(AttributeRegistry.MAGIC_RESISTANCE.get(), new AttributeModifier(uuid, "Magic Resistance", 1f, AttributeModifier.Operation.ADDITION));
        return builder;
    }


    public String getTexture() {
        return "haunted";
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(java.util.function.Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Override
            public HauntedArmorModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel _default) {
                float pticks = Minecraft.getInstance().getFrameTime();
                float f = Mth.rotLerp(pticks, entity.yBodyRotO, entity.yBodyRot);
                float f1 = Mth.rotLerp(pticks, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = f1 - f;
                float netHeadPitch = Mth.lerp(pticks, entity.xRotO, entity.getXRot());
                ItemRegistry.ClientOnly.HAUNTED_ARMOR.slot = slot;
                ItemRegistry.ClientOnly.HAUNTED_ARMOR.copyFromDefault(_default);
                ItemRegistry.ClientOnly.HAUNTED_ARMOR.setupAnim(entity, entity.animationPosition, entity.animationSpeed, entity.tickCount + pticks, netHeadYaw, netHeadPitch);
                return ItemRegistry.ClientOnly.HAUNTED_ARMOR;
            }
        });
    }
}