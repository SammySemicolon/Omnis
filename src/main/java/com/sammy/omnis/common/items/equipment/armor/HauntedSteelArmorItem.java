package com.sammy.omnis.common.items.equipment.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.sammy.omnis.client.model.ModelRavagedMetalArmor;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLEnvironment;

import javax.annotation.Nullable;

import java.util.UUID;

import static com.sammy.omnis.core.registry.item.ArmorTierRegistry.ArmorTierEnum.HAUNTED_ARMOR;


public class HauntedSteelArmorItem extends ArmorItem {
    private LazyValue<Object> model;

    public HauntedSteelArmorItem(EquipmentSlotType slot, Properties builder) {
        super(HAUNTED_ARMOR, slot, builder);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> new ModelRavagedMetalArmor(slot)), () -> () -> null);
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_MODIFIERS[slot.getIndex()];
        attributeBuilder.putAll(field_234656_m_);
        attributeBuilder.put(AttributeRegistry.MAGIC_RESISTANCE.get(), new AttributeModifier(uuid, "Armor magic resistance", 1, AttributeModifier.Operation.ADDITION));
        return slot == this.slot ? attributeBuilder.build() : ImmutableMultimap.of();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A original) {
        return (A) model.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "omnis:textures/armor/haunted_armor.png";
    }
}