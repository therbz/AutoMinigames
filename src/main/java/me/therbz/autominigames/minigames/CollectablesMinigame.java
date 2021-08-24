package me.therbz.autominigames.minigames;

import me.therbz.autominigames.AutoMinigames;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CollectablesMinigame extends Minigame {
    private AutoMinigames main;
    private HashMap<UUID, ArrayList<UUID>> chickens;
    private final String CUSTOM_CHICKEN_NAME = "§c§lEvent Chicken §7(Punch)";

    public CollectablesMinigame(AutoMinigames main, int length) {
        super(main, length);
        chickens = new HashMap<>();

        for (Player player : Bukkit.getOnlinePlayers()) { for (int i = 0; i < 10; i++) { this.spawnChicken(player); } }
    }

    @Override
    public @NotNull String getName() {
        return "Collect";
    }

    @Override
    public void finish() {
        super.finish();
        chickens.forEach((UUID uuid, ArrayList<UUID> list) -> {
            list.forEach((UUID chickenUuid) -> {
                Objects.requireNonNull(Bukkit.getEntity(chickenUuid)).remove();
            });
        });
    }

    private void spawnChicken(Player player) {
        double square_radius = 25;
        double diff_x = ((Math.random() * 2) - 1) * square_radius;
        double diff_z = ((Math.random() * 2) - 1) * square_radius;
        Location playerLocation = player.getLocation();
        Location spawnLocation = playerLocation.add(diff_x, 10, diff_z);

        LivingEntity spawnedEntity = (LivingEntity) player.getWorld().spawnEntity(spawnLocation, EntityType.CHICKEN);

        if (!chickens.containsKey(player.getUniqueId())) {
            chickens.put(player.getUniqueId(), new ArrayList<>());
        }

        chickens.get(player.getUniqueId()).add(spawnedEntity.getUniqueId());

        spawnedEntity.setHealth(0.1);
        spawnedEntity.setCustomName(CUSTOM_CHICKEN_NAME);
        spawnedEntity.setCustomNameVisible(true);

        //this.main.getLogger().info("Spawned new chicken");
    }

    @EventHandler
    public void onChickenKill(EntityDeathEvent e) {
        if (!Objects.equals(e.getEntity().getCustomName(), CUSTOM_CHICKEN_NAME)) { return; }

        Player player = e.getEntity().getKiller();
        if (player == null) { return; }

        UUID playerUuid = player.getUniqueId();

        List<UUID> playersChickens = chickens.get(playerUuid);

        Entity chicken = e.getEntity();

        if (!playersChickens.contains(chicken.getUniqueId())) { return; }

        playersChickens.remove(chicken.getUniqueId());

        this.updateScore(playerUuid, this.getScore(playerUuid) + 1);

        player.sendMessage("Your score is now: " + this.getScore(playerUuid));

        this.spawnChicken(player);
    }
}
