// GuiAddChatMessageMixin.java: Mixin for the method that adds chat messages.
package net.inyourwalls.timestamp.mixin;

// Imports:
import net.inyourwalls.timestamp.TimestampClient;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mixin(ChatComponent.class)
public abstract class GuiAddChatMessageMixin {
    @ModifyVariable(
            method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;Lnet/minecraft/client/GuiMessageTag;)V",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    private Component addMessage(Component component) {
        // If it is multiline, don't display timestamps.
        if (component.contains(Component.literal("\n"))) return component;
        // Ditto if it is disabled in config.
        if (!TimestampClient.CONFIG.isEnabled()) return component;

        // Get info from the config.
        TextColor colour = TimestampClient.CONFIG.getColour();
        String format = TimestampClient.CONFIG.getTimeFormat();
        MutableComponent timestamp = Component.literal(LocalDateTime.now().format(DateTimeFormatter.ofPattern(format))).setStyle(Style.EMPTY.withColor(colour));

        // Add a space and set styling to white.
        return timestamp.append(Component.literal(" ").setStyle(Style.EMPTY.withColor(TextColor.fromLegacyFormat(ChatFormatting.WHITE))).append(component));
    }
}
