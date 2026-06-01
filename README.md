# Sistema de Sorteo de Torneos

## Descripción
Proyecto desarrollado para la asignatura de **Programación Orientada a Objetos**.

El sistema permite realizar sorteos aleatorios de enfrentamientos entre equipos para torneos de eliminación directa en diferentes etapas: octavos de final, cuartos de final, semifinales y final. Aplica principios de código limpio, SOLID, arquitectura MVC y persistencia en archivos CSV.

## Cambios Realizados
Durante la complementación del proyecto desde la Unidad 3 se implementaron las siguientes mejoras:

- **Manejo de archivos**: Persistencia de torneos mediante archivo CSV (`TorneoRepositorioArchivo`).
- **Refactorización del código**: División de métodos largos, nombres claros y eliminación de duplicación.
- **Aplicación de principios SOLID**: SRP, OCP, LSP, ISP, DIP implementados en toda la arquitectura.
- **Arquitectura MVC**: Separación clara entre Modelo, Vista y Controlador.
- **Pruebas unitarias**: Validación de casos normales y límite con `TorneoTest.java`.
- **Generación automática**: El archivo `torneos.csv` se crea automáticamente en la carpeta `datos/`.

## Estructura del Proyecto

### Modelo
- `Equipo.java` - Representa un equipo participante
- `Partido.java` - Representa un enfrentamiento entre dos equipos
- `Torneo.java` - Lógica del sorteo recursivo

### Vista
- `ConsolaVista.java` - Interfaz de usuario por consola

### Controlador
- `TorneoControlador.java` - Coordina la comunicación entre modelo y vista

### Persistencia
- `ITorneoRepositorio.java` - Interfaz para operaciones de persistencia
- `TorneoRepositorioArchivo.java` - Implementación con archivos CSV
- `PersistenciaException.java` - Manejo de excepciones personalizadas

### Pruebas
- `TorneoTest.java` - Pruebas unitarias (6 casos: normales y límite)

## Requisitos
- Java JDK 17 o superior
- Apache NetBeans
- Git (opcional, para clonar)

## Cómo Clonar el Proyecto
Ejecutar el siguiente comando:

```bash
git clone https://github.com/Alan-Ramon2/Ramon_Alan_POO_U4.git
