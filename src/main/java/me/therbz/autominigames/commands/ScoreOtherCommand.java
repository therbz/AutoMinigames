package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import me.therbz.autominigames.minigames.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreOtherCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        Minigame event = main.getCurrentEvent();

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
