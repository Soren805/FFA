package fr.soren805.ffa;

import org.bukkit.plugin.java.JavaPlugin;

import fr.soren805.ffa.commands.CommandsExec;
import fr.soren805.ffa.commands.ListenersExec;

public class FFA extends JavaPlugin {
	
	public void onEnable(){
		saveDefaultConfig();
		System.out.println("FFA > Enabled!");
		getCommand("ffa").setExecutor(new CommandsExec(this));
		getCommand("setffaspawn").setExecutor(new CommandsExec(this));
		getCommand("ffastats").setExecutor(new CommandsExec(this));
		getCommand("ffacommands").setExecutor(new CommandsExec(this));
		getCommand("ffakit").setExecutor(new CommandsExec(this));
		getServer().getPluginManager().registerEvents(new ListenersExec(this), this);
	}
	
	public void onDisable(){
		System.out.println("FFA > Disabled!");
	}

}
