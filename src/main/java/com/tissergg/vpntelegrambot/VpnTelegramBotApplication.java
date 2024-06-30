package com.tissergg.vpntelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class VpnTelegramBotApplication {

	public static void main(String[] args) {
		// SpringApplication.run(VpnTelegramBotApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(VpnTelegramBotApplication.class, args);
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(ctx.getBean("vpnTelegramBot", AbilityBot.class));
		} catch (TelegramApiException e) {
			throw new RuntimeException(e);
		}
	}

}
