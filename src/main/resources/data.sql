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

INSERT INTO MENU (created, restaurant_id)
VALUES ('2023-01-01', 1),
       ('2023-01-01', 2),
       (now(), 1),
       (now(), 2);

INSERT INTO DISH (name, price, menu_id)
VALUES ('Суп', 200, 1),
       ('Котлеты', 150, 1),
       ('Макароны', 70, 1),
       ('Оливье', 120, 1),
       ('Харчо', 250, 2),
       ('Картошка', 100, 2),
       ('Винегрет', 110, 2),
       ('Рагу', 300, 2),
       ('Суп', 200, 3),
       ('Котлеты', 150, 3),
       ('Макароны', 70, 3),
       ('Оливье', 120, 3),
       ('Харчо', 250, 4),
       ('Картошка', 100, 4),
       ('Винегрет', 110, 4),
       ('Рагу', 300, 4);

