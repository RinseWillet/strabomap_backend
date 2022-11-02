CREATE TABLE IF NOT EXISTS settlements (
    id SERIAL PRIMARY KEY,
    pleiadesid INT,
    ancientname VARCHAR(255) NOT NULL,
    modernname VARCHAR(255),
    geom geography(POINT, 4326)
);
