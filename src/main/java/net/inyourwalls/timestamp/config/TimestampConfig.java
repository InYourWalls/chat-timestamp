// TimestampConfig.java: Configuration class.
package net.inyourwalls.timestamp.config;

// Imports:
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.ChatFormatting;

@Config(name = "timestamp")
public class TimestampConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    private boolean enabled = true;
    @ConfigEntry.Gui.Tooltip
    private String timeFormat = "HH:mm:ss";
    @ConfigEntry.Gui.Tooltip
    private ChatFormatting formatting = ChatFormatting.DARK_GRAY;

    public boolean isEnabled() {
        return enabled;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public ChatFormatting getFormatting() {
        return formatting;
    }
}
