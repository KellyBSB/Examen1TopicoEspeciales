# Examen1TópicosEspeciales
## Explicación del proyecto y sus funcionalidades
    Explicación
- :computer: El proyecto consiste en realizar una aplicación con Android Studio y Firebase, en la cual permita a un usuario interactuar  con uno o varios usuarios mediante mensajes de texto y fotos.
- :computer: La aplicación sera probada en 3 emuladores de teléfono y 3 de tablet.
- :computer:Todos los usuarios que interactuan en el chat, son usuarios que estan registrados en las misma.
~~~
    Funcionalidad
~~~    
- :computer: Los usuarios podran enviar mensajes tanto textual como imagenes, tambien puede cambiar su imagen de perfil, cada que un usuario envie un mensaje, este monstrar la hora en la que fue envia, en este caso la aplicación esta hecha para chichas gamer, por lo tanto el chat de grupo es solo paara comunicar sobre eventos, videojuegos, hacer amigas, etc.
## En que API se desarrollo y probó.
    API en la que se desarrollo
Se desarrolo en un API 22
![API 22](https://user-images.githubusercontent.com/38759833/88226720-1f132180-cc32-11ea-9f5c-8a1c432f7db2.png)
~~~
APIs en las que se probo
~~~
Se probo en las APIs 27, 28, 29, 30
##  Modelos de celulares y tablets que fueron probados y su respectiva API.
##  Explicación de lo más importante del código 
~~~
Es necesario que en la base de datos de Firebase las reglas esten de la siguiente manera.
~~~
![Reglas del database del Firebase](https://user-images.githubusercontent.com/38759833/88232066-d875f500-cc3a-11ea-9a3e-ea108ef0915e.png)
~~~
Es necesario que en el Storage de Firebase las reglas esten de la siguiente manera.
~~~
![permisosestorage](https://user-images.githubusercontent.com/38759833/88232301-3d314f80-cc3b-11ea-95a3-66a65acced40.png)
~~~
Permisos que se deben incluir en el AndroidManifest.xml
~~~
![usespermission](https://user-images.githubusercontent.com/38759833/88232654-dd877400-cc3b-11ea-8fc7-0635a858ab48.png)

##  Manual de uso
~~~
1. Al iniciar la aplicacion aparecerá un splash Screen, esperar hasta que inicie la app.
~~~
(![inicioapp](https://user-images.githubusercontent.com/38759833/88229096-ccd3ff80-cc35-11ea-8701-9da357128787.PNG))
~~~
2. La app inicia en la parte del login, en el caso de ya estar registrado, 
llegar los campos correspondientes de manera obligatoria, caso contrario la 
app no seguir, después hacer clic en el botón de login, en el caso de no estar
registrado hacer clic en el botón registrar.
~~~
![Loginapp](https://user-images.githubusercontent.com/38759833/88229404-4c61ce80-cc36-11ea-818a-9ecc34d9e644.PNG)
~~~
3. Para registrarse es necesario llenar los tres de manera obligatoria caso 
contrario la app no dejara continuar, una vez registrado en Firebase, le 
llevara a la ventana del chat, en donde podra comunicarse con las demás 
personas pertenecientes al gurpo.
~~~
![registrarapp](https://user-images.githubusercontent.com/38759833/88229753-e7f33f00-cc36-11ea-9c30-11febf2d58cb.PNG)
~~~
4. En el chat podrá comunicarse con las personas del grupo de manera textual o 
mediante imagenes, en los tres puntitos de la parte superior derecha se encuentra 
el menu en donde hay la opción de cerrar sección.
~~~
![Chatapp](https://user-images.githubusercontent.com/38759833/88230362-e413ec80-cc37-11ea-9be5-69cfc83dfd6f.PNG)
~~~
4.1 Menu del chat, en donde puede cerrar sección
~~~
![menuchatapp](https://user-images.githubusercontent.com/38759833/88230701-816f2080-cc38-11ea-8428-b5681c165780.PNG)
~~~
4.2 Al hacer clic en la imagen se puede cambiar la foto de perfil
~~~
![chatusoperfilapp](https://user-images.githubusercontent.com/38759833/88230813-b2e7ec00-cc38-11ea-904e-b2b970a9d247.PNG)
~~~
4.3 en la parte izquierda al hacer clic encima de la imagen podrá elegir 
la imagen para mandar en el chat, en la parte central podra enviar un mensaje 
textual, y la parte derecha esta el botón para enviar el mensaje.
~~~
![chatusoapp](https://user-images.githubusercontent.com/38759833/88230927-e62a7b00-cc38-11ea-86d3-65901c8dd536.PNG)
##  Fuentes de referencia 
- :clock1: [Registro - Login - Chat](https://www.youtube.com/watch?v=VVGuTDjsgcw&list=LL&index=12)
- :clock2: [Creación de chat](https://www.youtube.com/watch?v=DFnxY_PEnYY&list=LL&index=14)
- :clock3: [Base de datos en tiempo real Firebase - Android Studio](https://www.youtube.com/watch?v=7-LrsDclHeY&list=LL&index=5)
- :clock4: [Galleria Firebase - Android Studio](https://www.youtube.com/watch?v=pNleQQhVfd0&list=LL&index=4)
- :clock5: [Galleria Firebase - Android Studio](https://www.youtube.com/watch?v=RieQ6n8Y9LI&list=LL&index=4&t=1646s)
- :clock6: [Como escribir en un Readme.md ](https://www.youtube.com/watch?v=y6XdzBNC0_0)
- :clock7: [Como insertar imagenes en el readme.md](https://www.youtube.com/watch?v=nvPOUdz5PL4)
- :clock8: [Como insertar imagenes en el readme.md](https://www.youtube.com/watch?v=SQG36GkUHzE&t=845s)
