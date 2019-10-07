package net.alex9849.arm.presets.commands;

import net.alex9849.arm.Messages;
import net.alex9849.arm.Permission;
import net.alex9849.arm.commands.BasicArmCommand;
import net.alex9849.arm.exceptions.InputException;
import net.alex9849.arm.presets.ActivePresetManager;
import net.alex9849.arm.presets.PresetPlayerPair;
import net.alex9849.arm.presets.presets.*;
import net.alex9849.arm.regions.price.Autoprice.AutoPrice;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetAutoPriceCommand implements BasicArmCommand {

    private final String rootCommand = "autoprice";
    private final String regex_set = "(?i)autoprice [^;\n ]+";
    private final String regex_remove = "(?i)autoprice (?i)remove";
    private final List<String> usage = new ArrayList<>(Arrays.asList("autoprice ([AUTOPRICE]/remove)"));
    private PresetType presetType;

    public SetAutoPriceCommand(PresetType presetType) {
        this.presetType = presetType;
    }

    @Override
    public boolean matchesRegex(String command) {
        if (command.matches(this.regex_set)) {
            return true;
        } else {
            return command.matches(this.regex_remove);
        }
    }

    @Override
    public String getRootCommand() {
        return this.rootCommand;
    }

    @Override
    public List<String> getUsage() {
        return this.usage;
    }

    @Override
    public boolean runCommand(CommandSender sender, Command cmd, String commandsLabel, String[] args, String allargs) throws InputException {
        if (!(sender instanceof Player)) {
            throw new InputException(sender, Messages.COMMAND_ONLY_INGAME);
        }
        Player player = (Player) sender;

        if (!player.hasPermission(Permission.ADMIN_PRESET_SET_AUTOPRICE)) {
            throw new InputException(player, Messages.NO_PERMISSION);
        }
        if (presetType == null) {
            return false;
        }

        Preset preset = ActivePresetManager.getPreset(player, presetType);

        if (preset == null) {
            preset = this.presetType.create();
            ActivePresetManager.add(new PresetPlayerPair(player, preset));
        }

        if (allargs.matches(this.regex_remove)) {
            preset.removeAutoPrice();
            player.sendMessage(Messages.PREFIX + Messages.PRESET_REMOVED);
            return true;
        } else {
            AutoPrice autoPrice = AutoPrice.getAutoprice(args[1]);
            if (autoPrice == null) {
                throw new InputException(sender, ChatColor.RED + "AutoPrice does not exist!");
            }
            preset.setAutoPrice(autoPrice);
            player.sendMessage(Messages.PREFIX + Messages.PRESET_SET);
            if (priceLineCanBeLetEmpty(preset)) {
                player.sendMessage(Messages.PREFIX + "You can leave the price-line on signs empty now");
            }
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(Player player, String[] args) {
        List<String> returnme = new ArrayList<>();
        if (player.hasPermission(Permission.ADMIN_PRESET_SET_AUTOPRICE)) {
            if (args.length >= 1) {
                if (args.length == 1) {
                    if (this.rootCommand.startsWith(args[0])) {
                        returnme.add(this.rootCommand);
                    }
                }
                if (args.length == 2 && this.rootCommand.equalsIgnoreCase(args[0])) {
                    if ("remove".startsWith(args[1])) {
                        returnme.add("remove");
                    }
                    returnme.addAll(AutoPrice.tabCompleteAutoPrice(args[1]));
                }
            }
        }
        return returnme;
    }

    private boolean priceLineCanBeLetEmpty(Preset preset) {
        if (preset instanceof SellPreset) {
            return (preset.hasPrice() || preset.hasAutoPrice());
        } else if (preset instanceof ContractPreset) {
            ContractPreset contractPreset = (ContractPreset) preset;
            return (contractPreset.hasPrice() && contractPreset.hasExtend()) || preset.hasAutoPrice();
        } else if (preset instanceof RentPreset) {
            RentPreset rentPreset = (RentPreset) preset;
            return (rentPreset.hasPrice() && rentPreset.hasExtendPerClick() && rentPreset.hasMaxRentTime()) || preset.hasAutoPrice();
        }
        return false;
    }
}
