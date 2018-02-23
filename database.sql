USE test;

DROP TABLE IF EXISTS book;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) NOT NULL,
  `print_year` int(11) NOT NULL,
  `read_already` bit(1) NOT NULL,
  `title` varchar(100) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

INSERT INTO book (author, description, isbn, print_year, read_already, title)
VALUES ('Nosov', 'for children', '12345', 1986, 1, 'Neznaika na Lune'),
 ('Pushkin', 'poetry', '12346', 1793, 1, 'Evgehiy Ohegin'),
 ('Alexin', 'for children', '12347', 1984, 1, 'Sasha i Shura'),
 ('Bulgakov', 'misthery', '12348', 1932, 1, 'Master i Margarita'),
 ('Bulgakov', 'action', '12349', 1934, 0, 'Belaya Gvardia'),
 ('Tolstoy', 'history', '12350', 1854, 1, 'Voina i Mir, tom 1'),
 ('Tolstoy', 'history', '12450', 1854, 1, 'Voina i Mir, tom 2'),
 ('Tolstoy', 'history', '12550', 1854, 1, 'Voina i Mir, tom 3'),
 ('Tolstoy', 'history', '12650', 1854, 1, 'Voina i Mir, tom 4'),
 ('Orwell', 'russian reality', '12351', 1943, 1, '1984'),
 ('Orwell', 'soviet reality', '12352', 1946, 0, 'Skothiy Dvor'),
 ('Platon', 'philosophy', '12353', -356, 1, 'Dialogi'),
 ('Nosov', 'for children', '12354', 1987, 1, 'Neznaika v Solnechnom gorode'),
 ('Nosov', 'for children', '12355', 1984, 1, 'Prikluchenia Neznaiki'),
 ('Aleksin', 'for children', '12356', 1986, 0, 'Prikluchenia Alika Detkina'),
 ('Aleksin', 'for children', '12357', 1988, 1, 'Tretiy v Pyatom Ryadu'),
 ('Aleksin', 'for children', '12358', 1988, 1, 'Zvonite i Priezzhaite'),
 ('Aleksin', 'for children', '12359', 1989, 0, 'Sumasshedshaya Evdokia'),
 ('Lermontov', 'poetry', '12360', 1801, 1, 'Mtsiri'),
 ('Sholohov', 'action', '12361', 1934, 1, 'Tihiy Don, tom 1'),
 ('Sholohov', 'action', '12362', 1936, 1, 'Tihiy Don, tom 2'),
 ('Sholohov', 'action', '12363', 1938, 1, 'Tihiy Don, tom 3'),
 ('Sholohov', 'action', '12364', 1954, 1, 'Tihiy Don, tom 4'),
 ('Grishkovets', 'philosophy', '12365', 2009, 0, 'Kak Ya Syel Sobaku');
