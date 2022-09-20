package me.fiveq.ProjecileHPDisplay;

import me.fiveq.ProjecileHPDisplay.Events.onProjectileHitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectileHpDisplayer extends JavaPlugin {
    public static ProjectileHpDisplayer instance;

    public static ProjectileHpDisplayer getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new onProjectileHitEvent(), this);
        saveDefaultConfig();
        getLogger().info("Plugin has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled");
    }
}
