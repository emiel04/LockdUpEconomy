package me.emiel.esclockupeconomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageSender {

    public static void SendMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void SendMessageWithPrefix(Player player, String message){

        String prefix = EscLockupEconomy.getInstance().getConfig().getString("prefix");
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " &l|&r "+ message));
    }
    public static void SendErrorWithPrefix(Player player, String message){
        String prefix = EscLockupEconomy.getInstance().getConfig().getString("prefix");
        String code = EscLockupEconomy.getInstance().getConfig().getString("errorcolorcode");
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix  + " &l|&r "+  code + message));
    }

}
