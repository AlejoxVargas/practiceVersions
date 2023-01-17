CREATE TABLE CAMIONEROS (
dni TEXT,
nombre TEXT not null,
telefono TEXT,
salario NUMERIC,
direccion TEXT not null,
poblacion TEXT,
PRIMARY KEY ("dni")
);

CREATE TABLE PROVINCIAS (
codigo INTEGER,
nombre TEXT not null,
PRIMARY KEY ("codigo")
);

CREATE TABLE CAMIONES (
matricula TEXT,
modelo TEXT not null,
tipo TEXT not null,
potencia INTEGER null,
PRIMARY KEY("matricula")
);

CREATE TABLE PAQUETE (
codigo TEXT,
descripccion TEXT not null,
destinatario TEXT not null,
direccion TEXT not null,
dniCamionero TEXT,
codigoProvincia INTEGER,
PRIMARY KEY (codigo)
FOREIGN KEY dniCamionero REFERENCES CAMIONEROS(dni)
FOREIGN KEY codigoProvincia REFERENCES PROVINCIAS(codigo)
);

CREATE TABLE CONDUCIR (
dniCamionero TEXT,
matriculaCamion TEXT,
Fecha TEXT NOT NULL,
PRIMARY KEY ("dniCamionero","matricula_Camion","Fecha")
FOREIGN KEY ("dniCamionero") REFERENCES CAMIONEROS (dni)
FOREIGN KEY matriculaCamion REFERENCES CAMIONES (matricula)
);