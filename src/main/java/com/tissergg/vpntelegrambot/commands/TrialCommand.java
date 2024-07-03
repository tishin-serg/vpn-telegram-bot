package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TrialCommand implements Command {
    private final TelegramUserService telegramUserService;
    private final BotMessageConfig botMessageConfig;

    public TrialCommand(TelegramUserService telegramUserService, BotMessageConfig botMessageConfig) {
        this.telegramUserService = telegramUserService;
        this.botMessageConfig = botMessageConfig;
    }

    @Override
    public void execute(Update update, SilentSender silentSender) {
        // проверка использовал ли клиент пробный период
    }
}
