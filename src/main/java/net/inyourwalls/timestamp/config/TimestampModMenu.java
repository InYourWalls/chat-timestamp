// TimestampModMenu.java: Mod menu integration.
package net.inyourwalls.timestamp.config;

// Imports:
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.inyourwalls.timestamp.TimestampClient;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;

public class TimestampModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        ConfigBuilder builder = ConfigBuilder.create();
        ConfigCategory main = builder.getOrCreateCategory(Component.translatable("config.timestamp.category"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        // Add entries.
        main.addEntry(entryBuilder.startBooleanToggle(Component.translatable("config.timestamp.option.enabled"), TimestampClient.CONFIG.isEnabled())
                .setTooltip(Component.translatable("config.timestamp.tooltip.enabled"))
                .build());
        main.addEntry(entryBuilder.startColorField(Component.translatable("config.timestamp.option.colour"), TimestampClient.CONFIG.getColour())
                .setTooltip(Component.translatable("config.timestamp.tooltip.colour"))
                .build());
        main.addEntry(entryBuilder.startStrField(Component.translatable("config.timestamp.option.format"), TimestampClient.CONFIG.getTimeFormat())
                .setTooltip(Component.translatable("config.timestamp.tooltip.format"))
                .build());

        return parent -> builder.setParentScreen(parent).build();
    }

}
