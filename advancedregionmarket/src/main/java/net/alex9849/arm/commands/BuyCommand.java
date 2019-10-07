package net.alex9849.arm.commands;

import net.alex9849.arm.AdvancedRegionMarket;
import net.alex9849.arm.Messages;
import net.alex9849.arm.Permission;
import net.alex9849.arm.exceptions.*;
import net.alex9849.arm.minifeatures.PlayerRegionRelationship;
import net.alex9849.arm.regions.Region;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyCommand implements BasicArmCommand {

    private final String rootCommand = "buy";
    private final String regex = "(?i)buy";
    private final String regex_with_args = "(?i)buy [^;\n ]+";
    private final List<String> usage = new ArrayList<>(Arrays.asList("buy [REGION]", "buy"));

    @Override
    public boolean matchesRegex(String command) {
        return command.matches(this.regex) || command.matches(this.regex_with_args);
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
        if (Permission.hasAnyBuyPermission(sender)) {
            if (!(sender instanceof Player)) {
                throw new InputException(sender, Messages.COMMAND_ONLY_INGAME);
            }

            Player player = (Player) sender;
            Region region;

            if (allargs.matches(this.regex_with_args)) {
                region = AdvancedRegionMarket.getInstance().getRegionManager().getRegionAtPositionOrNameCommand(player, args[1]);
            } else {
                region = AdvancedRegionMarket.getInstance().getRegionManager().getRegionAtPositionOrNameCommand(player, null);
            }

            if (!region.isSold()) {
                try {
                    region.buy(player);
                } catch (NoPermissionException | OutOfLimitExeption | NotEnoughMoneyException |
                        AlreadySoldException | MaxRentTimeExceededException e) {
                    if (e.hasMessage()) player.sendMessage(Messages.PREFIX + e.getMessage());
                }
            } else {
                throw new InputException(sender, Messages.REGION_ALREADY_SOLD);
            }


            return true;
        } else {
            throw new InputException(sender, Messages.NO_PERMISSION);
        }
    }

    @Override
    public List<String> onTabComplete(Player player, String[] args) {
        List<String> returnme = new ArrayList<>();

        if (args.length >= 1) {
            if (this.rootCommand.startsWith(args[0])) {
                if (Permission.hasAnyBuyPermission(player)) {
                    if (args.length == 1) {
                        returnme.add(this.rootCommand);
                    } else if (args.length == 2 && (args[0].equalsIgnoreCase(this.rootCommand))) {
                        returnme.addAll(AdvancedRegionMarket.getInstance().getRegionManager().completeTabRegions(player, args[1], PlayerRegionRelationship.AVAILABLE, true, true));
                    }
                }
            }
        }
        return returnme;
    }
}
