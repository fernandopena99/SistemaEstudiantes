Características
La aplicación ofrece las siguientes funcionalidades a través de un menú interactivo:

Listar estudiantes: Muestra todos los estudiantes registrados en la base de datos.

Buscar estudiante: Permite buscar un estudiante por su ID.

Agregar estudiante: Permite agregar un nuevo estudiante a la base de datos.

Modificar estudiante: Permite actualizar la información de un estudiante existente.

Eliminar estudiante: Permite eliminar un estudiante de la base de datos.

Requisitos
Para compilar y ejecutar este proyecto, necesitas lo siguiente:

Java Development Kit (JDK): Versión 11 o superior.

Gestor de bases de datos MySQL.

MySQL Connector/J: El driver JDBC para Java. Este proyecto espera que el archivo JAR del conector esté en el classpath.

Configuración de la Base de Datos
Antes de ejecutar la aplicación, debes configurar la base de datos y la tabla necesarias.

Crea una base de datos llamada estudiantes_db en tu servidor MySQL.

Ejecuta el siguiente script SQL para crear la tabla estudiante:

SQL

CREATE TABLE estudiantes_db.estudiante (
    id_estudiante INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NULL,
    apellido VARCHAR(45) NULL,
    telefono VARCHAR(45) NULL,
    email VARCHAR(45) NULL,
    PRIMARY KEY (id_estudiante)
);
Asegúrate de que el usuario y la contraseña de la base de datos en el archivo Conexion.java coincidan con tus credenciales de MySQL. Por defecto, están configurados como:

Usuario: root

Contraseña: Pass

Puedes modificar estas credenciales en la clase Conexion.java:

Java

public static Connection getConexion(){
    // ...
    var usuario = "tu_usuario";
    var password = "tu_contraseña";
    // ...
}
Cómo Ejecutar la Aplicación
Clona este repositorio o descarga los archivos de código fuente.

Asegúrate de tener el driver MySQL Connector/J en tu classpath. Si usas un IDE como IntelliJ IDEA o Eclipse, puedes agregarlo fácilmente a las dependencias del proyecto.

Ejecuta la clase SistemaEstudiantesApp.java. El programa mostrará un menú en la consola para que interactúes con él.
