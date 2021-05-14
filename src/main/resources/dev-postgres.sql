-- NEED TO CREATE PROJECT ---------------

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_CUSTOMER'),
(3, 'ROLE_DRIVER'),
(4, 'ROLE_LOADER'),
(5, 'ROLE_MANAGER'),
(6, 'ROLE_ADMIN'),
(7, 'ROLE_EXTRA_CUSTOMER');

-----------------------------------------------

INSERT INTO users (id, first_name, second_name, last_name, username, email, password, phone_number, role_id, user_profile_image_url) VALUES
(1, 'John', 'Frederick', 'Smith', 'john_the_admin', 'j_smith@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+79165874526', 2, 'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/b561dc28-505f-426f-8a59-abec46161744/dbscvr2-c1a5e06a-2375-4dca-b7a0-8700279f9cbb.png/v1/fill/w_894,h_894,strp/sefsef_x_unnamed_by_cyacol_dbscvr2-pre.png'),
(2, 'Денис', 'Даниилович', 'Воробьев', 'vorobiev.d.d', 'vorobievd.d@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+75874569874', 3, ''),
(3, 'Александр', 'Михайлович', 'Богданов', 'bogdanov.a.m', 'bogdanov.a.m@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 4, ''),
(4, 'Владимир ', 'Даниилович', 'Блинов', 'blinov.v.d', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 5, ''),
(5, 'Ксения', 'Владимировна', 'Вдовина', 'vdovina.k.v', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 4, 'https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'),
(6, 'Михаил', 'Владиславович', 'Голованов', 'golovanov', 'golovanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 3, ''),
(7, 'Иван', 'Иванович', 'Ивванов', 'ivanov', 'ivanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 4, '');

INSERT INTO customers (id, user_id) VALUES
(1, 1);

INSERT INTO drivers (id, user_id) VALUES
(1, 2),
(2, 6);

INSERT INTO loaders (id, user_id) VALUES
(1, 3),
(2, 5),
(3, 7);

INSERT INTO user_likes (id, user_id_from, user_id_to) VALUES
(1, 1, 2),
(2, 1, 3);

INSERT INTO comments (id, comment_text, rating, user_id_from, user_id_to) VALUES
(1, '', 5.0, 1, 2);

INSERT INTO cars (id, gos_nomber, height, length, max_people_capacity, max_weight, price_per_hour, size, width, type) VALUES
(1, 'Р123ОМ123', 2.7, 3.5, 5, 5000, 2000, 15, 2, 1),
(2, 'К325ОТ777', 3, 6, 5, 9000, 3000, 25, 2.5, 2);

INSERT INTO cars_validity (id, is_valid, reason_of_crash, car_id) VALUES
(1, true, '', 1),
(2, true, '', 2);

INSERT INTO drivers_cars (drivers_id, cars_id) VALUES
(1, 1),
(2, 2);
