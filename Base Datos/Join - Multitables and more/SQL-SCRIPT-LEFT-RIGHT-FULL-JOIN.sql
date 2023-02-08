--------MULTI TABLAS chinook-------

-----TRACKS TABLE

----/tracks - albums/------
SELECT tracks.name as "Canción", albums.Title as "Album"
FROM tracks
INNER JOIN Albums on albums.AlbumId = tracks.AlbumId;

SELECT tracks.name as "Canción", albums.Title as "Album"
FROM albums
LEFT JOIN tracks on tracks.AlbumId = albums.AlbumId;

----/tracks - genres/------

--Se pueden hacer de ambas formas
SELECT genres.Name, tracks.Name, tracks.Composer
FROM genres
INNER JOIN tracks on tracks.GenreId = genres.GenreId;

SELECT genres.Name, genres.GenreId, tracks.Name, tracks.TrackId, Composer
FROM tracks
RIGHT JOIN genres on genres.GenreId = tracks.GenreId;

