CREATE TABLE Provincia (
	Nombre TEXT NOT NULL, 
	Codigo INTEGER, 
	PRIMARY KEY (Codigo));
	
CREATE TABLE Camioneros (
		DNI TEXT, 
		Nombre TEXT NOT NULL, 
		Telefono TEXT, 
		Direccion TEXT NOT NULL, 
		Poblacion TEXT, 
		Salario NUMERIC, 
		PRIMARY KEY (DNI));
		
CREATE TABLE Camiones(
	Matricula TEXT,
	Tipo TEXT NOT NULL,
	Modelo TEXT NOT NULL,
	Potencia INTEGER,
	PRIMARY KEY (Matricula));
	
CREATE TABLE Paquetes (
	Codigo INTEGER,
	Descripcion TEXT,
	Destinatario TEXT,
	Direccion_Destinatario TEXT,
	DNI_Camionero TEXT,
	Codigo_Provincia INTEGER,
	PRIMARY KEY (Codigo)
	FOREIGN KEY (DNI_Camionero) REFERENCES Camioneros (DNI)
	FOREIGN KEY (Codigo_Provincia) REFERENCES Provincia (Codigo));

CREATE TABLE Conducir(
	DNI_Camioneros TEXT,
	Matricula_Camion TEXT,
	Fecha TEXT NOT NULL,
	PRIMARY KEY (DNI_Camioneros,Matricula_Camion,Fecha)
	FOREIGN KEY(DNI_Camioneros) REFERENCES Camioneros(DNI)
	FOREIGN KEY(Matricula_Camion) REFERENCES Camiones(Matricula));
	
INSERT INTO Provincia VALUES ("Alava",01);
INSERT INTO Provincia VALUES ("Madrid",28);

INSERT INTO Camioneros VALUES ("12345678A","Carlos Garcia","+34123456789","Calle Hermosillo 32","Madrid",1670.28);

INSERT INTO Camiones VALUES("1234AAA","756","Volvo",200);

INSERT INTO Conducir VALUES("12345678A","1234AAA","02/01/2023");
INSERT INTO Conducir VALUES("12345678A","1234AAA","03/01/2023");

INSERT INTO Paquetes VALUES(1,"Paquete 1", "Juan Fernandez","Calle Mayor 5","12345678A",01);

