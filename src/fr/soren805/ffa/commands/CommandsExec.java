package fr.soren805.ffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.soren805.ffa.FFA;

public class CommandsExec implements CommandExecutor {
	
	private FFA main;
	private FileConfiguration config;
	
	public CommandsExec(FFA ffa){
		this.main = ffa;
		this.config = main.getConfig();
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player){
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("ffa")){
				double x = main.getConfig().getDouble("ffa.spawn.x");
				double y = main.getConfig().getDouble("ffa.spawn.y");
				double z = main.getConfig().getDouble("ffa.spawn.z");
				float yaw = main.getConfig().getInt("ffa.spawn.yaw");
				float pitch = main.getConfig().getInt("ffa.spawn.pitch");
				String worldName = main.getConfig().getString("ffa.spawn.worldName");
				World world = Bukkit.getWorld(worldName);				
				
				player.teleport(new Location(world,x,y,z,yaw,pitch));				
				
				player.sendMessage(config.getString("ffa.messages.spawn.teleported-to-ffa-spawn").replace("&", "§").replace("{PLAYER}", player.getName()));
			}
			
			if(cmd.getName().equalsIgnoreCase("setffaspawn")){
				main.getConfig().set("ffa.spawn.x", player.getLocation().getX());
				main.getConfig().set("ffa.spawn.y", player.getLocation().getY());
				main.getConfig().set("ffa.spawn.z", player.getLocation().getZ());
				main.getConfig().set("ffa.spawn.yaw", player.getLocation().getYaw());
				main.getConfig().set("ffa.spawn.pitch", player.getLocation().getPitch());
				main.getConfig().set("ffa.spawn.worldName", player.getWorld().getName());
                main.saveConfig();
                
                player.sendMessage(config.getString("ffa.messages.spawn.changed-ffa-spawn").replace("&", "§").replace("{PLAYER}", player.getName()));
                return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("ffastats")){
                player.sendMessage("§6" + player.getName() + " §2statistics :\n\n§2Kills : §6" + player.getStatistic(Statistic.PLAYER_KILLS) + "\n§2Deaths : §6" + player.getStatistic(Statistic.DEATHS));
                return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("ffacommands")){
                player.sendMessage("§2FFA Commands List :\n§6/ffacommands §2- Show all the FFA plugin commands\n§6/ffa §2- Teleport you to the FFA spawn\n\n§6/setffaspawn §2-Set the FFA spawn\n§6/ffastats §2- Get your stats of the FFA game\n§6/ffakit §2- Get the FFA kit");
                return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("ffakit")){
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
					swordM.setUnbreakable(false);
				}
				
				ItemMeta foodM = food.getItemMeta();
				foodM.setDisplayName(main.getConfig().getString("ffa.other.kit.item4.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.item4.unbreakable") == true){
					foodM.setUnbreakable(true);
				}else{
					foodM.setUnbreakable(false);
				}
				
				ItemMeta helmetM = helmet.getItemMeta();
				helmetM.setDisplayName(main.getConfig().getString("ffa.other.kit.helmet.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.helmet.unbreakable") == true){
					helmetM.setUnbreakable(true);
				}else{
					helmetM.setUnbreakable(false);
				}
				
				ItemMeta chestplateM = chestplate.getItemMeta();
				chestplateM.setDisplayName(main.getConfig().getString("ffa.other.kit.chestplate.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.chestplate.unbreakable") == true){
					chestplateM.setUnbreakable(true);
				}else{
					chestplateM.setUnbreakable(false);
				}
				
				ItemMeta leggingsM = leggings.getItemMeta();
				leggingsM.setDisplayName(main.getConfig().getString("ffa.other.kit.leggings.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.leggings.unbreakable") == true){
					leggingsM.setUnbreakable(true);
				}else{
					leggingsM.setUnbreakable(false);
				}
				
				ItemMeta bootsM = boots.getItemMeta();
				bootsM.setDisplayName(main.getConfig().getString("ffa.other.kit.boots.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.boots.unbreakable") == true){
					bootsM.setUnbreakable(true);
				}else{
					bootsM.setUnbreakable(false);
				}
				
				ItemMeta bowM = bow.getItemMeta();
				bowM.setDisplayName(main.getConfig().getString("ffa.other.kit.item2.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.item2.unbreakable") == true){
					bowM.setUnbreakable(true);
				}else{
					bowM.setUnbreakable(false);
				}
				
				ItemMeta arrowsM = arrows.getItemMeta();
				arrowsM.setDisplayName(main.getConfig().getString("ffa.other.kit.item3.name").replace("&", "§").replace("{PLAYER}", player.getName()));
				if(config.getBoolean("ffa.other.kit.item3.unbreakable") == true){
					arrowsM.setUnbreakable(true);
				}else{
					arrowsM.setUnbreakable(false);
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
				
				player.sendMessage(main.getConfig().getString("ffa.messages.gived-ffa-kit").replace("&", "§").replace("{PLAYER}", player.getName()));
			}
		}
		
		return false;
	}

}
