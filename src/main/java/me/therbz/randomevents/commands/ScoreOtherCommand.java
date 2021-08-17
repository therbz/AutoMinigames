package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEvents;
import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreOtherCommand {
    public boolean run(RandomEvents main, CommandSender sender, Command cmd, String label, String[] args) {
        RandomEvent event = main.getCurrentEvent();

        if (event == null) {
            sender.sendMessage("There is no current event!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("No such player!");
            return true;
        }

        float score = event.getScore(target.getUniqueId());

        sender.sendMessage(target.getName() + "'s score is: " + score);

        return true;
    }
}
