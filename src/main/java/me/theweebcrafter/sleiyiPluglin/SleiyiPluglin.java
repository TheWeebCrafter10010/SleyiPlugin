package me.theweebcrafter.sleiyiPluglin;

import me.theweebcrafter.sleiyiPluglin.Handler.PlayerLeaveHandler;
import me.theweebcrafter.sleiyiPluglin.Handler.SleepCountdownHandler;
import me.theweebcrafter.sleiyiPluglin.RunnableTasks.JuanSpawnRunnable;
import me.theweebcrafter.sleiyiPluglin.RunnableTasks.RunnableTask;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.theweebcrafter.sleiyiPluglin.CustomMobs.CustomMobs;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class SleiyiPluglin extends JavaPlugin implements Listener {


    CustomMobs customMobs = new CustomMobs();
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Pluglin activado");
        reloadConfig();
        startRunnableTasks();
        registerEvents();
    }

    @Override
    public void onDisable() {
        getLogger().info("Adios :D");
    }


    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        customMobs.colocarEntidad(event);
    }

    @EventHandler
    public void onCowDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Cow) {
            Silverfish silverfish = (Silverfish) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.SILVERFISH);
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1)); // Invisibilidad permanente
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));// Velocidad
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE,3));
            silverfish.setCustomName(ChatColor.GRAY + "Venganza de la Vaca");
            silverfish.setCustomNameVisible(true);
        }
    }

    public void startRunnableTasks(){
        List<RunnableTask> tareas = new ArrayList<>();
        tareas.add(new JuanSpawnRunnable());

        for (RunnableTask runnableTask : tareas) {
            runnableTask.startRunnable(this);
        }
    }

    public void registerEvents() {
        List<Listener> listeners = new ArrayList<>();
        listeners.add(new SleepCountdownHandler(this));
        listeners.add(new PlayerLeaveHandler(this));

        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }

    }
}
