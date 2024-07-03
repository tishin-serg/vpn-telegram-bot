package com.tissergg.vpntelegrambot.service;


import org.telegram.abilitybots.api.objects.Ability;

public interface AbilityFactory {
    Ability startBot();
    Ability stopBot();
    Ability helpBot();
    Ability textCommand();
}
