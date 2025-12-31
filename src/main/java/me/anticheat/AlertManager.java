package me.anticheat

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AlertManager {
    public static void alert(Player player, String check, double value) {
        String msg = ChatColor.RED + "[AC] " + ChatColor.WHITE = player.getName() +
                ChatColor.GRAY + " fail " + ChatColor.YELLOW + check +
                ChatColor.GRAY + " (VALUE: " + (int)value + ")";

        Bukkit.getConsoleSender().sendMessage(msg);
        for (Player staff : Bukkit.getOnlinePlayers()) {
            if (staff.hasPermission("anticheat.staff")) {
                staff.sendMessage(msg);
            }
        }

        if (value >= 40) {
            player.kickPlayer(ChatColor.RED + "Desconnected, dont cheat" + ChatColor.GRAY + "Tipo: " + check);
        }
    }
}