-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mart. 08, 2019 la 03:01 PM
-- Versiune server: 10.1.36-MariaDB
-- Versiune PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `ripbank`
--
CREATE DATABASE IF NOT EXISTS `ripbank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ripbank`;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `angajat`
--

CREATE TABLE `angajat` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `conturi`
--

CREATE TABLE `conturi` (
  `IBAN` varchar(30) NOT NULL,
  `proprietar` varchar(30) NOT NULL,
  `tipCont` enum('depozit','economii','altele') NOT NULL,
  `PIN` int(4) NOT NULL,
  `sold` double(10,5) DEFAULT '0.00000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizatori`
--

CREATE TABLE `utilizatori` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL,
  `cnp` int(14) UNSIGNED NOT NULL,
  `telefon` int(14) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `angajat`
--
ALTER TABLE `angajat`
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexuri pentru tabele `conturi`
--
ALTER TABLE `conturi`
  ADD PRIMARY KEY (`IBAN`);

--
-- Indexuri pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  ADD PRIMARY KEY (`cnp`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `cnp` (`cnp`),
  ADD UNIQUE KEY `telefon` (`telefon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
