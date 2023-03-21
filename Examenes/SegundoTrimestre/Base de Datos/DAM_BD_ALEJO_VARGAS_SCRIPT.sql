CREATE TABLE departamento (
  id INT,
  nombre TEXT NOT NULL,
  presupuesto REAL NOT NULL,
  gastos REAL NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE empleado (
  id INT,
  nif TEXT NOT NULL UNIQUE,
  nombre TEXT NOT NULL,
  apellido1 TEXT NOT NULL,
  apellido2 TEXT,
  id_departamento INT,
  PRIMARY KEY (id),
  FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

INSERT INTO departamento VALUES(1, 'Desarrollo', 120000, 6000);
INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);
INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);
INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000);
INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000);
INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0);
INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000);

INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1);
INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2);
INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3);
INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4);
INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5);
INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1);
INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2);
INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3);
INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2);
INSERT INTO empleado VALUES(10, '46384486H', 'Diego','Flores', 'Salas', 5);
INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1);
INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL);
INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL);

--------/CONSULTAS/----------
/*1.Devuelve una lista con el nombre de los departamentos que no tienen un presupuesto entre 100000 y 200000 euros. Utilizando el operador BETWEEN.*/
select nombre FROM departamento WHERE presupuesto NOT BETWEEN 100000 and 200000;

/*2.Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean mayores que el presupuesto del que disponen.*/
SELECT nombre, gastos, presupuesto FROM departamento WHERE gastos > presupuesto;

/*3.Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean iguales al presupuesto del que disponen..*/
SELECT nombre, gastos, presupuesto FROM departamento WHERE gastos = presupuesto;

/*4.Lista todos los datos de los empleados cuyo segundo apellido sea NULL.*/
SELECT * FROM empleado WHERE apellido2 IS NULL;

/*5.Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Sin utilizar el operador IN.*/
SELECT * FROM empleado WHERE apellido2 = 'Díaz' or apellido2 = 'Moreno';

/*6.Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Utilizando el operador IN.*/
SELECT * FROM empleado WHERE apellido2 IN ('Díaz') or apellido2 IN ('Moreno');

/*7.Lista los nombres, apellidos y nif de los empleados que trabajan en los departamentos 2, 4 o 5.*/
SELECT nombre, apellido1, apellido2, nif FROM empleado WHERE id_departamento = 2 or id_departamento = 4 or id_departamento = 5;

--------/CONSULTAS MULTITABLA (Composición Interna)/----------
--Resuelva todas las consultas sin usar JOIN de tablas.

/*1.Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.*/
SELECT * FROM empleado, departamento WHERE empleado.id_departamento = departamento.id;

/*2.Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno. Ordena el resultado, en primer lugar por el 
nombre del departamento (en orden alfabético) y en segundo lugar por los apellidos y el nombre de los empleados.*/
SELECT * FROM empleado, departamento WHERE empleado.id_departamento = departamento.id ORDER BY departamento.nombre and empleado.apellido1 and empleado.apellido2 and empleado.nombre ASC;

/*3.Devuelve un listado con el identificador y el nombre del departamento, solamente de aquellos departamentos que tienen empleados.*/
SELECT DISTINCT departamento.id, departamento.nombre FROM departamento, empleado WHERE empleado.id_departamento = departamento.id;

/*4.Devuelve un listado con el identificador, el nombre del departamento y el valor del presupuesto actual del que dispone, solamente de aquellos departamentos que tienen empleados. 
El valor del presupuesto actual lo puede calcular restando al valor del presupuesto inicial (columna presupuesto) el valor de los gastos que ha generado (columna gastos).*/
SELECT DISTINCT departamento.id, departamento.nombre, departamento.presupuesto - departamento.gastos as 'Presupuesto Actual' FROM departamento, empleado WHERE empleado.id_departamento = departamento.id;

/*5.Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif 38382980M.*/
SELECT departamento.nombre FROM empleado, departamento WHERE empleado.id_departamento = departamento.id AND empleado.nif like ('38382980M');

/*6.Devuelve el nombre del departamento donde trabaja el empleado Pepe Ruiz Santana.*/
SELECT departamento.nombre FROM empleado, departamento WHERE empleado.id_departamento = departamento.id AND empleado.nombre = 'Pepe' and empleado.apellido1 = 'Ruiz' and empleado.apellido2 = 'Santana';

/*7.Devuelve un listado con los datos de los empleados que trabajan en el departamento de I+D. Ordena el resultado alfabéticamente.*/
SELECT * FROM empleado, departamento WHERE empleado.id_departamento = departamento.id and departamento.nombre = 'I+D' ORDER BY empleado.nombre;

