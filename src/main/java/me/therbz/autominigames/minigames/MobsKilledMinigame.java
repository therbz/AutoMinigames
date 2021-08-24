package me.therbz.autominigames.minigames;

import me.therbz.autominigames.AutoMinigames;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MobsKilledMinigame extends Minigame {
    public MobsKilledMinigame(AutoMinigames main, int length) {
        super(main, length);
    }

    @Override
    public @NotNull String getName() {
        return "Mobs Killed";
    }

    @EventHandler
    private void onMobKill(EntityDeathEvent e) {
        Player player = e.getEntity().getKiller();
        if (player == null) { return; }
        UUID uuid = player.getUniqueId();

        this.updateScore(uuid, this.getScore(uuid) + 1);

        player.sendMessage("Killed a mob! Your score is now: " + this.getScore(uuid));
    }
}
