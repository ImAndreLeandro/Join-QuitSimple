package net.imandreleandro.joinquitsimple;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		String msg = getConfig().getString("Join");
		msg = msg.replace("{PLAYER_NAME}", p.getName());
		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		String msg = getConfig().getString("Quit");
		msg = msg.replace("{PLAYER_NAME}", p.getName());
		e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}
