delete from user_roles;
delete from users;
delete from roles;

insert into roles(id, name) values (1, 'ROLE_ADMIN');
insert into roles(id, name) values (2, 'ROLE_USER');

insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(1, 'Dmitry', 'Sandul', 'dmitry.sandul@codefactory.com', '069545451', 'dmitry1', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(2, 'Vsea', 'Gliuc', 'vsea@codefactory.com', '069545452', 'vsea2', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(3, 'Jora', 'Drish', 'jora@codefactory.com', '069545453', 'jora3', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(4, 'Petea', 'Kliuv', 'petea@codefactory.com', '069545454', 'petea4', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(5, 'Iura', 'Spirt', 'iura@codefactory.com', '069545455', 'iura5', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(6, 'Gena', 'Srez', 'gena@codefactory.com', '069545456', 'gena6', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(7, 'Liusea', 'Pliush', 'liusea@codefactory.com', '069545457', 'liusea7', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(8, 'Katea', 'Siezd', 'katea@codefactory.com', '069545458', 'katea8', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(9, 'Kristina', 'Sandul', 'kristina.sandul@codefactory.com', '069545459', 'kristina9', 'jora123');
insert into users(id, first_name, last_name, email, phone_number, username, password)
            values(10, 'Misha', 'Vlas', 'misha@codefactory.com', '069545410', 'misha10', 'jora123');

insert into user_roles(user_id, role_id) values (1, 1);
insert into user_roles(user_id, role_id) values (2, 2);
insert into user_roles(user_id, role_id) values (3, 2);
insert into user_roles(user_id, role_id) values (4, 2);
insert into user_roles(user_id, role_id) values (5, 2);
insert into user_roles(user_id, role_id) values (6, 2);
insert into user_roles(user_id, role_id) values (7, 2);
insert into user_roles(user_id, role_id) values (8, 2);
insert into user_roles(user_id, role_id) values (9, 2);
insert into user_roles(user_id, role_id) values (10, 2);