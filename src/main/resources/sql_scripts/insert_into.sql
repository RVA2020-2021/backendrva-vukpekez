--OBRAZOVANJE
insert into obrazovanje(id, naziv, stepen_strucne_spreme, opis)
    values
           (nextval('obrazovanje_seq'), 'Pravni fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Pravni fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Pravni fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Ekonomski fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Ekonomski fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Ekonomski fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Rudarsko-geološki fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Rudarsko-geološki fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Rudarsko-geološki fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Mašinski fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Mašinski fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Mašinski fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Elektrotehnički fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Elektrotehnički fakultet', '7.', 'MAS'),
           (nextval('obrazovanje_seq'), 'Elektrotehnički fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Medicinski fakultet', '6.', 'OAS'),
           (nextval('obrazovanje_seq'), 'Medicinski fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Medicinski fakultet', '8. DS', ''),
           (nextval('obrazovanje_seq'), 'Fakultet tehničkih nauka', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Fakultet tehničkih nauka', '7.', 'MAS'),
           (nextval('obrazovanje_seq'), 'Fakultet tehničkih nauka', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Filozofski fakultet', '6.2', 'OAS'),
           (nextval('obrazovanje_seq'), 'Filozofski fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Filozofski fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Poljoprivredni fakultet', '6.', 'OAS'),
           (nextval('obrazovanje_seq'), 'Poljoprivredni fakultet', '7.1', 'MAS'),
           (nextval('obrazovanje_seq'), 'Poljoprivredni fakultet', '7.2', 'SAS'),
           (nextval('obrazovanje_seq'), 'Poljoprivredni fakultet', '8.', 'DS'),
           (nextval('obrazovanje_seq'), 'Visoka tehnička škola', '6.1', 'OSS'),
           (nextval('obrazovanje_seq'), 'Visoka poslovna škola', '6.1', '0SS'),
           (nextval('obrazovanje_seq'), 'Visoka škola elektrotehnike i računarstva', '6.1', 'OSS'),
           (nextval('obrazovanje_seq'), 'Visoka tehnička škola', '6.1', '0SS'),
           (nextval('obrazovanje_seq'), 'Gimnazija', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Ekonomska škola', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Elektrotehnička škola', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Saobraćajno tehnička škola', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Medicinska škola', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Tehnička škola', '4.', 'SO 4god'),
           (nextval('obrazovanje_seq'), 'Srednja turistička škola', '4.', 'SO 4god');

--PREDUZECA
insert into preduzece(id, naziv, pib, sediste, opis)
    VALUES
        (nextval('preduzece_seq'), 'JP "Elektroprivreda Srbije"', 871872317, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Elektromreža Srbije"', 975802169, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Srbijavode"', 355950648, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Transnafta"', 852178011, 'Pančevo', ''),
        (nextval('preduzece_seq'), 'JP "Pošta Srbije"', 600313360, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Srbijašume"', 241790977, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Putevi Srbije"', 265466198, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Zavod za udženike"', 345784463, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP za skloništa', 339267666, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Skijališta Srbije"', 482790551, 'Beograd', ''),
        (nextval('preduzece_seq'), 'JP "Nacionalni park Tara"', 456926751, 'Bajina Bašta', ''),
        (nextval('preduzece_seq'), 'JP "Nacionalni park Fruška Gora"', 309766690, 'Sremska Kamenica', ''),
        (nextval('preduzece_seq'), 'Park prirode "Mokra Gora"', 227897021, 'Mokra Gora', ''),
        (nextval('preduzece_seq'), '"Srbija Voz" a.d.', 146689386, 'Beograd', ''),
        (nextval('preduzece_seq'), '"Metohija" d.o.o.', 798787589, 'Beograd', '');

--SEKTOR
insert into sektor(id, naziv, oznaka, preduzece)
    VALUES
        (nextval('sektor_seq'), 'Sektor za finansije', 'F', 1),
        (nextval('sektor_seq'), 'Sektor za korporativne poslove', 'KP', 1),
        (nextval('sektor_seq'), 'Sektor za proizvodnju', 'PZ', 1),
        (nextval('sektor_seq'), 'Sektor za prodaju', 'P', 1),
        (nextval('sektor_seq'), 'Sektor Nacionalni dispečerski centar', 'NDC', 2),
        (nextval('sektor_seq'), 'Sektor Regionalni dispečerski centri', 'RDC', 2),
        (nextval('sektor_seq'), 'Tehnički sektor', 'T', 3),
        (nextval('sektor_seq'), 'Sektor za ekonomsko-finansijske poslove', 'EFP', 3),
        (nextval('sektor_seq'), 'Sektor za pravne i opšte poslove', 'POP', 3),
        (nextval('sektor_seq'), 'Sektor za tranport', 'T', 4),

        (nextval('sektor_seq'), 'Sektor za skladištenje', 'S', 4),
        (nextval('sektor_seq'), 'Sektor za zaštitu životne sredine', 'ZŽS', 4),
        (nextval('sektor_seq'), 'Sektor za usluge', 'U', 5),
        (nextval('sektor_seq'), 'Sektor za poštanske mreže', 'PM', 5),
        (nextval('sektor_seq'), 'Sektor bezbednosti i zaštitne', 'BZ', 5),
        (nextval('sektor_seq'), 'Sektor za internu reviziju', 'IR', 5),
        (nextval('sektor_seq'), 'Sektor za šumarstvo', 'Š', 6),
        (nextval('sektor_seq'), 'Sektor za lovstvo, ribarstvo i turizam', 'LRT', 6),
        (nextval('sektor_seq'), 'Sektor za komercijalne poslove', 'UK', 6),
        (nextval('sektor_seq'), 'Sektor za strategiju, projektovanje i razvoj', 'SPR', 7),

        (nextval('sektor_seq'), 'Sektor za investicije', 'I', 7),
        (nextval('sektor_seq'), 'Sektor održavanja državnih puteva I i II reda', 'ODP', 7),
        (nextval('sektor_seq'), 'Sektor za naplatu putarine', 'NP', 7),
        (nextval('sektor_seq'), 'Izdavački sektor', 'I', 8),
        (nextval('sektor_seq'), 'Sektor finansija', 'F', 8),
        (nextval('sektor_seq'), 'Sektor za pravne poslove i ljudske resurse', 'PPLJR', 8),
        (nextval('sektor_seq'), 'Sektor za tehničke poslove', 'TP', 9),
        (nextval('sektor_seq'), 'Sektor za mirnodopsko korišćenje objekata', 'MKO', 9),
        (nextval('sektor_seq'), 'Sektor za tehničke podrške', 'TP', 10),
        (nextval('sektor_seq'), 'Sektor komercijale', 'K', 10),

        (nextval('sektor_seq'), 'Sektor marketinga', 'M', 10),
        (nextval('sektor_seq'), 'Sektor planiranja, zaštite i razvoja', 'PZR', 11),
        (nextval('sektor_seq'), 'Sektor korišćenja područja', 'KP', 11),
        (nextval('sektor_seq'), 'Sektor opštih i pravnih poslova', 'OPP', 11),
        (nextval('sektor_seq'), 'Sektor zaštite i razvoja', 'ZR', 12),
        (nextval('sektor_seq'), 'Sektor zajedničkih poslova', 'ZP', 12),
        (nextval('sektor_seq'), 'Sektor uprave i administracije', 'UA', 13),
        (nextval('sektor_seq'), 'Sektor odrzavanja', 'O', 13),
        (nextval('sektor_seq'), 'Sektor za saobraćajno-komercijalne poslove', 'KP', 14),
        (nextval('sektor_seq'), 'Sektor za vuču vozova', 'VV', 14),

        (nextval('sektor_seq'), 'Sektor za održavanje voznih sredstava', 'OVS', 14),
        (nextval('sektor_seq'), 'Sektor za nabavke i stovarišne poslove', 'NSP', 14),
        (nextval('sektor_seq'), 'Sektor za opšte, pravne i kadrovske poslove', 'OPKP', 15),
        (nextval('sektor_seq'), 'Sektor za prodaju i marketing', 'PM', 15);

--RADNIK
insert into radnik (id, ime, prezime, broj_lk, obrazovanje, sektor)
    VALUES
        (nextval('radnik_seq'), 'Aleksa', 'Novaković', 940919228, 20, 4),
        (nextval('radnik_seq'), 'Ivona', 'Filipović', 801675764, 11, 1),
        (nextval('radnik_seq'), 'Dušan', 'Simonović', 326355525, 30, 3),
        (nextval('radnik_seq'), 'Bojana', 'Lambić', 265265559, 26, 4),
        (nextval('radnik_seq'), 'Zoran', 'Bošković', 547288400, 2, 2),
        (nextval('radnik_seq'), 'Željko', 'Belić', 469809055, 16, 1),
        (nextval('radnik_seq'), 'Vukašin', 'Mihajlović', 344860076, 30, 4),
        (nextval('radnik_seq'), 'Srđan', 'Stanković', 414047350, 9, 2),
        (nextval('radnik_seq'), 'Igor', 'Raušević', 171249452, 31, 1),
        (nextval('radnik_seq'), 'Aleksandra', 'Vučurević', 105574842, 1, 4),
        (nextval('radnik_seq'), 'Isidora', 'Novaković', 543859073, 24, 3),
        (nextval('radnik_seq'), 'Bogdan', 'Radulović', 680087550, 34, 1),
        (nextval('radnik_seq'), 'Miloš','Stojković', 497589707, 19, 4),
        (nextval('radnik_seq'), 'Ana', 'Babović', 322118440, 22, 5),
        (nextval('radnik_seq'), 'Jelena', 'Radovanović', 380790592, 19, 5),
        (nextval('radnik_seq'), 'Veljko', 'Milutinović', 965253111, 34, 6),
        (nextval('radnik_seq'), 'Milica', 'Damjanović', 516425926, 15, 5),
        (nextval('radnik_seq'), 'Ivona', 'Simonović', 504308404, 33, 6),
        (nextval('radnik_seq'), 'Aleksandra', 'Gavrilović', 741972855, 11, 6),
        (nextval('radnik_seq'), 'Bojana', 'Avramović', 965682552, 28, 6),
        (nextval('radnik_seq'), 'Dušan', 'Spasović', 614623944, 5, 5),
        (nextval('radnik_seq'), 'Sara', 'Radulović', 313580693, 36, 8),
        (nextval('radnik_seq'), 'Boris', 'Grujović', 744187866, 1, 7),
        (nextval('radnik_seq'), 'Tijana', 'Tomović', 886189508, 4, 7),
        (nextval('radnik_seq'), 'Zoran', 'Mirčević', 725357122, 11, 8),
        (nextval('radnik_seq'), 'Vesna', 'Spasojević', 289919854, 13, 9),
        (nextval('radnik_seq'), 'Luka', 'Aksentijević', 543859073, 34, 7),
        (nextval('radnik_seq'), 'Aleksa', 'Cvetković', 193051153, 26, 9),
        (nextval('radnik_seq'), 'Dejan', 'Grbić', 741305403, 32, 9),
        (nextval('radnik_seq'), 'Tamara', 'Simović', 452758956, 2, 7),
        (nextval('radnik_seq'), 'Anastasija', 'Stefanović', 111776380, 22, 8),
        (nextval('radnik_seq'), 'Jovana', 'Makljenović', 671904122, 35, 9),
        (nextval('radnik_seq'), 'Željko', 'Kljajić', 261997116, 9, 12),
        (nextval('radnik_seq'), 'Milica', 'Stanković', 315548935, 4, 11),
        (nextval('radnik_seq'), 'Andrijana', 'Vučurević', 774554718, 15, 12),
        (nextval('radnik_seq'), 'Nikola', 'Novaković', 246728062, 10, 10),
        (nextval('radnik_seq'), 'Goran', 'Grbić', 338679140, 15, 11),
        (nextval('radnik_seq'), 'Miloš', 'Belić', 701871368, 13, 10),
        (nextval('radnik_seq'), 'Anastasija', 'Lukić', 327551495, 16, 10),
        (nextval('radnik_seq'), 'Sara', 'Tomović', 609968773, 6, 12),
        (nextval('radnik_seq'), 'Ivana', 'Raušević', 953067365, 17, 12),
        (nextval('radnik_seq'), 'Jelena', 'Mihajlović', 343643300, 9, 11),
        (nextval('radnik_seq'), 'Marko', 'Simonović', 711079751, 1, 12),
        (nextval('radnik_seq'), 'Aleksandra', 'Maksimović', 619147614, 17, 10),
        (nextval('radnik_seq'), 'Dejana', 'Milinović', 995421979, 3, 10),
        (nextval('radnik_seq'), 'Isidora', 'Stojković', 545821984, 13, 14),
        (nextval('radnik_seq'), 'David', 'Aksentijević', 320075651, 15, 15),
        (nextval('radnik_seq'), 'Dajana', 'Simović', 172122490, 24, 14),
        (nextval('radnik_seq'), 'Bogdan', 'Cvijanović', 644934931, 5, 15),
        (nextval('radnik_seq'), 'Srđan', 'Babović', 124896857, 15, 13),
        (nextval('radnik_seq'), 'Vesna', 'Filipović', 150880815, 28, 14),
        (nextval('radnik_seq'), 'Bojana', 'Marković', 185009188, 4, 15),
        (nextval('radnik_seq'), 'Luka', 'Gavrilović', 460148727, 28, 13),
        (nextval('radnik_seq'), 'Aleksandar', 'Bošković', 573540565, 30, 16),
        (nextval('radnik_seq'), 'David', 'Maksimović', 666240958, 36, 16),
        (nextval('radnik_seq'), 'Dejana', 'Radovanović', 449855678, 30, 15),
        (nextval('radnik_seq'), 'Boris', 'Mišić', 734885360, 39, 13),
        (nextval('radnik_seq'), 'Veljko', 'Novaković', 862482917, 7, 14),
        (nextval('radnik_seq'), 'Igor', 'Belić', 937338649, 13, 16),
        (nextval('radnik_seq'), 'Andrijana', 'Vučurević', 730034325, 14, 15),
        (nextval('radnik_seq'), 'Petar', 'Spasojević', 471622119, 23, 17),
        (nextval('radnik_seq'), 'Emilija', 'Starčević', 862002171, 36, 17),
        (nextval('radnik_seq'), 'Nikola', 'Avramović', 973057133, 12, 19),
        (nextval('radnik_seq'), 'Anastasija', 'Stefanović', 765468353, 38, 18),
        (nextval('radnik_seq'), 'Miloš', 'Gavrilović', 940580451, 19, 19),
        (nextval('radnik_seq'), 'Bojana', 'Milutinović', 643085182, 8, 17),
        (nextval('radnik_seq'), 'Marko', 'Spasović', 498605121, 13, 18),
        (nextval('radnik_seq'), 'Isidora', 'Radulović', 263040196, 1, 18),
        (nextval('radnik_seq'), 'Aleksa', 'Grujović', 197766118, 16, 18),
        (nextval('radnik_seq'), 'Ivana', 'Stojković', 850550733, 23, 19),
        (nextval('radnik_seq'), 'Emilija', 'Kljajić', 904400080, 3, 21),
        (nextval('radnik_seq'), 'Goran', 'Cvetković', 153152933, 23, 22),
        (nextval('radnik_seq'), 'Tamara', 'Grbić', 407397969, 5, 23),
        (nextval('radnik_seq'), 'Dajana', 'Marković', 410811591, 28, 22),
        (nextval('radnik_seq'), 'Sara', 'Simović', 169208514, 37, 22),
        (nextval('radnik_seq'), 'Jovana', 'Marković', 417342455, 24, 21),
        (nextval('radnik_seq'), 'Aleksandra', 'Mirčević', 334172301, 22, 23),
        (nextval('radnik_seq'), 'Branislav', 'Lukić', 441054407, 1, 23),
        (nextval('radnik_seq'), 'Ivona', 'Radovanović', 602728975, 23, 20),
        (nextval('radnik_seq'), 'Dejan', 'Simonović', 562819395, 28, 20),
        (nextval('radnik_seq'), 'Andrijana', 'Makljenović', 747187392, 33, 21),
        (nextval('radnik_seq'), 'Milica', 'Mišić', 279300419, 39, 20),
        (nextval('radnik_seq'), 'Igor', 'Spasojević', 327208294, 13, 23),
        (nextval('radnik_seq'), 'Boris', 'Milutinović', 863427138, 9, 20),
        (nextval('radnik_seq'), 'Petar', 'Stefanović', 407032552, 13, 26),
        (nextval('radnik_seq'), 'Marko', 'Latković', 512247691, 21, 24),
        (nextval('radnik_seq'), 'Aleksandar', 'Kučević', 739723328, 28, 26),
        (nextval('radnik_seq'), 'Nikola', 'Novaković', 790076913, 27, 24),
        (nextval('radnik_seq'), 'Zoran', 'Ninković', 124840631, 37, 26),
        (nextval('radnik_seq'), 'Ivana', 'Belić', 952973064, 27, 24),
        (nextval('radnik_seq'), 'Biljana', 'Vučurević', 842739312, 18, 25),
        (nextval('radnik_seq'), 'Veljko', 'Milošević', 312474203, 38, 25),
        (nextval('radnik_seq'), 'Miloš', 'Stanković', 603430287, 35, 26),
        (nextval('radnik_seq'), 'Bojana', 'Zečević', 603430287, 31, 26),
        (nextval('radnik_seq'), 'Dejana', 'Simović', 510004748, 9, 25),
        (nextval('radnik_seq'), 'Branislav', 'Kučević', 884998151, 6, 24),
        (nextval('radnik_seq'), 'Srđan', 'Lambić', 476544675, 39, 27),
        (nextval('radnik_seq'), 'Goran', 'Radulović', 399642108, 22, 28),
        (nextval('radnik_seq'), 'Ognjen', 'Lukić', 257498355, 1, 28),
        (nextval('radnik_seq'), 'Aleksandar', 'Avramović', 519674200, 5, 28),
        (nextval('radnik_seq'), 'Jelena', 'Kljajić', 889622242, 7, 27),
        (nextval('radnik_seq'), 'Biljana', 'Latković', 701300431, 30, 27),
        (nextval('radnik_seq'), 'Vladimir', 'Damjanović', 343401462, 17, 28),
        (nextval('radnik_seq'), 'Vukašin', 'Gavrilović', 635722484, 8, 27),
        (nextval('radnik_seq'), 'Tamara', 'Milinović', 844280606, 20, 29),
        (nextval('radnik_seq'), 'Aleksandra', 'Marković', 277860871, 17, 31),
        (nextval('radnik_seq'), 'Petar', 'Babović', 697311348, 14, 29),
        (nextval('radnik_seq'), 'Luka', 'Spasojević', 913369850, 13, 31),
        (nextval('radnik_seq'), 'Vesna', 'Tomović', 446537882, 2, 29),
        (nextval('radnik_seq'), 'Marko', 'Aksentijević', 934625919, 32, 31),
        (nextval('radnik_seq'), 'Boris', 'Mihajlović', 536026758, 36, 29),
        (nextval('radnik_seq'), 'Ognjen', 'Stojković', 659395831, 27, 29),
        (nextval('radnik_seq'), 'Nikola', 'Filipović', 197362360, 19, 30),
        (nextval('radnik_seq'), 'Dejan', 'Cvetković', 774897779, 33, 30),
        (nextval('radnik_seq'), 'Aleksa', 'Radovanović', 234810454, 12, 31),
        (nextval('radnik_seq'), 'Ognjen', 'Stefanović', 198078567, 18, 30),
        (nextval('radnik_seq'), 'Emilija', 'Grbić', 597490193, 27, 29),
        (nextval('radnik_seq'), 'Dejana', 'Mišić', 296903504, 9, 29),
        (nextval('radnik_seq'), 'Jovana', 'Grujović', 441562026, 24, 32),
        (nextval('radnik_seq'), 'Ivona', 'Bošković', 907814269, 28, 34),
        (nextval('radnik_seq'), 'Ana', 'Raušević', 279528364, 30, 33),
        (nextval('radnik_seq'), 'David', 'Atanacković', 421566557, 32, 32),
        (nextval('radnik_seq'), 'Tijana', 'Marković', 824231157, 17, 33),
        (nextval('radnik_seq'), 'Veljko', 'Spasović', 809709969, 6, 33),
        (nextval('radnik_seq'), 'Goran', 'Starčević', 757246537, 11, 32),
        (nextval('radnik_seq'), 'Vladimir', 'Kučević', 203986178, 34, 33),
        (nextval('radnik_seq'), 'Anastasija', 'Lukić', 573640360, 17, 32),
        (nextval('radnik_seq'), 'Sara', 'Lambić', 379808562, 30, 34),
        (nextval('radnik_seq'), 'Vukašin', 'Maksimović', 355484218, 28, 33),
        (nextval('radnik_seq'), 'Marko', 'Makljenović', 621886267, 29, 33),
        (nextval('radnik_seq'), 'Aleksandar', 'Latković', 819981832, 5, 34),
        (nextval('radnik_seq'), 'Vladimir', 'Mirčević', 345817602, 15, 34),
        (nextval('radnik_seq'), 'Zoran', 'Ninković', 530017644, 33, 32),
        (nextval('radnik_seq'), 'Bogdan', 'Zečević', 164243431, 22, 33),
        (nextval('radnik_seq'), 'Dejan', 'Marković', 514213228, 24, 34),
        (nextval('radnik_seq'), 'Nikola', 'Avramović', 869867130, 37, 35),
        (nextval('radnik_seq'), 'Ana', 'Milošević', 389178394, 36, 36),
        (nextval('radnik_seq'), 'Petar', 'Mihajlović', 534168309, 15, 36),
        (nextval('radnik_seq'), 'Jelena', 'Milošević', 397509818, 13, 36),
        (nextval('radnik_seq'), 'Branislav', 'Zečević', 295976684, 1, 35),
        (nextval('radnik_seq'), 'Tijana', 'Milošević', 846680718, 25, 36),
        (nextval('radnik_seq'), 'Jovana', 'Radovanović', 546813923, 23, 35),
        (nextval('radnik_seq'), 'Ivana', 'Latković', 302189161, 21, 36),
        (nextval('radnik_seq'), 'Aleksandar', 'Ninković', 312982359, 38, 35),
        (nextval('radnik_seq'), 'Tamara', 'Stojković', 792786452, 2, 37),
        (nextval('radnik_seq'), 'Željko', 'Lukić', 255319410, 31, 37),
        (nextval('radnik_seq'), 'David', 'Milinović', 941672578, 2, 38),
        (nextval('radnik_seq'), 'Biljana', 'Makljenović', 867021881, 20, 38),
        (nextval('radnik_seq'), 'Sara', 'Tomović', 230932039, 7, 38),
        (nextval('radnik_seq'), 'Marko', 'Novaković', 839966232, 27, 37),
        (nextval('radnik_seq'), 'Isidora', 'Maksimović', 201114121, 24, 38),
        (nextval('radnik_seq'), 'Biljana', 'Grbić', 615497288, 31, 38),
        (nextval('radnik_seq'), 'Milica', 'Cvetković', 633772088, 23, 37),
        (nextval('radnik_seq'), 'Emilija', 'Mihajlović', 645116884, 8, 42),
        (nextval('radnik_seq'), 'Aleksa', 'Stefanović', 585107419, 23, 40),
        (nextval('radnik_seq'), 'Srđan', 'Babović', 819618844, 21, 41),
        (nextval('radnik_seq'), 'Vukašin', 'Marković', 890575812, 29, 40),
        (nextval('radnik_seq'), 'Nikola', 'Radulović', 620924900, 7, 39),
        (nextval('radnik_seq'), 'Dajana', 'Simović', 888756087, 8, 42),
        (nextval('radnik_seq'), 'Ana', 'Stanković', 354052425, 14, 41),
        (nextval('radnik_seq'), 'Igor', 'Gavrilović', 836959079, 19, 40),
        (nextval('radnik_seq'), 'Dušan', 'Radovanović', 619610301, 9, 41),
        (nextval('radnik_seq'), 'Luka', 'Avramović', 906565962, 20, 41),
        (nextval('radnik_seq'), 'Bogdan', 'Raušević', 102788152, 10, 39),
        (nextval('radnik_seq'), 'Milica', 'Lambić', 266727592, 39, 39),
        (nextval('radnik_seq'), 'Vesna', 'Damjanović', 951093337, 9, 42),
        (nextval('radnik_seq'), 'Aleksandar', 'Vučurević', 124312170, 26, 39),
        (nextval('radnik_seq'), 'Marko', 'Atanacković', 106776113, 9, 42),
        (nextval('radnik_seq'), 'Branislav', 'Spasojević', 810306325, 4, 40),
        (nextval('radnik_seq'), 'Luka', 'Kljajić', 842522474, 29, 41),
        (nextval('radnik_seq'), 'Andrijana', 'Mišić', 536250098, 12, 42),
        (nextval('radnik_seq'), 'Ivana', 'Starčević', 615670802, 16, 44),
        (nextval('radnik_seq'), 'Goran', 'Bošković', 621474806, 26, 44),
        (nextval('radnik_seq'), 'Zoran', 'Spasović', 127274632, 23, 43),
        (nextval('radnik_seq'), 'Ana', 'Belić', 418542660, 29, 44),
        (nextval('radnik_seq'), 'Dajana', 'Filipović', 267112827, 9, 43),
        (nextval('radnik_seq'), 'Dušan', 'Grujović', 144021430, 21, 43),
        (nextval('radnik_seq'), 'Jovana', 'Milutinović', 331887739, 22, 44),
        (nextval('radnik_seq'), 'Igor', 'Atanacković', 778172376, 37, 44),
        (nextval('radnik_seq'), 'Aleksa', 'Cvetković', 988467042, 26, 44),
        (nextval('radnik_seq'), 'David', 'Mirčević', 187013343, 12, 43);
