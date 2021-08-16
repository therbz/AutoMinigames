package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandInterface {
    @Override
    public boolean run(RandomEvents main, CommandSender sender, Command cmd, String label, String[] args) {
        main.getConfig().getStringList("messages.help");
        return true;
    }
}
