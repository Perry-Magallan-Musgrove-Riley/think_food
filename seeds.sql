DROP DATABASE IF EXISTS think_food_db;

CREATE DATABASE IF NOT EXISTS think_food_db;

USE think_food_db;


INSERT INTO  recipes(id, title, prep_time, description, rating)
VALUES (1, 'Sweet potato casserole', 90, 'some words that make it sound delicious', 8);

INSERT INTO  recipes(id, title, prep_time, description, rating)
VALUES (2, 'Grilled chicken', 60, 'some words that make it sound scrump-dida-lumptious', 7);

INSERT INTO  recipes(id, title, prep_time, description, rating)
VALUES (3, 'Smoked Salmon', 60, 'You better act like you know', 7);

INSERT INTO images(img_path) values('https://cdn.filestackcontent.com/vTGVLn4tQoWBvgTCndPM');

INSERT INTO users(id, username, is_admin, email, first_name, last_name, password) values (2, "FantasticFive", 1, "kapena.a.m.magallan@gmail.com", "Kapena", "Magallan", "codeup");

UPDATE users SET is_admin = 1 WHERE id = 1;
