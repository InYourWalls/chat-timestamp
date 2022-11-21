// Timestamp: Just adds timestamps to chat messages.
package net.inyourwalls.timestamp;

// Imports:
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.inyourwalls.timestamp.config.TimestampConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class TimestampClient implements ClientModInitializer {
    // Get a logger.
    public static final Logger LOGGER = LoggerFactory.getLogger("timestamp");
    public static final TimestampConfig CONFIG = new TimestampConfig();

    @Override
    public void onInitializeClient() {
        // Register configuration.
        LOGGER.info("Registering config...");
        AutoConfig.register(TimestampConfig.class, GsonConfigSerializer::new);
    }
}
