package me.theweebcrafter.sleiyiPluglin.RunnableTasks;
import me.theweebcrafter.sleiyiPluglin.EntidadesCustom.JuanCustom;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class JuanSpawnRunnable extends BukkitRunnable implements RunnableTask {

    private static ArmorStand juanSpawned;
    @Override
    public void run() {
        if (juanSpawned != null && !juanSpawned.isDead()) {
            juanSpawned.remove();
        }
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();

        if (players.isEmpty()) return;
        Player target = players.get(new Random().nextInt(players.size()));
        World world = target.getWorld();

        Location spawnLocation = target.getLocation().add(
                new Random().nextInt(10) - 5,
                0,
                new Random().nextInt(10) - 5
        );
        juanSpawned = JuanCustom.spawnJuanCustom(world, spawnLocation);
        target.addPotionEffect(JuanCustom.juanEffectOnPlayer());
        Bukkit.broadcastMessage("Juan ha aparecido cerca de " + target.getName() + "!");

    }
    @Override
    public void startRunnable(Plugin plugin) {
        this.runTaskTimer(plugin, 0L, 1200L); // Corre cada 60 segundos (1200 ticks)
    }
}
