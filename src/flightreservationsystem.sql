-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2018 at 03:30 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `airlines`
--

CREATE TABLE `airlines` (
  `AirlinesId` int(11) NOT NULL,
  `AirlinesName` varchar(300) NOT NULL,
  `AdminId` int(11) NOT NULL,
  `FlightAirlinesId` int(11) NOT NULL,
  `CountryName` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Table structure for table `flightairlines`
--

CREATE TABLE `flightairlines` (
  `FlightAirlinesId` int(11) NOT NULL,
  `FlightId` int(11) NOT NULL,
  `AirlinesId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `FlightAirlinesId` int(11) NOT NULL,
  `DepartureTime` time NOT NULL,
  `DepartureDate` date NOT NULL,
  `AdminId` int(11) NOT NULL,
  `FlightRootId` int(11) NOT NULL,
  `FlightClassId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `DeparturePlace` varchar(300) NOT NULL,
  `DestinationPlace` varchar(300) NOT NULL,
  `FlightRootId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `SeatId` int(11) NOT NULL,
  `ClassId` int(11) NOT NULL,
  `FlightId` int(11) NOT NULL,
  `TicketId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `airlines`
--
ALTER TABLE `airlines`
  ADD PRIMARY KEY (`AirlinesId`),
  ADD KEY `AdminId` (`AdminId`),
  ADD KEY `FlightAirlinesId` (`FlightAirlinesId`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`ClassId`),
  ADD KEY `FlightClassId` (`FlightClassId`);

--
-- Indexes for table `flightairlines`
--
ALTER TABLE `flightairlines`
  ADD PRIMARY KEY (`FlightAirlinesId`),
  ADD KEY `AirlinesId` (`AirlinesId`),
  ADD KEY `FlightId` (`FlightId`);

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
  ADD KEY `FlightAirlinesId` (`FlightAirlinesId`),
  ADD KEY `AdminId` (`AdminId`),
  ADD KEY `FlightRootId` (`FlightRootId`),
  ADD KEY `FlightClassId` (`FlightClassId`);

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
  ADD KEY `FlightRootId` (`FlightRootId`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`SeatId`),
  ADD KEY `ClassId` (`ClassId`),
  ADD KEY `FlightId` (`FlightId`),
  ADD KEY `TicketId` (`TicketId`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`TicketId`),
  ADD KEY `SeatId` (`SeatId`),
  ADD KEY `PaymentId` (`PaymentId`);

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
  MODIFY `AdminId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `airlines`
--
ALTER TABLE `airlines`
  MODIFY `AirlinesId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `ClassId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `flightairlines`
--
ALTER TABLE `flightairlines`
  MODIFY `FlightAirlinesId` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `FlightId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `root`
--
ALTER TABLE `root`
  MODIFY `RootId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `SeatId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `TicketId` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `airlines_ibfk_1` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`),
  ADD CONSTRAINT `airlines_ibfk_2` FOREIGN KEY (`FlightAirlinesId`) REFERENCES `flightairlines` (`FlightAirlinesId`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`FlightClassId`) REFERENCES `flightclass` (`FlightClassId`);

--
-- Constraints for table `flightairlines`
--
ALTER TABLE `flightairlines`
  ADD CONSTRAINT `flightairlines_ibfk_1` FOREIGN KEY (`AirlinesId`) REFERENCES `airlines` (`AirlinesId`),
  ADD CONSTRAINT `flightairlines_ibfk_2` FOREIGN KEY (`FlightId`) REFERENCES `flights` (`FlightId`);

--
-- Constraints for table `flightclass`
--
ALTER TABLE `flightclass`
  ADD CONSTRAINT `flightclass_ibfk_1` FOREIGN KEY (`FlightId`) REFERENCES `flights` (`FlightId`),
  ADD CONSTRAINT `flightclass_ibfk_2` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`);

--
-- Constraints for table `flightroot`
--
ALTER TABLE `flightroot`
  ADD CONSTRAINT `flightroot_ibfk_1` FOREIGN KEY (`RootId`) REFERENCES `root` (`RootId`),
  ADD CONSTRAINT `flightroot_ibfk_2` FOREIGN KEY (`FLightId`) REFERENCES `flights` (`FlightId`);

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`FlightAirlinesId`) REFERENCES `flightairlines` (`FlightAirlinesId`),
  ADD CONSTRAINT `flights_ibfk_2` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`),
  ADD CONSTRAINT `flights_ibfk_3` FOREIGN KEY (`FlightRootId`) REFERENCES `flightroot` (`FlightRootId`),
  ADD CONSTRAINT `flights_ibfk_4` FOREIGN KEY (`FlightClassId`) REFERENCES `flightclass` (`FlightClassId`),
  ADD CONSTRAINT `flights_ibfk_5` FOREIGN KEY (`FlightClassId`) REFERENCES `flightclass` (`FlightClassId`),
  ADD CONSTRAINT `flights_ibfk_6` FOREIGN KEY (`FlightClassId`) REFERENCES `flightclass` (`FlightClassId`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`);

--
-- Constraints for table `root`
--
ALTER TABLE `root`
  ADD CONSTRAINT `root_ibfk_1` FOREIGN KEY (`FlightRootId`) REFERENCES `flightroot` (`FlightRootId`);

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`),
  ADD CONSTRAINT `seat_ibfk_2` FOREIGN KEY (`FlightId`) REFERENCES `flights` (`FlightId`),
  ADD CONSTRAINT `seat_ibfk_3` FOREIGN KEY (`TicketId`) REFERENCES `ticket` (`TicketId`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`SeatId`) REFERENCES `seat` (`SeatId`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`PaymentId`) REFERENCES `payment` (`PaymentId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
