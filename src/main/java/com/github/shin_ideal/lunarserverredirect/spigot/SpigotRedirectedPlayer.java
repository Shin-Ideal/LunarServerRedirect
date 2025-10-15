package com.github.shin_ideal.lunarserverredirect.spigot;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import org.bukkit.entity.Player;

public class SpigotRedirectedPlayer extends RedirectedPlayer {

    private final LunarServerRedirectSpigot plugin;

    public SpigotRedirectedPlayer(LunarServerRedirectSpigot plugin, Player proxiedPlayer) {
        super(proxiedPlayer.getUniqueId());
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return plugin.getServer().getPlayer(getUuid()).getName();
    }

    @Override
    public void sendMessage(String message) {
        plugin.getServer().getPlayer(getUuid()).sendMessage(message);
    }
}
