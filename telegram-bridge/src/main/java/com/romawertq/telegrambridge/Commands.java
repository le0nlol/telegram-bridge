package com.romawertq.telegrambridge;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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
    public Object playerjoin(PlayerJoinEvent event){
        String f = event.getPlayer().getDisplayName() + " зашёл на сервер!";
        return f;
    }
    @EventHandler
    public Object playerquit(PlayerQuitEvent event){
        String g = event.getPlayer().getDisplayName() + " вышел с сервера!";
        return g;
    }
    @EventHandler
    public Object playerchat(PlayerChatEvent event){
        String message = event.getMessage();
        String NamePlayer = event.getPlayer().getName();
        return message + NamePlayer;
    }
}
