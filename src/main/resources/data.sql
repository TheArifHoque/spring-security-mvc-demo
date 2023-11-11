INSERT INTO users (id,name,email,password) VALUES (101,'Arif','arif@gmail.com','1234');
INSERT INTO users (id,name,email,password) VALUES (102,'Hoque','hoque@gmail.com','abcd');

INSERT INTO authorities (id,authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (id,authority) VALUES (2,'ROLE_ADMIN');

INSERT INTO user_authority_mapping(user_id, authority_id) VALUES (101,1);
INSERT INTO user_authority_mapping(user_id, authority_id) VALUES (102,2);