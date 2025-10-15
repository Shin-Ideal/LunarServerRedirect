package com.github.shin_ideal.lunarserverredirect.velocity;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class VelocityRedirectedPlayer extends RedirectedPlayer {

    private final LunarServerRedirectVelocity plugin;

    public VelocityRedirectedPlayer(LunarServerRedirectVelocity plugin, Player player) {
        super(player.getUniqueId());
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return plugin.getServer().getPlayer(getUuid()).get().getUsername();
    }

    @Override
    public void sendMessage(String message) {
        Component componentMessage = Component.text(message).color(TextColor.color(255, 255, 255));
        plugin.getServer().getPlayer(getUuid()).get().sendMessage(componentMessage);
    }
}
