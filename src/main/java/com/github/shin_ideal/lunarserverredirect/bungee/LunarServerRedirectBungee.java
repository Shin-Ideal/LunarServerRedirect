package com.github.shin_ideal.lunarserverredirect.bungee;

import com.github.shin_ideal.lunarserverredirect.bungee.commands.LunarServerRedirectCommand;
import net.md_5.bungee.api.plugin.Plugin;

public final class LunarServerRedirectBungee extends Plugin {

    @Override
    public void onEnable() {
        registerCommands();
        getLogger().info("enable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("disable");
    }

    private void registerCommands() {
        getProxy().getPluginManager().registerCommand(this, new LunarServerRedirectCommand(this));
    }
}
