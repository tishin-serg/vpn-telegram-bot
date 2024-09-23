package com.tissergg.vpntelegrambot.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class UnknownCommand implements Command {

    @Override
    public void execute(Update update, SilentSender silentSender) {
        Long chatId;
        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            chatId = update.getMessage().getChatId();
        }
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        //todo
        message.setText("");
        silentSender.execute(message);
    }
}
