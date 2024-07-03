package com.tissergg.vpntelegrambot.keyboards;

import com.tissergg.vpntelegrambot.constants.MainMenuButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


public class ReplyKeyBoardMaker {

    public static ReplyKeyboardMarkup getMainMenuKeyBoard() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow currentRow = new KeyboardRow();

        List<String> buttonNames = MainMenuButton.getButtonNames();

        // Итерация по списку названий кнопок
        for (int i = 0; i < buttonNames.size(); i++) {
            // Добавление кнопки в текущий ряд
            currentRow.add(new KeyboardButton(buttonNames.get(i)));

            // Если в ряду уже 2 кнопки или это последний элемент списка
            if ((i + 1) % 2 == 0 || i + 1 == buttonNames.size()) {
                // Добавление ряда в клавиатуру и начало нового ряда
                keyboard.add(currentRow);
                currentRow = new KeyboardRow();  // Создаем новый ряд
            }
        }

        return ReplyKeyboardMarkup.builder()
                .keyboard(keyboard)
                .resizeKeyboard(true)
                .oneTimeKeyboard(false)
                .selective(true)
                .build();
    }
}
