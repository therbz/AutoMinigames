package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandInterface {

    @Override
    public boolean run(RandomEvents main, CommandSender sender, Command cmd, String label, String[] args) {
        main.reloadConfig();
        sender.sendMessage("Reloaded the config!");
        return true;
    }
}
