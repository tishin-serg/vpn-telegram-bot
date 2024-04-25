# Выбираем базовый образ с Java 17
FROM adoptopenjdk/openjdk17:ubi

# Определяем переменную для файла JAR
ARG JAR_FILE=target/*.jar

ENV BOT_NAME=test_vpn_tg_bot
ENV BOT_TOKEN=7098991817:AAEK5Sh8wqSqZCiUwQhir4X2tWAViAeHXrw
ENV BOT_DB_USERNAME=admin
ENV BOT_DB_PASSWORD=admin12345678

# Копируем файл JAR в образ под именем app.jar
COPY ${JAR_FILE} app.jar

# Указываем точку входа для запуска приложения
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-jar","/app.jar"]


