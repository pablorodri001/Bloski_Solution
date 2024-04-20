-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 20-04-2024 a las 13:49:16
-- Versión del servidor: 5.7.39
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Restaurantes_Bloski's`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Inventario`
--

CREATE TABLE `Inventario` (
  `id_producto` int(11) NOT NULL,
  `id_restaurante` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Inventario`
--

INSERT INTO `Inventario` (`id_producto`, `id_restaurante`, `nombre`, `cantidad`, `precio_unitario`) VALUES
(1, 1, 'Pizza Margarita', 30, '9.99'),
(2, 1, 'Hamburguesa con Queso', 25, '8.50'),
(3, 1, 'Refresco de Cola', 60, '1.99'),
(4, 2, 'Ensalada César', 15, '6.99'),
(5, 2, 'Sándwich de Pollo', 20, '7.50'),
(6, 2, 'Agua Mineral', 40, '0.99');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Restaurante`
--

CREATE TABLE `Restaurante` (
  `id_restaurante` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Restaurante`
--

INSERT INTO `Restaurante` (`id_restaurante`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Restaurante Bloski Principal', 'Calle Principal 123', '+1234567890'),
(2, 'Restaurante Bloski Sucursal', 'Avenida Secundaria 456', '+0987654321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Turnos`
--

CREATE TABLE `Turnos` (
  `id_turno` int(11) NOT NULL,
  `id_restaurante` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `turno` varchar(50) DEFAULT NULL,
  `descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Turnos`
--

INSERT INTO `Turnos` (`id_turno`, `id_restaurante`, `fecha`, `id_empleado`, `turno`, `descripcion`) VALUES
(1, 1, '2024-04-10', 1, 'Mañana', 'Preparación de cocina'),
(2, 1, '2024-04-10', 2, 'Tarde', 'Atención al cliente en el comedor'),
(3, 1, '2024-04-10', 3, 'Noche', 'Limpieza y cierre'),
(4, 1, '2024-04-11', 4, 'Mañana', 'Preparación de cocina'),
(5, 1, '2024-04-11', 5, 'Tarde', 'Atención al cliente en el comedor'),
(6, 1, '2024-04-11', 6, 'Noche', 'Limpieza y cierre'),
(7, 2, '2024-04-10', 1, 'Mañana', 'Preparación de ensaladas'),
(8, 2, '2024-04-10', 2, 'Tarde', 'Preparación de sándwiches'),
(9, 2, '2024-04-10', 3, 'Noche', 'Limpieza y cierre'),
(10, 2, '2024-04-11', 4, 'Mañana', 'Preparación de ensaladas'),
(11, 2, '2024-04-11', 5, 'Tarde', 'Preparación de sándwiches'),
(12, 2, '2024-04-11', 6, 'Noche', 'Limpieza y cierre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Inventario`
--
ALTER TABLE `Inventario`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_restaurante` (`id_restaurante`);

--
-- Indices de la tabla `Restaurante`
--
ALTER TABLE `Restaurante`
  ADD PRIMARY KEY (`id_restaurante`);

--
-- Indices de la tabla `Turnos`
--
ALTER TABLE `Turnos`
  ADD PRIMARY KEY (`id_turno`),
  ADD KEY `id_restaurante` (`id_restaurante`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Inventario`
--
ALTER TABLE `Inventario`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `Restaurante`
--
ALTER TABLE `Restaurante`
  MODIFY `id_restaurante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `Turnos`
--
ALTER TABLE `Turnos`
  MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Inventario`
--
ALTER TABLE `Inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `Restaurante` (`id_restaurante`);

--
-- Filtros para la tabla `Turnos`
--
ALTER TABLE `Turnos`
  ADD CONSTRAINT `turnos_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `Restaurante` (`id_restaurante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
