La app es realizada a travez de spring boot, Maven para el manejo de las dependencias, 
la Base de datos es relacional realizada en PosgreSql, la aplicacion tiene las siguientes funcionalidades: 

1) Buscar libro por titulo: se ingresa el titulo del libro, y se realiza su busqueda en la api externa Gutendex, 
   si la busqueda es positiva, se extrae los siguientes datos:
   a) titulo del libro
   b) nombre completo del autor, se toma el primer autor 
   c) numero de descarga del libro
   d) idioma del libro, se toma el primer idioma
   e) año nacimiento del autor 
   f) año fallecimiento del autor

Con estos datos se crean:
El objeto libroBd que contiene los siguientes datos: id, titulo del libro, autor, idioma, numero de descargas.
El objeto autorBd que contiene los siguientes datos: id, nombre_autor, año nacimiento, año fallecimiento.
Si el libro y el autor no existen en la base de datos se los guardan, solo se guardan los autores y libros que 
no existen en la base de datos.

2) Listar libros registrados: lista los libros que se buscaron en la api gutendex y se guardaron en la base de datos.                 

3) Listar autores registrados: lista los autores que se buscaron en la api gutendex y se guardaron en la base de datos.                  

4) Listar autores vivos en un determinado año: muestra una lista de los autores vivos, en un determinado año ingresado,
   que estan guardados en la base de datos.

5) Listar libros por idioma: muestra una lista de los libros que estan en un determinado idioma ingresado, las opciones
   son: en:ingles, fr:frances , es: español, los idiomas que figuran en la base de datos.                   

6) Listar top 10 libros mas descargados: se muestra una lista de los 10 libros mas descargados que estan almacenados en
   la base de datos.       

7) Listar libros por nombre de autor: se ingresa el nombre de un autor, primero se ingresa el apellido y despues el 
   nombre del autor, y se muestra una lista de los libros almacenados en la base de datos de ese autor.         

8) otras consultas: esta opcion contiene tres opciones:
   1) promedio de libros descargados: muestra el promedio de descarga de los libros guardados en la base de datos
   2) libro mas leido: muestra el libro que mas se leyo.
   3) libro menos leido: muestra el libro que menos se leyo.

 Base de Datos: la base de datos contiene las siguientes tablas:
 
 1) tabla librosBd: contiene las siguientes columnas:
   a) id
   b) titulo del libro
   c) autor 
   d) idioma
   e) numero_descarga
El titulo del libro no se repite en la tabla librosBd
1) tabla autoresBd: contiene las siguientes columnas:
   a) id
   b) nombre_autor  
   c) año_nacimiento
   d) año_fallecimiento
El nombre_autor no se repite en la tabla autoresBd

Entre las tablas existe una relacion ManyToOne - OneToMany, definida en el codigo, donde un autor tiene
uno o varios libros en la tabla librosBd, uno o varios libros tienen un solo autor en la tabla autoresBd. 