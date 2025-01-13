Create Table star (id BIGSERIAL PRIMARY KEY,
             name varchar(255),
             mass bigint,
             speed bigint,
             star_system_id bigint REFERENCES star_system(id))