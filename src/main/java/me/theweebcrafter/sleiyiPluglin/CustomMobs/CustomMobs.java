package me.theweebcrafter.sleiyiPluglin.CustomMobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CustomMobs {

    public void colocarEntidad(CreatureSpawnEvent event){
        Entity mob = event.getEntity();
        crearNuevoMob(mob);

    }

    private boolean crearNuevoMob(Entity mob){
        switch(mob.getType()){
            case SPIDER:
                ModifiedMobs.crearSpider(mob);
                return true;

            case ZOMBIE:
                ModifiedMobs.crearZombie(mob);
                return true;

            case CREEPER:
                ModifiedMobs.crearCreeper(mob);
                return true;

            case ENDERMAN:
                ModifiedMobs.crearEnderman(mob);
                return true;

            case SKELETON:
                ModifiedMobs.crearSkeleton(mob);
                return true;

            case CHICKEN:
                ModifiedMobs.crearChicken(mob);
                return true;

            default:
                return false;
        }
    }
}
