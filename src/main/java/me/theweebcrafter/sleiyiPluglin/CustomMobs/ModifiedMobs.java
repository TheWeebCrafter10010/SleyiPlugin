package me.theweebcrafter.sleiyiPluglin.CustomMobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class ModifiedMobs {

    protected static void crearZombie(Entity mob){

        Zombie zombie = (Zombie) mob;
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, Integer.MAX_VALUE, 1)); // Fuerza II
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.addEnchant(Enchantment.SHARPNESS, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
        sword.setItemMeta(meta);
        zombie.getEquipment().setItemInMainHand(sword);

    }
    protected static void crearSpider(Entity mob){
        World mundo = mob.getWorld();
        Location loc = mob.getLocation();
        mob.remove();
        CaveSpider caveSpider = (CaveSpider) mundo.spawnEntity(loc, EntityType.CAVE_SPIDER);
        caveSpider.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1)); // Invisibilidad
        caveSpider.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, Integer.MAX_VALUE, 1)); // Fuerza II
        caveSpider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)); // Velocidad

    }

    protected static void crearCreeper(Entity mob){
        Creeper creeper = (Creeper) mob;
        creeper.setPowered(true);
        creeper.setCustomName(ChatColor.BLUE + "Musulman");
        creeper.setCustomNameVisible(true);
    }

    protected static void crearEnderman(Entity mob){
        Enderman enderman = (Enderman) mob;
        enderman.setCustomName(ChatColor.LIGHT_PURPLE + "Enderman Gei");
        enderman.setCustomNameVisible(true);

        // Simula un cambio de color al quitar su textura natural
        enderman.getEquipment().setHelmet(new ItemStack(Material.PINK_STAINED_GLASS));

    }

    protected static void crearSkeleton(Entity mob){
        Skeleton skeleton = (Skeleton) mob;
        skeleton.setCustomName(ChatColor.LIGHT_PURPLE + "Calaca chida");
        skeleton.setCustomNameVisible(true);
        skeleton.setFireTicks(Integer.MAX_VALUE); // Hace que esté siempre en llamas
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1)); // Resistencia al fuego
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, Integer.MAX_VALUE, 1)); // No se quema
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1)); // Resistencia al sol

        ItemStack bow = new ItemStack(Material.BOW);
        Map<Enchantment,Integer> encantamientos = new HashMap<>();
        encantamientos.put(Enchantment.FLAME, 1);
        encantamientos.put(Enchantment.INFINITY, 1);
        encantamientos.put(Enchantment.POWER, 4);
        bow.addEnchantments(encantamientos); // Poder IV
        skeleton.getEquipment().setItemInMainHand(bow);
    }

    protected static void crearChicken(Entity mob){
        Chicken chicken = (Chicken) mob;
        chicken.setCustomName(ChatColor.RED + "Maicol Jordan");
        chicken.setCustomNameVisible(true);
    }
}
