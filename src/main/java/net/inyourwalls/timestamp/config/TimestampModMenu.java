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

import java.util.Map;

public class TimestampModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent);
            ConfigCategory main = builder.getOrCreateCategory(Component.translatable("config.timestamp.category"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // Set screen title.
            builder.setTitle(Component.translatable("config.timestamp.title"));

            // Add entries.
            main.addEntry(entryBuilder.startBooleanToggle(Component.translatable("config.timestamp.option.enabled"), TimestampClient.CONFIG.isEnabled())
                    .setTooltip(Component.translatable("config.timestamp.tooltip.enabled"))
                    .setSaveConsumer(TimestampClient.CONFIG::setEnabled)
                    .build());
            main.addEntry(entryBuilder.startColorField(Component.translatable("config.timestamp.option.colour"), TimestampClient.CONFIG.getColour())
                    .setTooltip(Component.translatable("config.timestamp.tooltip.colour"))
                    .setSaveConsumer(TimestampClient.CONFIG::setColour)
                    .build());
            main.addEntry(entryBuilder.startStrField(Component.translatable("config.timestamp.option.format"), TimestampClient.CONFIG.getTimeFormat())
                    .setTooltip(Component.translatable("config.timestamp.tooltip.format"))
                    .setSaveConsumer(TimestampClient.CONFIG::setTimeFormat)
                    .build());

            return builder.build();
        };
    }
}
