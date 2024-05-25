CREATE DATABASE IF NOT EXISTS Restaurante_bloski;


USE Restaurante_bloski;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET NAMES utf8mb4;

CREATE TABLE `Restaurante` (
  `id_restaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `id_restaurante` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`),
  KEY `id_restaurante` (`id_restaurante`),
  CONSTRAINT `fk_usuarios_restaurante` FOREIGN KEY (`id_restaurante`) REFERENCES `Restaurante` (`id_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Turnos` (
  `id_turno` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `turno` varchar(50) DEFAULT NULL,
  `descripcion` text,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_turno`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `turnos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `Usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Recetas` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_restaurante` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_restaurante` (`id_restaurante`),
  CONSTRAINT `fk_recetas_restaurante` FOREIGN KEY (`id_restaurante`) REFERENCES `Restaurante` (`id_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Clientes` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `id_cliente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  KEY `id_producto` (`id_producto`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `fk_clientes_recetas` FOREIGN KEY (`id_producto`) REFERENCES `Recetas` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Restaurante` (`id_restaurante`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Restaurante Bloski Principal', 'Calle Principal 123', '+1234567890'),
(2, 'Restaurante Bloski Sucursal', 'Avenida Secundaria 456', '+0987654321');

INSERT INTO `Usuarios` (`id_usuario`, `nombre_usuario`, `contrasena`, `id_restaurante`) VALUES
(1, 'pablo', 'admin', 1),
(2, 'usuarioprueba1', 'uno', 1),
(3, 'usuarioprueba2', 'dos', 1);

INSERT INTO `Turnos` (`fecha`, `turno`, `descripcion`, `id_usuario`) VALUES
('2024-04-10', 'Mañana', 'Preparación de cocina', 1),
('2024-04-10', 'Tarde', 'Atención al cliente en el comedor', 2),
('2024-04-10', 'Noche', 'Limpieza y cierre', 3),
('2024-04-11', 'Mañana', 'Preparación de ensaladas', 1),
('2024-04-11', 'Tarde', 'Preparación de sándwiches', 2),
('2024-04-11', 'Noche', 'Limpieza y cierre', 3);

INSERT INTO `Recetas` (`id_restaurante`, `nombre`, `descripcion`, `cantidad`, `precio_unitario`) VALUES
(1, 'Pizza Margarita', 'Para hacer la masa de pizza, mezclamos 500g de harina con una pizca de sal y 7g de levadura seca. Añadimos 300ml de agua templada y 2 cucharadas de aceite de oliva. Amasamos bien y dejamos reposar en un lugar cálido durante una hora. Extendemos la masa sobre una bandeja para horno y añadimos salsa de tomate, mozzarella rallada y hojas de albahaca. Horneamos a 200ºC durante 15-20 minutos.', 30, 9.99),
(1, 'Hamburguesa con Queso', 'Preparamos la carne mezclando 500g de carne de res picada con una pizca de sal y pimienta. Formamos hamburguesas y las cocinamos en una sartén caliente durante 4-5 minutos por cada lado. Cortamos los panes de hamburguesa por la mitad y los tostamos ligeramente. Montamos la hamburguesa colocando la carne sobre el pan, añadiendo una loncha de queso cheddar, unas hojas de lechuga y una rodaja de tomate. Cerramos con la otra mitad del pan y servimos.', 25, 8.50),
(1, 'Refresco de Cola', 'Servimos el refresco de cola bien frío en un vaso con hielo.', 60, 1.99),
(1, 'Ensalada César', 'Preparamos primero los picatostes caseros. Calentamos el horno a 180ºC. Frotamos un diente de ajo sobre unas rebanadas de pan y las cortamos en dados. Las aliñamos con un poco de aceite de oliva y las horneamos durante 5 minutos hasta que estén doradas. Para la salsa César, hacemos puré con un diente de ajo y lo mezclamos con aceite, salsa Perrins, zumo de limón, vinagre y una yema de huevo. Batimos bien hasta emulsionar y reservamos. Lavamos y secamos hojas de lechuga romana y las salpimentamos. Añadimos la salsa César por encima, los picatostes y queso parmesano rallado.', 15, 6.99),
(1, 'Sándwich de Pollo', 'Cocinamos pechugas de pollo a la parrilla hasta que estén doradas y cocidas. Tostamos rebanadas de pan de molde. Extendemos una capa de mayonesa sobre una rebanada de pan, colocamos las pechugas de pollo, unas hojas de lechuga y unas rodajas de tomate. Cerramos con la otra rebanada de pan y servimos.', 20, 7.50),
(1, 'Agua Mineral', 'Servimos el agua mineral en una botella o vaso.', 40, 0.99),
(1, 'Agua de Valencia', 'Mezclamos jugo de naranja fresco con cava, ginebra y vodka. Añadimos azúcar al gusto y servimos bien frío en una jarra con hielo y rodajas de naranja.', 50, 12.50),
(1, 'Bacon Cheese Fries', 'Freímos las papas hasta que estén doradas y crujientes. Las cubrimos con queso cheddar rallado y bacon crujiente troceado. Gratinar hasta que el queso se derrita. Servir con salsa ranch.', 50, 5.99);

COMMIT;

SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
