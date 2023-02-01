select sqrt (64);
select floor(10.2);
SELECT power (2,3) as potencia;
SELECT pi() as numeroPi;
--calcular el perimetro de un circulo
select pi()*2*5;
---calcular area del circulo
select pi() * power(2,2);
---calcular volumen de una esfera 
select 4 * pi () * power (2,3) / 3;

SELECT date ('now');
SELECT date (date ('now'),'+1 days') as 'fecha de manana'; 
SELECT date (date ('now'),'+1 months') as 'fecha ';
SELECT datetime ('now') ;
SELECT datetime('now', 'localtime');
SELECT datetime ('now','localtime','+1 days','+1 hours');
SELECT datetime ('now','localtime','+1 years','+1 months','+1 days','+1 hours','+1 minutes', '+1 seconds');

SELECT julianday('now', 'localtime') -julianday('2003-05-21');

select strftime ('%d','now ');

SELECT strftime('%d','now','localtime') || '-' || strftime('%m','now','locatime') || '-' || strftime('%Y','now','locatime') as fecha;

--Me cuenta todos los id_marcas mas no los suma
select DISTINCT (id_marca) from productos;

--Me cuenta todos los registros que tengo mas no los nulos y los suma, o sea los que no tienen id_marca
SELECT count (id_marca) from productos;

SELECT count (DISTINCT(id_marca)) from productos;

--Los orderna por orden y el DISTINCT no los ordena, es la diferencia entre

SELECT id_marca  from productos GROUP by id_marca;