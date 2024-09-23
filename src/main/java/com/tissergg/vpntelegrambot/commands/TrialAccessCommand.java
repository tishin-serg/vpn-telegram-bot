package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.keyboards.InlineKeyboardMaker;
import com.tissergg.vpntelegrambot.repository.entity.TelegramUser;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@RequiredArgsConstructor
public class TrialAccessCommand implements Command {
    private final TelegramUserService telegramUserService;

    @Override
    public void execute(Update update, SilentSender silentSender) {

        Optional<TelegramUser> telegramUser = telegramUserService.findByChatId(update.getMessage().getChatId());
        if (telegramUser.isPresent()) {
            SendMessage message = new SendMessage();
            message.enableMarkdown(true);
            message.setChatId(update.getMessage().getChatId());
            // если уже использовал пробный период
            if (telegramUser.get().getHasUsedTrial()) {
                message.setReplyMarkup(InlineKeyboardMaker.getFullPeriodButton());
                //todo
                message.setText("");
                // если еще не использовал пробный период
            } else {
                message.setReplyMarkup(InlineKeyboardMaker.getTrialPeriodButton());
                //todo
                message.setText("");
            }
            silentSender.execute(message);
        }

    }
}
