package com.github.shin_ideal.lunarserverredirect.bungee;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeeRedirectedPlayer extends RedirectedPlayer {

    private final LunarServerRedirectBungee plugin;

    public BungeeRedirectedPlayer(LunarServerRedirectBungee plugin, ProxiedPlayer proxiedPlayer) {
        super(proxiedPlayer.getUniqueId());
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return plugin.getProxy().getPlayer(getUuid()).getName();
    }

    @Override
    public void sendMessage(String message) {
        plugin.getProxy().getPlayer(getUuid()).sendMessage(message);
    }
}
