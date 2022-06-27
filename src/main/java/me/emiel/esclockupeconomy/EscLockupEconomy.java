package me.emiel.esclockupeconomy;

import org.bukkit.plugin.java.JavaPlugin;

public final class EscLockupEconomy extends JavaPlugin {

    private static EscLockupEconomy instance;


    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("coin").setExecutor(new CoinCommand());
        this.getCommand("coinamount").setExecutor(new BalanceCommand());
        this.getCommand("removecoins").setExecutor(new RemoveCoinsCommand());
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static EscLockupEconomy getInstance() {
        return instance;
    }
}
