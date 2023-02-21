CREATE TABLE cliente (
	 id INT PRIMARY KEY,
	 nombre TEXT NOT NULL,
	 apellido1 TEXT NOT NULL,
	 apellido2 TEXT,
	 ciudad TEXT,
	 categoria INT
 );
 
CREATE TABLE comercial (
	id INT PRIMARY KEY,
	nombre TEXT NOT NULL,
	apellido1 TEXT NOT NULL,
	apellido2 TEXT,
	comision REAL
 );
 
CREATE TABLE pedido (
	id INT PRIMARY KEY,
	cantidad_total REAL NOT NULL,
	fecha TEXT,
	id_cliente INT NOT NULL,
	id_comercial INT NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	FOREIGN KEY (id_comercial) REFERENCES comercial(id)
);

	INSERT INTO cliente VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);
	INSERT INTO cliente VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);
	INSERT INTO cliente VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);
	INSERT INTO cliente VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300);
	INSERT INTO cliente VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);
	INSERT INTO cliente VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);
	INSERT INTO cliente VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);
	INSERT INTO cliente VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);
	INSERT INTO cliente VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);
	INSERT INTO cliente VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);
	
	INSERT INTO comercial VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);
	INSERT INTO comercial VALUES(2, 'Juan', 'Gómez', 'López', 0.13);
	INSERT INTO comercial VALUES(3, 'Diego','Flores', 'Salas', 0.11);
	INSERT INTO comercial VALUES(4, 'Marta','Herrera', 'Gil', 0.14);
	INSERT INTO comercial VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);
	INSERT INTO comercial VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);
	INSERT INTO comercial VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);
	INSERT INTO comercial VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);
	
	INSERT INTO pedido VALUES(1, 150.5, '2017-10-05', 5, 2);
	INSERT INTO pedido VALUES(2, 270.65, '2016-09-10', 1, 5);
	INSERT INTO pedido VALUES(3, 65.26, '2017-10-05', 2, 1);
	INSERT INTO pedido VALUES(4, 110.5, '2016-08-17', 8, 3);
	INSERT INTO pedido VALUES(5, 948.5, '2017-09-10', 5, 2);
	INSERT INTO pedido VALUES(6, 2400.6, '2016-07-27', 7, 1);
	INSERT INTO pedido VALUES(7, 5760, '2015-09-10', 2, 1);
	INSERT INTO pedido VALUES(8, 1983.43, '2017-10-10', 4, 6);
	INSERT INTO pedido VALUES(9, 2480.4, '2016-10-10', 8, 3);
	INSERT INTO pedido VALUES(10, 250.45, '2015-06-27', 8, 2);
	INSERT INTO pedido VALUES(11, 75.29, '2016-08-17', 3, 7);
	INSERT INTO pedido VALUES(12, 3045.6, '2017-04-25', 2, 1);
	INSERT INTO pedido VALUES(13, 545.75, '2019-01-25', 6, 1);
	INSERT INTO pedido VALUES(14, 145.82, '2017-02-02', 6, 1);
	INSERT INTO pedido VALUES(15, 370.85, '2019-03-11', 1, 5);
	INSERT INTO pedido VALUES(16, 2389.23, '2019-03-11', 1, 5);
	
	---------/1.3.3 Consultas sobre una tabla/---------
	
/*1. Devuelve un listado con todos los pedidos que se han realizado. Los pedidos deben estar 
ordenados por la fecha de realización, mostrando en primer lugar los pedidos más recientes.*/
SELECT * FROM pedido ORDER by fecha DESC;

/*2. Devuelve todos los datos de los dos pedidos de mayor valor.*/
SELECT * FROM pedido ORDER by cantidad_total DESC LIMIT 2;

/*3. Devuelve un listado con los identificadores de los clientes que han realizado algún pedido. Tenga En 
cuenta que no debe mostrar identificadores que estén repetidos.*/
SELECT DISTINCT id_cliente FROM pedido;

/*4. Devuelve un listado de todos los pedidos que se realizaron durante el año 2017, cuya cantidad total 
sea superior a 500€.*/
SELECT * FROM pedido where fecha like '2017%' and cantidad_total > 500;

