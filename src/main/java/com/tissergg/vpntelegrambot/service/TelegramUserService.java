package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.repository.entity.TelegramUser;

import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    // List<TelegramUser> getAllActiveUsers();
    Optional<TelegramUser> findByChatId(Long chatId);
    void activate(Long chatId);
    void deactivate(Long chatId);
}
