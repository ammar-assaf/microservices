CREATE TABLE IF NOT EXISTS data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperature DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password) VALUES ('ammar', '1234');

INSERT INTO data (temperature) VALUES (22), (16.5), (30.5), (25);
