package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        main.reloadConfig();
        sender.sendMessage("Reloaded the config!");
        return true;
    }
}
