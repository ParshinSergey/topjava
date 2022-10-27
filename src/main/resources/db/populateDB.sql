DELETE
FROM user_roles;
DELETE
FROM meals;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, dateTime, description, calories)
VALUES (100000, '2022-10-24 07:20:00', 'Завтрак', 500),
       (100001, '2022-10-24 13:00:00', 'Обед', 1000),
       (100001, '2022-10-24 20:00:00', 'Ужин', 500),
       (100001, '2022-10-25 00:00:00', 'Еда на граничное значение', 100),
       (100000, '2022-10-25 09:30:00', 'Завтрак', 1000),
       (100000, '2022-10-25 15:00:00', 'Обед', 500),
       (100002, '2022-10-25 20:00:00', 'Ужин', 410);