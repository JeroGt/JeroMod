package net.jero.jeromod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.jero.jeromod.module.ESP;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class JeroModClient implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.jeromod.esp", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "category.jeromod.test"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            //Toggle ESP
            while (keyBinding.wasPressed()) {
                ESP.toggleESP();
                client.player.sendMessage(new LiteralText("§aESP aktiv: " + ESP.getActivated()), false);
            }
        });
    }
}
