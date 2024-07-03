package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.configs.BotMessageConfig;
import com.tissergg.vpntelegrambot.constants.CommandName;
import com.tissergg.vpntelegrambot.constants.MainMenuButton;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandContainer {
    private Map<String, Command> commandMap;
    private final TelegramUserService telegramUserService;
    private final BotMessageConfig botMessageConfig;
    private UnknownCommand unknownCommand;

    public CommandContainer(TelegramUserService telegramUserService, BotMessageConfig botMessageConfig) {
        this.telegramUserService = telegramUserService;
        this.botMessageConfig = botMessageConfig;
    }

    @PostConstruct
    public void init() {
        commandMap = new HashMap<>();
        commandMap.put(CommandName.START.getCommand(), new StartCommand(telegramUserService, botMessageConfig));
        commandMap.put(CommandName.STOP.getCommand(), new StopCommand(telegramUserService, botMessageConfig));
        commandMap.put(CommandName.HELP.getCommand(), new HelpCommand(botMessageConfig));
        commandMap.put(MainMenuButton.TRIAL.getButtonName(), new TrialCommand(telegramUserService, botMessageConfig));
        unknownCommand = new UnknownCommand(botMessageConfig);
    }

    public Command retrieveCommand(String commandName) {
        if (commandName.contains("/")) commandName = commandName.substring(1);
        return commandMap.getOrDefault(commandName, unknownCommand);
    }

}
