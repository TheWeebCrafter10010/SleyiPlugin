package me.theweebcrafter.sleiyiPluglin.RunnableTasks;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SleepCountdownRunnable extends BukkitRunnable implements RunnableTask {

    private static SleepCountdownRunnable instance;
    private int countdownTime = 25;
    public static boolean isRunning = false;
    private SleepCountdownRunnable() {

    }

    public static SleepCountdownRunnable getInstance() {
        return instance;
    }

    public static void createInstance(){
       instance = new SleepCountdownRunnable();

    }


    @Override
    public void run() {
        if (countdownTime <= 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!p.isSleeping()) {
                    p.setHealth(0.0);
                }
            }
            isRunning = false;
            cancel();
            instance = null;
            return;
        }
        if (Bukkit.getOnlinePlayers().stream().allMatch(Player::isSleeping)) {
            Bukkit.broadcastMessage("¡Todos han dormido! Buenas noches.");
            World world = Bukkit.getWorld("world");
            world.setTime(1000L);
            cancel();
            isRunning = false;
            instance = null;
            return;
        }
        World world = Bukkit.getWorld("world");
        long time = world.getTime();
        if(time < 12300 || time > 23850){
            Bukkit.broadcastMessage("Se hizo de dia!");
            cancel();
            isRunning = false;
            instance = null;
            return;

        }
        Bukkit.broadcastMessage("Todos deben dormir en " + countdownTime + " segundos...");
        countdownTime--;

    }

    @Override
    public void startRunnable(Plugin plugin) {
        isRunning = true;
        this.runTaskTimer(plugin,0L, 20L); // Corre cada segundo (20 ticks)
    }
}
