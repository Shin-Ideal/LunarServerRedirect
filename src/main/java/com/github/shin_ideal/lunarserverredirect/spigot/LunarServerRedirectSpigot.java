package com.github.shin_ideal.lunarserverredirect.spigot;

import com.github.shin_ideal.lunarserverredirect.spigot.commands.LunarServerRedirectCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class LunarServerRedirectSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        getLogger().info("enable");
    }

    @Override
    public void onDisable() {
        getLogger().info("disable");
    }

    private void registerCommands() {
        getCommand("lunarserverredirect").setExecutor(new LunarServerRedirectCommand(this));
    }
}
