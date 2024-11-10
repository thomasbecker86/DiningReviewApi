/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Thomas
 * Created: 07.10.2024
 */

INSERT INTO RESTAURANTS (NAME, CITY, STREET, ZIP_CODE) VALUES ('Burger Factory', 'Berlin', 'Alexanderplatz 2', 12458);
INSERT INTO RESTAURANTS (NAME, CITY, STREET, ZIP_CODE) VALUES ('Chicken House', 'München', 'Bogenstraße 8', 65157);
INSERT INTO RESTAURANTS (NAME, CITY, STREET, ZIP_CODE) VALUES ('Lord Of The Fries', 'Frankfurt', 'Bahnohofstraße 12', 54582);
INSERT INTO RESTAURANTS (NAME, CITY, STREET, ZIP_CODE) VALUES ('Soup Planet', 'Düsseldorf', 'Ruhrallee 44', 47159);
INSERT INTO USER (NAME, CITY, ZIP_CODE, PEANUT_ALLERGY, EGG_ALLERGY, DAIRY_ALLERGY) VALUES ('TestUser01', 'München', 65163, false, false, false);
INSERT INTO USER (NAME, CITY, ZIP_CODE, PEANUT_ALLERGY, EGG_ALLERGY, DAIRY_ALLERGY) VALUES ('TestUser02', 'Düsseldorf', 47166, false, false, true);