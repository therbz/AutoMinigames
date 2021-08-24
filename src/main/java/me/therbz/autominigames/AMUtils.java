package me.therbz.autominigames;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AMUtils {
    public static void messageSender(@NotNull CommandSender sender, @Nullable String message) {
        sender.sendMessage((message != null) ? ChatColor.translateAlternateColorCodes('&', message) : "Null message!");
    }
}
