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

    @Override
    public void activate(Long chatId) {
        findByChatId(chatId).ifPresentOrElse(
                telegramUser -> {
                    if (!telegramUser.getIsActive()) {
                        telegramUser.setIsActive(true);
                        save(telegramUser);
                    }
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setChatId(chatId);
                    telegramUser.setIsActive(true);
                    telegramUser.setHasUsedTrial(false);
                    save(telegramUser);
                }
        );
    }

    @Override
    public void deactivate(Long chatId) {
        findByChatId(chatId).ifPresent(
                telegramUser -> {
                    if (telegramUser.getIsActive()) {
                        telegramUser.setIsActive(false);
                        save(telegramUser);
                    }
                }
        );
    }
}
