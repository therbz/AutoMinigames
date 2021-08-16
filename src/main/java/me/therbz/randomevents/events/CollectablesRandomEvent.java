package me.therbz.randomevents.events;

import me.therbz.randomevents.RandomEvents;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class CollectablesRandomEvent extends RandomEvent {
    RandomEvents main;


    public CollectablesRandomEvent(RandomEvents main, int length) {
        super(main, length);
    }

    @Override
    public @NotNull String getName() {
        return "Collect";
    }

    private void spawnChicken(Player player) {
        double square_radius = 10;
        double diff_x = ((Math.random() * 2) - 1) * square_radius;
        double diff_z = ((Math.random() * 2) - 1) * square_radius;
        Location playerLocation = player.getLocation();
        Location spawnLocation = playerLocation.add(diff_x, 10, diff_z);

        LivingEntity spawnedEntity = (LivingEntity) player.getWorld().spawnEntity(spawnLocation, EntityType.CHICKEN);
        spawnedEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 127));

    }
}
