GRANT ALL PRIVILEGES ON *.* TO 'springuser'@'localhost' IDENTIFIED BY 'ThePassword';

DROP DATABASE IF EXISTS sherlock;

CREATE DATABASE sherlock;

USE sherlock;

DROP table IF EXISTS GAMEOBJECT;

CREATE table GAMEOBJECT (
  id VARCHAR(20) ,
  label VARCHAR(20) default NULL,
  PRIMARY KEY (id)
);
