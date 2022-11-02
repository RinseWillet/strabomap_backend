CREATE TABLE IF NOT EXISTS ancrefs (
    id SERIAL PRIMARY KEY,
    typework typework_enums,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    reference VARCHAR(255) NOT NULL,
    settlement_id INT NOT NULL,
    lastmodified TIMESTAMP,
    FOREIGN KEY(settlement_id) REFERENCES settlements(id) ON DELETE CASCADE
);