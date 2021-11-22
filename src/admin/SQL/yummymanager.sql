-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2021 at 11:07 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yummymanager`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkDataUser` (IN `phoneNumber` TEXT, IN `passwordHash` TEXT)  BEGIN
     SELECT * FROM tblaccount WHERE PHONENUMBER = phoneNUmber AND PASSWORD = passwordHash;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAccount` ()  BEGIN
   SELECT * FROM tblaccount;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tblaccount`
--

CREATE TABLE `tblaccount` (
  `ACCOUNTID` text NOT NULL,
  `NAME` text NOT NULL,
  `PHONENUMBER` text NOT NULL,
  `PASSWORD` text NOT NULL,
  `TYPE` text NOT NULL,
  `STATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblaccount`
--

INSERT INTO `tblaccount` (`ACCOUNTID`, `NAME`, `PHONENUMBER`, `PASSWORD`, `TYPE`, `STATUS`) VALUES
('A01', 'Tran Dinh Nam', '0357430668', 'Nam123456', 'Admin', 'Unlock'),
('A02', 'Pham Nhu Hoang Phuc', '0348231234', 'Phuc13579', 'Employee', 'Unlock');

-- --------------------------------------------------------

--
-- Table structure for table `tblbill`
--

CREATE TABLE `tblbill` (
  `BILLID` varchar(50) NOT NULL,
  `DATETIME` text NOT NULL,
  `TABLEID` varchar(50) NOT NULL,
  `DETAILBILLID` varchar(50) NOT NULL,
  `SUMOFPRICE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblbill`
--

INSERT INTO `tblbill` (`BILLID`, `DATETIME`, `TABLEID`, `DETAILBILLID`, `SUMOFPRICE`) VALUES
('B01', '22-11-2021', 'T01', '', 30);

-- --------------------------------------------------------

--
-- Table structure for table `tbldetailbill`
--

CREATE TABLE `tbldetailbill` (
  `DETAILBILLID` varchar(50) NOT NULL,
  `FOODID` varchar(50) NOT NULL,
  `TABLEID` varchar(50) NOT NULL,
  `FOODQUANTITY` int(10) NOT NULL,
  `SUMOFPRICE` double NOT NULL,
  `BILLSTATUS` text NOT NULL,
  `SALECODE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tblfoodmenu`
--

CREATE TABLE `tblfoodmenu` (
  `FOODID` varchar(50) NOT NULL,
  `FOODIMAGE` text NOT NULL,
  `FOODNAME` text NOT NULL,
  `FOODTYPE` text NOT NULL,
  `FOODMATERIAL` text NOT NULL,
  `FOODSTATUS` text NOT NULL,
  `FOODPRICE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblfoodmenu`
--

INSERT INTO `tblfoodmenu` (`FOODID`, `FOODIMAGE`, `FOODNAME`, `FOODTYPE`, `FOODMATERIAL`, `FOODSTATUS`, `FOODPRICE`) VALUES
('F01', 'Image1', 'HAMBERGER', 'Fastfood', 'beff,salat,tomato,cheese', 'Active', 30),
('F02', 'Image2', 'Italy Noodle', 'Fastfood', 'noodle,tomato and meat source', 'Active', 20);

-- --------------------------------------------------------

--
-- Table structure for table `tblsaledetail`
--

CREATE TABLE `tblsaledetail` (
  `SALECODE` varchar(50) NOT NULL,
  `DATESTART` text NOT NULL,
  `DATEEND` text NOT NULL,
  `DECRIPTION` text NOT NULL,
  `DISCOUNT` int(11) NOT NULL,
  `SALESTATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbltablemap`
--

CREATE TABLE `tbltablemap` (
  `TABLEID` varchar(50) NOT NULL,
  `SEATSNUMBER` int(11) NOT NULL,
  `FLOORNUMBER` int(11) NOT NULL,
  `TABLESTATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbltablemap`
--

INSERT INTO `tbltablemap` (`TABLEID`, `SEATSNUMBER`, `FLOORNUMBER`, `TABLESTATUS`) VALUES
('T01', 4, 1, 'Active'),
('T02', 2, 2, 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbill`
--
ALTER TABLE `tblbill`
  ADD PRIMARY KEY (`BILLID`),
  ADD KEY `FKTABLEID` (`TABLEID`);

--
-- Indexes for table `tbldetailbill`
--
ALTER TABLE `tbldetailbill`
  ADD PRIMARY KEY (`DETAILBILLID`),
  ADD KEY `FKBILLTABLEID` (`TABLEID`),
  ADD KEY `FK_DETAIL_FOODID` (`FOODID`),
  ADD KEY `FK_SALECODE` (`SALECODE`);

--
-- Indexes for table `tblfoodmenu`
--
ALTER TABLE `tblfoodmenu`
  ADD PRIMARY KEY (`FOODID`);

--
-- Indexes for table `tblsaledetail`
--
ALTER TABLE `tblsaledetail`
  ADD PRIMARY KEY (`SALECODE`);

--
-- Indexes for table `tbltablemap`
--
ALTER TABLE `tbltablemap`
  ADD PRIMARY KEY (`TABLEID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblbill`
--
ALTER TABLE `tblbill`
  ADD CONSTRAINT `FKTABLEID` FOREIGN KEY (`TABLEID`) REFERENCES `tbltablemap` (`TABLEID`);

--
-- Constraints for table `tbldetailbill`
--
ALTER TABLE `tbldetailbill`
  ADD CONSTRAINT `FKBILLTABLEID` FOREIGN KEY (`TABLEID`) REFERENCES `tbltablemap` (`TABLEID`),
  ADD CONSTRAINT `FK_DETAIL_FOODID` FOREIGN KEY (`FOODID`) REFERENCES `tblfoodmenu` (`FOODID`),
  ADD CONSTRAINT `FK_SALECODE` FOREIGN KEY (`SALECODE`) REFERENCES `tblsaledetail` (`SALECODE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
