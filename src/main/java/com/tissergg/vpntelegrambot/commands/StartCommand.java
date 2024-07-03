package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import com.tissergg.vpntelegrambot.keyboards.ReplyKeyBoardMaker;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    private final TelegramUserService telegramUserService;
    private final BotMessageConfig botMessageConfig;

    public StartCommand(TelegramUserService telegramUserService, BotMessageConfig botMessageConfig) {
        this.telegramUserService = telegramUserService;
        this.botMessageConfig = botMessageConfig;
    }

    @Override
    public void execute(Update update, SilentSender silentSender) {
        var chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        message.setText(botMessageConfig.getStart());
        message.setReplyMarkup(ReplyKeyBoardMaker.getMainMenuKeyBoard());
        telegramUserService.activate(chatId);
        silentSender.execute(message);
    }
}
