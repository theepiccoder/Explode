package com.ConorGrocock.src;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Explode extends JavaPlugin{
	public void onEnable()  {}
	public void onDisable() {}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player p = event.getPlayer();
		Material bID = p.getItemInHand().getType();
		if(p.isOp()){
			if(bID == Material.STICK){
				Block b = p.getTargetBlock((Set<Material>) null, 500);
				p.getWorld().createExplosion(b.getLocation(), 5);
				p.sendMessage("Explosion!");
			}else if(bID == Material.BONE){
				Block b = p.getTargetBlock((Set<Material>) null, 500);
				p.getWorld().strikeLightning(b.getLocation());
				p.sendMessage("Lightning!");
			}
		}
	}
}
