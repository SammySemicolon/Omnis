package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.ModSwordItem;
import com.sammy.omnis.network.packets.SpellBladeParticlePacket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.PacketDistributor;

import static com.sammy.omnis.network.NetworkManager.INSTANCE;

public class SpellBladeItem extends ModSwordItem
{
    public final float effectStrength;
    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.effectStrength = effectStrength;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if (attacker.world instanceof ServerWorld)
        {
            INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> target), new SpellBladeParticlePacket(effectStrength, target.getPosX(), target.getPosY() + target.getHeight() / 2, target.getPosZ()));
        }
        return super.hitEntity(stack, target, attacker);
    }
}
