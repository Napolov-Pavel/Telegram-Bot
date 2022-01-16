package com.github.javarushcommunity.jrtb.command;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtb.command.CommandName.NO;
import static com.github.javarushcommunity.jrtb.command.NoCommand.NO_MASSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MASSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}