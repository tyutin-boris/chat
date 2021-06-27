
    CREATE sequence hibernate_sequence start 1 increment 1;

    CREATE TABLE users (
        id BIGSERIAL NOT NULL,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) UNIQUE NOT NULL,
        password VARCHAR(255) NOT NULL,
        PRIMARY KEY (id));

    SELECT setval('users_id_seq', 10, true);

--password 000000
    INSERT INTO users
        VALUES (0, 'Boris', 'Boris@gmail.com', '$2y$12$1rfj9i4hq.pG3CEd62ivWuoxOWUx7YpGiFuI7Qsis9DcrT7l5ptE.');