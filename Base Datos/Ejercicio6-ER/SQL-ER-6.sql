CREATE TABLE PACIENTE(
codPaciente INTEGER,
nombre TEXT,
apellido TEXT,
direccion TEXT,
provincia TEXT,
poblacion TEXT, 
codigoPostal INTEGER,
telefono TEXT,
PRIMARY KEY (codPaciente)
);

CREATE TABLE MEDICO(
codMedico INTEGER,
nombre TEXT,
apellido TEXT,
telefono TEXT,
especialidad TEXT,
PRIMARY KEY (codMedico)
);

CREATE TABLE INGRESO (
codIngreso INTEGER,
habitacion TEXT,
cama TEXT,
fechaIngreso TEXT,
codPaciente INTEGER,
codMedico INTEGER,
PRIMARY KEY (codIngreso),
FOREIGN KEY (codPaciente) REFERENCES PACIENTE (codPaciente)
FOREIGN KEY (codMedico) REFERENCES MEDICO (codMedico)
);

INSERT INTO PACIENTE VALUES (1,"Tania","Velasquez", "calle serrano", "Madrid", "Madrid",2887,"231232131");
INSERT INTO MEDICO VALUES (10, "Pablo", "Escobar","null","anestesiologia");
INSERT INTO INGRESO VALUES (123,"12","1","00/00/00",1,10);