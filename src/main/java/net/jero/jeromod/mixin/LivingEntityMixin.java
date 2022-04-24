package net.jero.jeromod.mixin;

import net.jero.jeromod.module.ESP;
import net.jero.jeromod.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity{
    @Shadow protected abstract void updateGlowing();

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        updateGlowing();
    }

    @Inject(at = @At("TAIL"), method = "updateGlowing")
    private void updateGlow(CallbackInfo info) {
        System.out.println("kommt an!");
        if(ESP.getActivated()) {
            System.out.println("geil!");
            this.setFlag(Entity.GLOWING_FLAG_INDEX, true);
        }
    }

}
