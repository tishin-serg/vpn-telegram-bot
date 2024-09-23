package com.tissergg.vpntelegrambot.commands;

import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BuyFullAccessCommand implements Command {
    @Override
    public void execute(Update update, SilentSender silentSender) {
        update.getCallbackQuery().getData();
    }
}
