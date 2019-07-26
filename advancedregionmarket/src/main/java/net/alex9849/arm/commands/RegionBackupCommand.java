package net.alex9849.arm.commands;

import net.alex9849.arm.Permission;
import net.alex9849.arm.handler.CommandHandler;
import net.alex9849.exceptions.CmdSyntaxException;
import net.alex9849.exceptions.InputException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO Finalize
public class RegionBackupCommand extends BasicArmCommand {
    private final String rootCommand = "regionbackup";
    private final String regex = "(?i)regionbackup [^;\n]+";
    private final List<String> usage = new ArrayList<>(Arrays.asList("regionbackup [SETTING]", "subregion help"));
    private CommandHandler commandHandler;

    public RegionBackupCommand() {
        this.commandHandler = new CommandHandler(this.usage, this.rootCommand);
        String[] betweencmds = {this.rootCommand};
        List<BasicArmCommand> commands = new ArrayList<>();
        this.commandHandler.addCommands(commands);
    }

    @Override
    public boolean matchesRegex(String command) {
        return command.matches(this.regex);
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
    public boolean runCommand(CommandSender sender, Command cmd, String commandsLabel, String[] args, String allargs) throws InputException, CmdSyntaxException {

        String newallargs = "";
        String[] newargs = new String[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            newargs[i - 1] = args[i];
            if(i == 1) {
                newallargs = args[i];
            } else {
                newallargs = newallargs + " " + args[i];
            }
        }

        return  this.commandHandler.executeCommand(sender, cmd , commandsLabel, newargs);
    }

    @Override
    public List<String> onTabComplete(Player player, String[] args) {
        List<String> returnme = new ArrayList<>();
        if(args.length >= 1) {
            if(this.rootCommand.startsWith(args[0])) {
                if(Permission.hasAnyRegionBackupPermission(player)) {
                    if(args.length == 1) {
                        if(this.rootCommand.startsWith(args[0])) {
                            returnme.add(this.rootCommand);
                        }
                    }
                    if(args.length > 1) {
                        String[] newargs = new String[args.length - 1];
                        for(int i = 0; i < newargs.length; i++) {
                            newargs[i] = args[i + 1];
                        }
                        returnme.addAll(this.commandHandler.onTabComplete(player, newargs));
                    }
                }
            }
        }
        return returnme;
    }
}
