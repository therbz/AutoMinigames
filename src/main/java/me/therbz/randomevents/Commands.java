package me.therbz.randomevents;

import me.therbz.randomevents.events.BlocksMinedRandomEvent;
import me.therbz.randomevents.events.FishingRandomEvent;
import me.therbz.randomevents.events.MobsKilledRandomEvent;
import me.therbz.randomevents.events.RandomEvent;
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

        if (cmd.getName().equalsIgnoreCase("startevent")) {
            if (args.length < 2) {
                return false;
            }

            Integer length;

            try {
                length = Integer.parseInt(args[1]) * 20;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                sender.sendMessage("Not a number!");
                return true;
            }

            RandomEvent gameEvent = null;

            switch (args[0]) {
                case "blocksMined":
                    gameEvent = new BlocksMinedRandomEvent(this.main, length);
                    break;

                case "mobsKilled":
                    gameEvent = new MobsKilledRandomEvent(this.main, length);
                    break;

                case "fishing":
                    gameEvent = new FishingRandomEvent(this.main, length);
                    break;

                default:
                    sender.sendMessage("Not an event!");
                    return true;
            }

            main.getLogger().info("Started a new event: " + gameEvent.getClass().getName() + " lasting for " + args[1] + " seconds.");

            return true;
        }

        return false;
    }
}
