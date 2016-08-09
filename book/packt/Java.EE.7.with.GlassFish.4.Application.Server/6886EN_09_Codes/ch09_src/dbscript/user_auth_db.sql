-- Create the database and connect to it.
connect 'jdbc:derby://localhost:1527/userauth;create=true';

-- Add a user to the database, username dev, password dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.admin','admin');

-- Grant all privileges to user dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.fullAccessUsers','admin');

-- Disconnect from the newly created database
disconnect;

-- Reconnect to the newly created database as user dev
connect 'jdbc:derby://localhost:1527/userauth;user=admin;password=admin';

CREATE TABLE USERS
(
   USER_ID INTEGER PRIMARY KEY not null,
   USERNAME VARCHAR(10) not null,
   FIRST_NAME VARCHAR(15),
   MIDDLE_NAME VARCHAR(15),
   LAST_NAME VARCHAR(20),
   PASSWORD CHAR(32) not null
);

CREATE UNIQUE INDEX SQL070522071825971 ON USERS(USERNAME);


CREATE TABLE GROUPS
(
   GROUP_ID INTEGER PRIMARY KEY not null,
   GROUP_NAME VARCHAR(20) unique not null,
   GROUP_DESC VARCHAR(200)
);

CREATE TABLE USER_GROUPS
(
   USER_ID INTEGER not null,
   GROUP_ID INTEGER not null,
   PRIMARY KEY (USER_ID,GROUP_ID)
);

ALTER TABLE USER_GROUPS
ADD CONSTRAINT SQL070522071838550
FOREIGN KEY (USER_ID)
REFERENCES USERS(USER_ID) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE USER_GROUPS
ADD CONSTRAINT SQL070522071838560
FOREIGN KEY (GROUP_ID)
REFERENCES GROUPS(GROUP_ID) ON DELETE NO ACTION ON UPDATE NO ACTION;

create view v_user_role as
select u.username, g.group_name, u.password from users u, groups g, user_groups ug where u.USER_ID = ug.USER_ID and g.GROUP_ID = ug.GROUP_ID;

INSERT INTO USERS (USER_ID,USERNAME,FIRST_NAME,MIDDLE_NAME,LAST_NAME,PASSWORD) VALUES (1,'dheffel','David','Raymond','Heffelfinger','62072d95acb588c7ee9d6fa0c6c85155');
INSERT INTO USERS (USER_ID,USERNAME,FIRST_NAME,MIDDLE_NAME,LAST_NAME,PASSWORD) VALUES (2,'rgonz','Rose','Mary','Gonzalez','5ebe2294ecd0e0f08eab7690d2a6ee69');

INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_DESC) VALUES (1,'Admin','Administrators');
INSERT INTO GROUPS (GROUP_ID,GROUP_NAME,GROUP_DESC) VALUES (2,'Users','Regular users');

INSERT INTO USER_GROUPS (USER_ID,GROUP_ID) VALUES (1,1);
INSERT INTO USER_GROUPS (USER_ID,GROUP_ID) VALUES (1,2);
INSERT INTO USER_GROUPS (USER_ID,GROUP_ID) VALUES (2,2);



