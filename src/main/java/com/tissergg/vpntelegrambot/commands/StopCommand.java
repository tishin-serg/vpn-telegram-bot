package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StopCommand implements Command {
    private final TelegramUserService telegramUserService;
    private final BotMessageConfig botMessageConfig;

    public StopCommand(TelegramUserService telegramUserService, BotMessageConfig botMessageConfig) {
        this.telegramUserService = telegramUserService;
        this.botMessageConfig = botMessageConfig;
    }

    @Override
    public void execute(Update update, SilentSender silentSender) {
        SendMessage message = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        message.setText(botMessageConfig.getStop());
        telegramUserService.deactivate(chatId);
        silentSender.execute(message);
    }
}
