package com.romawertq.telegrambridge;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;

        return true;
    }
    @EventHandler
    public void playerjoin(PlayerJoinEvent event){
        Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " зашёл на сервер!");
    }
}
