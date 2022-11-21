// GuiAddChatMessageMixin.java: Mixin for the method that adds chat messages.
package net.inyourwalls.timestamp.mixin;

// Imports:
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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

        // Get info from the config.
        return component;
    }
}
