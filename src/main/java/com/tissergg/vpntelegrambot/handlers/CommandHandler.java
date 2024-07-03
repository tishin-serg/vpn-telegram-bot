package com.tissergg.vpntelegrambot.handlers;

import com.tissergg.vpntelegrambot.commands.CommandContainer;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class CommandHandler {
    private final CommandContainer commandContainer;

    public CommandHandler(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

    public void handleCommand(Update update, SilentSender sender) {
        commandContainer.retrieveCommand(update.getMessage().getText()).execute(update, sender);
    }

}
