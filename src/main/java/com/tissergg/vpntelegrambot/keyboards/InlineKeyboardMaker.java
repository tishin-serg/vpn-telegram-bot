package com.tissergg.vpntelegrambot.keyboards;

import com.tissergg.vpntelegrambot.constants.FullAccessInlineMenuButton;
import com.tissergg.vpntelegrambot.constants.TrialAccessInlineMenuButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class InlineKeyboardMaker {

    //todo сделать универсальным. передавать в параметр лист кнопок в вызывающем коде
    public static InlineKeyboardMarkup getFullPeriodButton() {
        // Создание списка кнопок
        List<List<InlineKeyboardButton>> buttonRows = Stream.of(FullAccessInlineMenuButton.values())
                .map(button -> {
                    InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                    inlineKeyboardButton.setText(button.getButtonName());
                    inlineKeyboardButton.setCallbackData(button.getCallback());
                    // Оборачиваем каждую кнопку в отдельный список для создания ряда
                    return Collections.singletonList(inlineKeyboardButton);
                }).toList();

        // Строим InlineKeyboardMarkup, передавая список списков кнопок
        return InlineKeyboardMarkup.builder().keyboard(buttonRows).build();
    }

    public static InlineKeyboardMarkup getTrialPeriodButton() {
        // Создание списка кнопок
        List<List<InlineKeyboardButton>> buttonRows = Stream.of(TrialAccessInlineMenuButton.values())
                .map(button -> {
                    InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                    inlineKeyboardButton.setText(button.getButtonName());
                    inlineKeyboardButton.setCallbackData(button.getCallback());
                    // Оборачиваем каждую кнопку в отдельный список для создания ряда
                    return Collections.singletonList(inlineKeyboardButton);
                }).toList();

        // Строим InlineKeyboardMarkup, передавая список списков кнопок
        return InlineKeyboardMarkup.builder().keyboard(buttonRows).build();

    }
}
