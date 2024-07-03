package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {

    private final BotMessageConfig botMessageConfig;

    public UnknownCommand(BotMessageConfig botMessageConfig) {
        this.botMessageConfig = botMessageConfig;
    }

    @Override
    public void execute(Update update, SilentSender silentSender) {
        var chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        message.setText(botMessageConfig.getUnknown());
        silentSender.execute(message);
    }
}
