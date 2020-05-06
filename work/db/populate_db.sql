--
-- Inserare date in tabelul `angajat`
--

INSERT INTO `angajat` (`nume`, `prenume`, `email`, `parola`) VALUES
('Agafiței', 'Marina', 'agafiței.marina_6070@ripbank.ro', 'AgafițeiMARINA7801'),
('Alina', 'Dua', 'alina@mail.com', 'alina123'),
('Costache', 'Florin', 'costache.florin_3099@ripbank.ro', 'CostacheFLORIN9219'),
('Dorobăț', 'Laur', 'dorobăț.laur_4221@ripbank.ro', 'DorobățLAUR6009'),
('Doroftei', 'Codruța', 'doroftei.codruța_9082@ripbank.ro', 'DorofteiCODRUȚA1859'),
('Gavrilescu', 'Ștefan', 'gavrilescu.ștefan_4689@ripbank.ro', 'GavrilescuȘTEFAN4236'),
('Iacob', 'Alin', 'iacob.alin_6523@ripbank.ro', 'IacobALIN9579'),
('Ionescu', 'Ion', 'ionescu.ion_1043@ripbank.ro', 'IonescuION2114'),
('Mardare', 'Bianca', 'mardare.bianca_5234@ripbank.ro', 'MardareBIANCA3673'),
('Marius', 'Ionut', 'marius@mail.com', 'marius_02'),
('Mihăilescu', 'Vladimir', 'mihăilescu.vladimir_5900@ripbank.ro', 'MihăilescuVLADIMIR1543'),
('Tudor', 'Gheorghe', 'tudor.gheorghe_2342@ripbank.ro', 'TudorGHEORGHE2436');

--
-- Inserare date in tabelul `cont`
--

INSERT INTO `cont` (`IBAN`, `proprietar_cnp`, `tip_cont`, `PIN`, `sold`) VALUES
('R0509793', '23123', 'depozit', '0509', 100.30),
('RO123123', '12', 'depozit', '3210', 210.00),
('RO163376', '193213', 'depozit', '1633', 16.32),
('RO23412', '23', 'depozit', '1233', 75.00),
('RO270803', '23432', 'depozit', '2708', 2712.32),
('RO388953', '29123123', 'economii', '0281', 3219.32),
('RO579178', '1921312', 'altele', '5791', 702.34),
('RO579178312321', '23', 'depozit', '3123', 0.00),
('RO579178321', '23', 'depozit', '3123', 0.00),
('RO662660', '198321', 'economii', '6626', 5023.40),
('RO84RIPB0053757943986953', '7890', 'depozit', '0000', 0.00),
('RO84RIPB0206234148853150', '23', 'economii', '0000', 646.43),
('RO84RIPB0873581504372755', '7890', 'altele', '0000', 1000.00),
('RO84RIPB1245416591080396', '123456789', 'depozit', '0000', 55.00),
('RO84RIPB1524312158460260', '1900908231890', 'economii', '9140', 3826.89),
('RO84RIPB1669312083713750', '2930101780911', 'altele', '6715', 6582.41),
('RO84RIPB1882396887414170', '2810430127890', 'economii', '9901', 7865.11),
('RO84RIPB1991208624386140', '2930101780911', 'depozit', '4512', 7435.90),
('RO84RIPB2061794270905660', '2980315221900', 'economii', '6178', 3886.79),
('RO84RIPB2691893694994720', '2980315221900', 'depozit', '9046', 4853.95),
('RO84RIPB2804319068695400', '2920204189726', 'altele', '4128', 6144.69),
('RO84RIPB2835562149202483', '123456789', 'economii', '0000', 44.00),
('RO84RIPB2925876046463866', '2920204189726', 'depozit', '0000', 1530.50),
('RO84RIPB2945312251326103', '1234', 'depozit', '0000', 0.00),
('RO84RIPB2970258959002022', '1234', 'depozit', '0000', 1234.00),
('RO84RIPB3617422720362080', '1920131374098', 'depozit', '3290', 3674.67),
('RO84RIPB3903657004899970', '1900908231890', 'depozit', '3401', 2413.00),
('RO84RIPB4203717507803240', '1920131374098', 'altele', '3895', 6573.37),
('RO84RIPB4562744182455149', '98765', 'economii', '0000', 899.50),
('RO84RIPB4933418034069930', '2961112228906', 'depozit', '1209', 1147.08),
('RO84RIPB5018505385086146', '98765', 'depozit', '0000', 99.50),
('RO84RIPB5110530073020215', '9876', 'depozit', '0000', 0.00),
('RO84RIPB5240682116554790', '1761207374081', 'depozit', '5671', 1357.72),
('RO84RIPB5400025190270550', '1630228547890', 'economii', '1008', 5969.47),
('RO84RIPB5458523673791883', '23', 'economii', '0000', 999.90),
('RO84RIPB5466426920391627', '7890', 'economii', '0000', 800.00),
('RO84RIPB5879989202630088', '12345', 'depozit', '0000', 1610.01),
('RO84RIPB6154890127634561', '1901109227809', 'depozit', '8901', 5797.27),
('RO84RIPB6185546665299800', '1630228547890', 'altele', '2481', 7048.37),
('RO84RIPB7028319235965437', '23', 'depozit', '0000', 123.00),
('RO84RIPB7041844188481140', '2810430127890', 'depozit', '2174', 7032.41),
('RO84RIPB7052315742334150', '1901109227809', 'altele', '2308', 6743.53),
('RO84RIPB7108425662153458', '12', 'altele', '0000', 13.32),
('RO84RIPB7452086269597660', '23', 'depozit', '0000', 321.20),
('RO84RIPB7612097651389004', '2920204189726', 'economii', '2104', 1000.01),
('RO84RIPB8190672319083276', '1761207374081', 'economii', '3915', 4862.39),
('RO84RIPB9144736082059910', '2961112228906', 'altele', '7712', 5481.20),
('RO975509', '291231', 'altele', '9755', 13928.80),
('RO983129', '19213131', 'depozit', '8931', 901.30);

