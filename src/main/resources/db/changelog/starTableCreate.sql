Create Table star
(
    id             BIGSERIAL PRIMARY KEY UNIQUE,
    name           varchar(255),
    mass           bigint,
    check (mass > 0),
    speed          bigint,
    image_path     varchar,
    star_system_id bigint REFERENCES star_system (id)
)