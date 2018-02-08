-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2018 at 01:37 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightreservationsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL,
  `AdminUserName` varchar(300) NOT NULL,
  `AdminPassword` varchar(300) NOT NULL,
  `Email` varchar(300) NOT NULL,
  `FirstName` varchar(300) NOT NULL,
  `LastName` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminId`, `AdminUserName`, `AdminPassword`, `Email`, `FirstName`, `LastName`) VALUES
(1, 'admin', '123', 'admin@gmail.com', 'Toufiqul', 'Islam');

-- --------------------------------------------------------

--
-- Table structure for table `airlines`
--

CREATE TABLE `airlines` (
  `AirlinesId` int(11) NOT NULL,
  `AirlinesName` varchar(300) NOT NULL,
  `AdminId` int(11) NOT NULL,
  `CountryName` varchar(300) NOT NULL,
  `LicenseNo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airlines`
--

INSERT INTO `airlines` (`AirlinesId`, `AirlinesName`, `AdminId`, `CountryName`, `LicenseNo`) VALUES
(4, 'Biman Bangladesh Airlines', 1, 'Bangladesh', '123-456-789');

-- --------------------------------------------------------

--
-- Table structure for table `airport`
--

CREATE TABLE `airport` (
  `AirportId` int(11) NOT NULL,
  `AirportName` varchar(500) NOT NULL,
  `CountryName` varchar(500) NOT NULL,
  `CityName` varchar(300) NOT NULL,
  `AirportCode` varchar(300) NOT NULL,
  `AdminId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airport`
--

INSERT INTO `airport` (`AirportId`, `AirportName`, `CountryName`, `CityName`, `AirportCode`, `AdminId`) VALUES
(4, 'Netaji Subhas Chandra Bose International Airport', 'India', 'Kolkata', 'CCU', 1),
(5, 'Hazrat Shahjalal International Airport', 'Bangladesh', 'Dhaka', 'DAC', 1),
(6, 'Osmani International Airport', 'Bangladesh', 'Sylhet', 'ZYL', 1),
(7, 'Shah Amanat International Airport', 'Bangladesh', 'Chittagong', 'CGP', 1),
(8, 'Paro Airport', 'Bhutan', 'Paro', 'PBH', 1),
(9, 'Veer Savarkar International Airport', 'India', 'Andaman & Nicobar Islands', 'IXZ', 1),
(10, 'Veer Savarkar International Airport', 'India', 'Ahmedabad', 'AMD', 1),
(11, 'Sri Guru Ram Dass Jee International Airport', 'India', 'Amritsar', 'ATQ', 1),
(12, 'Kempegowda International Airport', 'India', 'Bangalore', 'BLR', 1),
(13, 'New Chennai International Airport', 'India', 'Chennai', 'NMA', 1);

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `ClassId` int(11) NOT NULL,
  `NumberOfSeats` int(11) NOT NULL,
  `ClassName` varchar(300) NOT NULL,
  `FlightClassId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feeds`
--

CREATE TABLE `feeds` (
  `FeedId` int(11) NOT NULL,
  `AdminId` int(11) NOT NULL,
  `Events` varchar(300) DEFAULT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feeds`
--

INSERT INTO `feeds` (`FeedId`, `AdminId`, `Events`, `Date`) VALUES
(1, 1, 'Registration of Biman Bangladesh Airlines', '2018-02-03'),
(2, 1, 'Registration of Netaji Subhas Chandra Bose International Airport', '2018-02-04'),
(3, 1, 'Registration of Hazrat Shahjalal International Airport', '2018-02-04'),
(4, 1, 'Registration of Osmani International Airport', '2018-02-04'),
(5, 1, 'Registration of Shah Amanat International Airport', '2018-02-04'),
(6, 1, 'Registration of Paro Airport', '2018-02-04'),
(7, 1, 'Registration of Veer Savarkar International Airport', '2018-02-04'),
(8, 1, 'Registration of Veer Savarkar International Airport', '2018-02-04'),
(9, 1, 'Registration of Sri Guru Ram Dass Jee International Airport', '2018-02-04'),
(10, 1, 'Registration of Kempegowda International Airport', '2018-02-04'),
(11, 1, 'Registration of New Chennai International Airport', '2018-02-04'),
(12, 1, 'Added root id 0', '2018-02-04'),
(13, 1, 'Added NMA DAC', '2018-02-05'),
(14, 1, 'Added a new Flight BG-101', '2018-02-08'),
(15, 1, 'Added a new Flight BG-101', '2018-02-08'),
(16, 1, 'Added a new Flight BG-102', '2018-02-08');

