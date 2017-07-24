package fr.soren805.ffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.soren805.ffa.FFA;

public class ListenersExec implements Listener {
	
	private FFA main;
	private FileConfiguration config;
	
	public ListenersExec(FFA main){
		this.main = main;
		this.config = main.getConfig();
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		
		if(config.getBoolean("ffa.other.player.teleport-on-server-join") == true){
	        
			Player player = event.getPlayer();				
			event.setJoinMessage(config.getString("ffa.messages.join-message").replace("&", "§").replace("{PLAYER}", player.getName()));	
			
			if(config.getBoolean("ffa.other.player.on-join.enable-ffa-join-message") == true){
				
				player.sendMessage(config.getString("ffa.messages.on-ffa-join.message").replace("&", "§").replace("{PLAYER}", player.getName()));	
				
			}else{
				
			}
			
			double x = main.getConfig().getDouble("ffa.spawn.x");
			double y = main.getConfig().getDouble("ffa.spawn.y");
			double z = main.getConfig().getDouble("ffa.spawn.z");
			float yaw = main.getConfig().getInt("ffa.spawn.yaw");
			float pitch = main.getConfig().getInt("ffa.spawn.pitch");
			String worldName = main.getConfig().getString("ffa.spawn.worldName");
			World world = Bukkit.getWorld(worldName);
			
			player.teleport(new Location(world,x,y,z,yaw,pitch));				
			
		}else{
			
			Player player = event.getPlayer();				
			event.setJoinMessage(config.getString("ffa.messages.join-message").replace("&", "§").replace("{PLAYER}", player.getName()));
			
			if(config.getBoolean("ffa.other.player.on-join.enable-ffa-join-message") == true){
				
				player.sendMessage(config.getString("ffa.messages.on-ffa-join.message").replace("&", "§").replace("{PLAYER}", player.getName()));	
				
			}else{
				
			}
			
		}
		
		if(config.getBoolean("ffa.other.player.give-kit-on-server-join") == true){
			
			Player player = event.getPlayer();
			
			ItemStack sword = new ItemStack(main.getConfig().getInt("ffa.other.kit.item1.id"), main.getConfig().getInt("ffa.other.kit.item1.number"));
			ItemStack bow = new ItemStack(main.getConfig().getInt("ffa.other.kit.item2.id"), main.getConfig().getInt("ffa.other.kit.item2.number"));
			ItemStack arrows = new ItemStack(main.getConfig().getInt("ffa.other.kit.item3.id"), main.getConfig().getInt("ffa.other.kit.item3.number"));
			ItemStack food = new ItemStack(main.getConfig().getInt("ffa.other.kit.item4.id"), main.getConfig().getInt("ffa.other.kit.item4.number"));
			ItemStack helmet = new ItemStack(main.getConfig().getInt("ffa.other.kit.helmet.id"), 1);
			ItemStack chestplate = new ItemStack(main.getConfig().getInt("ffa.other.kit.chestplate.id"), 1);
			ItemStack leggings = new ItemStack(main.getConfig().getInt("ffa.other.kit.leggings.id"), 1);
			ItemStack boots = new ItemStack(main.getConfig().getInt("ffa.other.kit.boots.id"), 1);
			
			ItemMeta swordM = sword.getItemMeta();
			swordM.setDisplayName(main.getConfig().getString("ffa.other.kit.item1.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.item1.unbreakable") == true){
				swordM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta foodM = food.getItemMeta();
			foodM.setDisplayName(main.getConfig().getString("ffa.other.kit.item4.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.item4.unbreakable") == true){
				foodM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta helmetM = helmet.getItemMeta();
			helmetM.setDisplayName(main.getConfig().getString("ffa.other.kit.helmet.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.helmet.unbreakable") == true){
				helmetM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta chestplateM = chestplate.getItemMeta();
			chestplateM.setDisplayName(main.getConfig().getString("ffa.other.kit.chestplate.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.chestplate.unbreakable") == true){
				chestplateM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta leggingsM = leggings.getItemMeta();
			leggingsM.setDisplayName(main.getConfig().getString("ffa.other.kit.leggings.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.leggings.unbreakable") == true){
				leggingsM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta bootsM = boots.getItemMeta();
			bootsM.setDisplayName(main.getConfig().getString("ffa.other.kit.boots.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.boots.unbreakable") == true){
				bootsM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta bowM = bow.getItemMeta();
			bowM.setDisplayName(main.getConfig().getString("ffa.other.kit.item2.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.item2.unbreakable") == true){
				bowM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta arrowsM = arrows.getItemMeta();
			arrowsM.setDisplayName(main.getConfig().getString("ffa.other.kit.item3.name").replace("&", "§").replace("{PLAYER}", player.getName()));
			if(config.getBoolean("ffa.other.kit.item3.unbreakable") == true){
				arrowsM.setUnbreakable(true);
			}else{
				
			}
			
			sword.setItemMeta(swordM);
			bow.setItemMeta(bowM);
			arrows.setItemMeta(arrowsM);
			food.setItemMeta(foodM);
			helmet.setItemMeta(helmetM);
			chestplate.setItemMeta(chestplateM);
			leggings.setItemMeta(leggingsM);
			boots.setItemMeta(bootsM);
			
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(2, arrows);
			player.getInventory().setItem(3, food);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggings);
			player.getInventory().setBoots(boots);
			player.updateInventory();
			
		}else{
			
		}
		
		if(config.getBoolean("ffa.other.player.on-join.give-all-life-to-the-player") == true){
			
			Player player = event.getPlayer();
			
			player.setHealth(player.getMaxHealth());
			
		}else{
			
		}
		
        if(config.getBoolean("ffa.other.player.on-join.give-all-food-to-the-player") == true){
			
			Player player = event.getPlayer();
			
			player.setFoodLevel(20);
			
		}else{
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		
		Player victim = event.getEntity();
		Player killer = event.getEntity().getKiller();
		event.setDeathMessage(config.getString("ffa.messages.death-message").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		
		if(config.getBoolean("ffa.other.player.on-death.give-all-life-to-the-killer") == true){	
			
			killer.setHealth(killer.getMaxHealth());	
			
		}else{
			
		}
		
        if(config.getBoolean("ffa.other.player.on-death.give-all-food-to-the-killer") == true){	
			
			killer.setFoodLevel(20);	
			
		}else{
			
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 50){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.50-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 100){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.100-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 150){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.150-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 200){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.200-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 250){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.250-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 300){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.300-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 350){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.350-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 400){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.400-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 450){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.450-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 500){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.500-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 550){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.550-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 600){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.600-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 650){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.650-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 700){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.700-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 750){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.750-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 800){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.800-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 850){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.850-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 900){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.900-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 950){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.950-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(killer.getStatistic(Statistic.PLAYER_KILLS) == 1000){
			Bukkit.broadcastMessage(config.getString("ffa.messages.kills-reach.1000-kills").replace("&", "§").replace("{PLAYER}", victim.getName()).replace("{KILLER}", killer.getName()));
		}
		
		if(main.getConfig().getBoolean("ffa.other.player.on-death.respawn-at-ffa-spawn") == true){
			
			double x = main.getConfig().getDouble("ffa.spawn.x");
			double y = main.getConfig().getDouble("ffa.spawn.y");
			double z = main.getConfig().getDouble("ffa.spawn.z");
			float yaw = main.getConfig().getInt("ffa.spawn.yaw");
			float pitch = main.getConfig().getInt("ffa.spawn.pitch");
			String worldName = main.getConfig().getString("ffa.spawn.worldName");
			World world = Bukkit.getWorld(worldName);
			
			victim.teleport(new Location(world,x,y,z,yaw,pitch));
			
		}else{
			
		}
		
		if(main.getConfig().getBoolean("ffa.other.player.on-death.give-ffa-kit-at-respawn") == true){			
			
			ItemStack sword = new ItemStack(main.getConfig().getInt("ffa.other.kit.item1.id"), main.getConfig().getInt("ffa.other.kit.item1.number"));
			ItemStack bow = new ItemStack(main.getConfig().getInt("ffa.other.kit.item2.id"), main.getConfig().getInt("ffa.other.kit.item2.number"));
			ItemStack arrows = new ItemStack(main.getConfig().getInt("ffa.other.kit.item3.id"), main.getConfig().getInt("ffa.other.kit.item3.number"));
			ItemStack food = new ItemStack(main.getConfig().getInt("ffa.other.kit.item4.id"), main.getConfig().getInt("ffa.other.kit.item4.number"));
			ItemStack helmet = new ItemStack(main.getConfig().getInt("ffa.other.kit.helmet.id"), 1);
			ItemStack chestplate = new ItemStack(main.getConfig().getInt("ffa.other.kit.chestplate.id"), 1);
			ItemStack leggings = new ItemStack(main.getConfig().getInt("ffa.other.kit.leggings.id"), 1);
			ItemStack boots = new ItemStack(main.getConfig().getInt("ffa.other.kit.boots.id"), 1);
			
			ItemMeta swordM = sword.getItemMeta();
			swordM.setDisplayName(main.getConfig().getString("ffa.other.kit.item1.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.item1.unbreakable") == true){
				swordM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta foodM = food.getItemMeta();
			foodM.setDisplayName(main.getConfig().getString("ffa.other.kit.item4.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.item4.unbreakable") == true){
				foodM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta helmetM = helmet.getItemMeta();
			helmetM.setDisplayName(main.getConfig().getString("ffa.other.kit.helmet.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.helmet.unbreakable") == true){
				helmetM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta chestplateM = chestplate.getItemMeta();
			chestplateM.setDisplayName(main.getConfig().getString("ffa.other.kit.chestplate.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.chestplate.unbreakable") == true){
				chestplateM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta leggingsM = leggings.getItemMeta();
			leggingsM.setDisplayName(main.getConfig().getString("ffa.other.kit.leggings.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.leggings.unbreakable") == true){
				leggingsM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta bootsM = boots.getItemMeta();
			bootsM.setDisplayName(main.getConfig().getString("ffa.other.kit.boots.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.boots.unbreakable") == true){
				bootsM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta bowM = bow.getItemMeta();
			bowM.setDisplayName(main.getConfig().getString("ffa.other.kit.item2.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.item2.unbreakable") == true){
				bowM.setUnbreakable(true);
			}else{
				
			}
			
			ItemMeta arrowsM = arrows.getItemMeta();
			arrowsM.setDisplayName(main.getConfig().getString("ffa.other.kit.item3.name").replace("&", "§").replace("{PLAYER}", victim.getName()));
			if(config.getBoolean("ffa.other.kit.item3.unbreakable") == true){
				arrowsM.setUnbreakable(true);
			}else{
				
			}
			
			sword.setItemMeta(swordM);
			bow.setItemMeta(bowM);
			arrows.setItemMeta(arrowsM);
			food.setItemMeta(foodM);
			helmet.setItemMeta(helmetM);
			chestplate.setItemMeta(chestplateM);
			leggings.setItemMeta(leggingsM);
			boots.setItemMeta(bootsM);
			
			victim.getInventory().setItem(0, sword);
			victim.getInventory().setItem(1, bow);
			victim.getInventory().setItem(2, arrows);
			victim.getInventory().setItem(3, food);
			victim.getInventory().setHelmet(helmet);
			victim.getInventory().setChestplate(chestplate);
			victim.getInventory().setLeggings(leggings);
			victim.getInventory().setBoots(boots);
			victim.updateInventory();
			
		}else{
			
		}

	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event){
		
		Player kicked = event.getPlayer();
		event.setLeaveMessage(config.getString("ffa.messages.kick-message").replace("&", "§").replace("{PLAYER}", kicked.getName()).replace("{REASON}", event.getReason()));
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event){
		
		if(config.getBoolean("ffa.other.player.can-drop-items") == false){
			
			Player player = event.getPlayer();
			Item item = event.getItemDrop();
			player.sendMessage(config.getString("ffa.messages.item-drop-message").replace("&", "§").replace("{PLAYER}", player.getName()).replace("{ITEM}", item.getName()));
			
			event.setCancelled(true);
			
		}else{
			
		}
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event){
		
        if(config.getBoolean("ffa.other.player.can-break-blocks") == false){
			
        	Player player = event.getPlayer();
    		Block block = event.getBlock();
    		player.sendMessage(config.getString("ffa.messages.block-break-message").replace("&", "§").replace("{PLAYER}", player.getName()).replace("{BLOCK}", block.getType().toString()));
    		
    		event.setCancelled(true);
			
		}else{
			
		}
        
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		
		Player player = event.getPlayer();
		event.setQuitMessage(config.getString("ffa.messages.leave-message").replace("&", "§").replace("{PLAYER}", player.getName()));
		
	}
	
}
