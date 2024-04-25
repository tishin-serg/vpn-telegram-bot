package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    // List<TelegramUser> getAllActiveUsers();
    Optional<TelegramUser> findByChatId(Long chatId);
}
