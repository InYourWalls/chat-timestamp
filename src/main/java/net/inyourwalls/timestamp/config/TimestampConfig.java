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
}
