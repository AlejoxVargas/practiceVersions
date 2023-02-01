-----------------------------------------

SELECT name, Title ---no es necesaria cuando tenemos campos con diferentes nombres en las dos tablas 
	FROM artists
INNER JOIN albums on albums.ArtistId = artists.ArtistId; 
--Saldrá la relacion sin null

-----------------------------------------

SELECT name, Title 
	FROM artists
RIGHT JOIN albums on albums.ArtistId = artists.ArtistId;
--con rigth join nos dará igual que el inner debido que para crear un album necesitamos de un artista, por lo tanto 
--en esta relacion quedará igual ya que no existiran nulos debido a que no hay ningun album sin artista 

----------------------------------------

SELECT name, Title
	FROM artists
LEFT JOIN albums on albums.ArtistId = artists.ArtistId; 

--con left si me salen los null en cambio con inner solo me salen los NOT NULL, esto debido a que se puede crear un artista sin tener un album, por lo tanto habrán artistas que no tengan album y estos
--apareceran como NULL debido a que pueden haber artistas que no tengan albumns 

----------------------------------------

SELECT name, Title
	FROM artists
FULL OUTER JOIN albums on albums.ArtistId = artists.ArtistId; 

--el resultado de esto, es igual al LEFT JOIN debido que albunes es un subconjunto de artistas, porque no existe un album nulo o sin artista, en un hipotetico caso, nos saca todo, albums nulos y artistas nulos,
--mas la relacion inner. 
--teoria de conjuntos 

---------------------------------------

SELECT name, Title
	FROM artists
LEFT OUTER JOIN albums on albums.ArtistId = artists.ArtistId;
UNION ALL 

----Este se utilizaba cuando no habia RIGHT JOIN o FULL OUTER JOIN, ya que antes esta era la unica manera de ver todas la tablas, lo que hace ahora un FULL