CREATE TABLE star_system
(
    id         BIGSERIAL PRIMARY KEY UNIQUE,
    name       varchar,
    mass       bigint,
    check (mass > 0),
    speed      bigint,
    image_path varchar,
    galaxy_id  bigint REFERENCES galaxy (id)
)