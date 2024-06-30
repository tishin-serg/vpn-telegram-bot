package com.tissergg.vpntelegrambot.bot;

import com.tissergg.vpntelegrambot.service.AbilityFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

@Component
public class VpnTelegramBot extends AbilityBot {

    private final AbilityFactory abilityFactory;

    public VpnTelegramBot(Environment env,
                          AbilityFactory abilityFactory) {
        super(env.getProperty("bot.token"), env.getProperty("bot.username"));
        this.abilityFactory = abilityFactory;
    }

    @Override
    public long creatorId() {
        return 1L;
    }

    public Ability startCommand() {
        return abilityFactory.startBot(silent);
    }

    public Ability stopCommand() {
        return abilityFactory.stopBot(silent);
    }

    public Ability helpCommand() {
        return abilityFactory.helpBot(silent);
    }

}
