package me.therbz.autominigames.minigames;

import me.therbz.autominigames.AutoMinigames;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class FishingMinigame extends Minigame {
    AutoMinigames main;

    public FishingMinigame(AutoMinigames main, int length) {
        super(main, length);
    }


    @Override
    public @NotNull String getName() {
        return "Fishing";
    }

    @EventHandler
    private void onFishing(PlayerFishEvent e) {
        if (e.getState() != PlayerFishEvent.State.CAUGHT_FISH) { return; }

        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        this.updateScore(uuid, this.getScore(uuid) + 1);

        player.sendMessage("Caught a fish! Your score is now: " + this.getScore(uuid));
    }
}
