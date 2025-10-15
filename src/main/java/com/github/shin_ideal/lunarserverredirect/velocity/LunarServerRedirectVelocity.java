package com.github.shin_ideal.lunarserverredirect.velocity;

import com.github.shin_ideal.lunarserverredirect.velocity.commands.LunarServerRedirectCommand;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "lunarserverredirect",
        name = "LunarServerRedirect",
        version = "1.0.0"
)
public final class LunarServerRedirectVelocity {

    private final ProxyServer server;
    @Inject
    private Logger logger;

    @Inject
    public LunarServerRedirectVelocity(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
        logger.info("enable");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        registerCommands();
    }

    private void registerCommands() {
        new LunarServerRedirectCommand(this);
    }

    public Logger getLogger() {
        return logger;
    }

    public ProxyServer getServer() {
        return server;
    }
}
