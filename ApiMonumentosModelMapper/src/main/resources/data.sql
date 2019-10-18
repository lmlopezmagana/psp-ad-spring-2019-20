INSERT INTO PAIS(ID, NOMBRE, CODIGO_ISO) VALUES(NEXTVAL('hibernate_sequence'), 'España', 'Es');
INSERT INTO PAIS(ID, NOMBRE, CODIGO_ISO) VALUES(NEXTVAL('hibernate_sequence'), 'Francia', 'Fr');
INSERT INTO PAIS(ID, NOMBRE, CODIGO_ISO) VALUES(NEXTVAL('hibernate_sequence'), 'Italia', 'It');
INSERT INTO PAIS(ID, NOMBRE, CODIGO_ISO) VALUES(NEXTVAL('hibernate_sequence'), 'Estados Unidos', 'USA');

INSERT INTO MONUMENTO (ID, PAIS_ID, CIUDAD, LATITUD, LONGUITUD, NOMBRE, DESCRIPCION) VALUES(NEXTVAL('hibernate_sequence'), 1, 'Sevilla', '37.386332', '-5.992517', 'Giralda', 'Está constituida por dos cuerpos diferentes aunque perfectamente unidos, mostrando un ejemplo perfecto del crisol de culturas existente en la ciudad');
INSERT INTO MONUMENTO (ID, PAIS_ID, CIUDAD, LATITUD, LONGUITUD, NOMBRE, DESCRIPCION) VALUES(NEXTVAL('hibernate_sequence'), 2, 'París', '48.858596', '2.294462', 'Torre Eiffel', 'La Torre Eiffel está construida en el eje de los Campos de Marte en París, que está orientado aproximadamente a 45 ° del meridiano');
INSERT INTO MONUMENTO (ID, PAIS_ID, CIUDAD, LATITUD, LONGUITUD, NOMBRE, DESCRIPCION) VALUES(NEXTVAL('hibernate_sequence'), 2, 'París', '48.853166', '2.350342', 'Catedral de Notre Dame', 'Se edificó a partir del año 1163, siendo el más notable de los edificios franceses del Gótico Temprano');
INSERT INTO MONUMENTO (ID, PAIS_ID, CIUDAD, LATITUD, LONGUITUD, NOMBRE, DESCRIPCION) VALUES(NEXTVAL('hibernate_sequence'), 3, 'Roma', '41.890482', '12.492800', 'Coliseo Romano', 'Fue el edificio más grande construido por Roma, razón por la cual desde el Renacimiento se le ha considerado un modelo arquitectónico');
INSERT INTO MONUMENTO (ID, PAIS_ID, CIUDAD, LATITUD, LONGUITUD, NOMBRE, DESCRIPCION) VALUES(NEXTVAL('hibernate_sequence'), 4, 'Nueva York', '40.689441', '-74.044275', 'Estatua de la libertad', 'Esta estatua trajo alegría, miedo, pero sobre todo la esperanza de una vida mejor que la que se vivía en la vieja Europa en ese momento.');

INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://lh5.googleusercontent.com/p/AF1QipNaEBqu4MTMHYTQquofcyrKXWsBeT4Iv7ZOS0rq=w408-h725-k-no', 5);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://miviaje.com/wp-content/uploads/2018/02/giralda-de-sevilla.jpg', 5);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'http://blog.ticketea.com/wp-content/uploads/2018/02/giralda.jpg', 5);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://www.hola.com/imagenes/viajes/20190614143996/catedral-sevilla-giralda/0-691-393/catedral-puertas-giralda-sevilla-a.jpg', 5);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://rec-end.elnuevodia.com/images/tn/620/0/3740/2715/900/789/2018/12/06/ap18340740200829.jpg', 6);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://media.tacdn.com/media/attractions-splice-spp-674x446/06/71/2e/77.jpg', 6);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://lh5.googleusercontent.com/p/AF1QipPvwJ6_SmJX67cYATM3lqAAG9nRkWLaGopW029-=w408-h725-k-no', 6);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://lh5.googleusercontent.com/p/AF1QipNDc4Dw-9PDZjB7vJ5MKdVuifbcvBzJypdv2xwR=w408-h282-k-no',7 );
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://86087-590828-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2012/09/catedral-notre-dame-paris.jpg',7 );
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://lh5.googleusercontent.com/p/AF1QipMtKzGhCHLPCXEZ0jRwb5aFkWuHQPxyVi64O11m=w408-h276-k-no', 8);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://upload.wikimedia.org/wikipedia/commons/5/53/Colosseum_in_Rome%2C_Italy_-_April_2007.jpg', 8);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://afrodita-production.s3.amazonaws.com/images/coliseo-subterraneo-roma-m200718.original.jpg', 8);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://afrodita-production.s3.amazonaws.com/images/coliseo-subterraneo-roma-m200718.original.jpg', 8);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://lh5.googleusercontent.com/p/AF1QipMJeBK80ANM0TCDMVzNw76tLcXB39aWhsvsuHaB=w408-h710-k-no', 9);
INSERT INTO IMAGEN(ID, RUTA, MONUMENTO_ID) VALUES(NEXTVAL('hibernate_sequence'), 'https://cdn.civitatis.com/estados-unidos/nueva-york/galeria/estatua-libertad.jpg', 9);