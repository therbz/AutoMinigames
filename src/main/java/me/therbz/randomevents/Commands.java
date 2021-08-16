package me.therbz.randomevents;

import me.therbz.randomevents.RandomEvents;
import me.therbz.randomevents.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    private RandomEvents main;

    public Commands(RandomEvents main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        // Check for permission
        if (!sender.hasPermission("randomevents.user")) {
            sender.sendMessage("No permission!");
            return true;
        }

        if (args[0].equalsIgnoreCase("help")) {
            return new HelpCommand().run(main, sender, cmd, label, args);
        }

        if (args[0].equalsIgnoreCase("startevent")) {
            if (!sender.hasPermission("randomevents.admin")) {
                sender.sendMessage("No permission!");
                return true;
            }

            return new StartEventCommand().run(main, sender, cmd, label, args);
        }

        if (args[0].equalsIgnoreCase("stopevent")) {
            if (!sender.hasPermission("randomevents.admin")) {
                sender.sendMessage("No permission!");
                return true;
            }

            return new StopEventCommand().run(main, sender, cmd, label, args);
        }

        if (args[0].equalsIgnoreCase("score")) {
            if (args.length == 1) {
                return new ScoreSelfCommand().run(main, sender, cmd, label, args);
            }

            if (!sender.hasPermission("randomevents.scoreothers")) {
                sender.sendMessage("No permission!");
                return true;
            }

            return new ScoreOtherCommand().run(main, sender, cmd, label, args);
        }

        return false;
    }
}
