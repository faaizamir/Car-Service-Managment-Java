-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2023 at 12:11 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carservice`
--

-- --------------------------------------------------------

--
-- Table structure for table `addtoservice`
--

CREATE TABLE `addtoservice` (
  `id` varchar(30) NOT NULL,
  `vehicleNum` varchar(30) NOT NULL,
  `vehicleModel` varchar(30) NOT NULL,
  `owner` varchar(30) NOT NULL,
  `ServiceType` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addtoservice`
--

INSERT INTO `addtoservice` (`id`, `vehicleNum`, `vehicleModel`, `owner`, `ServiceType`) VALUES
('123', 'QW', '321', 'SDFS', 'Repairing');

-- --------------------------------------------------------

--
-- Table structure for table `customermanage`
--

CREATE TABLE `customermanage` (
  `custName` varchar(20) NOT NULL,
  `custEmail` varchar(20) NOT NULL,
  `custAddress` varchar(20) NOT NULL,
  `custDate` date NOT NULL DEFAULT current_timestamp(),
  `custContact` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customermanage`
--

INSERT INTO `customermanage` (`custName`, `custEmail`, `custAddress`, `custDate`, `custContact`) VALUES
('12', '56', '34', '2023-11-30', 78);

-- --------------------------------------------------------

--
-- Table structure for table `usersignup`
--

CREATE TABLE `usersignup` (
  `userName` varchar(20) NOT NULL,
  `userEmail` varchar(30) NOT NULL,
  `userContact` int(15) NOT NULL,
  `userPass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usersignup`
--

INSERT INTO `usersignup` (`userName`, `userEmail`, `userContact`, `userPass`) VALUES
('imtiaz', 'imtazgamil', 12345, 'imtiaz'),
('janisar', 'janisargamil', 123456, 'janisar'),
('faaiz', 'faaiz@gmail.com', 123, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `vehicledetails`
--

CREATE TABLE `vehicledetails` (
  `vehicleNumber` int(30) NOT NULL,
  `CNIC` int(30) NOT NULL,
  `OwnerName` text NOT NULL,
  `vehicleModel` varchar(30) NOT NULL,
  `FuelType` text NOT NULL,
  `VehicleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicledetails`
--

INSERT INTO `vehicledetails` (`vehicleNumber`, `CNIC`, `OwnerName`, `vehicleModel`, `FuelType`, `VehicleId`) VALUES
(123, 123, 'faa', '123', 'Cleaning', 1),
(123, 123, 'faa', '123', 'Spare parts', 2),
(275, 41923, 'faa', '2070', 'Cleaning', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `vehicledetails`
--
ALTER TABLE `vehicledetails`
  ADD PRIMARY KEY (`VehicleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `vehicledetails`
--
ALTER TABLE `vehicledetails`
  MODIFY `VehicleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
