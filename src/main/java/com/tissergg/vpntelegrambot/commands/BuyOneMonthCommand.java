package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class BuyOneMonthCommand implements Command {

    private final TelegramUserService telegramUserService;

    @Override
    public void execute(Update update, SilentSender silentSender) {
        //выдаем ссылку на оплату
        System.out.println("ВЫДАЛИ ССЫЛКУ НА ОПЛАТУ");

    }
}
