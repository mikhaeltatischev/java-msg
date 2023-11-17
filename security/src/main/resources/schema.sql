DROP TYPE IF EXISTS ROLES CASCADE;

CREATE TYPE ROLES AS ENUM ('ADMIN', 'USER');

CREATE TABLE IF NOT EXISTS users (
    login            VARCHAR(255) NOT NULL,
    password         VARCHAR(255) NOT NULL,
    first_name       VARCHAR(255) NOT NULL,
    last_name        VARCHAR(255) NOT NULL,
    roles            VARCHAR(6)   DEFAULT 'USER',
    CONSTRAINT pk_users           PRIMARY KEY (login)
);