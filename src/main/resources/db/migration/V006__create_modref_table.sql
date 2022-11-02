CREATE TABLE IF NOT EXISTS modrefs (
    id SERIAL PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    pubyear INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    pagenumbers VARCHAR(255) NOT NULL,
    settlement_id INT NOT NULL,
    lastmodified TIMESTAMP,
    FOREIGN KEY(settlement_id) REFERENCES settlements(id) ON DELETE CASCADE
);