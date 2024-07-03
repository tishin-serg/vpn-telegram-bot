package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.constants.CommandName;
import com.tissergg.vpntelegrambot.handlers.CommandHandler;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;

@Component
public class AbilityFactoryImpl implements AbilityFactory {

    private final CommandHandler commandHandler;

    public AbilityFactoryImpl(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

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
    public Ability textCommand() {
        return Ability
                .builder()
                .name("default")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .flag(Flag.TEXT)
                .action(ctx -> commandHandler.handleCommand(ctx.update(), ctx.bot().silent()))
                .build();
    }
}