/*5. Devuelve un listado con el nombre y los apellidos de los comerciales que tienen una comisión entre 0.05 y 0.11.*/
SELECT nombre, apellido1, apellido2 FROM comercial where comision BETWEEN 0.05 and 0.11; 

/*6. Devuelve el valor de la comisión de mayor valor que existe en la tabla comercial.*/
SELECT comision FROM comercial ORDER by comision DESC LIMIT 1;

/*7. Devuelve el identificador, nombre y primer apellido de aquellos clientes cuyo segundo apellido no es 
NULL. El listado deberá estar ordenado alfabéticamente por apellidos y nombre.*/
SELECT id, nombre, apellido1 FROM cliente WHERE apellido2 IS NOT NULL ORDER BY apellido1 ASC, nombre ASC;

/*8. Devuelve un listado de los nombres de los clientes que empiezan por A y terminan por n y también los 
nombres que empiezan por P. El listado deberá estar ordenado alfabéticamente.*/
SELECT nombre FROM cliente WHERE nombre like 'A%n' OR nombre like 'P%' ORDER BY nombre ASC;

/*9. Devuelve un listado de los nombres de los clientes que no empiezan por A. El listado deberá estar 
ordenado alfabéticamente.*/
SELECT nombre FROM cliente WHERE nombre NOT like 'A%' ORDER by nombre ASC;

/*10. Devuelve un listado con los nombres de los comerciales que terminan por "el" o "o". Tenga en cuenta que 
se deberán eliminar los nombres repetidos.*/
SELECT DISTINCT nombre FROM comercial WHERE nombre like '%el' OR nombre like '%o';

	---------/1.3.4 Consultas multitabla (Composición interna)/---------
	
--• Resuelva todas las consultas utilizando la sintaxis de SQL1 y SQL2.
	
/*1. Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado algún pedido. 
El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos.*/
SELECT DISTINCT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2
FROM cliente, pedido where pedido.id_cliente = cliente.id ORDER BY cliente.nombre ASC;

/*2. Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe mostrar todos 
los datos de los pedidos y del cliente. El listado debe mostrar los datos de los clientes ordenados alfabéticamente.*/
SELECT * FROM cliente, pedido WHERE cliente.id = pedido.id_cliente ORDER by nombre ASC;

/*3. Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado debe 
mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar los datos de los comerciales 
ordenados alfabéticamente.*/
SELECT * FROM pedido, comercial WHERE pedido.id_comercial = comercial.id ORDER by nombre ASC;

/*4. Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con los datos de los 
comerciales asociados a cada pedido.*/
SELECT * FROM cliente, pedido, comercial WHERE cliente.id = pedido.id_cliente and comercial.id = pedido.id_comercial;

/*5. Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya cantidad esté entre 
300 €y 1000 €.*/
SELECT * FROM cliente, pedido where pedido.id_cliente = cliente.id and pedido.fecha like '2017%' and pedido.cantidad_total BETWEEN 300 and 1000;

/*6.Devuelve el nombre y los apellidos de todos los comerciales que ha participado en algún pedido realizado por 
María Santana Moreno.*/
SELECT DISTINCT comercial.nombre, comercial.apellido1, comercial.apellido2 
FROM comercial, pedido, cliente 
WHERE pedido.id_comercial = comercial.id and pedido.id_cliente = cliente.id and 
cliente.nombre in ('María') and cliente.apellido1 in ('Santana') and cliente.apellido2 in ('Moreno');

/*7. Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega.*/
SELECT DISTINCT cliente.nombre, cliente.apellido1, cliente.apellido2
FROM comercial, pedido, cliente 
WHERE pedido.id_comercial = comercial.id and pedido.id_cliente = cliente.id and 
comercial.nombre like 'Daniel' and comercial.apellido1 like 'Sáez' and comercial.apellido2 like 'Vega';

	---------/1.3.5 Consultas multitabla (Composición Externa)/---------
	
--• Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.

/*1 Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este 
listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar 
ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.*/

SELECT * FROM cliente
LEFT JOIN pedido on pedido.id_cliente = cliente.id
ORDER BY cliente.apellido1 ASC, cliente.apellido2 ASC, cliente.nombre ASC;

