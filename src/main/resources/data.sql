INSERT INTO USERS (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (name, address)
VALUES ('Тануки', 'ул. Новая'),
       ('Сахли', 'ул. Старая');

INSERT INTO DISH (name, price)
VALUES ('Суп', 200),
       ('Харчо', 250),
       ('Котлеты', 150),
       ('Макароны', 70),
       ('Оливье', 120),
       ('Картошка', 100),
       ('Винегрет', 110),
       ('Рагу', 300),
       ('Шашлык', 400);

INSERT INTO DAY_MENU (created, restaurant_id, dish_id)
VALUES ('2023-01-01', 1, 1),
       ('2023-01-01', 2, 2),
       (now(), 1, 3),
       (now(), 2, 4);

