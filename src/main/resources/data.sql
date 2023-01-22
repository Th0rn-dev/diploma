INSERT INTO USERS (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (name, address)
VALUES ('Tanuki', 'St New'),
       ('Sakhli', 'St Old');

INSERT INTO MENU (display_date,created, restaurant_id)
VALUES ('2023-01-01','2023-01-01', 1),
       ('2023-01-01','2023-01-01', 2),
       (now(),now(), 1),
       (now(),now(), 2);

INSERT INTO DISH (display_date, name, price, menu_id)
VALUES ('2023-01-01', 'Soup', 200, 1),
       ('2023-01-01', 'Cutlets', 150, 1),
       ('2023-01-01', 'Pasta', 70, 1),
       ('2023-01-01', 'Olivier salad', 120, 1),
       ('2023-01-01', 'Kharcho', 250, 2),
       ('2023-01-01', 'Potatoes', 100, 2),
       ('2023-01-01', 'Vinaigrette', 110, 2),
       ('2023-01-01', 'Stew', 300, 2),
       ('2023-01-01', 'Soup', 200, 3),
       (now(), 'Cutlets', 150, 3),
       (now(), 'Pasta', 70, 3),
       (now(), 'Olivier salad', 120, 3),
       (now(), 'Kharcho', 250, 4),
       (now(), 'Potatoes', 100, 4),
       (now(), 'Vinaigrette', 110, 4),
       (now(), 'Stew', 300, 4);

INSERT INTO VOTE (voting_day, restaurant_id, user_id)
VALUES (now(), 1, 2);

