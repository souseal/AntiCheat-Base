package me.anticheat;

import me.anticheat.checks.CombatChecks;
import me.anticheat.checks.MovementChecks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheatBase  extends JavaPlugin {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MovementChecks(), this);
        Bukkit.getPluginManager().registerEvents(new CombatChecks(), this);
        getLogger().info("AntiCheat enabled!");
    }
}