package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEventsMain;
import me.therbz.randomevents.events.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StartEventCommand {
    public boolean run(RandomEventsMain main, CommandSender sender, Command cmd, String label, String[] args) {
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

        RandomEvent gameEvent;
        switch (args[1]) {
            case "blocksMined":
                gameEvent = new BlocksMinedRandomEvent(main, length);
                break;

            case "mobsKilled":
                gameEvent = new MobsKilledRandomEvent(main, length);
                break;

            case "fishing":
                gameEvent = new FishingRandomEvent(main, length);
                break;

            case "chickens":
                gameEvent = new CollectablesRandomEvent(main, length);
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
