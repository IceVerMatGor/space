create TABLE astronomer_authority
(
    astronomer_id bigserial REFERENCES astronomer(id),
    authority_id bigserial REFERENCES authority(id),
    PRIMARY KEY (astronomer_id,authority_id)
)

