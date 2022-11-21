// TimestampModMenu.java: Mod menu integration.
package net.inyourwalls.timestamp.config;

// Imports:
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;


import static net.inyourwalls.timestamp.TimestampClient.CONFIG;

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
            main.addEntry(entryBuilder.startBooleanToggle(Component.translatable("config.timestamp.option.enabled"), CONFIG.isEnabled())
                    .setDefaultValue(true)
                    .setTooltip(Component.translatable("config.timestamp.tooltip.enabled"))
                    .setSaveConsumer(CONFIG::setEnabled)
                    .build());
            main.addEntry(entryBuilder.startColorField(Component.translatable("config.timestamp.option.colour"), CONFIG.getColour())
                    .setDefaultValue(TextColor.fromLegacyFormat(ChatFormatting.GRAY))
                    .setTooltip(Component.translatable("config.timestamp.tooltip.colour"))
                    .setSaveConsumer(CONFIG::setColour)
                    .build());
            main.addEntry(entryBuilder.startStrField(Component.translatable("config.timestamp.option.format"), CONFIG.getTimeFormat())
                    .setDefaultValue("HH:mm:ss")
                    .setTooltip(Component.translatable("config.timestamp.tooltip.format"))
                    .setSaveConsumer(CONFIG::setTimeFormat)
                    .build());

            // Save.
            builder.setSavingRunnable(CONFIG::save);

            return builder.build();
        };
    }
}
