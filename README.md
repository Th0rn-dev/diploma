[Project TopJava-2](https://javaops.ru/view/topjava2)
===============================

#### Technical task [graduate project TopJava](https://github.com/JavaOPs/topjava/blob/master/graduation.md)
- Source code taken from TopJava to Spring Boot migration (no meals)
- Graduation project ["Voting for restaurants"](https://github.com/Th0rn-dev/diploma)
- implementer: Anokhin Nikolay

-------------------------------------------------------------
- Stack: [JDK 17](http://jdk.java.net/17/), Spring Boot 2.5, Lombok, H2, Caffeine Cache, Swagger/OpenAPI 3.0
- Run: `mvn spring-boot:run` in root directory.
-----------------------------------------------------
[REST API documentation](http://localhost:8080/swagger-ui.html)  
Credentials:
```
User:  user@yandex.ru / password
Admin: admin@gmail.com / admin
```


##### Additional tools and utilities
1. Additional tools and utilities: https://github.com/antonmedv/fx
```
    Install:
    snap install fx (Ubuntu)

    Usage:
    curl ... | fx
```

#### List of requests via curl, view fx

##### Users with roles
* curl -s http://localhost:8080/api/profile --user user@yandex.ru:password | fx
* curl -s http://localhost:8080/api/admin/users --user admin@gmail.com:admin | fx

##### Restaurants
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

##### Dishes (administrations with role - ADMIN)
* curl -s http://localhost:8080/api/admin/dishes --user admin@gmail.com:admin | fx
* curl -s http://localhost:8080/api/admin/dishes/1 --user admin@gmail.com:admin | fx
* curl -i \
  -H "Accept: application/json" \
  -H "Content-Type:application/json" \
  -X PUT --data '{"menu": {"id": 1}, "name": "Суп-пюре", "price": 150}' \
  -s http://localhost:8080/api/admin/dishes/1 --user admin@gmail.com:admin
* curl -X DELETE -s http://localhost:8080/api/admin/dishes/1 --user admin@gmail.com:admin

##### Menus for voting (view all, administrations with role - ADMIN)
* curl -s http://localhost:8080/api/menus | fx
* curl -s http://localhost:8080/api/menus/3 --user admin@gmail.com:admin | fx
* curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data '{"restaurant": {"id": 1}, "dishes": [{"name": "Суп", "price": 100}, {"name": "Салат", "price": 70}]}' \
-s  http://localhost:8080/api/menus --user admin@gmail.com:admin

* curl -x DELETE -s http://localhost:8080/api/menus/1 --user admin@gmail.com:admin

##### Voting (only authorized user can vote)
* curl -X PUT -s http://localhost:8080/api/votes/restaurants/1/vote --user user@yandex.ru:password | fx

##### Voting results
* curl -s http://localhost:8080/api/results | fx