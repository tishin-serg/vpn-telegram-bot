package com.tissergg.vpntelegrambot.commands;

import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update, SilentSender silentSender);
}
