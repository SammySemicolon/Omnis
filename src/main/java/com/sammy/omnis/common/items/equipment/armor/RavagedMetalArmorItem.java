package com.sammy.omnis.common.items.equipment.armor;

import com.sammy.omnis.client.model.ModelRavagedMetalArmor;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLEnvironment;

import javax.annotation.Nullable;

import static com.sammy.omnis.core.registry.item.ArmorTierRegistry.ArmorTierEnum.RAVAGED_ARMOR;


public class RavagedMetalArmorItem extends ArmorItem
{
    private LazyValue<Object> model;
    public RavagedMetalArmorItem(EquipmentSlotType slot, Properties builder)
    {
        super(RAVAGED_ARMOR, slot, builder);
        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> new ModelRavagedMetalArmor(slot)), () -> () -> null);
        }
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A original)
    {
        return (A) model.getValue();
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
    {
        return "omnis:textures/armor/ravaged_armor.png";
    }
}