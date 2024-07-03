package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {

    private final BotMessageConfig botMessageConfig;

    public HelpCommand(BotMessageConfig botMessageConfig) {
        this.botMessageConfig = botMessageConfig;
    }


    @Override
    public void execute(Update update, SilentSender silentSender) {
        SendMessage message = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        message.setText(botMessageConfig.getHelp());
        silentSender.execute(message);
    }
}
