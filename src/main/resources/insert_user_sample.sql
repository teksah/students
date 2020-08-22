INSERT INTO users VALUES ('user', '{noop}password', 1);
INSERT INTO users VALUES ('admin', '{noop}password', 1);

INSERT INTO authorities VALUES('user', 'USER');
INSERT INTO authorities VALUES('admin', 'USER');
INSERT INTO authorities VALUES('admin', 'ADMIN');
