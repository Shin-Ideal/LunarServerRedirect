package com.github.shin_ideal.lunarserverredirect.bungee.commands;

import com.github.shin_ideal.lunarserverredirect.bungee.BungeeRedirectedPlayer;
import com.github.shin_ideal.lunarserverredirect.bungee.LunarServerRedirectBungee;
import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import com.github.shin_ideal.lunarserverredirect.core.utils.LunarTransferUtil;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LunarServerRedirectCommand extends Command {

    private final LunarServerRedirectBungee plugin;

    public LunarServerRedirectCommand(LunarServerRedirectBungee plugin) {
        super("lunarserverredirect", "lunarserverredirect.command.lunarserverredirect", "lserverredirect");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings.length == 0) {
            sendUsage(commandSender);
            return;
        }

        if (strings.length != 2) {
            sendUsage(commandSender);
            return;
        }

        ProxiedPlayer proxiedPlayer = plugin.getProxy().getPlayer(strings[0]);
        String address = strings[1];

        if (proxiedPlayer == null) {
            commandSender.sendMessage(ChatColor.RED + "Player Not Found.");
            return;
        }

        RedirectedPlayer redirectedPlayer = new BungeeRedirectedPlayer(plugin, proxiedPlayer);
        LunarTransferUtil.transfer(redirectedPlayer, address);
    }

    private void sendUsage(CommandSender commandSender) {
        commandSender.sendMessage("/lunarserverredirect <player> <address>");
    }
}
