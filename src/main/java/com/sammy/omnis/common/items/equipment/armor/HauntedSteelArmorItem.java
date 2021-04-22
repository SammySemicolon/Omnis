package com.sammy.omnis.common.items.equipment.armor;

import com.sammy.omnis.client.model.ModelRavagedMetalArmor;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLEnvironment;

import javax.annotation.Nullable;

import java.util.List;

import static com.sammy.omnis.common.items.OmnisArmorTiers.ArmorTierEnum.HAUNTED_ARMOR;
import static com.sammy.omnis.common.items.OmnisArmorTiers.ArmorTierEnum.RAVAGED_ARMOR;


public class HauntedSteelArmorItem extends ArmorItem
{
    private LazyValue<Object> model;
    public HauntedSteelArmorItem(EquipmentSlotType slot, Properties builder)
    {
        super(HAUNTED_ARMOR, slot, builder);
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
        return "omnis:textures/armor/haunted_armor.png";
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(1,new TranslationTextComponent("omnis.tooltip.haunted_armor").mergeStyle(TextFormatting.BLUE));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}