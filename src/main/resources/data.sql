INSERT INTO users(email, encryptedPassword, enabled)
VALUES ('nivkpd@gmail.com', '$2a$12$FO8MHF8C6cNsyzXpJx213eYT34UYOkR4VkY5esLoVEkSRd0vYADcS', 1);

INSERT INTO users(email, encryptedPassword, enabled)
VALUES('niv@nivkapadia.com', '$2a$12$FO8MHF8C6cNsyzXpJx213eYT34UYOkR4VkY5esLoVEkSRd0vYADcS', 1);

INSERT INTO users(email, encryptedPassword, enabled)
VALUES('admin@nivkapadia.com', '$2a$12$FO8MHF8C6cNsyzXpJx213eYT34UYOkR4VkY5esLoVEkSRd0vYADcS', 1);

INSERT INTO role(roleName)
VALUES ('ROLE_ADMIN');

INSERT INTO role(roleName)
VALUES('ROLE_USER');

INSERT INTO role(roleName)
VALUES ('ROLE_GUEST');


INSERT INTO userRole VALUES(1, 2);
INSERT INTO userRole VALUES(2, 3);
INSERT INTO userRole VALUES(3, 1);

INSERT INTO book (title, isbn)
VALUES
('Poor Charlies Almanack', 'ISBN0000000001');
INSERT INTO book (title, isbn)
VALUES
('Elon Musk', 'ISBN0000000002');
INSERT INTO book (title, isbn)
VALUES
('Sapiens', 'ISBN0000000003');
INSERT INTO book (title, isbn)
VALUES
('Mindset', 'ISBN0000000004');

INSERT INTO author(firstName, lastName)
VALUES ('Charlie', 'Munger');
INSERT INTO author(firstName, lastName)
VALUES ('Carol', 'S. Dweck');
INSERT INTO author(firstName, lastName)
VALUES ('Walter', 'Issacson');

INSERT INTO authorBook VALUES(1, 1);
INSERT INTO authorBook VALUES(3, 2);
INSERT INTO authorBook Values(2, 3);
INSERT INTO authorBook VALUES(2, 4);

