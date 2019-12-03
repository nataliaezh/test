DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id bigserial,
    login varchar(255),
    name varchar(255),
    password varchar(255),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

INSERT INTO users (login, name, password) VALUES
('test_user', 'Jhon','A123');



DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id bigserial,
    name varchar(255),
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);
INSERT INTO roles (name) VALUES
('admin'),
('user'),
('manager');

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles
(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id)
        REFERENCES roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
INSERT INTO user_roles (user_id, role_id) VALUES
(1,1),
(1,2),
(1,3);
