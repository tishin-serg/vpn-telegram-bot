package com.tissergg.vpntelegrambot.commands;

import com.tissergg.vpntelegrambot.constants.CommandName;
import com.tissergg.vpntelegrambot.service.TelegramUserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommandContainer {
    private Map<String, Command> commandMap;
    private final TelegramUserService telegramUserService;
    private UnknownCommand unknownCommand;

//    @PostConstruct
//    public void init() {
//        commandMap = new HashMap<>();
//        //start
//        commandMap.put(CommandName.START.getCommand(), new StartCommand(telegramUserService, botMessageConfig));
//        //stop
//        commandMap.put(CommandName.STOP.getCommand(), new StopCommand(telegramUserService, botMessageConfig));
//        //help
//        commandMap.put(CommandName.HELP.getCommand(), new HelpCommand(botMessageConfig));
//        //Пробный период
//        commandMap.put(MainMenuButton.TRIAL_ACCESS.getButtonName(), new TrialAccessCommand(telegramUserService, botMessageConfig));
//        //Полный доступ
//        commandMap.put(MainMenuButton.FULL_ACCESS.getButtonName(), new FullAccessCommand(telegramUserService, botMessageConfig));
//        //Покупка 1 месяц
//        commandMap.put(FullAccessInlineMenuButton.BUY_ONE_MONTH.getCallback(), new FullAccessCommand(telegramUserService, botMessageConfig));
//        unknownCommand = new UnknownCommand(botMessageConfig);
//    }

    @PostConstruct
    public void init() {
        commandMap = new HashMap<>();
        //COMMANDS
        //start
        commandMap.put(CommandName.START.getCommand(), new StartCommand(telegramUserService));
        //stop
        commandMap.put(CommandName.STOP.getCommand(), new StopCommand(telegramUserService));
        //help
        commandMap.put(CommandName.HELP.getCommand(), new HelpCommand());

        //REPLY BOARD Распознаем по имени кнопок
        //Пробный период
        //todo
        commandMap.put("botReplyButtonConfig.getTrialAccess()", new TrialAccessCommand(telegramUserService));
        //Полный доступ
        commandMap.put("botReplyButtonConfig.getFullAccess()", new FullAccessCommand(telegramUserService));

        //INLINE BOARD Распознаем по коллбекам
        //Покупка 1 месяц
        commandMap.put("botCallbackConfig.getBuyOneMonth()", new FullAccessCommand(telegramUserService));
        unknownCommand = new UnknownCommand();
    }

    public Command retrieveCommand(String commandName) {
        // проверяем, если команда начинается со / то обрезаем его, чтобы корректно вызвать команду из мапы
        if (commandName.contains("/")) commandName = commandName.substring(1);
        return commandMap.getOrDefault(commandName, unknownCommand);
    }

}
