FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_javarush_the_best_bot
ENV BOT_TOKEN=5038055127:AAEDZ_xsPCq6wGtv_izW4v81dK0YKB5TJ1U
ENV BOT_DB_USERNAME=jrtb_db_user
ENV BOT_DB_PASSWORD=jrtb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]