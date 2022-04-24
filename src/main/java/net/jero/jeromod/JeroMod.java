package net.jero.jeromod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.jero.jeromod.command.ReturnHomeCommand;
import net.jero.jeromod.command.SetHomeCommand;
import net.jero.jeromod.event.ModPlayerEventCopyFrom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JeroMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		LOGGER.info("ayo :)");
		registerCommands();
		registerEvents();
	}

	private static void registerCommands() {
		CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
		CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
	}
	private static void registerEvents() {
		ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
	}
}
