package com.tissergg.vpntelegrambot.constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainMenuButton {

    TRIAL("Пробный период"),
    SUBSCRIPTION("Полный доступ"),
    HELP("Помощь"),
    //REFERRAL("Привести друга")
    ;

    private final String buttonName;

    MainMenuButton(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }

    // Метод для получения списка названий кнопок
    public static List<String> getButtonNames() {
        return Arrays.stream(MainMenuButton.values())
                .map(MainMenuButton::getButtonName)
                .collect(Collectors.toList());
    }
}
