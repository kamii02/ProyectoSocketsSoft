# Sistema de Bola en Red con Sockets (Pong Distribuido)

## Descripción del Proyecto

Este proyecto implementa un sistema de comunicación en red mediante **sockets TCP** que permite sincronizar el movimiento de una bola entre dos computadoras a través de una interfaz gráfica desarrollada con **Java Swing**.

El sistema permite:
- Visualizar una bola animada que se mueve en un panel gráfico.
- Transferir la bola de una máquina a otra cuando sale de la pantalla.
- Sincronizar posición vertical (`y`) y velocidad vertical (`vy`) entre cliente y servidor.
- Configurar la dirección IP y el puerto mediante archivos de propiedades.
- Crear la bola usando el patrón **Factory Method** con soporte de imagen personalizada.
- Notificar cambios de estado de la bola mediante el patrón **Observer**.

El desarrollo está orientado a aplicar principios de **Programación Orientada a Objetos**, **patrones de diseño** y comunicación en red con **sockets en Java**.

---

### Estructura del Repositorio

El proyecto está dividido en dos módulos Maven independientes:

```
ProyectoSocketsSoft/
├── server_sockets/          → Aplicación del servidor
│   └── src/main/java/org/kami/
│       ├── Main.java
│       ├── ballSettings/
│       │   ├── animacion/   → HiloAnimacion
│       │   ├── config/      → ConfigBola, PropertiesManager, IConfigReader
│       │   ├── factory/     → CreadorBola, CreadorBolaImagen
│       │   ├── modelo/      → Bola, EstadoBola
│       │   ├── observer/    → ObserverBola, SubjectBola
│       │   └── vista/       → PanelBolas, VentanaBolas
│       └── networkService/  → Server, ListenService, SendService, IOnDataReceived
│
└── cliente_socket/          → Aplicación del cliente
    └── src/main/java/org/kami/
        ├── Main.java
        ├── ballSettings/    → (misma estructura que servidor)
        └── networkService/  → Client, ListenService, SendService, IOnDataReceived
```

---

## Patrones de Diseño Aplicados

### Factory Method
La creación de la bola está desacoplada mediante una jerarquía de fabricas:
- `CreadorBola` → clase abstracta que define el método `crearBola()`
- `CreadorBolaImagen` → implementación concreta que carga una imagen y construye la bola

### Observer
La clase `Bola` implementa `SubjectBola` y notifica a sus observadores ante dos eventos:
- `onBolaMovida(EstadoBola)` → actualiza la posición en el panel
- `onBolaSalio(EstadoBola)` → envía los datos al otro equipo vía socket

`PanelBolas` implementa `ObserverBola` y reacciona a ambos eventos para redibujar la interfaz o transmitir la bola en red.

---

## Principios de Diseño Aplicados

### Programación Orientada a Objetos (POO)
- Encapsulamiento
- Herencia
- Polimorfismo
- Abstracción

### Principios SOLID

- **S** - Single Responsibility Principle  
  Cada clase tiene una única responsabilidad: `Bola` maneja la lógica de movimiento, `PanelBolas` maneja la vista, `SendService` y `ListenService` manejan exclusivamente la red.

- **O** - Open/Closed Principle  
  Se pueden agregar nuevos tipos de bola sin modificar `CreadorBola` ni el sistema base.

- **L** - Liskov Substitution Principle  
  `CreadorBolaImagen` puede sustituir a `CreadorBola` sin alterar el comportamiento esperado.

- **I** - Interface Segregation Principle  
  Las interfaces están separadas por responsabilidad: `ObserverBola`, `SubjectBola`, `IConfigReader`, `IOnDataReceived`.

- **D** - Dependency Inversion Principle  
  Los componentes dependen de abstracciones (`IConfigReader`, `ObserverBola`, `IOnDataReceived`), no de implementaciones concretas.

---

## Tecnologías Utilizadas

- Java 17
- Maven
- Java Swing (interfaz gráfica)
- Sockets TCP (`java.net.Socket`, `java.net.ServerSocket`)
- Programación multihilo (`Thread`, `CountDownLatch`)
- Arquitectura modular por paquetes
- Patrones de diseño: Factory Method y Observer

---

## Versión del Proyecto

- Versión: 1.0.0
- Tipo: Proyecto de Sockets
- Gestión de dependencias: Maven

---

## Instalación y Ejecución

### Requisitos previos

Antes de ejecutar el proyecto debes tener instalado:

- Java 17 o superior
- Maven
- Git
- Un IDE (IntelliJ IDEA recomendado)

Puedes verificar las versiones con:

```bash
java -version
mvn -version
git --version
```

### Clonar el repositorio

```bash
git clone https://github.com/kamii02/ProyectoSocketsSoft.git
```

### Actualizar el proyecto

Para traer los últimos cambios del repositorio remoto:

```bash
git pull origin develop
```

---

## Configuración de Red

Cada módulo tiene su propio archivo `application.properties` en `src/main/resources/`.

**Servidor** (`server_sockets/src/main/resources/application.properties`):
```properties
server.port = 5000
bola.activa = true
```

**Cliente** (`cliente_socket/src/main/resources/application.properties`):
```properties
server.address = 192.168.1.8
server.port = 5000
bola.activa = false
```

> Reemplaza `server.address` con la IP real de la máquina que ejecuta el servidor.  
> Solo uno de los dos inicia con `bola.activa = true` (quien lanza primero la bola).

---

## Ejecución

### 1. Compilar cada módulo

```bash
# En server_sockets/
mvn clean package

# En cliente_socket/
mvn clean package
```

### 2. Ejecutar el servidor primero

```bash
cd server_sockets
mvn exec:java
```

### 3. Ejecutar el cliente en otra máquina

```bash
cd cliente_socket
mvn exec:java
```

> El servidor queda en espera hasta que el cliente se conecta. Una vez conectados, la bola comienza a moverse y se transfiere entre ambas ventanas cuando sale de la pantalla.

---

## Autores

- Juan David Gomez 
- Emmanuel Penuela
- Camila Prada
- Manuel Noreña
