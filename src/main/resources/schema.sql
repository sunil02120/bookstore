DROP TABLE IF EXISTS CUSTOMER;  
CREATE TABLE CUSTOMER (id number, name varchar(20), age number, address varchar(20), 
salary number);  

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT(ID INT,PRODUCT_NAME VARCHAR(10));


DROP TABLE IF EXISTS SALES;
CREATE TABLE SALES(ID INT, PRODUCT VARCHAR(10), ORDER_DATE DATE,SALE_COUNT INT);