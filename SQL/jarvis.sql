-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2021 at 11:41 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jarvis`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `email`, `username`, `password`) VALUES
(1, 'hridoy47@gmail.com', 'hridoy789', '54321'),
(2, 'Gravita98', 'gravita98@gmail.com', '654321');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `pid` int(20) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `category` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `quantity` int(20) NOT NULL,
  `unit_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`pid`, `p_name`, `category`, `type`, `quantity`, `unit_price`) VALUES
(1001, 'Gibson Les Paul', 'Strings', 'Electric', 20, 2499.99),
(1002, 'Fender Stratocaster', 'Strings', 'Electric', 22, 2999.99),
(1003, 'Epiphone LP Standard', 'Strings', 'Electric', 25, 1599.99),
(1004, 'Ibanez ART-100', 'Strings', 'Electric', 35, 899.99),
(1005, 'Epiphone J-45', 'Strings', 'Acoustic', 40, 269.99),
(1006, 'Gibson J-50 Classic', 'Strings', 'Acoustic', 35, 299.99),
(1007, 'Ibanez GA3 Nylon', 'Strings', 'Acoustic', 40, 229.99),
(1008, 'Rickenbacker 4003S', 'Strings', 'Bass', 30, 999.99),
(1009, 'Fender Duff McKagen', 'Strings', 'Bass', 32, 1099.99),
(1010, 'Ibanez SR', 'Strings', 'Bass', 45, 699.99),
(1011, 'Yamaha TRBX500', 'Strings', 'Bass', 45, 299.99),
(1012, 'Cordoba Ukulele', 'Strings', 'Ukulele', 69, 99.99),
(1013, 'Gibson SG 1963', 'Strings', 'Electric', 25, 3299.99),
(2001, 'Nord  Stage', 'Keys', 'Live', 20, 5399.99),
(2002, 'Korg Kronos LS', 'Keys', 'Live', 20, 3699.99),
(2003, 'Yamaha PSR-295', 'Keys', 'Live', 42, 129.99),
(2004, 'Roland V-Combo', 'Keys', 'Live', 42, 299.99),
(2005, 'Yamaha Classical Grand', 'Keys', 'Piano', 12, 14999.99),
(2006, 'Steinway Grand', 'Keys', 'Piano', 10, 99999.99),
(2007, 'AKAI MPK Mini', 'Keys', 'MIDI', 50, 199.99),
(2008, 'Alesis VI25', 'Keys', 'MIDI', 48, 249.99),
(2009, 'Surasree Custom Harmonium', 'Keys', 'Harmonium', 36, 999.99),
(3001, 'Tama Club JAM 9pcs', 'Percussion', 'Acoustic drums', 36, 19999.99),
(3002, 'Pearl Roadshow RS 5pcs', 'Percussion', 'Acoustic drums', 28, 24999.99),
(3003, 'Zildjan (Cymbals) \\nCrash, Splash, Hi-Hats, Ride, China', 'Percussion', 'Acoustic drums', 36, 949.99),
(3004, 'Alesis Nitro Mesh', 'Percussion', 'Electric drums', 40, 549.99),
(3005, 'ROland TD-1DMK', 'Percussion', 'Electric drums', 42, 649.99),
(3006, 'Yamaha DTX402K', 'Percussion', 'Electric drums', 38, 449.99),
(3007, 'Cajon', 'Percussion', 'Cajon', 52, 39.99),
(3008, 'Surasree Tabla', 'Percussion', 'Tabla', 50, 69.99),
(3009, 'Tambourine', 'Percussion', 'Tambourine', 60, 19.99),
(6701, 'abc', 'Percussion', 'Electric', 60, 266.99);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `trxid` int(50) NOT NULL,
  `pid` int(50) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `quantity` int(20) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `cardholder` varchar(100) NOT NULL,
  `cardnumber` varchar(100) NOT NULL,
  `expirydate` date DEFAULT NULL,
  `pin` int(20) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`trxid`, `pid`, `pname`, `quantity`, `user_name`, `cardholder`, `cardnumber`, `expirydate`, `pin`, `amount`) VALUES
