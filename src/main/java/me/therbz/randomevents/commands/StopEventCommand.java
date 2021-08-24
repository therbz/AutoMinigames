package me.therbz.randomevents.commands;

import me.therbz.randomevents.RandomEventsMain;
import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StopEventCommand {
    public boolean run(RandomEventsMain main, CommandSender sender, Command cmd, String label, String[] args) {
        if (main.getCurrentEvent() == null) { return true; }

        RandomEvent event = main.getCurrentEvent();

        event.finish();
        main.setCurrentEvent(null);

        return true;
    }
}
