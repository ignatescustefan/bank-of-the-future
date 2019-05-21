--
-- Bază de date: `ripbank`
--
CREATE DATABASE IF NOT EXISTS `ripbank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ripbank`;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabelul `angajat`
--

CREATE TABLE `angajat` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Structură tabel pentru tabelul `cont`
--

CREATE TABLE `cont` (
  `IBAN` varchar(30) NOT NULL,
  `proprietar_cnp` varchar(14) NOT NULL,
  `tip_cont` enum('depozit','economii','altele') NOT NULL,
  `PIN` varchar(4) NOT NULL,
  `sold` double(10,2) UNSIGNED DEFAULT 0.00
) ;


-- --------------------------------------------------------

--
-- Structură tabel pentru tabelul `status_client`
--

CREATE TABLE `status_client` (
  `cnp` varchar(14) NOT NULL,
  `client_status` enum('activ','inactiv') NOT NULL DEFAULT 'activ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabelul `tranzactie`
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


-- --------------------------------------------------------

--
-- Structură tabel pentru tabelul `utilizator`
--

CREATE TABLE `utilizator` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `parola` varchar(30) NOT NULL,
  `cnp` varchar(14) NOT NULL,
  `telefon` varchar(10) NOT NULL
) ;


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
-- Indexuri pentru tabele `status_client`
--
ALTER TABLE `status_client`
  ADD KEY `cnp_sfk` (`cnp`);

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
  ADD UNIQUE KEY `cnp` (`cnp`);

--
-- AUTO_INCREMENT pentru tabele `tranzactie`
--
ALTER TABLE `tranzactie`
  MODIFY `id_Tranzactie` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constrângeri pentru tabele
--

--
-- Constrângeri pentru tabele `utilizator`
--

ALTER TABLE `utilizator`
  ADD CONSTRAINT `parola_ck` CHECK (LENGTH(`parola`) > 0);

--
-- Constrângeri pentru tabele `cont`
--
ALTER TABLE `cont`
  ADD CONSTRAINT `cont_ibfk_1` FOREIGN KEY (`proprietar_cnp`) REFERENCES `utilizator` (`cnp`)
  ADD CONSTRAINT `cont_soldck` CHECK (`sold` > 0);
--
-- Constrângeri pentru tabele `status_client`
--
ALTER TABLE `status_client`
  ADD CONSTRAINT `cnp_sfk` FOREIGN KEY (`cnp`) REFERENCES `utilizator` (`cnp`);

--
-- Constrângeri pentru tabele `tranzactie`
--

ALTER TABLE `tranzactie`
  ADD CONSTRAINT `tranzactie_ibfk_1` FOREIGN KEY (`IBAN_sursa`) REFERENCES `cont` (`IBAN`);


--
-- Adaugare user pentru baza de date
--

GRANT ALL PRIVILEGES ON *.* TO 'adminRIP'@'localhost' IDENTIFIED BY PASSWORD '*B28C29E37B404FAFF47D236713CDF833B9B94742' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `ripbank`.* TO 'adminRIP'@'localhost';