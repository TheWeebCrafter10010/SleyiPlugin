package me.theweebcrafter.sleiyiPluglin.Handler;

import me.theweebcrafter.sleiyiPluglin.RunnableTasks.SleepCountdownRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerLeaveHandler implements Listener {
    private Set<UUID> punishedPlayers = new HashSet<>();
    private Plugin plugin;
    public PlayerLeaveHandler(Plugin plugin) {
        this.plugin = plugin;

    }
    @EventHandler
    public void jugadorSeVaPorGei(PlayerQuitEvent e){
        if(SleepCountdownRunnable.isRunning){
            punishedPlayers.add(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void jugadorEntraPorGei(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID gei = p.getUniqueId();

        if(SleepCountdownRunnable.isRunning){
            if(punishedPlayers.contains(gei)){
                punishedPlayers.remove(gei);
            }
            return;
        }

    if(punishedPlayers.contains(gei)){
            punishment(p);
            punishedPlayers.remove(gei);
        }

    }


    private void punishment(Player p) {
        p.setHealth(0.0);
        p.sendMessage(p.getName() + "Se ha morido por irse del server mientras estaba el contador, gei.");
    }
}
