CREATE TABLE astronomer
(
    id   BIGSERIAL UNIQUE PRIMARY KEY,
    username varchar UNIQUE,
    password varchar
)