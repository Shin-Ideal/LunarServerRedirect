package com.github.shin_ideal.lunarserverredirect.velocity.commands;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import com.github.shin_ideal.lunarserverredirect.core.utils.LunarTransferUtil;
import com.github.shin_ideal.lunarserverredirect.velocity.LunarServerRedirectVelocity;
import com.github.shin_ideal.lunarserverredirect.velocity.VelocityRedirectedPlayer;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

import java.util.Optional;

public class LunarServerRedirectCommand implements SimpleCommand {

    private final LunarServerRedirectVelocity plugin;

    public LunarServerRedirectCommand(LunarServerRedirectVelocity plugin) {
        this.plugin = plugin;
        CommandManager commandManager = plugin.getServer().getCommandManager();
        commandManager.register(commandManager.metaBuilder("lunarserverredirect").aliases("lserverredirect").build(), this);
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource commandSource = invocation.source();
        String[] strings = invocation.arguments();

        if (!commandSource.hasPermission("lunarserverredirect.command.lunarserverredirect")) {
            commandSource.sendMessage(Component.text("You don't have permission.").color(TextColor.color(255, 0, 0)));
            return;
        }

        if (strings.length == 0) {
            sendUsage(commandSource);
            return;
        }

        if (strings.length != 2) {
            sendUsage(commandSource);
            return;
        }

        Optional<Player> optionalPlayer = plugin.getServer().getPlayer(strings[0]);
        String address = strings[1];

        if (!optionalPlayer.isPresent()) {
            Component componentMessage = Component.text("Player Not Found.").color(TextColor.color(255, 0, 0));
            commandSource.sendMessage(componentMessage);
            return;
        }
        Player player = optionalPlayer.get();

        RedirectedPlayer redirectedPlayer = new VelocityRedirectedPlayer(plugin, player);
        LunarTransferUtil.transfer(redirectedPlayer, address);
    }

    private void sendUsage(CommandSource commandSource) {
        Component componentMessage = Component.text("/lunarserverredirect <player> <address>").color(TextColor.color(255, 255, 255));
        commandSource.sendMessage(componentMessage);
    }
}
