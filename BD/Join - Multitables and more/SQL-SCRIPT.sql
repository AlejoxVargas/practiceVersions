--Inner join sirve para cuando tenemos aunque sea un campo en común entre las dos tablas 

----Consulta 1
SELECT 
	TrackId,
	name,
	Title 
FROM 
	tracks
INNER JOIN albums on albums.AlbumId = tracks.AlbumId;
----Consulta 2
SELECT 
	TrackId,
	name,
	tracks.AlbumId as album_id_tracks,
	albums.AlbumId as album_id_albums,
	Title
FROM
	tracks
	INNER JOIN albums on albums.AlbumId = tracks.AlbumId;

----Consulta 3 (3 tablas)
SELECT 
	TrackId,
	tracks.Name as track,
	albums.Title as album,
	artists.Name as artist
FROM
	tracks
	INNER JOIN albums on albums.AlbumId = tracks.AlbumId
	INNER JOIN artists on artists.ArtistId = albums.ArtistId;
	
----Consulta 4 (con where)
SELECT 
	TrackId,
	tracks.Name as track,
	albums.Title as album,
	artists.Name as artist,
	artists.ArtistId ---esto es solo para saber si funciona
FROM
	tracks
	INNER JOIN albums on albums.AlbumId = tracks.AlbumId
	INNER JOIN artists on artists.ArtistId = albums.ArtistId
WHERE 
	artists.ArtistId = 10;
	
----Consulta 5 (LEFT JOIN)
pending...