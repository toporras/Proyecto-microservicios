CREATE TABLE estadio(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100),
 capacidad INT,
 ciudad VARCHAR(100)
);

INSERT INTO estadio(nombre, capacidad, ciudad)
VALUES ('Monumental', 47000, 'Santiago');