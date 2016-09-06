#DROP DATABASE devise_db;
CREATE DATABASE IF NOT EXISTS devise_db;
USE devise_db;

DROP TABLE IF EXISTS Devise;
CREATE TABLE Devise (
  codeDevise VARCHAR(8) NOT NULL,
  monnaie VARCHAR(64) NULL,
  tauxChange double,
  PRIMARY KEY (codeDevise)
);

INSERT INTO Devise(codeDevise,monnaie,tauxChange)
VALUES ('EUR', 'euro',1.1),
       ('USD', 'dollar',1.0),
       ('JPY', 'yen',0.012),
       ('GBP', 'livre',1.2);


show tables;
select * from Devise;

