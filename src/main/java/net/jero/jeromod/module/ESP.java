package net.jero.jeromod.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

import java.util.List;

public class ESP {

    private static boolean esp_activated;

    public static void toggleESP() {
        esp_activated = !esp_activated;
        System.out.println("esp toggled! " + esp_activated);
    }
    public static boolean getActivated() {
        System.out.println("ist esp an?");
        return esp_activated;
    }


}
