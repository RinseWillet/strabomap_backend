CREATE TABLE IF NOT EXISTS ancrefs (
    id SERIAL PRIMARY KEY,
    typework typework_enums,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    reference VARCHAR(255) NOT NULL
);