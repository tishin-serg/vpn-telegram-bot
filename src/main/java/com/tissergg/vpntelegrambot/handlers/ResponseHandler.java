package com.tissergg.vpntelegrambot.handlers;

import com.tissergg.vpntelegrambot.service.TelegramUserService;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


public class ResponseHandler {
    private SilentSender sender;
    private final TelegramUserService telegramUserService;

    public ResponseHandler(TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
    }

    public void replyToStart(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("HELLO"); //todo сделать константы
        telegramUserService.activate(chatId);
        sender.execute(message);
    }

    public void replyToStop(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("BYE"); //todo сделать константы
        telegramUserService.deactivate(chatId);
        sender.execute(message);
    }

    public void replyToHelp(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("HELP"); //todo сделать константы
        sender.execute(message);
    }

    public void setSender(SilentSender sender) {
        this.sender = sender;
    }
}
