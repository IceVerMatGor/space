CREATE TABLE star_system (
 id BIGSERIAL PRIMARY KEY,
 name varchar,
 mass bigint,
 speed bigint,
 image_path varchar,
 galaxy_id bigint REFERENCES galaxy(id)
)