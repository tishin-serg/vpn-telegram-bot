package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.constants.Command;
import com.tissergg.vpntelegrambot.handlers.ResponseHandler;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;

@Component
public class AbilityFactory {

    public Ability startBot(ResponseHandler responseHandler) {
        return Ability
                .builder()
                .name(Command.START.getCommand())
                .info(Command.START.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
                .build();
    }

    public Ability stopBot(ResponseHandler responseHandler) {
        return Ability
                .builder()
                .name(Command.STOP.getCommand())
                .info(Command.STOP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToStop(ctx.chatId()))
                .build();
    }

    public Ability helpBot(ResponseHandler responseHandler) {
        return Ability
                .builder()
                .name(Command.HELP.getCommand())
                .info(Command.HELP.getDescription())
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> responseHandler.replyToHelp(ctx.chatId()))
                .build();
    }
}
