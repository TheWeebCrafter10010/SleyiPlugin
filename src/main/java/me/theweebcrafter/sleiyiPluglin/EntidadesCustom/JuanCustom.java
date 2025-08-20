package me.theweebcrafter.sleiyiPluglin.EntidadesCustom;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JuanCustom {

    public static ArmorStand spawnJuanCustom(World world, Location location) {

        ArmorStand juan = (ArmorStand) world.spawnEntity(location, org.bukkit.entity.EntityType.ARMOR_STAND);
        juan.setInvisible(true);
        juan.setCustomName(ChatColor.DARK_RED + "Juan");
        juan.setCustomNameVisible(true);
        juan.setGravity(false);
        return juan;
    }

    public static PotionEffect juanEffectOnPlayer() {
        return new PotionEffect(PotionEffectType.WITHER, 600, 0);

    }

}
