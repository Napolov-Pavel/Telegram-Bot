package com.github.javarushcommunity.jrtb.command;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtb.command.CommandName.START;
import static com.github.javarushcommunity.jrtb.command.StartCommand.START_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}