package com.tissergg.vpntelegrambot.constants;

public enum TrialAccessInlineMenuButton {
    CONFIRM("Начать пробный период", "start_trial");

    private final String buttonName;
    private final String callback;

    TrialAccessInlineMenuButton(String buttonName, String callback) {
        this.buttonName = buttonName;
        this.callback = callback;
    }

    public String getButtonName() {
        return buttonName;
    }

    public String getCallback() {
        return callback;
    }
}
