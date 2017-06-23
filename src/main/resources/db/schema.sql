CREATE TABLE T_USER (
   "ID" int NOT NULL AUTO_INCREMENT,
   "USERNAME" varchar,
   "PASSWORD" varchar,
   PRIMARY KEY ("ID")
 ) DEFAULT CHARSET=utf8;

 CREATE TABLE T_USER_ROLE (
   "USER_ID" int,
   "ROLE_ID" int
 ) DEFAULT CHARSET=utf8;

 CREATE TABLE T_TB_USER (
   "ID" int NOT NULL AUTO_INCREMENT,
   "NAME" varchar,
   "PASSWD" varchar,
   PRIMARY KEY ("ID")
 ) DEFAULT CHARSET=utf8;

 CREATE TABLE T_ROLE (
   "ID" int NOT NULL AUTO_INCREMENT,
   "ROLENAME" varchar,
   PRIMARY KEY ("ID")
 ) DEFAULT CHARSET=utf8;


 CREATE TABLE T_PERMISSION (
   "ID" int NOT NULL AUTO_INCREMENT,
   "PERMISSIONNAME" varchar,
   "ROLE_ID" int,
   PRIMARY KEY ("ID")
 ) DEFAULT CHARSET=utf8;