/*Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado. 
Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe 
estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.*/
SELECT * FROM comercial
LEFT JOIN pedido on comercial.id = pedido.id_comercial
ORDER BY comercial.apellido1 ASC, comercial.apellido2 ASC, comercial.nombre ASC;

/*3. Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.*/
SELECT * FROM cliente 
LEFT JOIN pedido on cliente.id = pedido.id_cliente
WHERE pedido.id_cliente IS NULL;

/*4. Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.*/
SELECT * FROM comercial 
LEFT JOIN pedido on pedido.id_comercial = comercial.id
WHERE pedido.id_comercial IS NULL;

/*5. Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no 
han participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el nombre. En 
en listado deberá diferenciar de algún modo los clientes y los comerciales.*/
SELECT * FROM cliente, comercial
LEFT JOIN pedido on pedido.id_cliente = cliente.id
LEFT JOIN comercial on pedido.id_comercial = comercial.id
WHERE pedido.id_cliente IS NULL and pedido.id_comercial IS NULL
ORDER BY; --lo dejaré pendiente

/*6. ¿Se podrían realizar las consultas anteriores con NATURAL LEFT JOIN o NATURAL RIGHT JOIN? 
Justifique su respuesta.*/
--NO, porque no tienen el mismo nombre de columna

	---------/1.3.6 Consultas Resumen/---------

/*1. Calcula la cantidad total que suman todos los pedidos que aparecen en la tabla pedido.*/
SELECT sum (cantidad_total)  as 'Suma total Pedidos' FROM pedido;

/*2. Calcula la cantidad media de todos los pedidos que aparecen en la tabla pedido.*/
SELECT avg (cantidad_total)  as 'Media total' FROM pedido;

/*3. Calcula el número total de comerciales distintos que aparecen en la tabla pedido.*/
SELECT count (DISTINCT id_comercial) as 'Total comerciales distintos' FROM pedido;

/*4. Calcula el número total de clientes que aparecen en la tabla cliente.*/
SELECT count (*) as 'Total clientes' FROM cliente;

/*5. Calcula cuál es la mayor cantidad que aparece en la tabla pedido.*/
SELECT max (cantidad_total) FROM pedido; --Primera forma
SELECT cantidad_total FROM pedido ORDER by cantidad_total DESC LIMIT 1; --Segunda forma

/*6. Calcula cuál es la menor cantidad que aparece en la tabla pedido.*/
SELECT min (cantidad_total) FROM pedido; --Primera forma
SELECT cantidad_total FROM pedido ORDER by cantidad_total ASC LIMIT 1; --Segunda forma

/*7. Calcula cuál es el valor máximo de categoría para cada una de las ciudades que aparece en la tabla 
cliente.*/
SELECT max(categoria) as 'Maximo categoria' FROM cliente;

/*8. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los 
clientes. Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes cantidades el 
mismo día. Se pide que se calcule cuál es el pedido de máximo valor para cada uno de los días en los 
que un cliente ha realizado un pedido. Muestra el identificador del cliente, nombre, apellidos, la fecha 
y el valor de la cantidad.*/
SELECT count(pedido.fecha) as 'Numero de Pedidos', cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, pedido.fecha, max(pedido.cantidad_total) as 'Maximo valor'
FROM cliente
LEFT JOIN pedido on pedido.id_cliente = cliente.id
GROUP by cliente.nombre, pedido.fecha;

/*9. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los 
clientes, teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la cantidad de 
2000 €.*/
SELECT count (cliente.id) as 'Pedido Realizados', cliente.nombre, cliente.apellido1, cliente.apellido2, pedido.fecha,  max(pedido.cantidad_total) as 'Maximo valor'
FROM cliente
LEFT JOIN pedido on pedido.id_cliente = cliente.id
WHERE pedido.cantidad_total > 2000
GROUP by cliente.nombre, pedido.fecha;

/*10 Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha 
2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total.*/
SELECT max(cantidad_total) 'Valor', comercial.id, comercial.nombre, comercial.apellido1, comercial.apellido2
FROM comercial
LEFT JOIN pedido on pedido.id_comercial = comercial.id
WHERE pedido.fecha in ('2016-08-17');

