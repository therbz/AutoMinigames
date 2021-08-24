package me.therbz.randomevents.events;

import me.therbz.randomevents.RandomEventsMain;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class RandomEvent implements Listener {
    private RandomEventsMain main;
    private long lengthInTicks;
    private long timeEnd;
    private HashMap<UUID, Float> scores;

    public RandomEvent(RandomEventsMain main, long lengthInTicks) {
        this.main = main;
        this.lengthInTicks = lengthInTicks;
        this.timeEnd = System.currentTimeMillis() + this.lengthInTicks * 20 * 1000;
        this.scores = new HashMap<>();

        this.main.getServer().getPluginManager().registerEvents(this, this.main);

        main.setCurrentEvent(this);

        Bukkit.getScheduler().runTaskLater(main, this::finish, lengthInTicks);
    }

    public void finish() {
        main.setCurrentEvent(null);

        HandlerList.unregisterAll(this);

        scores.forEach((uuid, score) -> Objects.requireNonNull(Bukkit.getPlayer(uuid)).sendMessage("Your score: " + score));

        main.getLogger().info("Finished event: " + this.getClass().getName() + " with " + scores.size() + " attendees.");
    }

    public long getTimeRemainingMillis() {
        return this.timeEnd - System.currentTimeMillis();
    }

    public Float getScore(UUID uuid) {
        Float score = this.scores.get(uuid);
        if (score == null) return 0f;
        else return score;
    }

    public HashMap<UUID, Float> getScores() {
        return this.scores;
    }

    public void updateScore(UUID uuid, float newScore) {
        this.scores.put(uuid, newScore);
    }

    @NotNull
    public abstract String getName();
}
