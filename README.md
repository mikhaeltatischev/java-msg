# java-msg
Проект социальной сети

## Проект создан с использованием  

![Spring](https://img.shields.io/badge/spring-boot%236DB33F.svg?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring](https://img.shields.io/badge/spring%20security-%236DB33F.svg?style=for-the-badge&logo=security&logoColor=white)
![React](https://img.shields.io/badge/react-black?logo=react&style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## Функционал
 - Регистрация
 - Авторизация
 - Добавлен модуль "client" - содержит пользовательский интерфейс, написанный на ReactJs 

## Микросервисы 
1. Gateway - входная точка, принимает запросы от пользователя и распределяет между другими сервисами.
2. Security - отвечает за регистрацию и авторизацию пользователей.

## Запуск приложения  
- Выполнить команду ```mvn clean install```
- Далее команда ```docker-compose up```
- Используемая версия языка Java - 17
