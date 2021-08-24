package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import me.therbz.autominigames.minigames.Minigame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StopEventCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        if (main.getCurrentEvent() == null) { return true; }

        Minigame event = main.getCurrentEvent();

        event.finish();
        main.setCurrentEvent(null);

        return true;
    }
}
