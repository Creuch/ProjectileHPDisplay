package me.fiveq.ProjecileHPDisplay.Events;

import me.fiveq.ProjecileHPDisplay.ColorMSG;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import static me.fiveq.ProjecileHPDisplay.ProjectileHpDisplayer.instance;

public class onProjectileHitEvent implements Listener {
    private me.fiveq.ProjecileHPDisplay.ProjectileHpDisplayer plugin;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getHitEntity() == null) {
            return;
        }
        this.plugin = instance;
        Projectile projectile = event.getEntity();
        Entity tempAttacker = (Entity) projectile.getShooter();
        Entity tempVictim = event.getHitEntity();
        if (tempVictim.getType().equals(EntityType.PLAYER) && tempAttacker.getType().equals(EntityType.PLAYER)) {
            Player attacker = (Player) projectile.getShooter();
            Player victim = (Player) event.getHitEntity();
            FileConfiguration config = plugin.getConfig();
            String message = (String) config.get("config.chat-message");
            String victimHealth = (String.valueOf((int) (victim.getHealth())));
            String secondMsg = message.replace("{PLAYER}", victim.getName());
            String finalMsg = secondMsg.replace("{PLAYER_HEALTH}", victimHealth);
            ColorMSG.send(attacker, finalMsg);
        }
    }
}
