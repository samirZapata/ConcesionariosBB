-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-04-2020 a las 15:26:03
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `BD_Burnz_Buttly`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Registrar`
--

CREATE TABLE `Registrar` (
  `NombresyApellidos` varchar(80) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` varchar(12) DEFAULT NULL,
  `Email` varchar(80) DEFAULT NULL,
  `Cedula` int(12) NOT NULL,
  `Ciudad` varchar(50) DEFAULT NULL,
  `Usuario` varchar(80) DEFAULT NULL,
  `Contraseña` varchar(90) DEFAULT NULL,
  `rol` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Registrar`
--

INSERT INTO `Registrar` (`NombresyApellidos`, `Direccion`, `Telefono`, `Email`, `Cedula`, `Ciudad`, `Usuario`, `Contraseña`, `rol`) VALUES
('Luisa Gorler', 'Nowogard', '66', 'lgorlerp@stanford.edu', 1, 'Yangpu', 'lgorlerp', '22k4H9V6', '1'),
('Rhonda Stovell', 'Hasuda', '26', 'rstovellf@goo.gl', 3, 'Vostochnoe Degunino', 'rstovellf', 'dxF6Bz', '2'),
('Caro Aynsley', 'Vigo', '86', 'caynsley14@i2i.jp', 6, 'Jiahe', 'caynsley14', 'St3X8T2EiS', '2'),
('Emilie Simcock', 'Camabatela', '19', 'esimcocku@vistaprint.com', 8, 'Pananaw', 'esimcocku', '5pzNW9CKqgKE', '2'),
('Natalee Silly', 'Qunsheng', '86', 'nsilly2@eventbrite.com', 11, 'Ordem', 'nsilly2', 'mJSQKV7FuZ', '2'),
('Carmita Coopey', 'La Francia', '6', 'ccoopeyc@mozilla.com', 15, 'Dawuhan', 'ccoopeyc', 'o69RW9y1K', '2'),
('Debera Mulbry', 'Helsingborg', '86', 'dmulbry18@sciencedaily.com', 16, 'Nkoteng', 'dmulbry18', '6bIq9cM4', '2'),
('Leslie Mellody', 'Puor', '15', 'lmellodyj@free.fr', 18, 'Nynäshamn', 'lmellodyj', 'hKqxpn', '2'),
('Budd Hadland', 'Jibu', '11', 'bhadland9@is.gd', 19, 'Ede', 'bhadland9', 'rZlO7DTxVV', '2'),
('Amandie Cashman', 'Harper', '93', 'acashman16@shareasale.com', 24, 'Mangga Dua', 'acashman16', 'Dt0qP4jv', '2'),
('Shae Warbey', 'Davao', '49', 'swarbeyl@utexas.edu', 25, 'Augsburg', 'swarbeyl', 'YBJ3ilS', '2'),
('Olenolin Bispham', 'Bełżyce', '20', 'obisphamw@photobucket.com', 26, 'Kabac', 'obisphamw', 'togqfHdCEmx', '2'),
('Zea Quilleash', 'Dukla', '63', 'zquilleash1@nytimes.com', 27, 'Ulaan-Ereg', 'zquilleash1', '2TBoDcKEm', '2'),
('Frans Spinola', 'Krujë', '87', 'fspinola1c@arizona.edu', 30, 'Jasaan', 'fspinola1c', '67gD85r', '2'),
('Delmor Crannage', 'Tabivere', '62', 'dcrannage19@nytimes.com', 35, 'Vatutine', 'dcrannage19', 'x4SaI5gV5Ct8', '2'),
('Sherry Sidebottom', 'Yangzhuang', '68', 'ssidebottom1d@latimes.com', 43, 'Parksville', 'ssidebottom1d', 'm6CdRqxF9c4l', '2'),
('Lind Eastmond', 'Stockton', '22', 'leastmondg@earthlink.net', 44, 'Betania', 'leastmondg', '04qcwHfVmM', '2'),
('Tallulah Dyas', 'Nhơn Trạch', '35', 'tdyasd@lulu.com', 46, 'Şurmān', 'tdyasd', 'bydE8coTI9G', '2'),
('Mattias Andras', 'Nakło nad Notecią', '62', 'mandrasv@multiply.com', 48, 'Totoral', 'mandrasv', '2So7znbVKxy', '2'),
('Arlyne Rosin', 'Novi Šeher', '14', 'arosinx@amazon.co.jp', 50, 'Léchovo', 'arosinx', 'La8ixv3p9', '2'),
('Kalle Rolland', 'Tulaghi', '86', 'krolland0@fc2.com', 51, 'Bojongsari', 'krolland0', 'JIoCmsBMT24X', '2'),
('Colleen Dabel', 'Majdal Banī Fāḑil', '80', 'cdabelq@jugem.jp', 52, 'Moppo', 'cdabelq', 'gXLDH2', '2'),
('Rayshell Dunkerly', 'Inuyama', '87', 'rdunkerly10@mysql.com', 53, 'Xinqiao', 'rdunkerly10', 'L0zQ7AtO39', '2'),
('Ingeberg Liffe', 'Gerong', '68', 'iliffe11@so-net.ne.jp', 55, 'Wangjiahe', 'iliffe11', 'FVPSizwSy4SA', '2'),
('Livvyy Tremoille', 'Tešanj', '6', 'ltremoillet@loc.gov', 59, 'Kaczory', 'ltremoillet', 'HNtVQ4JRZ', '2'),
('Gearalt McCleverty', 'Stradbally', '11', 'gmccleverty3@ox.ac.uk', 60, 'Pueblo Nuevo', 'gmccleverty3', 'NBb4slaC7', '2'),
('Antonin Cinnamond', 'Colegiales', '61', 'acinnamond4@google.co.jp', 61, 'Petropavlivka', 'acinnamond4', 'D88qJct', '2'),
('Roderigo Barlas', 'Huyang', '73', 'rbarlas8@timesonline.co.uk', 62, 'Potrerillos', 'rbarlas8', 'mo3cjWpv7Pi4', '2'),
('Debee Idell', 'Shuigou', '11', 'didell1b@studiopress.com', 65, 'Gadon', 'didell1b', 'T1zqus', '2'),
('Georg Beecroft', 'Kalloní', '81', 'gbeecrofte@tinypic.com', 68, 'La Palma', 'gbeecrofte', 'uirBxlc9', '2'),
('Rabi Dagworthy', 'Xiema', '77', 'rdagworthy1a@netvibes.com', 69, 'Cincinnati', 'rdagworthy1a', 'K5t0ciW4', '2'),
('Magdalene Greystock', 'Shuikou', '24', 'mgreystock17@creativecommons.org', 73, 'Uinskoye', 'mgreystock17', 'ZrUerSs6Ri5u', '2'),
('Geri Bleackly', 'Haarlem', '72', 'gbleacklym@cpanel.net', 75, 'Kurnia', 'gbleacklym', 'dU2a4XcM6cy', '2'),
('Tersina Rickeard', 'Velykyy Burluk', '35', 'trickeard7@sfgate.com', 76, 'Puerto Cisnes', 'trickeard7', 'rG9QTyfLI', '2'),
('Estelle Turneaux', 'Grijó', '55', 'eturneauxy@sohu.com', 78, 'Padej', 'eturneauxy', 'UOq1XDfEZ', '2'),
('Romona Girardin', 'Fyllingsdalen', '97', 'rgirardino@slideshare.net', 84, 'Yanggan', 'rgirardino', 'bHkFIJ', '2'),
('Ermin Taks', 'Uvarovka', '74', 'etaks6@cmu.edu', 85, 'Lefengzhen', 'etaks6', 'pGeZXKT6rTD', '2'),
('Harvey Van den Oord', 'Tongyangdao', '73', 'hvanr@dion.ne.jp', 87, 'Zhujiachang', 'hvanr', 'NDKLJvXAxLu', '2'),
('Hillary Malatalant', 'Cubatão', '58', 'hmalatalant1e@weebly.com', 88, 'Gubkinskiy', 'hmalatalant1e', 'MnlcdlsCb3w', '2'),
('Damian Karus', 'Liushui', '57', 'dkarusn@gmpg.org', 89, 'Balete', 'dkarusn', 'Osgmgn', '2'),
('Vere Ivantyev', 'Daishan', '47', 'vivantyev5@chron.com', 93, 'Gangshangji', 'vivantyev5', 'xcecVEJM', '2'),
('Bevan Pilkington', 'Rovnoye', '18', 'bpilkingtonh@thetimes.co.uk', 95, 'Lago da Pedra', 'bpilkingtonh', '2kciKc9', '2'),
('Jarrad Crowe', 'Labuhan Deli', '18', 'jcrowez@reference.com', 100, 'Toulouse', 'jcrowez', 'KcwMiz', '2'),
('n', 'bj', '858', 'bjn', 596, 'jh', 'h', 'jh', '2'),
('hola', 'c78', '564296', 'hola', 798076, 'ghj', 'hola', 'hola', '1'),
('gfh', 'cgvhb', '78', 'vhbj', 7548754, 'vbn', 'hgj', 'ghj', '2'),
('Yonier asprilla', 'cr34', '7777', 'samzapb@jmail', 8888777, 'bh', 'samzap2', 'abcq', '1'),
('Yonier', 'cr45', '756842', 'samzap1@jmail', 56752644, 'Abu Dabi', 'samzap', '1', '2'),
('Yonier Zapata', 'cr125#45-78', '254762', 'samzap@gmail.com', 567458257, 'BOG', 'SAMZAP', 'ABC', '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Registrar`
--
ALTER TABLE `Registrar`
  ADD PRIMARY KEY (`Cedula`),
  ADD UNIQUE KEY `Cedula` (`Cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