-- --------------------------------------------------------

--
-- Table structure for table `flightclass`
--

CREATE TABLE `flightclass` (
  `FlightClassId` int(11) NOT NULL,
  `FlightId` int(11) NOT NULL,
  `ClassId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `flightroot`
--

CREATE TABLE `flightroot` (
  `FlightRootId` int(11) NOT NULL,
  `RootId` int(11) NOT NULL,
  `FLightId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `FlightId` int(11) NOT NULL,
  `AirlinesId` int(11) NOT NULL,
  `FLightNumber` varchar(300) NOT NULL,
  `RootId` int(11) NOT NULL,
  `AdminId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`FlightId`, `AirlinesId`, `FLightNumber`, `RootId`, `AdminId`) VALUES
(11, 4, 'BG-101', 1, 1),
(12, 4, 'BG-102', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentId` int(11) NOT NULL,
  `PaymentMethod` varchar(100) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `TotalAmount` double(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `root`
--

CREATE TABLE `root` (
  `RootId` int(11) NOT NULL,
  `DepartureCityAirportCode` varchar(300) NOT NULL,
  `DestinationCityAirportCode` varchar(300) NOT NULL,
  `AdminId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `root`
--

INSERT INTO `root` (`RootId`, `DepartureCityAirportCode`, `DestinationCityAirportCode`, `AdminId`) VALUES
(1, 'DAC', 'CCU', 1),
(2, 'DAC', 'ZYL', 1),
(3, 'CCU', 'DAC', 1),
(4, 'ZYL', 'CCU', 1),
(5, 'DAC', 'PBH', 1),
(6, 'NMA', 'DAC', 1);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `SeatId` int(11) NOT NULL,
  `ClassId` int(11) NOT NULL,
  `FlightNumber` varchar(300) NOT NULL,
  `TicketId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seatinfo`
--

CREATE TABLE `seatinfo` (
  `SeatInfoId` int(11) NOT NULL,
  `FirstClass` int(11) DEFAULT '0',
  `BusinessClass` int(11) DEFAULT '0',
  `EconomoyClass` int(11) DEFAULT '0',
  `FLightNumber` varchar(300) NOT NULL,
  `FirstClassSeatPrice` int(11) DEFAULT NULL,
  `BusinessClassSeatPrice` int(11) DEFAULT NULL,
  `EconomyClassSeatPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seatinfo`
--

INSERT INTO `seatinfo` (`SeatInfoId`, `FirstClass`, `BusinessClass`, `EconomoyClass`, `FLightNumber`, `FirstClassSeatPrice`, `BusinessClassSeatPrice`, `EconomyClassSeatPrice`) VALUES
(7, 50, 30, 25, 'BG-101', 4500, 700, 5000),
(8, 50, 25, 40, 'BG-102', 4500, 7000, 5500);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `TicketId` int(11) NOT NULL,
  `TicketType` varchar(300) NOT NULL,
  `PaymentId` int(11) NOT NULL,
  `SeatId` int(11) NOT NULL,
  `BookingDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `timeanddate`
--

CREATE TABLE `timeanddate` (
  `TimeAndDateId` int(11) NOT NULL,
  `DepartureDay` varchar(100) NOT NULL,
  `DepartureTime` varchar(100) NOT NULL,
  `ArrivalDay` varchar(100) NOT NULL,
  `ArrivalTime` varchar(100) NOT NULL,
  `FlightNumber` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timeanddate`
--

INSERT INTO `timeanddate` (`TimeAndDateId`, `DepartureDay`, `DepartureTime`, `ArrivalDay`, `ArrivalTime`, `FlightNumber`) VALUES
(8, 'Monday', '22:00:00', 'Tuesday', '22:30:00', 'BG-101'),
(9, 'Monday', '22:00:00', 'Tuesday', '22:30:00', 'BG-101'),
(10, 'Monday', '22:00:00', 'Tuesday', '22:30:00', 'BG-101'),
(11, 'Wednesday', '17:30:00', 'Wednesday', '17:30:00', 'BG-102'),
(12, 'Wednesday', '17:30:00', 'Wednesday', '17:30:00', 'BG-102'),
(13, 'Wednesday', '17:30:00', 'Wednesday', '17:30:00', 'BG-102'),
(14, 'Wednesday', '17:30:00', 'Wednesday', '17:30:00', 'BG-102');

-- --------------------------------------------------------

--
-- Table structure for table `transitinfo`
--

CREATE TABLE `transitinfo` (
  `TransitId` int(11) NOT NULL,
  `FlightNumber` varchar(300) NOT NULL,
  `FirstTransit` varchar(100) DEFAULT NULL,
  `SecondTransit` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transitinfo`
--

INSERT INTO `transitinfo` (`TransitId`, `FlightNumber`, `FirstTransit`, `SecondTransit`) VALUES
(8, 'BG-101', 'CGP', NULL),
(9, 'BG-102', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `Passord` varchar(300) NOT NULL,
  `FirstName` varchar(300) NOT NULL,
  `LastName` varchar(300) NOT NULL,
  `Email` varchar(300) DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  `Address` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_id`, `user_name`, `Passord`, `FirstName`, `LastName`, `Email`, `Phone`, `Address`) VALUES
(2, 'toufiq97', '123', 'Toufiqul', 'Islam', 'toufiq@gmail.com', '256897456', '123,Rampura,Dhaka'),
(6, 'abir98', 'abir123', 'Rahat Mushfiq', 'Abir', 'abir@gmail.com', '5896745', 'Khilgaon,Dhaka');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminId`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `AdminUserName` (`AdminUserName`);

--
-- Indexes for table `airlines`
--
ALTER TABLE `airlines`
  ADD PRIMARY KEY (`AirlinesId`),
  ADD UNIQUE KEY `LicenseNo` (`LicenseNo`),
  ADD KEY `AdminId` (`AdminId`);

--
-- Indexes for table `airport`
--
ALTER TABLE `airport`
  ADD PRIMARY KEY (`AirportId`),
  ADD UNIQUE KEY `AirportCode` (`AirportCode`),
  ADD KEY `AdminId` (`AdminId`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`ClassId`),
  ADD KEY `FlightClassId` (`FlightClassId`);

--
-- Indexes for table `feeds`
--
ALTER TABLE `feeds`
  ADD PRIMARY KEY (`FeedId`),
  ADD KEY `AdminId` (`AdminId`);

--
-- Indexes for table `flightclass`
--
ALTER TABLE `flightclass`
  ADD PRIMARY KEY (`FlightClassId`),
  ADD KEY `FlightId` (`FlightId`),
  ADD KEY `ClassId` (`ClassId`);

--
-- Indexes for table `flightroot`
--
ALTER TABLE `flightroot`
  ADD PRIMARY KEY (`FlightRootId`),
  ADD KEY `RootId` (`RootId`),
  ADD KEY `FLightId` (`FLightId`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`FlightId`),
  ADD UNIQUE KEY `FLightNumber` (`FLightNumber`),
  ADD KEY `AirlinesId` (`AirlinesId`),
  ADD KEY `RootId` (`RootId`),
  ADD KEY `AdminId` (`AdminId`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentId`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `root`
--
ALTER TABLE `root`
  ADD PRIMARY KEY (`RootId`),
  ADD KEY `DepartureCityAirportCode` (`DepartureCityAirportCode`),
  ADD KEY `DestinationCityAirportCode` (`DestinationCityAirportCode`),
  ADD KEY `AdminId` (`AdminId`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`SeatId`),
  ADD KEY `ClassId` (`ClassId`),
  ADD KEY `FlightId` (`FlightNumber`),
  ADD KEY `TicketId` (`TicketId`);

--
-- Indexes for table `seatinfo`
--
ALTER TABLE `seatinfo`
  ADD PRIMARY KEY (`SeatInfoId`),
  ADD KEY `FLightNumber` (`FLightNumber`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`TicketId`),
  ADD KEY `SeatId` (`SeatId`),
  ADD KEY `PaymentId` (`PaymentId`);

--
-- Indexes for table `timeanddate`
--
ALTER TABLE `timeanddate`
  ADD PRIMARY KEY (`TimeAndDateId`),
  ADD KEY `FlightNumber` (`FlightNumber`);

--
-- Indexes for table `transitinfo`
--
ALTER TABLE `transitinfo`
  ADD PRIMARY KEY (`TransitId`),
  ADD KEY `FlightNumber` (`FlightNumber`),
  ADD KEY `FirstTransit` (`FirstTransit`),
  ADD KEY `SecondTransit` (`SecondTransit`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_id`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Phone` (`Phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `airlines`
--
ALTER TABLE `airlines`
  MODIFY `AirlinesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `airport`
--
ALTER TABLE `airport`
  MODIFY `AirportId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `ClassId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feeds`
--
ALTER TABLE `feeds`
  MODIFY `FeedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `flightclass`
--
ALTER TABLE `flightclass`
  MODIFY `FlightClassId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `flightroot`
--
ALTER TABLE `flightroot`
  MODIFY `FlightRootId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `FlightId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `root`
--
ALTER TABLE `root`
  MODIFY `RootId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `SeatId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seatinfo`
--
ALTER TABLE `seatinfo`
  MODIFY `SeatInfoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `TicketId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `timeanddate`
--
ALTER TABLE `timeanddate`
  MODIFY `TimeAndDateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `transitinfo`
--
ALTER TABLE `transitinfo`
  MODIFY `TransitId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `airlines`
--
ALTER TABLE `airlines`
  ADD CONSTRAINT `airlines_ibfk_1` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `airport`
--
ALTER TABLE `airport`
  ADD CONSTRAINT `airport_ibfk_1` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`FlightClassId`) REFERENCES `flightclass` (`FlightClassId`);

--
-- Constraints for table `feeds`
--
ALTER TABLE `feeds`
  ADD CONSTRAINT `feeds_ibfk_1` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`AirlinesId`) REFERENCES `airlines` (`AirlinesId`),
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`RootId`) REFERENCES `root` (`RootId`),
  ADD CONSTRAINT `flights_ibfk_3` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`);

--
-- Constraints for table `root`
--
ALTER TABLE `root`
  ADD CONSTRAINT `root_ibfk_1` FOREIGN KEY (`DepartureCityAirportCode`) REFERENCES `airport` (`AirportCode`),
  ADD CONSTRAINT `root_ibfk_2` FOREIGN KEY (`DestinationCityAirportCode`) REFERENCES `airport` (`AirportCode`),
  ADD CONSTRAINT `root_ibfk_3` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`),
  ADD CONSTRAINT `seat_ibfk_3` FOREIGN KEY (`TicketId`) REFERENCES `ticket` (`TicketId`);

--
-- Constraints for table `seatinfo`
--
ALTER TABLE `seatinfo`
  ADD CONSTRAINT `seatinfo_ibfk_1` FOREIGN KEY (`FLightNumber`) REFERENCES `flights` (`FLightNumber`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`SeatId`) REFERENCES `seat` (`SeatId`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`PaymentId`) REFERENCES `payment` (`PaymentId`);

--
-- Constraints for table `timeanddate`
--
ALTER TABLE `timeanddate`
  ADD CONSTRAINT `timeanddate_ibfk_1` FOREIGN KEY (`FlightNumber`) REFERENCES `flights` (`FLightNumber`);

--
-- Constraints for table `transitinfo`
--
ALTER TABLE `transitinfo`
  ADD CONSTRAINT `transitinfo_ibfk_1` FOREIGN KEY (`FlightNumber`) REFERENCES `flights` (`FLightNumber`),
  ADD CONSTRAINT `transitinfo_ibfk_2` FOREIGN KEY (`FirstTransit`) REFERENCES `airport` (`AirportCode`),
  ADD CONSTRAINT `transitinfo_ibfk_3` FOREIGN KEY (`SecondTransit`) REFERENCES `airport` (`AirportCode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
