package me.therbz.randomevents;

import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public class RandomEventsMain extends JavaPlugin {
    private RandomEvent currentEvent;

    @Override
    public void onEnable() {
        this.getCommand("randomevents").setExecutor(new Commands(this));

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIHook(this).register();
        }

        new MetricsLite(this, 12582);
    }

    public void setCurrentEvent(@Nullable RandomEvent event) {
        this.currentEvent = event;
    }

    public RandomEvent getCurrentEvent() {
        return this.currentEvent;
    }
}
