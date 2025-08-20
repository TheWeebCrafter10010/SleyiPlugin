package me.theweebcrafter.sleiyiPluglin.Handler;

import me.theweebcrafter.sleiyiPluglin.RunnableTasks.SleepCountdownRunnable;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class SleepCountdownHandler implements Listener {
    private final Plugin plugin;

    public SleepCountdownHandler(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent e){
        World world = e.getPlayer().getWorld();

        if(isDay(world)) return;

        Player player = e.getPlayer();
        SleepCountdownRunnable contadorDormir = SleepCountdownRunnable.getInstance();
        if (contadorDormir == null) {
            SleepCountdownRunnable.createInstance();
            contadorDormir = SleepCountdownRunnable.getInstance();
            contadorDormir.startRunnable(plugin);
        }

    }
    private boolean isDay(World w) {

        long time = w.getTime();
        return time < 12300 || time > 23850;
    }

}
