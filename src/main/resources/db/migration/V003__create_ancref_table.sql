CREATE TABLE IF NOT EXISTS ancref (
    id SERIAL PRIMARY KEY,
    typework typework_enum,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    reference VARCHAR(255) NOT NULL
);