// TimestampConfig.java: Configuration class.
package net.inyourwalls.timestamp.config;

// Imports:
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.fabricmc.loader.api.FabricLoader;
import net.inyourwalls.timestamp.TimestampClient;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextColor;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.loader.ConfigurationLoader;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

@Config(name = "timestamp")
public class TimestampConfig implements ConfigData {
    // Configurate nodes.
    private final ConfigurationLoader<CommentedConfigurationNode> loader;
    private CommentedConfigurationNode root;
    private final CommentedConfigurationNode enabledNode;
    private final CommentedConfigurationNode formatNode;
    private final CommentedConfigurationNode colourNode;

    // Config fields.
    private boolean enabled;
    private String timeFormat;
    private TextColor colour;

    public TimestampConfig() {
        // Load the config from disk.
        loader = YamlConfigurationLoader.builder().path(FabricLoader.getInstance().getConfigDir().resolve("timestamp.yml")).build();

        try {
            // Try loading from disk.
            root = loader.load();
        } catch (ConfigurateException ex) {
            // Create a virtual configuration.
            TimestampClient.LOGGER.error("Failed to load config from file: " + ex.getMessage());
            TimestampClient.LOGGER.error("Falling back on defaults...");
            root = loader.createNode();
        }

        enabledNode = root.node("enabled").commentIfAbsent("Enable/disable the mod.");
        formatNode = root.node("format").commentIfAbsent("Formatting used for the timestamp.");
        colourNode = root.node("colour").commentIfAbsent("The colour used for the timestamp, represented by an integer.");

        // Store the values in their respective fields.
        enabled = enabledNode.getBoolean(true);
        timeFormat = formatNode.getString("HH:mm:ss");
        colour = TextColor.fromRgb(colourNode.getInt(0xaaaaaa));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public TextColor getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = TextColor.fromRgb(colour);
    }

    public void save() {
        // Save the config to disk.
        try {
            enabledNode.set(enabled);
            formatNode.set(timeFormat);
            colourNode.set(colour.getValue());
            loader.save(root);
        } catch (ConfigurateException ex) {
            TimestampClient.LOGGER.error("Failed to save configuration: " + ex.getMessage());
        }
    }
}
