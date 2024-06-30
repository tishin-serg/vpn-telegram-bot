package com.tissergg.vpntelegrambot.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "telegram_user")
public class TelegramUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "has_used_trial")
    private Boolean hasUsedTrial;
}
