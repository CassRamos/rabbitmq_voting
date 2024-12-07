CREATE TABLE IF NOT EXISTS candidates
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS votes
(
    id SERIAL PRIMARY KEY ,
    candidate_id BIGINT NOT NULL ,
    vote_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

