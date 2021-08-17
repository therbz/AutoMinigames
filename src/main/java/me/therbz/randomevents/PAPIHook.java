package me.therbz.randomevents;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.therbz.randomevents.events.RandomEvent;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PAPIHook extends PlaceholderExpansion {
    final private RandomEvents main;

    public PAPIHook(RandomEvents main) {
        this.main = main;
    }

    @Override
    public @NotNull String getAuthor() {
        return "therbz";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "RandomEvents";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        // This is required or else PlaceholderAPI will unregister the Expansion on reload
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("score")) {
            RandomEvent event = main.getCurrentEvent();
            //if (event == null) { return ""; }
            //return String.valueOf(main.getCurrentEvent().getScore(player.getUniqueId()));
            return (event == null) ? "" : String.valueOf(main.getCurrentEvent().getScore(player.getUniqueId()));
        }

        if (params.equalsIgnoreCase("current_event")) {
            RandomEvent event = main.getCurrentEvent();
            //if (event == null) { return ""; }
            //return main.getCurrentEvent().getName();
            return (event == null) ? "" : main.getCurrentEvent().getName();
        }

        if (params.equalsIgnoreCase("event_ongoing")) {
            //if (main.getCurrentEvent() != null) {
            //    return "true";
            //}
            //return "false";
            return (main.getCurrentEvent() != null) ? "true" : "false";
        }

        return null;
    }
}
