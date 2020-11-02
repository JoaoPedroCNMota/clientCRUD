/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  joaopedrocnmota
 * Created: Oct 28, 2020
 */

INSERT into users(login, pass) values('admin', '{bcrypt}$2a$10$1.y1JEEqLfZmX/WqbT4lvOx.uwwa3H9lDbkD0uJvEkqH8.7D8Xjt2')
INSERT into users(login, pass) values('comum', '{bcrypt}$2a$10$1.y1JEEqLfZmX/WqbT4lvOx.uwwa3H9lDbkD0uJvEkqH8.7D8Xjt2')

INSERT into user_role(role_name) values('ROLE_ADMIN')
INSERT into user_role(role_name) values('ROLE_COMUM')

INSERT into user_roles(user_id, role_id) values('admin','ROLE_ADMIN')
INSERT into user_roles(user_id, role_id) values('comum','ROLE_COMUM')

INSERT into user_role_users(users_login, user_role_role_name) values('admin','ROLE_ADMIN')
INSERT into user_role_users(users_login, user_role_role_name) values('comum','ROLE_COMUM')