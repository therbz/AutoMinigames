package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import me.therbz.autominigames.minigames.Minigame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreSelfCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You are not a player!");
            return true;
        }
        Player player = (Player) sender;

        Minigame event = main.getCurrentEvent();

        if (event == null) {
            sender.sendMessage("There is no current event!");
            return true;
        }

        float score = event.getScore(player.getUniqueId());

        sender.sendMessage("Your score is: " + score);

        return true;
    }
}
