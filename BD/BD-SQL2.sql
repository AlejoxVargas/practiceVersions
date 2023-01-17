DROP TABLE ALUMNOS;
DROP TABLE ciudad;

CREATE TABLE ALUMNOS (
id INTEGER PRIMARY KEY AUTOINCREMENT,
id_grupo INTEGER,
nombre TEXT NOT NULL,
direccion TEXT NOT NULL,
id_ciudad INTEGER,
FOREIGN KEY (id_grupo) REFERENCES grupos (id),
FOREIGN KEY (id_ciudad)REFERENCES ciudad (id_ciudad)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE ciudad (
id_ciudad INTEGER PRIMARY KEY AUTOINCREMENT,
nombre TEXT NOT NULL
);
--DELETE es para eliminar datos
--DROP para las estructuras