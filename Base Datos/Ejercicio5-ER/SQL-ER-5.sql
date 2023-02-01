CREATE TABLE AUTORES (
	codigoAutores INTEGER,
	nombre TEXT not null,
	apellidos TEXT not null,
	fechaNacimiento TEXT not null,
	fechaFallecimiento TEXT,
	nacionalidad TEXT,
	resumen TEXT,
	PRIMARY KEY (codigoAutores)
);

CREATE TABLE SOCIOS (
	codigoSocio INTEGER,
	nombre TEXT not null,
	apellidos TEXT not null,
	direccion TEXT not null,
	telefono TEXT,
	email TEXT,
	fechaNacimiento TEXT,
	PRIMARY KEY (codigoSocio)
);

CREATE TABLE LIBRO (
	codigoLibro TEXT,
	titulo TEXT not null,
	editorial TEXT not null,
	numPaginas INTEGER not null,
	resumen TEXT,
	codigoAutores INTEGER,
	codigoSocio INTEGER,
	PRIMARY KEY (codigoLibro),
	FOREIGN KEY (codigoAutores) REFERENCES AUTORES (codigoAutores)
	FOREIGN KEY (codigoSocio) REFERENCES SOCIOS (codigoSocio)
);