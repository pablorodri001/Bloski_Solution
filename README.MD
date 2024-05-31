# Restaurante Bloski's - README.md

## Descripción del Proyecto
Restaurante Bloski’s es una aplicación dedicada al sector hostelero. Su objetivo es brindar ayuda en la gestión de diversas áreas de un restaurante, incluyendo la gestión del personal durante los turnos de servicio, la formación de nuevos miembros del equipo y la generación de facturas durante el servicio.

## Requisitos para el Funcionamiento

Para el correcto funcionamiento de la aplicación, es indispensable contar con el siguiente software:
- **Entorno de desarrollo (IDE):** IntelliJ IDEA
- **Java JDK:** OpenJDK 20
- **Servidor de Base de Datos local:** MAMP, XAMP, WAMP
- **Gestor de dependencias:** Maven versión 3.8.5
- **Java:** Versión 21.0.2

## Instalación y Configuración

### 1. Clonar el Proyecto
Clona el proyecto usando la siguiente URL:
```bash
# SSH
git clone git@github.com:pablorodri001/TFCPRR.git

# HTTPS
git clone https://github.com/pablorodri001/TFCPRR.git

2. Iniciar el Servidor Local de Base de Datos
Inicia el servidor local de base de datos y abre phpMyAdmin o MySQL Workbench. Luego, ejecuta el script SQL que se encuentra en la carpeta principal del proyecto llamado Restaurantes_Bloski's.sql.

3. Configuración en IntelliJ IDEA
Abre el proyecto en IntelliJ IDEA:

Dirígete al archivo de configuración hibernate.cfg.xml y modifica el puerto localhost:8889 si tu servidor local usa un puerto diferente.
Modifica el campo de password con tus credenciales de inicio de sesión en el servidor MySQL.
4. Ejecutar la Aplicación
Navega a la clase principal dentro del paquete src/main/java/com.example.MainPackage, llamada Restaurantes_bloski.
Haz clic en el botón de ejecución para desplegar la interfaz principal.

5. Configuración de Correo Electrónico
Para la funcionalidad del apartado de "Generar Pedido" dentro de la sección de pedidos, cambia el correo de destino por el de interés en la clase PedidosController en la línea 223.

Precauciones
Es imperativo asegurarse de tener el puerto del archivo hibernate.cfg.xml bien configurado, de lo contrario, la aplicación no se lanzará.

Manual de Usuario
Sección de Login/Register
Registro:

Establece un nombre de usuario y una contraseña.
Selecciona el restaurante en el que vas a trabajar.
Inicio de Sesión:

Introduce tus credenciales para iniciar sesión.
Menú Principal
En el menú principal, encontrarás cuatro botones para navegar entre las diferentes secciones de la aplicación: Horarios, Pedidos, Recetas y Salir. También hay un carrusel de imágenes de restaurantes.

Horarios
En esta sección, dispones de un TableView que describe la tabla horarios de la base de datos. Puedes:

Hacer clic en un horario para modificarlo.
Consultar visualmente los horarios.
Crear nuevos horarios.
Volver al menú principal.
Recetas
En esta sección, puedes seleccionar un producto y ver un pop-up con la receta del producto. Esto es útil para los empleados para evitar la formación tradicional.

Pedidos
Esta es la sección más importante de la aplicación:

Los trabajadores pueden registrar los productos que consumen los clientes.
Muestra una ventana con el precio total y una lista de productos pedidos.
Al seleccionar "Generar Recibo", se inserta el pedido en la base de datos y se genera una factura que se envía por correo electrónico a la empresa.
Notas Finales
Asegúrate de seguir todas las instrucciones de instalación y configuración cuidadosamente para asegurar el correcto funcionamiento de la aplicación. Para cualquier problema o duda, revisa la documentación adicional en los enlaces de las bibliotecas y herramientas utilizadas:

JavaFX API Documentation
MVN Repository
JavaMail
iTextPDF Documentation
Java Oracle Documentation
Hibernate Documentation
Autor: Pablo Rodríguez Rodríguez
Tutor: Jesús Ángel Pérez-Roca Fernández
Proyecto Fin de Ciclo - Desarrollo de Aplicaciones Multiplataforma
C.P.R. Liceo “La Paz”