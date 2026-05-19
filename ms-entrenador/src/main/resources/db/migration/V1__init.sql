CREATE TABLE entrenador(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100),
 edad INT,
 equipo_id INT
);

INSERT INTO entrenador(nombre, edad, equipo_id)
VALUES ('Jorge Almiron', 52, 1);