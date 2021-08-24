package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEventsMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand {
    public boolean run(RandomEventsMain main, CommandSender sender, Command cmd, String label, String[] args) {
        main.reloadConfig();
        sender.sendMessage("Reloaded the config!");
        return true;
    }
}
