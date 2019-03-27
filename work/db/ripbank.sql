-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mart. 27, 2019 la 08:42 PM
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

--
-- Trunchiază tabelul înainte de inserare `angajat`
--

TRUNCATE TABLE `angajat`;
--
-- Eliminarea datelor din tabel `angajat`
--

INSERT INTO `angajat` (`nume`, `prenume`, `email`, `parola`) VALUES
('Alina', 'Dua', 'alina@mail.com', 'alina123'),
('Marius', 'Ionut', 'marius@mail.com', 'marius_02');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `cont`
--

CREATE TABLE `cont` (
  `IBAN` varchar(30) NOT NULL,
  `proprietar_cnp` varchar(14) NOT NULL,
  `tip_cont` enum('depozit','economii','altele') NOT NULL,
  `PIN` varchar(4) NOT NULL,
  `sold` double(10,2) UNSIGNED DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Trunchiază tabelul înainte de inserare `cont`
--

TRUNCATE TABLE `cont`;
--
-- Eliminarea datelor din tabel `cont`
--

INSERT INTO `cont` (`IBAN`, `proprietar_cnp`, `tip_cont`, `PIN`, `sold`) VALUES
('R0509793', '23123', 'depozit', '0509', 100.30),
('RO123123', '12', 'depozit', '3210', 0.00),
('RO163376', '193213', 'depozit', '1633', 16.32),
('RO23412', '23', 'depozit', '1233', 400.23),
('RO270803', '23432', 'depozit', '2708', 2712.32),
('RO388953', '29123123', 'economii', '0281', 3219.32),
('RO579178', '1921312', 'altele', '5791', 702.34),
('RO662660', '198321', 'economii', '6626', 5023.40),
('RO975509', '291231', 'altele', '9755', 13928.80),
('RO983129', '19213131', 'depozit', '8931', 901.30);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `token`
--

CREATE TABLE `token` (
  `id` int(10) UNSIGNED NOT NULL,
  `token_cnp` varchar(14) NOT NULL,
  `token_key` varchar(32) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Trunchiază tabelul înainte de inserare `token`
--

TRUNCATE TABLE `token`;
-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `tranzactie`
--

CREATE TABLE `tranzactie` (
  `id_Tranzactie` int(10) UNSIGNED NOT NULL,
  `tip_Tranzactie` enum('depunere','retragere') NOT NULL,
  `IBAN_sursa` varchar(30) NOT NULL,
  `IBAN_destinatie` varchar(30) NOT NULL,
  `operator_tranzactie` varchar(60) NOT NULL,
  `data_tranzactie` date NOT NULL,
  `ora_tranzactie` time NOT NULL,
  `suma_tranzactie` double(10,2) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Trunchiază tabelul înainte de inserare `tranzactie`
--

TRUNCATE TABLE `tranzactie`;
-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizator`
--

CREATE TABLE `utilizator` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL,
  `cnp` varchar(14) NOT NULL,
  `telefon` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Trunchiază tabelul înainte de inserare `utilizator`
--

TRUNCATE TABLE `utilizator`;
--
-- Eliminarea datelor din tabel `utilizator`
--

INSERT INTO `utilizator` (`nume`, `prenume`, `email`, `parola`, `cnp`, `telefon`) VALUES
('Ana', 'Maria', 'ana@maria.ro', '12312', '12', '09321'),
('Voicu', 'Ioan', 'voicu@mail.com', 'voicu123', '1921312', '03213'),
('Cojocaru', 'Vlad', 'vlad@mail.com', 'vlad1234', '19213131', '0741123'),
('Vranciu', 'Vasile', 'vasi@mail.com', 'vasi1234', '193213', '094213'),
('Manea', 'Cristi', 'cristi@mail.com', 'cristi123', '198321', '071331'),
('Dan', 'Marius', 'dan@marius.ro', 'dan123', '23', '08732'),
('Creangă', 'Mircea', 'mircea@mail.com', 'mircea1234', '23123', '083123'),
('Ionescu', 'George', 'george@mail.com', 'george1234', '23432', '04123'),
('Eminescu', 'Mihai', 'emi@mail.com', 'luceafarul1234', '291231', '0831234'),
('Micle', 'Veronica', 'vero@mail.com', 'emi1234', '29123123', '039231');

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `angajat`
--
ALTER TABLE `angajat`
  ADD PRIMARY KEY (`email`);

--
-- Indexuri pentru tabele `cont`
--
ALTER TABLE `cont`
  ADD PRIMARY KEY (`IBAN`),
  ADD KEY `proprietar_cnp` (`proprietar_cnp`);

--
-- Indexuri pentru tabele `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `token_cnp` (`token_cnp`);

--
-- Indexuri pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  ADD PRIMARY KEY (`id_Tranzactie`),
  ADD KEY `IBAN_sursa` (`IBAN_sursa`);

--
-- Indexuri pentru tabele `utilizator`
--
ALTER TABLE `utilizator`
  ADD PRIMARY KEY (`cnp`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `cnp` (`cnp`),
  ADD UNIQUE KEY `telefon` (`telefon`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  MODIFY `id_Tranzactie` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `cont`
--
ALTER TABLE `cont`
  ADD CONSTRAINT `cont_ibfk_1` FOREIGN KEY (`proprietar_cnp`) REFERENCES `utilizator` (`cnp`);

--
-- Constrângeri pentru tabele `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `token_ibfk_1` FOREIGN KEY (`token_cnp`) REFERENCES `utilizator` (`cnp`);

--
-- Constrângeri pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  ADD CONSTRAINT `tranzactie_ibfk_1` FOREIGN KEY (`IBAN_sursa`) REFERENCES `cont` (`IBAN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
