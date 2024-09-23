package com.tissergg.vpntelegrambot.commands;

import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {

    @Override
    public void execute(Update update, SilentSender silentSender) {
        SendMessage message = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        //todo
        message.setText("");
        silentSender.execute(message);
    }
}
