-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mart. 09, 2019 la 10:04 AM
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

DROP TABLE IF EXISTS `angajat`;
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

DROP TABLE IF EXISTS `conturi`;
CREATE TABLE `conturi` (
  `IBAN` varchar(30) NOT NULL,
  `proprietar_cnp` varchar(14) NOT NULL,
  `tipCont` enum('depozit','economii','altele') NOT NULL,
  `PIN` int(4) UNSIGNED NOT NULL,
  `sold` double(10,2) UNSIGNED DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `tranzactii`
--

DROP TABLE IF EXISTS `tranzactii`;
CREATE TABLE `tranzactii` (
  `idTTranzactie` int(10) UNSIGNED NOT NULL,
  `tipTranzactie` enum('depunere','retragere') NOT NULL,
  `IBAN_sursa` varchar(30) NOT NULL,
  `IBAN_destinatie` varchar(30) NOT NULL,
  `operator_tranzactie` varchar(60) NOT NULL,
  `data_tranzactie` date NOT NULL,
  `ora_tranzactie` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizatori`
--

DROP TABLE IF EXISTS `utilizatori`;
CREATE TABLE `utilizatori` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL,
  `cnp` varchar(14) NOT NULL,
  `telefon` varchar(10) NOT NULL
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
  ADD PRIMARY KEY (`IBAN`),
  ADD KEY `proprietar_cnp` (`proprietar_cnp`);

--
-- Indexuri pentru tabele `tranzactii`
--
ALTER TABLE `tranzactii`
  ADD PRIMARY KEY (`idTTranzactie`),
  ADD KEY `IBAN_sursa` (`IBAN_sursa`);

--
-- Indexuri pentru tabele `utilizatori`
--
ALTER TABLE `utilizatori`
  ADD PRIMARY KEY (`cnp`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `cnp` (`cnp`),
  ADD UNIQUE KEY `telefon` (`telefon`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `tranzactii`
--
ALTER TABLE `tranzactii`
  MODIFY `idTTranzactie` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `conturi`
--
ALTER TABLE `conturi`
  ADD CONSTRAINT `conturi_ibfk_1` FOREIGN KEY (`proprietar_cnp`) REFERENCES `utilizatori` (`cnp`);

--
-- Constrângeri pentru tabele `tranzactii`
--
ALTER TABLE `tranzactii`
  ADD CONSTRAINT `tranzactii_ibfk_1` FOREIGN KEY (`IBAN_sursa`) REFERENCES `conturi` (`IBAN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
