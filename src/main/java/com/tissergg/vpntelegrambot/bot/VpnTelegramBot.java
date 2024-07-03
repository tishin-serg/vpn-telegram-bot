package com.tissergg.vpntelegrambot.bot;

import com.tissergg.vpntelegrambot.service.AbilityFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

/**
 * VpnTelegramBot class that extends the AbilityBot to define bot commands using Abilities.
 * This bot handles /start, /stop, and /help commands.
 * Uses the SilentSender object 'silent' from AbilityBot for sending messages silently.
 */
@Component
public class VpnTelegramBot extends AbilityBot {

    private final AbilityFactory abilityFactory;

    /**
     * Constructor for VpnTelegramBot.
     *
     * @param env the environment containing bot token and username properties.
     * @param abilityFactory the factory to create abilities.
     */
    public VpnTelegramBot(Environment env,
                          AbilityFactory abilityFactory) {
        super(env.getProperty("bot.token"), env.getProperty("bot.username"));
        this.abilityFactory = abilityFactory;
    }

    /**
     * Returns the creator ID of the bot. This method is required by the AbilityBot framework.
     *
     * @return the creator ID.
     */
    @Override
    public long creatorId() {
        return 1L;
    }

    /**
     * Defines the /start command ability.
     *
     * @return the ability for the /start command.
     */
    public Ability startCommand() {
        return abilityFactory.startBot();
    }

    /**
     * Defines the /stop command ability.
     *
     * @return the ability for the /stop command.
     */
    public Ability stopCommand() {
        return abilityFactory.stopBot();
    }

    /**
     * Defines the /help command ability.
     *
     * @return the ability for the /help command.
     */
    public Ability helpCommand() {
        return abilityFactory.helpBot();
    }

    public Ability textButtonCommand() {
        return abilityFactory.textCommand();
    }
}
