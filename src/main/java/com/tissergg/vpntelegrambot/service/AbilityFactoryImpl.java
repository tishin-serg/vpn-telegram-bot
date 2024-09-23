package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.constants.CommandName;
import com.tissergg.vpntelegrambot.handlers.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class AbilityFactoryImpl implements AbilityFactory {

    private final CommandHandler commandHandler;

    @Override
    public Ability startBot() {
        return Ability
                .builder()
                .name(CommandName.START.getCommand())
                .info(CommandName.START.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> commandHandler.handleCommand(ctx.update(), ctx.bot().silent()))
                .build();
    }

    @Override
    public Ability stopBot() {
        return Ability
                .builder()
                .name(CommandName.STOP.getCommand())
                .info(CommandName.STOP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> commandHandler.handleCommand(ctx.update(), ctx.bot().silent()))
                .build();
    }

    @Override
    public Ability helpBot() {
        return Ability
                .builder()
                .name(CommandName.HELP.getCommand())
                .info(CommandName.HELP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> commandHandler.handleCommand(ctx.update(), ctx.bot().silent()))
                .build();
    }

    @Override
    public Ability buttonCommand() {
        // Создание предикатов для проверки наличия callback-запроса и текстового сообщения
        Predicate<Update> isCallbackQuery = Update::hasCallbackQuery;
        Predicate<Update> isTextMessage = update -> update.hasMessage() && update.getMessage().hasText();

        // Объединение предикатов с использованием логического оператора ИЛИ
        Predicate<Update> combinedPredicate = isCallbackQuery.or(isTextMessage);

        return Ability.builder()
                .name("default")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .flag(combinedPredicate) //
                .action(ctx -> commandHandler.handleCommand(ctx.update(), ctx.bot().silent())) // Действие при активации
                .build();
    }
}
