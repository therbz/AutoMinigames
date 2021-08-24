package me.therbz.autominigames;

import me.therbz.autominigames.commands.Commands;
import me.therbz.autominigames.minigames.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public class AutoMinigames extends JavaPlugin {
    private Minigame currentEvent;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.getCommand("randomevents").setExecutor(new Commands(this));

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIHook(this).register();
        }



        new MetricsLite(this, 12582);
    }

    public void setCurrentEvent(@Nullable Minigame event) {
        this.currentEvent = event;
    }

    public Minigame getCurrentEvent() {
        return this.currentEvent;
    }

    public boolean isPAPIEnabled() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }
}
