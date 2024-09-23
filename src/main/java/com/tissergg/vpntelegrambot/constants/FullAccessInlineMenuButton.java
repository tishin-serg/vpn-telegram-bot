package com.tissergg.vpntelegrambot.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FullAccessInlineMenuButton {
    BUY_ONE_MONTH("1 месяц за 149 руб.", "buy_one_month"),
    BUY_THREE_MONTH("3 месяца за 349 руб.", "buy_three_month"),
    BUY_SIX_MONTH("6 месяцев за 590 руб.", "buy_six_month");

    private final String buttonName;
    private final String callback;

}
