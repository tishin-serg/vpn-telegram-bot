package com.tissergg.vpntelegrambot.constants;

public enum Command {
    START("start", "Нажмите чтобы начать работу"),
    STOP("stop", "Нажмите, чтобы остановить"),
    HELP("help", "Нажмите для отображения доступных команд");

    private final String command;
    private final String description;

    Command(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return command;
    }
}
