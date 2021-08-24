package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEventsMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCommand {
    public boolean run(RandomEventsMain main, CommandSender sender, Command cmd, String label, String[] args) {
        List<String> stringList = main.getConfig().getStringList("messages.help");
        stringList.forEach((line) -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));
        return true;
    }
}
