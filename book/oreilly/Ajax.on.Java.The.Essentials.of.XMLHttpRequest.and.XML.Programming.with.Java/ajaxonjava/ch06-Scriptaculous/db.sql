DROP TABLE PRODUCTS;
CREATE TABLE PRODUCTS
(
   PRODUCT_ID int PRIMARY KEY not null auto_increment,
   PRODUCT_NAME varchar(50),
   DESCRIPTION varchar(100),
   FILENAME varchar(100),
   PRICE decimal(9,2)
);
INSERT INTO PRODUCTS VALUES (1,'house','Estes Park Home2','house.png',575000.00);
INSERT INTO PRODUCTS VALUES (2,'latrines','Estes Park latrine','latrine.png','15.99');
INSERT INTO PRODUCTS VALUES (3,'chessboard','Home-made Chessboard','chessboard.png','99.99');
INSERT INTO PRODUCTS VALUES (4,'Guitar','Fernandez Green Guitar','guitar.png','255.00');
INSERT INTO PRODUCTS VALUES (5,'Tortoise','Cherry Box Turtle','cherry.png','19.99');

DROP TABLE SHOPPING_CART;
CREATE TABLE SHOPPING_CART
(
   CART_ID int PRIMARY KEY not null auto_increment,
   USER_ID int,
   START_DATE datetime,
   LAST_UPDATED datetime,
   ACTIVE tinyint
);
DROP TABLE USERS;
CREATE TABLE USERS
(
   USER_ID int PRIMARY KEY not null auto_increment,
   USERNAME varchar(50),
   PASSWORD varchar(50),
   FIRST_NAME varchar(50),
   LAST_NAME varchar(50),
   EMAIL varchar(50),
   ADDRESS varchar(50),
   ZIPCODE varchar(10),
   CITY varchar(50),
   STATE varchar(2),
   JOINED datetime,
   LAST_LOGIN datetime
);


DROP TABLE ITEMS_IN_CART;
CREATE TABLE ITEMS_IN_CART
(
   ITEM_ID int,
   CART_ID int,
   COUNT int
);
