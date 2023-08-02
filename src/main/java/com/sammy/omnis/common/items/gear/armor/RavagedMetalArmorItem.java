package com.sammy.omnis.common.items.gear.armor;

import com.google.common.collect.ImmutableMultimap;
import com.sammy.omnis.client.model.HauntedArmorModel;
import com.sammy.omnis.client.model.RavagedArmorModel;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.*;

import static com.sammy.omnis.core.registry.item.ArmorTierRegistry.ArmorTierEnum.RAVAGED_ARMOR;

public class RavagedMetalArmorItem extends OmnisArmorItem {
    public RavagedMetalArmorItem(EquipmentSlot slot, Item.Properties builder) {
        super(RAVAGED_ARMOR, slot, builder);
    }

    public String getTexture() {
        return "ravaged";
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public RavagedArmorModel getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel _default) {
                float pticks = Minecraft.getInstance().getFrameTime();
                float f = Mth.rotLerp(pticks, entity.yBodyRotO, entity.yBodyRot);
                float f1 = Mth.rotLerp(pticks, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = f1 - f;
                float netHeadPitch = Mth.lerp(pticks, entity.xRotO, entity.getXRot());
                ItemRegistry.ClientOnly.RAVAGED_ARMOR.slot = slot;
                ItemRegistry.ClientOnly.RAVAGED_ARMOR.copyFromDefault(_default);
                ItemRegistry.ClientOnly.RAVAGED_ARMOR.setupAnim(entity, entity.animationPosition, entity.animationSpeed, entity.tickCount + pticks, netHeadYaw, netHeadPitch);
                return ItemRegistry.ClientOnly.RAVAGED_ARMOR;
            }
        });
    }
}