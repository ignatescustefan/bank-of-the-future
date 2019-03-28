﻿-- phpMyAdmin SQL Dump
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

INSERT INTO utilizator VALUES("Georgescu","Matei","matei_grg_230@gmail.com","matYg2167","1901109227809","746210984");
INSERT INTO utilizator VALUES("Chiriac","Florina","flory_ch832@yahoo.com","Parlament7615","2920204189726","723990178");
INSERT INTO utilizator VALUES("Ionescu","Cosmin-Mihai","cm_ionescu_1976@hotmail.com","AlbatroS8265","1761207374081","752019777");
INSERT INTO utilizator VALUES("Mihăiescu","Georgiana","georgy_mih93@gmail.com","FloareDeCactus328","2930101780911","761200807");
INSERT INTO utilizator VALUES("Ababei","Mitică","mitica_ababei_1963@mail.ru","MarinarulVesel189","1630228547890","725161718");
INSERT INTO utilizator VALUES("Florescu","Ciprian","cipp_flor_1121@yahoo.com","CipyStrong2019","1900908231890","761259098");
INSERT INTO utilizator VALUES("Darie","Ancuța","ancutza_darie_96@outlook.com","MaiMuTica999","2961112228906","771387123");
INSERT INTO utilizator VALUES("Ciobanu","Victorița","victoria_cb@.com","Călăreț890","2980315221900","788304899");
INSERT INTO utilizator VALUES("Calancea","Iuliana","iulica_calancea@hotmail.com","RoșuNegru_9012a","2810430127890","720514869");
INSERT INTO utilizator VALUES("Lovin","Emil","emy_92_lovin@gmail.com","Emy2310Cash","1920131374098","744120934");

INSERT INTO angajat VALUES("Ionescu","Ion","ionescu.ion_1043@ripbank.ro","IonescuION2114");
INSERT INTO angajat VALUES("Gavrilescu","Ștefan","gavrilescu.ștefan_4689@ripbank.ro","GavrilescuȘTEFAN4236");
INSERT INTO angajat VALUES("Mardare","Bianca","mardare.bianca_5234@ripbank.ro","MardareBIANCA3673");
INSERT INTO angajat VALUES("Iacob","Alin","iacob.alin_6523@ripbank.ro","IacobALIN9579");
INSERT INTO angajat VALUES("Tudor","Gheorghe","tudor.gheorghe_2342@ripbank.ro","TudorGHEORGHE2436");
INSERT INTO angajat VALUES("Mihăilescu","Vladimir","mihăilescu.vladimir_5900@ripbank.ro","MihăilescuVLADIMIR1543");
INSERT INTO angajat VALUES("Doroftei","Codruța","doroftei.codruța_9082@ripbank.ro","DorofteiCODRUȚA1859");
INSERT INTO angajat VALUES("Agafiței","Marina","agafiței.marina_6070@ripbank.ro","AgafițeiMARINA7801");
INSERT INTO angajat VALUES("Costache","Florin","costache.florin_3099@ripbank.ro","CostacheFLORIN9219");
INSERT INTO angajat VALUES("Dorobăț","Laur","dorobăț.laur_4221@ripbank.ro","DorobățLAUR6009");

INSERT INTO cont VALUES("RO84RIPB6154890127634561","1901109227809","depozit","8901","5797.27");
INSERT INTO cont VALUES("RO84RIPB7612097651389004","2920204189726","economie","2104","2610.02");
INSERT INTO cont VALUES("RO84RIPB8190672319083276","1761207374081","economie","3915","4862.39");
INSERT INTO cont VALUES("RO84RIPB1991208624386140","2930101780911","depozit","4512","7435.90");
INSERT INTO cont VALUES("RO84RIPB5400025190270550","1630228547890","economie","1008","5969.47");
INSERT INTO cont VALUES("RO84RIPB3903657004899970","1900908231890","depozit","3401","2413.00");
INSERT INTO cont VALUES("RO84RIPB9144736082059910","2961112228906","altele","7712","5481.20");
INSERT INTO cont VALUES("RO84RIPB2691893694994720","2980315221900","depozit","9046","4853.95");
INSERT INTO cont VALUES("RO84RIPB1882396887414170","2810430127890","economie","9901","7865.11");
INSERT INTO cont VALUES("RO84RIPB4203717507803240","1920131374098","altele","3895","6573.37");
INSERT INTO cont VALUES("RO84RIPB2061794270905660","2980315221900","economie","6178","3886.79");
INSERT INTO cont VALUES("RO84RIPB7041844188481140","2810430127890","depozit","2174","7032.41");
INSERT INTO cont VALUES("RO84RIPB7052315742334150","1901109227809","altele","2308","6743.53");
INSERT INTO cont VALUES("RO84RIPB6185546665299800","1630228547890","altele","2481","7048.37");
INSERT INTO cont VALUES("RO84RIPB2804319068695400","2920204189726","altele","4128","6144.69");
INSERT INTO cont VALUES("RO84RIPB1669312083713750","2930101780911","altele","6715","6582.41");
INSERT INTO cont VALUES("RO84RIPB5240682116554790","1761207374081","depozit","5671","1357.72");
INSERT INTO cont VALUES("RO84RIPB1524312158460260","1900908231890","economie","9140","3826.89");
INSERT INTO cont VALUES("RO84RIPB3617422720362080","1920131374098","depozit","3290","3674.67");
INSERT INTO cont VALUES("RO84RIPB4933418034069930","2961112228906","depozit","1209","1147.08");













