package com.tissergg.vpntelegrambot.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class TelegramUser {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "chat_id")
    private long chatId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "has_used_trial")
    private boolean hasUsedTrial;
}
