package me.therbz.autominigames.commands;

import me.therbz.autominigames.AutoMinigames;
import me.therbz.autominigames.minigames.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StartEventCommand {
    public boolean run(AutoMinigames main, CommandSender sender, Command cmd, String label, String[] args) {
        if (main.getCurrentEvent() != null) { return true; }

        if (args.length < 3) {
            return false;
        }

        int length;
        try {
            length = Integer.parseInt(args[2]) * 20;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            sender.sendMessage("Not a number!");
            return true;
        }

        Minigame gameEvent;
        switch (args[1]) {
            case "blocksMined":
                gameEvent = new BlocksMinedMinigame(main, length);
                break;

            case "mobsKilled":
                gameEvent = new MobsKilledMinigame(main, length);
                break;

            case "fishing":
                gameEvent = new FishingMinigame(main, length);
                break;

            case "chickens":
                gameEvent = new CollectablesMinigame(main, length);
                break;

            default:
                sender.sendMessage("Not an event!");
                return true;
        }

        sender.sendMessage("Started a new event: " + gameEvent.getClass().getName() + " lasting for " + args[2] + " seconds.");
        main.getLogger().info("Started a new event: " + gameEvent.getClass().getName() + " lasting for " + args[2] + " seconds.");

        return true;
    }
}
