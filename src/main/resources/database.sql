DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

--Table users
CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

--Table roles
CREATE TABLE IF NOT EXISTS roles(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL
);

--Table for mapping user and roles: user_roles
CREATE TABLE IF NOT EXISTS user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    --make user_id and role_id field unique
    UNIQUE (user_id, role_id)
);

-- Insert data
INSERT INTO users VALUES (1, 'sviatdev', '12345');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);