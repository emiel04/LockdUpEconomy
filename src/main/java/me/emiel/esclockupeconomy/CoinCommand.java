package me.emiel.esclockupeconomy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.color.ICC_ColorSpace;

public class CoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player p = (Player) sender;
        String prefix = EscLockupEconomy.getInstance().getConfig().getString("prefix");
        prefix += " &r&l|&r ";

        if(args.length > 0){
            if(args[0].equalsIgnoreCase("coin") ||args[0].equalsIgnoreCase("c")){

                if(args.length == 1){
                    CoinManager.GiveCoin(p, 1);
                    ChatColor.translateAlternateColorCodes('&', prefix + "Given a coin");
                    return true;

                }else if(isNumeric(args[1])){
                    int amount = Integer.parseInt(args[1]);
                    CoinManager.GiveCoin(p, amount);
                    ChatColor.translateAlternateColorCodes('&', prefix + "Given " +amount+ " coins");
                    return true;
                }
            }else if (args[0].equalsIgnoreCase("coin+") || args[0].equalsIgnoreCase("coinplus") || args[0].equalsIgnoreCase("cp")){
                if(args.length == 1){
                    CoinManager.GiveCoinPlus(p, 1);
                    ChatColor.translateAlternateColorCodes('&', prefix + "Given a coin plus");
                    return true;

                }else if(isNumeric(args[1])){
                    int amount = Integer.parseInt(args[1]);
                    CoinManager.GiveCoinPlus(p, amount);
                    ChatColor.translateAlternateColorCodes('&', prefix + "Given " +amount+ " coin plus");
                    return true;
                }
            }
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&l---------------------------------"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&c&lPlease use the correct format:"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "    &c/coin <coin, coin+> <amount>"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&l---------------------------------"));
        return true;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
