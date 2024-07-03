package com.tissergg.vpntelegrambot.constants;

import lombok.Getter;

@Getter
public enum CommandName {
    START("start", "Нажмите чтобы начать работу"),
    STOP("stop", "Нажмите, чтобы остановить"),
    HELP("help", "Нажмите для отображения доступных команд");

    private final String command;
    private final String description;

    CommandName(String command, String description) {
        this.command = command;
        this.description = description;
    }

    @Override
    public String toString() {
        return command;
    }
}
