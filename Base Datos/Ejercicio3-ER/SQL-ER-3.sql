CREATE TABLE PROFESORES (
	dni TEXT,
	nombre TEXT NOT NULL,
	direccion TEXT NOT NULL,
	telefono TEXT NOT NULL,
	PRIMARY KEY (dni)
);

CREATE TABLE MODULOS (
	codigo INTEGER,
	nombre TEXT NOT NULL,
	dni TEXT,
	PRIMARY KEY (codigo AUTOINCREMENT),
	FOREIGN KEY (dni) REFERENCES PROFESORES (dni)
);

CREATE TABLE ESTUDIANTE (
	nExpediente TEXT,
	nombre TEXT NOT NULL,
	apellido TEXT NOT NULL,
	fechaNacimiento TEXT NOT NULL,
	PRIMARY KEY (nExpediente)
);

CREATE TABLE MATRICULA (
	codigo INTEGER,
	nExpediente TEXT,
	PRIMARY KEY ("codigo","nExpediente"),
	FOREIGN KEY ("codigo") REFERENCES MODULOS (codigo)
	FOREIGN KEY (nExpediente) REFERENCES ESTUDIANTE(nExpediente)
);

CREATE TABLE DELEGADO (
	nExpAlumno TEXT,
	curso TEXT NOT NULL,
	PRIMARY KEY (nExpAlumno),
	FOREIGN KEY (nExpAlumno) REFERENCES ESTUDIANTE(nExpediente)
);

INSERT INTO PROFESORES VALUES ("2347668A","Juan Carrazco","Calle chamartin 13","658978588");
INSERT INTO PROFESORES VALUES ("2325324S","Maria Serrano","Calle todelo 45","658973432");
INSERT INTO PROFESORES VALUES ("1232432Z","Fernando Atocha","Calle juan ignacio 22","648867586");
INSERT INTO PROFESORES VALUES ("46745343G","Ester Exposito","Calle elite 20","658748598");
INSERT INTO PROFESORES VALUES ("12453252D","Lily Collins","Calle paris 10","624589568");

INSERT INTO MODULOS VALUES ("58758", "Programación","2347668A");
INSERT INTO MODULOS VALUES ("58759", "Base de Datos","2325324S");
INSERT INTO MODULOS VALUES ("58760", "Sistemas Informaticos","1232432Z");
INSERT INTO MODULOS VALUES ("58761", "Lenguajes de marcas","46745343G");
INSERT INTO MODULOS VALUES ("58762", "Entornos de Desarrollo","12453252D");

INSERT INTO ESTUDIANTE VALUES ("50230","Javier", "Velazque","01/02/00");
INSERT INTO ESTUDIANTE VALUES ("50231","Luis", "Serrano","01/03/03");
INSERT INTO ESTUDIANTE VALUES ("50232","Tania", "Toledo","01/04/03");
INSERT INTO ESTUDIANTE VALUES ("50233","Laura", "Lopez","01/05/03");
INSERT INTO ESTUDIANTE VALUES ("50234","Mey", "Ojeda","01/06/03");

INSERT INTO MATRICULA VALUES ("58758","50230");
INSERT INTO MATRICULA VALUES ("58759","50231");
INSERT INTO MATRICULA VALUES ("58760","50232");
INSERT INTO MATRICULA VALUES ("58761","50233");
INSERT INTO MATRICULA VALUES ("58762","50234");

INSERT INTO DELEGADO VALUES ("50230","DAM 1");
INSERT INTO DELEGADO VALUES ("50231","DAW 1");
INSERT INTO DELEGADO VALUES ("50232","ASIR 1");
INSERT INTO DELEGADO VALUES ("50233","MARKETING 1");
INSERT INTO DELEGADO VALUES ("50234","DAM 2");