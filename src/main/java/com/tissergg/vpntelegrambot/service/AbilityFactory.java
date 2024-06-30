package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.constants.Command;
import com.tissergg.vpntelegrambot.handlers.ResponseHandler;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.sender.SilentSender;

@Component
public class AbilityFactory {

    private final ResponseHandler responseHandler;

    public AbilityFactory(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    public Ability startBot(SilentSender sender) {
        return Ability
                .builder()
                .name(Command.START.getCommand())
                .info(Command.START.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToStart(ctx.chatId(), sender))
                .build();
    }

    public Ability stopBot(SilentSender sender) {
        return Ability
                .builder()
                .name(Command.STOP.getCommand())
                .info(Command.STOP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToStop(ctx.chatId(), sender))
                .build();
    }

    public Ability helpBot(SilentSender sender) {
        return Ability
                .builder()
                .name(Command.HELP.getCommand())
                .info(Command.HELP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToHelp(ctx.chatId(), sender))
                .build();
    }
}
