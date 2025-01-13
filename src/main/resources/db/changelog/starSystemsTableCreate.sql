CREATE TABLE star_system (
 id BIGSERIAL PRIMARY KEY,
 name varchar,
 mass bigint,
 speed bigint,
 galaxy_id bigint REFERENCES galaxy(id)
)