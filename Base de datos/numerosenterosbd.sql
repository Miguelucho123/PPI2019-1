-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2019 a las 05:01:45
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin2 */;

--
-- Base de datos: `numerosenterosbd`
--
CREATE DATABASE IF NOT EXISTS `numerosenterosbd` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `numerosenterosbd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `negativos`
--

DROP TABLE IF EXISTS `negativos`;
CREATE TABLE `negativos` (
  `num_negativos` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `negativos`
--

INSERT INTO `negativos` (`num_negativos`) VALUES
(-430692793),
(-931880259),
(-1694747413);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `neutros`
--

DROP TABLE IF EXISTS `neutros`;
CREATE TABLE `neutros` (
  `num_neutro` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `neutros`
--

INSERT INTO `neutros` (`num_neutro`) VALUES
(0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `positivos`
--

DROP TABLE IF EXISTS `positivos`;
CREATE TABLE `positivos` (
  `num_positivos` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `positivos`
--

INSERT INTO `positivos` (`num_positivos`) VALUES
(302891439),
(87057781),
(1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `neutros`
--
ALTER TABLE `neutros`
  ADD PRIMARY KEY (`num_neutro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
