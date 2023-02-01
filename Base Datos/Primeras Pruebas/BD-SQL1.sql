CREATE TABLE empleados (
	clave INTEGER,
	nombre TEXT,
	apellido_paterno TEXT, 
	apellido_materno TEXT,
	fecha_de_nacimiento TEXT,
	sueldo NUMERIC
);

CREATE TABLE producto (
	codigo INTEGER,
	nombre TEXT,
	precio NUMERIC
);

-----TABLAS RELACIONADAS-----
CREATE TABLE grupos(
id INTEGER PRIMARY KEY AUTOINCREMENT,
nombre TEXT NOT NULL
);

-----RELACION PRINCIPAL------
CREATE TABLE ALUMNOS (
id INTEGER PRIMARY KEY AUTOINCREMENT,
id_grupo INTEGER,
nombre TEXT NOT NULL,
direccion TEXT NOT NULL,
id_ciudad INTEGER,
FOREIGN KEY (id_grupo) REFERENCES grupos (id),
FOREIGN KEY (id_ciudad)REFERENCES ciudad (id_ciudad)
);

DROP TABLE ALUMNOS;

INSERT INTO grupos (nombre) VALUES ("ASIR1");
INSERT INTO grupos (nombre) VALUES ("DAW");
INSERT INTO grupos (nombre) VALUES ("DAM");


INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (1,"Fernando","Calle Napolitana 20",1);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (2,"juan","Calle Napolitana 21",1);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (3,"pedro","Calle Napolitana 22",3);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (1,"nato","Calle Napolitana 23",4);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (2,"mateo","Calle Napolitana 24",5);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (3,"lisa","Calle Napolitana 25",6);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (1,"fer","Calle Napolitana 26",7);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (2,"mari","Calle Napolitana 27",8);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (3,"gabi","Calle Napolitana 28",9);
INSERT INTO ALUMNOS (id_grupo, nombre,direccion,id_ciudad) VALUES (1,"sana","Calle Napolitana 29",10);

CREATE TABLE foo(
id_alumno INTEGER, 
FOREIGN KEY (id_alumno) REFERENCES ALUMNOS (id)
);

CREATE TABLE ciudad (
id_ciudad INTEGER PRIMARY KEY AUTOINCREMENT,
nombre TEXT NOT NULL
);

INSERT INTO ciudad (nombre) values ("Madrid");
INSERT INTO ciudad (nombre) values ("Barcelona");
INSERT INTO ciudad (nombre) values ("Sevilla");
INSERT INTO ciudad (nombre) values ("Valencia");
INSERT INTO ciudad (nombre) values ("Zaragoza");
INSERT INTO ciudad (nombre) values ("Cordoba");
INSERT INTO ciudad (nombre) values ("Toledo");
INSERT INTO ciudad (nombre) values ("Salamanca");
INSERT INTO ciudad (nombre) values ("Granada");
INSERT INTO ciudad (nombre) values ("Palma");

--Renombrar tabla 
ALTER TABLE empleados RENAME to persona

--Renombrar columna 
ALTER TABLE persona RENAME COLUMN sueldo to sueldo_mensual

--Agregar columna
ALTER TABLE persona ADD COLUMN DNI TEXT;

--Borrar Columna 
ALTER TABLE persona DROP COLUMN sueldo_mensual;

--Eliminar tabla
DROP TABLE 

--Insertar datos en la tabla
INSERT INTO persona(clave, nombre, apellido_paterno, apellido_materno, fecha_de_nacimiento, DNI)VALUES
	(1,'Carlos', 'Garcia', 'Gonzales','10-02-2000','1234787A');
	
--Insertar datos sin meter las columnas 
INSERT INTO persona VALUES(2,'Maria', 'Garcia', 'Gonzales','02/12/1998','0147895AH');

--Insertar datos sin la fecha de nacimiento
INSERT INTO persona(clave, nombre, apellido_paterno, apellido_materno, DNI)VALUES
		(3,'Zara', 'Fernandez', 'Petrella','78945ZL');
		
--Insertar daots de la forma corta 
INSERT INTO persona
	VALUES (4,'Luis', 'Lopez', 'Lopez', NULL,'78945DE' )

--Update todas las fechas de nacimientos de los registros
UPDATE persona SET fecha_de_nacimiento ='01-01-2000';

--Update especifico
UPDATE persona SET fecha_de_nacimiento = '05/05/2005' WHERE clave=3;

UPDATE persona SET fecha_de_nacimiento = '29/02/1995' WHERE apellido_paterno='Lopez';

--Borrado de datos
DELETE FROM (nombreTabla);

--Eliminar un registro de una columna
DELETE FROM productos WHERE id_producto = 1;

--Eliminar registro por el valor de un campo
DELETE FROM productos WHERE id_marca = 39;

SELECT*FROM productos;
SELECT nombre, modelo FROM productos;

--Consulta con filtro por columnas
SELECT*FROM productos WHERE id_marca = 34;
SELECT*FROM productos WHERE id_marca = '34';

--obtener valores unicos de un campo mas no los cuenta 
SELECT DISTINCT id_marca FROM productos;

--Orden ascendente
SELECT*FROM productos ORDER by id_marca ASC;

--Orden descendente
SELECT*FROM productos ORDER by id_marca DESC;

--Filtrar y ordenar los resultados por un campo o columna
SELECT id_producto, clave, modelo FROM productos WHERE nombre ='Cable UTP' ORDER by modelo;

--
SELECT id_producto, id_marca, modelo FROM productos WHERE id_marca=267 ORDER by modelo;

--Pruebas
SELECT id_producto, id_marca,id_categoria, nombre from productos WHERE id_marca = 363 ORDER BY id_categoria DESC, nombre DESC LIMIT 5;
--SELECT id_producto, id_marca, modelo FROM productos WHERE id_marca=267 ORDER BY modelo DESC;

--Operador < que
SELECT id_producto FROM productos WHERE id_producto <= 11;

--Operador <> (diferente o no igual a)
SELECT id_producto FROM productos WHERE id_producto <> 11
ORDER by id_producto ASC
LIMIT 5;

--Operador BETWEEN.
SELECT id_producto FROM productos
WHERE id_producto BETWEEN 14812 AND 14816;

--Operador like 
SELECT id_producto, no_parte FROM productos 
WHERE no_parte like 'L___0';

--Operador IN
SELECT id_producto, id_marca, nombre FROM productos
WHERE nombre IN ('Pegamento','Folder');

--Operador concatena distinas condiciones AND (Y)
SELECT id_producto, id_marca, id_categoria, nombre FROM productos
WHERE id_marca =11 AND id_categoria=618;

--Operador NOT
SELECT id_producto, id_marca, id_categoria, nombre FROM productos
WHERE NOT id_marca <> 11;