package me.therbz.randomevents.events;

import me.therbz.randomevents.RandomEventsMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class BlocksMinedRandomEvent extends RandomEvent {
    public BlocksMinedRandomEvent(RandomEventsMain main, int length) {
        super(main, length);
    }

    @Override
    public @NotNull String getName() {
        return "Blocks Mined";
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        this.updateScore(uuid, this.getScore(uuid) + 1);

        if (Math.floor(this.getScore(uuid)) % 25 == 0) { player.sendMessage("Your score is now: " + this.getScore(uuid)); }
    }
}
