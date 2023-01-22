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

INSERT INTO DISH (display_date, name, price, menu_id)
VALUES ('2023-01-01', 'Суп', 200, 1),
       ('2023-01-01', 'Котлеты', 150, 1),
       ('2023-01-01', 'Макароны', 70, 1),
       ('2023-01-01', 'Оливье', 120, 1),
       ('2023-01-01', 'Харчо', 250, 2),
       ('2023-01-01', 'Картошка', 100, 2),
       ('2023-01-01', 'Винегрет', 110, 2),
       ('2023-01-01', 'Рагу', 300, 2),
       ('2023-01-01', 'Суп', 200, 3),
       (now(), 'Котлеты', 150, 3),
       (now(), 'Макароны', 70, 3),
       (now(), 'Оливье', 120, 3),
       (now(), 'Харчо', 250, 4),
       (now(), 'Картошка', 100, 4),
       (now(), 'Винегрет', 110, 4),
       (now(), 'Рагу', 300, 4);

INSERT INTO VOTE (voting_day, restaurant_id, user_id)
VALUES (now(), 1, 2);

