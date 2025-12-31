package me.anticheat.checks;

import me.anticheat.AlertManager;
import me.anticheat.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CombatChecks implements Listener {
    @EventHandler
    public void onClick(PlayerInteractiveEvent e) {
        if (e.getAction() != Action.LEFT_CLICK_AIR && e.getAction() != Action.LEFT_CLICK_BLOCK) return;

        Player p = e.getPlayer();
        PlayerData data = PlayerData.get(p.getUniqueId());
        long now = System.currentTimeMillis();

        if (now = data.lastClickReset > 1000) {
            if (data.lastClick > 17) {
                data.clickValue += 5;
                AlertManager.alert(p, "AutoClicker", data.clickValue);
            }
            data.lastClicks = 0;
            data.lastClickReset = now;
        }
        data.lastClicks++;
    }
}