(1, 1011, 'Yamaha TRBX500', 5, 'bee111', 'Birjan Burjan', '1234567891234567', '2022-03-18', 12356, 1499.95),
(3, 1002, 'Fender Stratocaster', 5, 'bee111', 'Sakib Hasan', '3212645697895465', '2021-09-10', 12345, 14999.9),
(4, 3001, 'Tama Club JAM 9pcs', 3, 'mithu321', 'Mithun Dash', '2211555669955778', '2021-08-28', 12345, 59999.97),
(5, 2009, 'Surasree Custom Harmonium', 7, 'bee111', 'Hashim Amla', '3322557799884455', '2023-03-10', 65438, 6999.93),
(6, 10011, 'Yamaha TRBX500', 4, 'bee111', 'Eva Ericson', '1234567788998877', '2021-10-08', 12345, 1199.96),
(7, 1001, 'Gibson Les Paul', 3, 'Ashrafi99', 'Halim Sarowar', '1233456678991233', '2021-04-24', 11621, 7499.99),
(8, 3002, 'Pearl Roadshow RS 5pcs', 5, 'Ashrafi99', 'Ashrafi Talukdar', '3333222211116666', '2021-07-22', 12345, 124999.95),
(9, 1001, 'Gibson Les Paul', 5, 'bee111', 'Eva Ellison', '9877654432118521', '2025-04-07', 12345, 12499.95),
(10, 3001, 'Tama Club JAM 9pcs', 1, 'sujon5013', 'Saidur Rahman', '1477258836991477', '2022-04-02', 35421, 19999.99),
(11, 2008, 'Alesis VI25', 6, 'sujon5016@gmail.com', 'Saidur', '12345678912345', '2024-04-13', 32165, 1499.94);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `mobile`, `username`, `password`, `address`) VALUES
(1, 'ashrafi99@gmail.com', '01771122336', 'Ashrafi99', '116213', 'Patuakhali'),
(2, 'b@gmail.com', '01771122337', 'bee111', '654321', 'Dhaka'),
(17, 'Mithu123@gmail.com', '01771122332', 'Mithu123', 'AbCd123456', '254/2, Ambagan, Dhaka-1217'),
(21, 'hridoy1234@gmail.com', '01771122346', 'Hridoy1234', 'Hridoy1234', 'Kushtia'),
(27, 'halim123@gmail.com', '01771122356', 'Halim2222', '123456', 'Chittagong'),
(30, 'halim360@gmail.com', '01771122341', 'Halim360', 'halim360', 'Chittagong'),
(31, 'mishu69@gmail.com', '01771122344', 'Mishu69', 'Mishu69', '254/3, Moghbazar, Dhaka'),
(42, 'rabab69@hotmail.com', '01771122326', 'Rabab69', 'MNOPQRST', '420 korail bosti, Dhaka'),
(43, 'sujon5013@gmail.com', '01729545654', 'sujon5013', '116215PrP', '254/2, Ambagan, Moghbazar, Dhaka-1217'),
(46, 'sujon5014@gmail.com', '01729545655', 'sujon5014', '116215SrS', '254/2, Noyatola, Ambagan, Dhaka-1214'),
(47, 'sujon5015@gmail.com', '01729545658', 'sujon5015', '116215PrP', '254/2, Ambagan, Moghbazar, Dhaka'),
(48, 'sujon5016@gmail.com', '01729545653', 'sujon5016', '116215SrS', '32/C, Gabtola'),
(49, 'mithun69@hiotmail.com', '01818115654', 'MithunDash69', '123456', '22/1, Dhanmondi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`pid`,`p_name`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`trxid`,`pid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `trxid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
