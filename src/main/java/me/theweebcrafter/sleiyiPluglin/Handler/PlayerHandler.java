package me.theweebcrafter.sleiyiPluglin.Handler;

import me.theweebcrafter.sleiyiPluglin.SleiyiPluglin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerHandler implements Listener{

    public PlayerHandler(SleiyiPluglin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);


    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
    }

}
