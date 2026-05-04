Proyecto: Sistema de Contenido Audiovisual en Java (POO + MVC)
-Descripción del Proyecto

Este proyecto consiste en el desarrollo de una aplicación en Java basada en los principios de la Programación Orientada a Objetos (POO). El sistema permite gestionar distintos tipos de contenido audiovisual como películas, series, documentales y contenido de redes sociales (TikTok e Instagram).

Se aplican conceptos fundamentales como:
Herencia y polimorfismo
Clases abstractas
Relaciones entre clases (asociación, agregación y composición)
Organización mediante paquetes
Implementación del patrón arquitectónico MVC (Modelo - Vista - Controlador)

El propósito del proyecto es modelar un sistema realista de contenido audiovisual y demostrar buenas prácticas en el desarrollo de software.

-Características principales
Gestión de contenido audiovisual mediante una clase base ContenidoAudiovisual
Subclases implementadas:
Película
Serie de TV
Documental
TikTokVideo
InstagramReel
Implementación de relaciones:
Asociación - Actor (Película)
Agregación - Temporada (Serie)
Composición - Investigador (Documental)
Uso de polimorfismo para recorrer objetos
Implementación del patrón MVC con el sistema de estudiantes
Aplicación ejecutable en consola

-Instrucciones de instalación y uso
1- Clonar el repositorio

Abrir terminal o Git Bash y ejecutar:

git clone https://github.com/USUARIO/NOMBRE-REPOSITORIO.git
2- Abrir el proyecto en NetBeans
Abrir NetBeans
Ir a: File → Open Project
Seleccionar la carpeta del proyecto clonado
3- Ejecutar el programa

Ubicar la clase principal:
PruebaAV.java
Click derecho → Run File

4- Uso de la aplicación
Al ejecutar el programa, se mostrará en consola información de distintos contenidos audiovisuales:

      PELICULA      
Titulo: Interstellar
Genero: Ciencia Ficcion
Actores:
- Matthew McConaughey

      SERIE       
TItulo: Breaking Bad
Temporadas: 5
