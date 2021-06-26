
    CREATE TABLE messages (
        id BIGSERIAL NOT NULL,
        author_id int8 NOT NULL,
        title VARCHAR(255),
        text VARCHAR(2024),
        PRIMARY KEY (id));

    SELECT setval('messages_id_seq', 10, true);

    INSERT INTO messages
        VALUES (0, 0, 'title1', 'text1'),
               (1, 0, 'title2', 'text2'),
               (2, 0, 'title3', 'text3');