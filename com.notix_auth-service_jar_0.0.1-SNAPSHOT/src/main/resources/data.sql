/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jibin
 * Created: 16 Apr, 2018
 */
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;


CREATE  TABLE users (
  user_name VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled boolean NOT NULL ,
  PRIMARY KEY (user_name));

CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_name varchar(100) NOT NULL,
  role varchar(100) NOT NULL,
  PRIMARY KEY (user_role_id));



INSERT INTO users(user_name,password,enabled) VALUES ('shah','useradmin', true);
INSERT INTO users(user_name,password,enabled) VALUES ('admin','admin', true);

INSERT INTO user_roles (user_name, role) VALUES ('shah', 'ROLE_USER');
INSERT INTO user_roles (user_name, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (user_name, role) VALUES ('admin', 'ROLE_USER');


