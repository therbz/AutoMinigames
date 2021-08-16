package me.therbz.randomevents;

import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public class RandomEvents extends JavaPlugin {
    private RandomEvent currentEvent;

    @Override
    public void onEnable() {
        this.getCommand("startevent").setExecutor(new Commands(this));

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIHook(this).register();
        }
    }

    public void setCurrentEvent(@Nullable RandomEvent event) {
        this.currentEvent = event;
    }

    public RandomEvent getCurrentEvent() {
        return this.currentEvent;
    }
}
