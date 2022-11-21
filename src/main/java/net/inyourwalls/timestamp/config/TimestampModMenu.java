// TimestampModMenu.java: Mod menu integration.
package net.inyourwalls.timestamp.config;

// Imports:
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class TimestampModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(TimestampConfig.class, parent).get();
    }
}
