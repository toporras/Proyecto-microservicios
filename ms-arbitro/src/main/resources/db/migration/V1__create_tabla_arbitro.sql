CREATE TABLE arbitro(
                id int primary key auto_increment,
                nombre varchar(100),
                fecha_nacimiento varchar(100),
                telefono int (10)
);

INSERT INTO arbitro(nombre, fecha_nacimiento, telefono)
VALUES ("Pedro", "20-12-2000",231235375);