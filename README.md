# TarrifsAndBalance
Разработать приложение для хранение тарифов и балансов пользователей в SQL БД с одним HTTP GET методом - получение
данных о пользователях (их тариф, баланс), т.е. выгрузка данных из БД.

Не использовать Spring Boot, схема БД с тестовыми данными в виде SQL скрипта. API должно уметь как JSON, так и XML.

II
Разработать второе приложение для кеширования балансов пользователей, полученных из приложения #1. Приложение должно
раз в N секунд опрашивать приложение #1, конвертировать XML результат в пару client_id/balance с помощью XSLT,
сохранять значение в кеш. Так же, раз в M секунд, приложение должно публиковать состояние кеша для пользователей,
баланс которых составляет < K - в AMQP брокер.