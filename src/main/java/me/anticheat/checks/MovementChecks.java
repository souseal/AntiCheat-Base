package me.anticheat.checks;

import me.anticheat.AlertManager;
import me.anticheat.PlayerData;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementChecks {
    @EventHandler
    public void onMove(PLayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.SURVIVAL) return;

        PlayerData data = PlayerData.get(p.getUniqueId());
        Location from = e.getFrom();
        Location to = e.getTo();

        // Speed check (simple)
        double distance = from.distance(to);
        if (distance > 0.65 && !p.isFlying()) {
            data.speedValue += 5;
            if (data.speedValue >= 10) AlertManager.alert(p, "Speed", data.speedValue);
        }

        //Fly check (air time)
        if (to.getY() >= from.getY() && p.getLocation().subtract(0, 0.1, 0).getBlock().getType() == Material.AIR) {
            data.airTicks++;
            if (data.airTicks > 20) {
                data.flyValue += 10;
                AlertManager.alert(p, "Fly", data.flyValue);
                data.airTicks = 0;
            }
        } else {
            data.airTicks = 0;
            }
        }
    }
}