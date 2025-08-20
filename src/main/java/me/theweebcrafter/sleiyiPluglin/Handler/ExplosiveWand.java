package me.theweebcrafter.sleiyiPluglin.Handler;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class ExplosiveWand {
    ItemStack varita = new ItemStack(Material.STICK);

    ExplosiveWand() {
        //Map<Enchantment,Integer> encantamientos = new HashMap<>();
        //encantamientos.put(Enchantment.FIRE_ASPECT, 5);
        //encantamientos.put(Enchantment.DIG_SPEED, 20);

        //varita.addEnchantments(encantamientos);
        ItemMeta meta = varita.getItemMeta();

        meta.setDisplayName("Explosive Wand");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 5,true);
    }



}
