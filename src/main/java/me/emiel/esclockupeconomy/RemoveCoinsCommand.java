package me.emiel.esclockupeconomy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCoinsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;

        if(args.length < 2){
            MessageSender.SendErrorWithPrefix(p, "Please use the command like this: ");
            MessageSender.SendErrorWithPrefix(p, "/removecoins <name> <amount>");
            return true;
        }

        int amount;
        try{
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            MessageSender.SendErrorWithPrefix(p, "Please use the command like this: ");
            MessageSender.SendErrorWithPrefix(p, "/removecoins <name> <amount>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target ==null){
            MessageSender.SendErrorWithPrefix(p, "This player was not found!");
            return true;
        }
        if(!CoinManager.HasEnoughCoins(target, amount)){
            MessageSender.SendErrorWithPrefix(p, "This player doesn't have enough coins!");
            return true;
        }
        CoinManager.removeCoins(target, amount);
        MessageSender.SendMessageWithPrefix(p, "Removed " + amount +" coins from player!");
        return true;
    }
}
