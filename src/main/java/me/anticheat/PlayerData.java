package me.anticheat

import java.util.HashMap;
import java.util.UUID;

public class PlayerData {
    public static HashMap<UUID, PlayerData> users = new HashMap<>();

    public double speedValue = 0;
    public double flyValue = 0;
    public double clickValue = 0;

    // Moviment
    public double lastDistance = 0;
    public int airTicks = 0;

    // Combat
    public int lastClicks = 0;
    public long lastClickReset = System.currentTimeMillis();

    public static PlayerData get(UUID uuid) {
        return users.computeIfAbsent(uuid, k -> new PlayerData());
    }
}