/*11 Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos 
que ha realizado cada uno de clientes. Tenga en cuenta que pueden existir clientes que no han 
realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando que el número 
de pedidos realizados es 0.*/
SELECT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, count (pedido.id_cliente) as 'Total pedidos'
FROM pedido
RIGHT JOIN cliente on pedido.id_cliente = cliente.id
GROUP by cliente.id;

/*12 Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos 
que ha realizado cada uno de clientes durante el año 2017.*/
SELECT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, count (pedido.id_cliente) as 'Total pedidos'
FROM pedido
RIGHT JOIN cliente on pedido.id_cliente = cliente.id
WHERE pedido.fecha like ('2017%')
GROUP by pedido.id_cliente;

/*13.  Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor de la 
máxima cantidad del pedido realizado por cada uno de los clientes. El resultado debe mostrar aquellos 
clientes que no han realizado ningún pedido indicando que la máxima cantidad de sus pedidos 
realizados es 0. Puede hacer uso de la función IFNULL.*/
SELECT cliente.id, cliente.nombre, cliente.apellido1, max (pedido.cantidad_total) as 'Maxima Cantidad'
FROM cliente
LEFT JOIN pedido on pedido.id_cliente = cliente.id
GROUP by cliente.id;

/*14. Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.*/
SELECT substr (pedido.fecha,1,4) as 'Año', max (pedido.cantidad_total) as 'Maximo valor' FROM pedido GROUP by substr (pedido.fecha, 1,4);

/*15. Devuelve el número total de pedidos que se han realizado cada año.*/
SELECT substr (pedido.fecha,1,4) as 'Año', count (pedido.id) as 'Pedidos Totales' FROM pedido GROUP BY substr (pedido.fecha, 1,4);

	---------/1.3.7 Subconsultas/---------

/*1. Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz. (Sin utilizar INNER JOIN).*/
SELECT * FROM pedido WHERE id_cliente = (SELECT cliente.id FROM cliente WHERE nombre = 'Adela' and apellido1 = 'Salas' and apellido2 = 'Díaz');

/*2. Devuelve el número de pedidos en los que ha participado el comercial Daniel Sáez Vega. (Sin utilizar INNER JOIN)*/
SELECT count (*) as 'Pedidos' FROM pedido WHERE id_cliente = (SELECT comercial.id FROM comercial WHERE nombre = 'Daniel' and apellido1 = 'Sáez' and apellido2 = 'Vega');

/*3. Devuelve los datos del cliente que realizó el pedido más caro en el año 2019. (Sin utilizar INNER JOIN)*/
SELECT * FROM cliente WHERE cliente.id = (SELECT pedido.id_cliente FROM pedido WHERE cantidad_total = (SELECT max(pedido.cantidad_total) FROM pedido WHERE pedido.fecha like '2019%'));

/*4. Devuelve la fecha y la cantidad del pedido de menor valor realizado por el cliente Pepe Ruiz Santana.*/
SELECT pedido.fecha, pedido.cantidad_total FROM cliente INNER JOIN pedido on cliente.id = pedido.id_cliente where cliente.nombre = 'Pepe' 
and cliente.apellido1 = 'Ruiz' and cliente.apellido2 = 'Santana' and pedido.cantidad_total = (SELECT min (pedido.cantidad_total )
FROM pedido INNER JOIN cliente on cliente.id = pedido.id_cliente WHERE cliente.nombre = 'Pepe' 
and cliente.apellido1 = 'Ruiz' and cliente.apellido2 = 'Santana');

/*5. Devuelve un listado con los datos de los clientes y los pedidos, de todos los clientes que  han realizado un pedido durante el año 2017 con un 
valor mayor o igual al valor medio de los pedidos realizados durante ese mismo año.*/
SELECT * FROM cliente INNER JOIN pedido on pedido.id_cliente = cliente.id WHERE pedido.fecha like '2017%' and 
pedido.cantidad_total >= (SELECT avg (pedido.cantidad_total) FROM pedido WHERE pedido.fecha like '2017%');

--1.3.7.2 Subconsultas con ALL y ANY

/*6. Devuelve el pedido más caro que existe en la tabla pedido si hacer uso de MAX, ORDER BY ni LIMIT.*/
SELECT * FROM pedido WHERE cantidad_total >= all(SELECT cantidad_total FROM pedido); --falta
