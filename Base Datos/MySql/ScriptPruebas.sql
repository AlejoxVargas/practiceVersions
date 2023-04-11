select greatest(1,2,4,"ab90ab",21,3,"ab91ab");
select 19 not in (1,18,3,6);
select isnull (@a);
select @a is null;
set @x = 25;
select interval(@x,5,15,20,25);
select interval ("Gerardo","Antonio","Fernando","Javier","Ramon"); /*No sirve para los intervalos de tipo texto*/
set @a = 3;
select case @a when 1 then "uno"
when 2 then "varios"
else "muchos" end;

select "Hola" like "HOLA"; /*No distingue entre MAS y MINUS*/

select "PEPE%32" like "____\%_"; /*la barra significa para buscar el caracter '%' especifico y que no lo tome como si fuera un "lo que sea"*/
/*pepe%32 (que es mi texto) -> tiene 4 caracteres '____' y un '%' y dos caracteres mas '__' pero para que no lo confunda el '%' como un 'lo que sea,
el barra '\%' busca un caracter en concreto en este caso (contra slahs) \%'*/

select "PEPE%32" like "_%";

select "PEPE%32" like "____!%__" escape "!"; /*MySQL nos permite usar otros caracteres para crear secuencias de escape, para eso se usa la cláusula opcional ESCAPE:*/

select "PEPE%32" not like "____!%__" escape "!";
select not ("PEPE%32" like "____!%__" escape "!"); /*se debe poner el parentesis para negar toda la expresion dentro del not*/

select 'a' regexp '^[a-d]';

/*----CASTING-----*/
/*Solo hay 1 --- BINARY*/
select 'a' = 'A', 'a' = binary 'A'; /*Esto es muy bueno cuando queremos diferenciar entre mayusculas y minusculas*/

SET PASSWORD = 'auth_string';
SELECT CURRENT_USER();
select password("Ana");