package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEvents;
import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreSelfCommand {
    public boolean run(RandomEvents main, CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You are not a player!");
            return true;
        }
        Player player = (Player) sender;

        RandomEvent event = main.getCurrentEvent();

        if (event == null) {
            sender.sendMessage("There is no current event!");
            return true;
        }

        float score = event.getScore(player.getUniqueId());

        sender.sendMessage("Your score is: " + score);

        return true;
    }
}
