// Timestamp: Just adds timestamps to chat messages.
package net.inyourwalls.timestamp;

// Imports:
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class TimestampClient implements ClientModInitializer {
    // Get a logger.
    public static final Logger LOGGER = LoggerFactory.getLogger("timestamp");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello!");
    }
}
