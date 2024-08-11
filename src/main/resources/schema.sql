CREATE TABLE users
(
	userId BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	email VARCHAR(45) NOT NULL UNIQUE,
	encryptedPassword VARCHAR(100) NOT NULL,
	enabled BIT NOT NULL
);

CREATE TABLE role
(
	roleId BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	roleName Varchar(45) NOT NULL
);

CREATE TABLE userRole
(
	userId BIGINT,
	roleId BIGINT
);

ALTER TABLE userRole
	ADD CONSTRAINT uq_01 UNIQUE (userId, roleId);

ALTER TABLE userRole
	ADD CONSTRAINT fk_01 FOREIGN KEY (userId) REFERENCES
	users(userId);
ALTER TABLE userRole
	ADD CONSTRAINT fk_02 FOREIGN KEY (roleId) REFERENCES
	role(roleId);

CREATE TABLE author
(
	authorId BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(45),
	lastName VARCHAR(45)
);

CREATE TABLE book
(
	bookId BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	title VARCHAR(45) NOT NULL,
	isbn VARCHAR(45) NOT NULL
);

CREATE TABLE authorBook
(
	authorId BIGINT,
	bookId BIGINT
);

ALTER TABLE book ADD CONSTRAINT isbnuq UNIQUE (isbn);

ALTER TABLE authorbook ADD CONSTRAINT
	fkauth FOREIGN KEY (authorId) REFERENCES author(authorId);
	
ALTER TABLE authorbook ADD CONSTRAINT
	fkbook FOREIGN KEY (bookId) REFERENCES book(bookId);