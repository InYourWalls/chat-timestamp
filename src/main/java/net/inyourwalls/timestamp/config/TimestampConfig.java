// TimestampConfig.java: Configuration class.
package net.inyourwalls.timestamp.config;

// Imports:
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextColor;

@Config(name = "timestamp")
public class TimestampConfig implements ConfigData {
    private boolean enabled = true;
    private String timeFormat = "HH:mm:ss";
    private TextColor colour = TextColor.fromLegacyFormat(ChatFormatting.DARK_GRAY);

    public boolean isEnabled() {
        return enabled;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public TextColor getColour() {
        return colour;
    }
}
