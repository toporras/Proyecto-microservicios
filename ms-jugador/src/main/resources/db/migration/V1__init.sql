CREATE TABLE jugador(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100),
 posicion VARCHAR(100),
 equipo_id INT
);

INSERT INTO jugador(nombre, posicion, equipo_id)
VALUES ('Carlos Diaz', 'Delantero', 1);