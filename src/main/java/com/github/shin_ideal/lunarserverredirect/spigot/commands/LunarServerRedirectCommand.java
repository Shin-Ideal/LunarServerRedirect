package com.github.shin_ideal.lunarserverredirect.spigot.commands;

import com.github.shin_ideal.lunarserverredirect.core.RedirectedPlayer;
import com.github.shin_ideal.lunarserverredirect.core.utils.LunarTransferUtil;
import com.github.shin_ideal.lunarserverredirect.spigot.LunarServerRedirectSpigot;
import com.github.shin_ideal.lunarserverredirect.spigot.SpigotRedirectedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LunarServerRedirectCommand implements CommandExecutor {

    private final LunarServerRedirectSpigot plugin;

    public LunarServerRedirectCommand(LunarServerRedirectSpigot plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            sendUsage(commandSender);
            return true;
        }

        if (strings.length != 2) {
            sendUsage(commandSender);
            return false;
        }

        Player player = Bukkit.getPlayer(strings[0]);
        String address = strings[1];

        if (player == null) {
            commandSender.sendMessage(ChatColor.RED + "Player Not Found.");
            return false;
        }

        RedirectedPlayer redirectedPlayer = new SpigotRedirectedPlayer(plugin, player);
        LunarTransferUtil.transfer(redirectedPlayer, address);
        return true;
    }

    private void sendUsage(CommandSender commandSender) {
        commandSender.sendMessage("/lunarserverredirect <player> <address>");
    }
}
