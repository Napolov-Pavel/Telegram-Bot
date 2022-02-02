package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;

import java.util.HashMap;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class CommandContainer {
    private final HashMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        commandMap = new HashMap<String, Command>();
        commandMap.put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService));
        commandMap.put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
        commandMap.put(NO.getCommandName(), new NoCommand(sendBotMessageService));
        commandMap.put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService));
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }
    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
