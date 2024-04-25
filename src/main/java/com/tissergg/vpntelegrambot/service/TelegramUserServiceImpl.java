package com.tissergg.vpntelegrambot.service;

import com.tissergg.vpntelegrambot.repository.TelegramUserRepository;
import com.tissergg.vpntelegrambot.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    public TelegramUserServiceImpl(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public Optional<TelegramUser> findByChatId(Long chatId) {
        return telegramUserRepository.findByChatId(chatId);
    }
}
