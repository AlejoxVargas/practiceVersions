DROP TABLE CLIENTE;

CREATE TABLE CLIENTE (
dni TEXT PRIMARY  KEY,
nombre TEXT NOT NULL,
apellido TEXT NOT NULL,
direccion TEXT NOT NULL,
fecha_Nacimiento TEXT
);

DROP TABLE PRODUCTO;

CREATE TABLE PRODUCTO(
codigo INTEGER PRIMARY KEY,
nombre TEXT NOT NULL,
precio_Unitario REAL NOT NULL
);

CREATE TABLE PROOVEDOR(
nif TEXT PRIMARY KEY,
nombre TEXT NOT NULL,
direccion TEXT NOT NULL,
codigo_producto INTEGER,
FOREIGN KEY (codigo_producto) REFERENCES PRODUCTO(codigo)
);

CREATE TABLE COMPRAS (
	nif_Clientes TEXT,
	cod_producto INTEGER,
	PRIMARY KEY (nif_Clientes, cod_producto)
	FOREIGN KEY (nif_Clientes) REFERENCES CLIENTE (dni)
	FOREIGN KEY (cod_producto) REFERENCES PRODUCTO (codigo)
);

INSERT INTO PRODUCTO VALUES (1,"Tornillos",3.5);

INSERT INTO CLIENTE VALUES ("1231231F","Guayaco","guayaco","vergatario 232","12/12/12");

INSERT INTO PROOVEDOR VALUES ("12345678A","Pepe S.A","Calle Mayor 35",1);

INSERT INTO PRODUCTO VALUES (2,"Tuercas",2.5);
INSERT INTO COMPRAS VALUES ("1231231F",1);
INSERT INTO COMPRAS VALUES ("1231231F",2);


--Siempre en el modelo relacional, cuando una tabla tenga de su lado la cardinalidad de muchos y la otra de 1, la de muchos siempre va a albergar la llave foranea
--De la tabla con relacion de 1 y este pasa a hacer campo foraneo del de muchos