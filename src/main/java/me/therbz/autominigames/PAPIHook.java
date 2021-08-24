package me.therbz.autominigames;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.therbz.autominigames.minigames.Minigame;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PAPIHook extends PlaceholderExpansion {
    final private AutoMinigames main;

    public PAPIHook(AutoMinigames main) {
        this.main = main;
    }

    @Override
    public @NotNull String getAuthor() {
        return "therbz";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "AutoMinigames";
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
            Minigame event = main.getCurrentEvent();
            return (event == null) ? "" : String.valueOf(event.getScore(player.getUniqueId()));
        }

        if (params.equalsIgnoreCase("current_event")) {
            Minigame event = main.getCurrentEvent();
            return (event == null) ? "" : event.getName();
        }

        if (params.equalsIgnoreCase("event_ongoing")) {
            return (main.getCurrentEvent() != null) ? "true" : "false";
        }

        return null;
    }
}
