CREATE TABLE cliente(
identificador INTEGER,
nif TEXT,
nombre TEXT,
direccion TEXT,
telefono INTEGER,
saldo_deudor NUMERIC,
saldo_clientes NUMERIC
)

INSERT INTO cliente VALUES (5000,'12345678A', 'Carmen Lozano','Calle Mayor 35',12345678,20000.3,50000.45);
INSERT INTO cliente VALUES (5001,'45620107C', 'Jose Garcia','Calle Luchana 32',34567890,40013.76,70120.49);
INSERT INTO cliente (identificador, nif, nombre, direccion, saldo_deudor)
VALUES (5007,'45620107C','Sara Lopez','Calle Suiza 78',34000.56);

INSERT INTO cliente (identificador,DNI_NIF, nombre, telefono, saldo_clientes)
VALUES (5008, '28462871P','Begoña Fernandez',781342567, 39000.32);

DELETE FROM cliente WHERE identificador = 5001;
DELETE FROM cliente WHERE identificador = 5007;
UPDATE cliente SET direccion = 'Calle Mayor 38' WHERE identificador = 5000;
UPDATE cliente SET saldo_clientes = 52345.7 WHERE identificador = 5000;
UPDATE cliente SET saldo_deudor = 34732.69 WHERE identificador = 5008;

ALTER TABLE cliente ADD COLUMN Poblacion TEXT;
ALTER TABLE cliente RENAME nif to DNI_NIF;

ALTER TABLE cliente DROP COLUMN Poblacion;

DELETE FROM cliente WHERE identificador = 5008;
DELETE FROM cliente WHERE identificador = 5001;

SELECT identificador,DNI_NIF FROM cliente where identificador BETWEEN 100 AND 200  ORDER BY DNI_NIF DESC LIMIT 1;

--Select donde el campo direccion tenga la palabra avenida
SELECT direccion FROM cliente WHERE direccion like '%avenida%';
SELECT direccion FROM cliente WHERE direccion like '%avenida R%';
SELECT direccion FROM cliente WHERE direccion like '%avenida__a%';

--Solo registros donde el identificador sea el dado así funciona el in
SELECT*FROM cliente WHERE identificador in (100,200,300);

--Operador concatena distinas condiciones AND (Y)

--Literales en un select
SELECT 'hola', 12.45;

--Funcion Upper()
SELECT upper ('Este es el texto a convertir en mayusculas') as mayusculas;

--Funcion substr
SELECT substr ('HOLA',2,3) as hola;

--Funcion length 
SELECT length ;

--Funcion INSTR 
SELECT instr ('palabra a extraer','ext' )as posicion;

--Funcion replace 
SELECT replace ('Texto original',' ','') as reemplazo;

--Concatenar textox
SELECT 'concatenando'||'tres'||'textos' as concatenancion;

--Division de columnas tipo entero
select 
