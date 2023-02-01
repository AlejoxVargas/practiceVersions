CREATE TABLE CLIENTE (
codigo INTEGER,
nif TEXT,
nombre TEXT,
direccion TEXT,
telefono TEXT,
ciudad TEXT,
PRIMARY KEY (nif)
);

CREATE TABLE COCHES (
matricula TEXT,
color TEXT,
modelo TEXT,
marca TEXT, 
precioVenta real,
nifCliente INTEGER,
PRIMARY KEY (matricula),
FOREIGN KEY (nifCliente) REFERENCES CLIENTE (nif)
);

CREATE TABLE REVISIONES (
codigo INTEGER,
frenos TEXT,
aceite TEXT,
filtros TEXT,
otros TEXT,
matriculaCoche TEXT,
PRIMARY KEY (codigo),
FOREIGN KEY (matriculaCoche) REFERENCES COCHES(matricula)
);