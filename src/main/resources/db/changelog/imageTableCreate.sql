CREATE TABLE image
(
    id                 uuid PRIMARY KEY UNIQUE,
    path_to_file       varchar,
    original_file_name varchar,
    content_type       varchar,
    description        varchar,
    galaxy_id          bigint references galaxy (id)
)