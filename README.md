[Проект TopJava-2](https://javaops.ru/view/topjava2)
===============================

#### Техническое задание [выпускного проекта TopJava](https://github.com/JavaOPs/topjava/blob/master/graduation.md)
- Исходный код взят из миграции TopJava на Spring Boot (без еды)
- Выпускной проект ["Голосование за рестораны"](https://github.com/Th0rn-dev/diploma)
- Исполнитель: Анохин Н.В.

-------------------------------------------------------------
- Stack: [JDK 17](http://jdk.java.net/17/), Spring Boot 2.5, Lombok, H2, Caffeine Cache, Swagger/OpenAPI 3.0
- Run: `mvn spring-boot:run` in root directory.
-----------------------------------------------------
[REST API documentation](http://localhost:8080/swagger-ui.html)  
Креденшелы:
```
User:  user@yandex.ru / password
Admin: admin@gmail.com / admin
```


##### Дополнительные инструменты и утилиты
1. Утилита для просмотра json в терминале: https://github.com/antonmedv/fx
```
    Установка:
    snap install fx (Ubuntu)

    Использование:
    curl ... | fx
```

#### Список запросов через curl, просмотр fx

##### Пользователи с ролями
* curl -s http://localhost:8080/api/profile --user user@yandex.ru:password | fx
* curl -s http://localhost:8080/api/admin/users --user admin@gmail.com:admin | fx

##### Рестораны
* curl -s http://localhost:8080/api/admin/restaurants --user admin@gmail.com:admin | fx
* curl -s http://localhost:8080/api/admin/restaurants/1 --user admin@gmail.com:admin | fx
* curl -i \
  -H "Accept: application/json" \
  -H "Content-Type:application/json" \
  -X POST --data '{"name": "Новый ресторан", "address": "Новый адрес"}' \
  -s  http://localhost:8080/api/admin/restaurants --user admin@gmail.com:admin
* curl -i \
  -H "Accept: application/json" \
  -H "Content-Type:application/json" \
  -X PUT --data '{"name": "Новый ресторан", "address": "Замена адреса"}' \
  -s  http://localhost:8080/api/admin/restaurants/3 --user admin@gmail.com:admin

* curl -X DELETE -s http://localhost:8080/api/admin/restaurants/1

##### Блюда (администрирование с ролью - ADMIN)
* curl -i \
  -H "Accept: application/json" \
  -H "Content-Type:application/json" \
  -X PUT --data '{"menu": {"id": 1}, "name": "Суп-пюре", "price": 150}' \
  -s http://localhost:8080/api/admin/dishes/1 --user admin@gmail.com:admin
* curl -X DELETE -s http://localhost:8080/api/admin/dishes/1 --user admin@gmail.com:admin

##### Меню для голосования (видят все, в том числе и не авторизованные, администрирование с ролью - ADMIN)
* curl -s http://localhost:8080/api/menus | fx
* curl -s http://localhost:8080/api/menus/3 --user admin@gmail.com:admin | fx

* curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data '{"restaurant": {"id": 1}, "dishes": [{"name": "Суп", "price": 100}, {"name": "Салат", "price": 70}]}' \
-s  http://localhost:8080/api/menus --user admin@gmail.com:admin

* curl -x DELETE -s http://localhost:8080/api/menus/1 --user admin@gmail.com:admin

##### Голосование (голосует только авторизованный пользователь)
* curl -X PUT -s http://localhost:8080/api/votes/restaurants/1/vote --user user@yandex.ru:password | fx

##### Результаты голосования
* curl -s http://localhost:8080/api/results | fx