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
CREATE TABLE Enabling_status(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  status VARCHAR(20) NOT NULL
)
  ENGINE InnoDB;
CREATE TABLE user_enabling_status(
  userId INT NOT NULL ,
  enabledId INT NOT NULL ,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (enabledId) REFERENCES Enabling_status(id)
)
  ENGINE InnoDB;
-- Table for mapping user and roles
CREATE TABLE userRoles(
  userId INT NOT NULL ,
  roleId INT NOT NULL ,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (roleId) REFERENCES roles(id),
  UNIQUE(userId,roleId)
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

