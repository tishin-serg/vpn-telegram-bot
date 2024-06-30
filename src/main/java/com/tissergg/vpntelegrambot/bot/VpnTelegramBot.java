package com.tissergg.vpntelegrambot.bot;

import com.tissergg.vpntelegrambot.service.AbilityFactory;
import com.tissergg.vpntelegrambot.handlers.ResponseHandler;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.sender.SilentSender;

@Component
public class VpnTelegramBot extends AbilityBot {

    private final TelegramUserService telegramUserService;
    private final ResponseHandler responseHandler;
    private final SilentSender sender;
    private final AbilityFactory abilityFactory;


    public VpnTelegramBot(Environment env,
                          TelegramUserService telegramUserService,
                          AbilityFactory abilityFactory) {
        super(env.getProperty("bot.token"), env.getProperty("bot.username"));
        this.sender = super.silent();
        this.responseHandler = new ResponseHandler(telegramUserService);
        this.responseHandler.setSender(sender);
        this.telegramUserService = telegramUserService;
        this.abilityFactory = abilityFactory;
    }

    @Override
    public long creatorId() {
        return 1L;
    }

    public Ability startCommand() {
        return abilityFactory.startBot(responseHandler);
    }

    public Ability stopCommand() {
        return abilityFactory.stopBot(responseHandler);
    }

    public Ability helpCommand() {
        return abilityFactory.helpBot(responseHandler);
    }

}
