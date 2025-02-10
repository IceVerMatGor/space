CREATE TABLE galaxy
(
    id          BIGSERIAL PRIMARY KEY UNIQUE,
    name        varchar,
    mass        bigint,
    check (mass > 0),
    speed       bigint,
    galaxy_type integer,
    image_path  varchar
)