--
-- Inserare date in tabelul `status_client`
--

INSERT INTO `status_client` (`cnp`, `client_status`) VALUES
('9876', 'activ'),
('1921312', 'activ'),
('29123123', 'activ'),
('23432', 'activ'),
('198321', 'activ'),
('2920204189726', 'activ'),
('12', 'activ'),
('19213131', 'activ'),
('23123', 'activ'),
('291231', 'activ'),
('7890', 'activ'),
('23', 'activ'),
('193213', 'activ'),
('98765', 'activ'),
('2810430127890', 'activ'),
('1630228547890', 'activ'),
('123456789', 'activ'),
('1920131374098', 'activ'),
('1901109227809', 'activ'),
('1761207374081', 'activ'),
('2930101780911', 'activ'),
('1900908231890', 'activ'),
('2961112228906', 'activ'),
('2980315221900', 'activ'),
('12345', 'activ'),
('1234', 'activ');

--
-- Inserare date in tabelul `tranzactie`
--

INSERT INTO `tranzactie` (`id_Tranzactie`, `tip_Tranzactie`, `IBAN_sursa`, `IBAN_destinatie`, `operator_tranzactie`, `data_tranzactie`, `ora_tranzactie`, `suma_tranzactie`) VALUES
(5, 'retragere', 'RO84RIPB1524312158460260', 'RO84RIPB5240682116554790', 'Alina Frona', '2019-04-09', '12:22:23', 523.14),
(6, 'depunere', 'RO84RIPB0206234148853150', 'RO84RIPB0206234148853150', 'AlineDua', '2019-05-05', '13:18:51', 20.23),
(7, 'depunere', 'RO23412', 'RO84RIPB0206234148853150', 'AlineDua', '2019-05-05', '13:23:29', 25.23),
(9, 'depunere', 'RO84RIPB7108425662153458', 'RO123123', 'Alina Maria', '2019-05-11', '11:20:49', 110.00),
(10, 'depunere', 'RO84RIPB5466426920391627', 'RO123123', 'Aline Dua', '2019-05-11', '13:54:41', 100.00),
(11, 'depunere', 'RO84RIPB2835562149202483', 'RO84RIPB1245416591080396', 'Alina Dua', '2019-05-11', '15:56:15', 55.00),
(12, 'depunere', 'RO84RIPB4562744182455149', 'RO84RIPB5018505385086146', 'Alina Dua', '2019-05-11', '16:06:22', 99.50),
(13, 'depunere', 'RO84RIPB7612097651389004', 'RO84RIPB5879989202630088', 'Marius Ionut', '2019-05-12', '16:17:00', 1610.01),
(14, 'depunere', 'RO23412', 'RO84RIPB0206234148853150', 'Alina Dua', '2019-05-12', '19:10:20', 300.00);