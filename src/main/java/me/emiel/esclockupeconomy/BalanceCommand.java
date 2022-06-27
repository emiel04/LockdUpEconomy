package me.emiel.esclockupeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        MessageSender.SendMessageWithPrefix(p, "Your balance is: " + CoinManager.getPlayerCoinAmount(p));
        return true;
    }
}
