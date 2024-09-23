package com.tissergg.vpntelegrambot.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum MainMenuButton {

    TRIAL_ACCESS("Пробный период"),
    FULL_ACCESS("Полный доступ"),
    HELP("Помощь"),
    //REFERRAL("Привести друга")
    ;

    private final String buttonName;

    // Метод для получения списка названий кнопок
    public static List<String> getButtonNames() {
        return Arrays.stream(MainMenuButton.values())
                .map(MainMenuButton::getButtonName)
                .collect(Collectors.toList());
    }
}
