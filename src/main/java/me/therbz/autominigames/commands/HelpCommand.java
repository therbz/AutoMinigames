package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        List<String> stringList = main.getConfig().getStringList("messages.help");
        stringList.forEach((line) -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));
        return true;
    }
}
