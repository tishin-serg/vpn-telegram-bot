package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.keyboards.ReplyKeyBoardMaker;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class StartCommand implements Command {
    private final TelegramUserService telegramUserService;

    @Override
    public void execute(Update update, SilentSender silentSender) {
        var chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableMarkdown(true);
        //todo
        message.setText("");
        message.setReplyMarkup(ReplyKeyBoardMaker.getMainMenuKeyBoard());
        telegramUserService.activate(chatId);
        silentSender.execute(message);
    }
}
