package me.fiveq.ProjecileHPDisplay;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ColorMSG {
    public static void send(CommandSender player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}