PowerGym Manager

Descripción del sistema

PowerGym Manager es una aplicación de escritorio desarrollada en Java con interfaz gráfica (Swing) para la gestión administrativa de un gimnasio. Permite registrar socios, llevar el control de su evaluación física (cálculo automático de IMC), gestionar membresías (Básica y VIP), administrar un inventario de polos (kit de bienvenida) y un catálogo de suplementos, y registrar las ventas de suplementos a los socios.

Actualmente la versión del código Java incluida en este repositorio maneja toda la información en memoria durante la ejecución (no persiste datos al cerrar la aplicación). El proyecto contempla además la implementación de una base de datos en SQL Server para dar persistencia real a socios, instructores, membresías, inventario de polos, suplementos y ventas, módulo que se encuentra en desarrollo/integración.

Objetivo

Brindar una herramienta sencilla que permita a un gimnasio centralizar la información de sus socios e instructores, controlar el stock de polos y suplementos, y automatizar el cálculo de precios y descuentos según el tipo de membresía, facilitando así la gestión diaria del negocio.

Tecnologías utilizadas

Lenguaje: Java
Interfaz gráfica: Java Swing (formularios construidos con setBounds, CardLayout y JTable)
Base de datos: SQL Server (en implementación, para persistencia de socios, instructores, membresías, inventario de polos, suplementos y ventas)
Paradigma: Programación Orientada a Objetos (herencia, encapsulamiento)
IDE de desarrollo: Apache NetBeans (el proyecto incluye su estructura de build con Ant: build.xml, nbproject/)
Control de versiones: Git

Requisitos para ejecutar el proyecto

JDK (Java Development Kit) instalado en el equipo. El proyecto está configurado para compilarse con Java 25 (javac.source / javac.target en nbproject/project.properties); puede ajustarse a una versión disponible en el equipo si es necesario.
Apache NetBeans (recomendado, ya que el proyecto trae la configuración de NetBeans/Ant lista para usar) u otro IDE/compilador compatible con proyectos Ant.
Microsoft SQL Server (junto con SQL Server Management Studio, SSMS) para la base de datos del sistema.
Driver JDBC de SQL Server (Microsoft JDBC Driver for SQL Server), necesario para que la aplicación Java se conecte a la base de datos.
Sistema operativo con soporte para Java (Windows, Linux o macOS).

Pasos para instalar y ejecutar el sistema

Clonar o descargar este repositorio en tu equipo.
(Cuando la integración con la base de datos esté lista) Ejecutar el script SQL de creación de la base de datos en SQL Server Management Studio (SSMS) y configurar la cadena de conexión de la aplicación con los datos de tu servidor (nombre de instancia, usuario/autenticación, etc.).
Abrir NetBeans.
Ir a Archivo > Abrir Proyecto y seleccionar la carpeta PowerGym Manager.
Esperar a que NetBeans reconozca el proyecto (usa la estructura estándar de NetBeans con Ant).
Ejecutar el proyecto con el botón Run (o Shift + F6 sobre la clase principal).
Se abrirá la ventana de inicio de sesión. Ingresar las credenciales de acceso:

Usuario: admin
Contraseña: 1234

Tras un inicio de sesión correcto, se abrirá la ventana principal del sistema.

Alternativamente, el proyecto puede compilarse y ejecutarse por línea de comandos usando javac y java sobre los archivos de src/powergym/manager, o mediante ant con el build.xml incluido.

Estructura básica del proyecto

PowerGym Manager/
├── build.xml                     # Script de construcción Ant
├── manifest.mf                   # Manifiesto de la aplicación
├── nbproject/                    # Configuración del proyecto NetBeans
└── src/
    └── powergym/
        └── manager/
            ├── PowerGymManager.java     # Clase principal (main), inicia la app
            ├── FrmLogin.java            # Ventana de inicio de sesión
            ├── FrmPowerGymManager.java  # Ventana principal con todos los módulos
            ├── Persona.java             # Clase base (datos personales comunes)
            ├── Socio.java                # Socio del gimnasio (hereda de Persona)
            ├── Instructor.java          # Instructor del gimnasio (hereda de Persona)
            ├── EvaluacionFisica.java    # Evaluación física y cálculo de IMC
            ├── Membresia.java           # Tipo de membresía y descuentos
            ├── GestionSocios.java       # Lógica de registro/búsqueda de socios e instructores
            ├── Polo.java                # Modelo de un polo del kit de bienvenida
            ├── InventarioPolos.java     # Lógica de inventario de polos
            ├── Suplemento.java          # Modelo de un suplemento
            └── Venta.java               # Modelo y lógica de una venta de suplemento

Funcionalidades principales implementadas

Inicio de sesión con usuario y contraseña antes de acceder al sistema.
Gestión de socios:

Registro de nuevos socios (datos personales, peso, talla, membresía, talla de polo e instructor asignado).
Validación de documento duplicado al registrar.
Búsqueda de socios por número de documento (DNI).
Listado de todos los socios registrados, con su membresía e IMC.

Evaluación física: cálculo automático del IMC y su clasificación (Bajo peso, Normal, Sobrepeso, Obesidad Grado I/II/III) a partir del peso y la talla del socio.
Membresías: manejo de membresía Básica y VIP, esta última con 15% de descuento en la compra de suplementos.
Gestión de inventario de polos:

Registro de nuevos polos (con generación automática de código).
Consulta del inventario completo con aviso de stock bajo.
Reposición (agregar stock) de polos existentes.
Entrega de un polo a un socio según talla disponible.

Gestión de suplementos:

Registro de nuevos suplementos (con generación automática de código).
Reposición de stock de suplementos.
Consulta del catálogo de suplementos.

Compra de suplementos:

Búsqueda del socio por DNI para aplicar el descuento correspondiente a su membresía.
Cálculo automático del precio final (precio base, descuento aplicado y precio final).

Registro de ventas: registro de la venta de un suplemento, con cálculo del total y descuento automático del stock vendido.
Interfaz gráfica con tema oscuro personalizado (estilo "gimnasio"), con menú de navegación por módulos (Socios, Inventario, Suplementos, Ventas, Sistema) y tablas (JTable) para visualizar la información.
Persistencia en SQL Server (en desarrollo): está planificada la conexión del sistema a una base de datos en SQL Server, de modo que la información de socios, instructores, membresías, inventario de polos, suplementos y ventas se almacene de forma permanente en lugar de mantenerse solo en memoria mientras la aplicación está abierta.

Integrantes:
AZAÑERO CAMACHO, ARAMIS ALEXANDER
ABANTO MARIN, ORLAMDO STEVENS
ABANTO POLO, GANDHI MARCO II
GALLARDO CELIS, DANIEL
TUCUMANGO QUILICHE, EVER MICAEL

Licencia

Este proyecto fue desarrollado con fines académicos, como parte de un curso universitario. Su uso está destinado al aprendizaje y no tiene fines comerciales.
