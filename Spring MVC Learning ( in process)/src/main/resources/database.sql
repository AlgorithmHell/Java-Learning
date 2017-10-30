DROP TABLE users;
DROP TABLE roles;
Drop TABLE userRoles;
-- Table users
CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Username VARCHAR(255) NOT NULL ,
  Password VARCHAR(255) NOT NULL
)
  ENGINE =InnoDB;
-- Table roles
CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  role VARCHAR(20) NOT NULL
)
  ENGINE = InnoDB;
CREATE TABLE enabling_status(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  status VARCHAR(20) NOT NULL
)
  ENGINE InnoDB;
CREATE TABLE user_enabling_status(
  userId INT NOT NULL ,
  enabledId INT NOT NULL ,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (enabledId) REFERENCES enabling_status(id),
  UNIQUE (userId,enabledId)
)
  ENGINE InnoDB;
-- Table for mapping user and roles
CREATE TABLE user_roles(
  user_id INT NOT NULL ,
  role_id INT NOT NULL ,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  UNIQUE(user_id,role_id)
)
  ENGINE = InnoDB;


CREATE TABLE userInfo(
  userInfoId INT NOT NULL,
  age INT UNSIGNED ,
  birthDate DATE,
  info VARCHAR(255) NOT NULL,
  FOREIGN KEY (userInfoId) REFERENCES users(id)
)ENGINE InnoDB;
INSERT INTO users VALUES (1,'Helga','$2a$04$TBhVPZX5RriLR7R05FuS0.gu5ko1acrHFvB28RTYWZq5NSH26vC9G');
INSERT INTO Roles VALUE (1,'USER');
INSERT INTO Roles VALUE (2,'ADMIN');
INSERT INTO Roles VALUE (3,'ANONYMOUS');
INSERT INTO userInfo VALUES (1,19,'1998-08-08','FAMCS Student, runs evetyhring');
INSERT INTO  userRoles VALUES (1,2);
INSERT INTO Enabling_status VALUES (1,'Blocked');
INSERT INTO Enabling_status VALUES (2,'Unblocked');
INSERT INTO user_enabling_status VALUES (1,2);
DROP TABLE instruction;
DROP TABLE comment;
CREATE TABLE instruction(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(255) NOT NULL,
  date_created DATE,
  description VARCHAR(255) NOT NULL,
  body VARCHAR(1024) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
)
  ENGINE InnoDB;
CREATE TABLE comment(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  date_created DATE,
  body VARCHAR(512) NOT NULL,
  FOREIGN KEY (instruction_id) REFERENCES instruction(id)
)ENGINE InnoDB;

CREATE TABLE user_instruction(
  user_id INT NOT NULL ,
  instruction_id INT NOT NULL ,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (instruction_d) REFERENCES instruction(id),
  UNIQUE(user_id, instruction_id)
)
  ENGINE =InnoDB;
CREATE TABLE instruction_comment
(
  comment_id INT NOT NULL ,
  instruction_id INT NOT NULL ,
  FOREIGN KEY (comment_id) REFERENCES comment(id),
  FOREIGN KEY (instruction_d) REFERENCES instruction(id),
  UNIQUE( instruction_id,comment_id)
)
  ENGINE =InnoDB;