/*8.Devuelve un listado con los datos de los empleados que trabajan en el departamento de Sistemas, Contabilidad o I+D. Ordena el resultado alfabéticamente.*/
SELECT * FROM empleado, departamento WHERE empleado.id_departamento = departamento.id and departamento.nombre like 'Sistemas' or departamento.nombre like 'Contabilidad' or departamento.nombre like 'I+D' ORDER BY empleado.nombre;

/*9.Devuelve una lista con el nombre de los empleados que tienen los departamentos que no tienen un presupuesto entre 100000 y 200000 euros.*/
SELECT empleado.nombre FROM empleado, departamento WHERE empleado.id_departamento = departamento.id and departamento.presupuesto NOT BETWEEN 100000 AND 200000;

/*10.Devuelve un listado con el nombre de los departamentos donde existe algún empleado cuyo segundo apellido sea NULL. Tenga en cuenta que no debe mostrar nombres de departamentos que estén repetidos.*/
SELECT DISTINCT departamento.nombre FROM empleado, departamento WHERE empleado.id_departamento = departamento.id and empleado.apellido2 is NULL;

--------/CONSULTAS MULTITABLA (Composición Externa)/----------
--Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.

/*1.Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan. Este listado también debe incluir los empleados que no tienen ningún departamento asociado.*/
SELECT * FROM empleado 
LEFT JOIN departamento on departamento.id = empleado.id_departamento;

/*2.Devuelve un listado donde sólo aparezcan aquellos empleados que no tienen ningún departamento asociado.*/
SELECT * FROM empleado 
LEFT JOIN departamento on departamento.id = empleado.id_departamento WHERE empleado.id_departamento is NULL;

/*3.Devuelve un listado donde sólo aparezcan aquellos departamentos que no tienen ningún empleado asociado.*/
SELECT * FROM departamento 
LEFT JOIN empleado on departamento.id = empleado.id_departamento WHERE empleado.id_departamento is NULL;

/*4.Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan. El listado debe incluir los empleados que no tienen ningún 
departamento asociado y los departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.*/
SELECT * FROM empleado 
LEFT JOIN departamento on departamento.id = empleado.id_departamento
UNION ALL
SELECT * FROM departamento
LEFT JOIN empleado on departamento.id = empleado.id_departamento;

/*5.Devuelve un listado con los empleados que no tienen ningún departamento asociado y los departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.*/
SELECT * FROM empleado 
LEFT JOIN departamento on departamento.id = empleado.id_departamento WHERE empleado.id_departamento is NULL
UNION ALL
SELECT * FROM departamento
LEFT JOIN empleado on departamento.id = empleado.id_departamento WHERE empleado.id_departamento is NULL
ORDER by departamento.nombre;

--------/CREACION DE TRIGGER/----------
/*Los DNI, los nombres y apellidos de los empleados son datos importantes que no podemos perderlos aunque el empleado haya abandonado el departamento 
usando como gestor de base de datos SQLite, para ello deberás volver a cargar las tablas de la base de datos en dicho gestor.

Para proteger estos valiosos datos, utiliza un disparador para registrar el contenido de dicha información cuando se proceda a la eliminación de un empleado, 
para almacenar dicha información genera una tabla de histórico_empleados que recoja los datos de NIF, nombre, apellidos y departamento.*/

CREATE TABLE historico_empleados (
  nif TEXT PRIMARY KEY,
  old_nif TEXT,
  new_nif TEXT,
  nombre TEXT,
  old_nombre TEXT,
  new_nombre TEXT,
  apellido1 TEXT,
  old_apellido1 TEXT,
  new_apellido1 TEXT,
  apellido2 TEXT,
  old_apellido2 TEXT,
  new_apellido2 TEXT,
  id_departamento INT,
  old_id_departamento INT,
  new_id_departamento INT,
  user_action text,
  created_at text
);

CREATE TRIGGER log_empleado_after_delete
	AFTER DELETE ON empleado
	BEGIN
INSERT INTO historico_empleados (
	old_nif,
	old_nombre,
	old_apellido1,
	old_apellido2,
	old_id_departamento,
	user_action,
	created_at
)
VALUES
(
	old.nif,
	old.nombre,
	old.apellido1,
	old.apellido2,
	old.id_departamento,
	'DELETE',
	DATETIME('NOW')
) ;
END;

DELETE FROM empleado WHERE empleado.id = 13;