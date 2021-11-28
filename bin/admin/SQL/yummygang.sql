-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2021 at 03:20 PM
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
-- Database: `yummygang`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewTable` (IN `tableID` TEXT, IN `tableName` TEXT, IN `seatsNumber` INT, IN `floorsNumber` INT, IN `tableStatus` TEXT)  BEGIN
	INSERT INTO  tbltablemap (TABLEID,TABLENAME,SEATSNUMBER,FLOORNUMBER,TABLESTATUS) VALUES (tableID,tableName,seatsNumber,floorsNumber,tableStatus);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `checkDataUser` (IN `phoneNumber` TEXT, IN `passwordHash` TEXT)  BEGIN
     SELECT * FROM tblaccount WHERE PHONENUMBER = phoneNUmber AND PASSWORD = passwordHash;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editTableMap` (IN `tableName` TEXT, IN `seatsNumber` INT, IN `floorsNumber` INT, IN `tableStatus` TEXT, IN `tableID` TEXT)  BEGIN
   UPDATE tbltablemap SET TABLENAME =tableName,SEATSNUMBER=seatsNumber,FLOORNUMBER=floorsNumber,TABLESTATUS=tableStatus WHERE `tbltablemap`.`TABLEID`= tableID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `filterDate` (IN `DateStart` CHAR(50), IN `DateEnd` CHAR(50))  BEGIN
SELECT * FROM `tblbill` WHERE DATETIME BETWEEN DateStart AND DateEnd ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAccount` ()  BEGIN
   SELECT * FROM tblaccount;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllBillOrder` ()  BEGIN
SELECT * FROM `tblbill`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllTable` ()  BEGIN
   SELECT * FROM tbltablemap;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataForBill` (IN `BillID` CHAR(50))  BEGIN
SELECT c.DETAILBILLID , a.FOODNAME,SUM(b.FOODQUANTITY) AS FOODQUANTITY,a.FOODPRICE,c.SUMOFPRICE from tblfoodmenu a JOIN tbldetailbill b on a.FOODID=b.FOODID JOIN tblbill c ON c.DETAILBILLID = b.DETAILBILLID WHERE c.DETAILBILLID = BillID GROUP BY a.FOODNAME;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tblaccount`
--

CREATE TABLE `tblaccount` (
  `ACCOUNTID` text NOT NULL,
  `NAME` text NOT NULL,
  `EMAIL` text NOT NULL,
  `PASSWORD` text NOT NULL,
  `TYPE` text NOT NULL,
  `STATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblaccount`
--

INSERT INTO `tblaccount` (`ACCOUNTID`, `NAME`, `EMAIL`, `PASSWORD`, `TYPE`, `STATUS`) VALUES
('A01', 'Trần Đình Nam', 'Nam@gmail.com', 'Nam123456', 'Admin', 'Unlock'),
('A02', 'Nguyễn Văn Luận', 'Luan@gmail.com', 'Luan123456', 'Admin', 'Unlock');

-- --------------------------------------------------------

--
-- Table structure for table `tblbill`
--

CREATE TABLE `tblbill` (
  `BILLID` varchar(50) NOT NULL,
  `DATETIME` text NOT NULL,
  `TABLEID` varchar(50) NOT NULL,
  `DETAILBILLID` varchar(50) NOT NULL,
  `SUMOFPRICE` double NOT NULL,
  `BillStatus` varchar(50) NOT NULL DEFAULT 'On'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblbill`
--

INSERT INTO `tblbill` (`BILLID`, `DATETIME`, `TABLEID`, `DETAILBILLID`, `SUMOFPRICE`, `BillStatus`) VALUES
('D02', '2021-12-01', 'T01', 'D01', 100, 'On'),
('D03', '2022-01-01', 'T02', 'D02', 10, 'On'),
('D04', '2022-02-01', 'T01', 'D01', 100, 'On');

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
  `BILLSTATUS` text NOT NULL DEFAULT 'On',
  `SALECODE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbldetailbill`
--

INSERT INTO `tbldetailbill` (`DETAILBILLID`, `FOODID`, `TABLEID`, `FOODQUANTITY`, `SUMOFPRICE`, `BILLSTATUS`, `SALECODE`) VALUES
('D01', 'F01', 'T01', 5, 100, 'On', 'ABC123XYZ'),
('D01', 'F02', 'T01', 5, 100, 'On', 'ABC123XYZ'),
('D02', 'F02', 'T01', 10, 200, 'On', 'ABC123XYZ');

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
  `FOODSTATUS` text NOT NULL DEFAULT 'Active',
  `FOODPRICE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblfoodmenu`
--

INSERT INTO `tblfoodmenu` (`FOODID`, `FOODIMAGE`, `FOODNAME`, `FOODTYPE`, `FOODMATERIAL`, `FOODSTATUS`, `FOODPRICE`) VALUES
('F01', 'Image1', 'HAMBERGER', 'Fastfood', 'beff,salat,tomato,cheese', 'Active', 30),
('F02', 'Image2', 'Italy Noodle', 'Fastfood', 'noodle,tomato and meat source', 'Active', 20),
('F03', 'Image3', 'Ramen', 'Fast food', 'a,b,c,d', 'Active', 50),
('F04', 'Image4', 'KFC Chicken', 'Fast Food', 'x,y,z', 'Active', 40);

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

--
-- Dumping data for table `tblsaledetail`
--

INSERT INTO `tblsaledetail` (`SALECODE`, `DATESTART`, `DATEEND`, `DECRIPTION`, `DISCOUNT`, `SALESTATUS`) VALUES
('ABC123XYZ', '1-1-2022', '1-2-2022', 'Khuyễn mãi đầu năm', 20, 'Off');

-- --------------------------------------------------------

--
-- Table structure for table `tbltablemap`
--

CREATE TABLE `tbltablemap` (
  `TABLEID` varchar(50) NOT NULL,
  `TABLENAME` text NOT NULL,
  `SEATSNUMBER` int(11) NOT NULL,
  `FLOORNUMBER` int(11) NOT NULL,
  `TABLESTATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbltablemap`
--

INSERT INTO `tbltablemap` (`TABLEID`, `TABLENAME`, `SEATSNUMBER`, `FLOORNUMBER`, `TABLESTATUS`) VALUES
('T01', 'Bàn T01 tầng 1', 4, 1, 'Active'),
('T02', 'bàn T02 tầng 2', 4, 2, 'Full'),
('T03', 'Bàn T03 tầng 1', 4, 1, 'Empty'),
('T04', 'Bàn T04 tầng 1', 4, 1, 'Empty'),
('T05', 'Bàn T05 tầng 1', 2, 1, 'Inactive'),
('T06', 'Bàn T06 tầng 2', 4, 2, 'Full'),
('T07', 'Bàn T07 tầng 1', 4, 1, 'Empty'),
('T08', 'Bàn T08 tầng 2', 2, 2, 'Empty'),
('T09', 'Bàn T09 tầng 1', 4, 1, 'Full'),
('T10', 'Bàn T10 tầng 2', 2, 2, 'Empty'),
('T11', 'Bàn T11 tầng 2', 4, 2, 'Full'),
('T12', 'Bàn T12 tầng 2', 4, 2, 'Empty'),
('T13', 'Bàn T13 tầng 2', 4, 2, 'Empty'),
('T14', 'bàn T14 tầng 1', 2, 1, 'Empty'),
('T15', 'Bàn T15 tầng 2', 4, 2, 'Full'),
('T16', 'Bàn T16 tầng 2', 4, 2, 'Empty'),
('T17', 'Bàn T17 tầng 1', 2, 1, 'Full'),
('T18 ', 'Bàn T18 tầng 2', 2, 1, 'Full'),
('T20', 'Bàn T20 tầng 2', 4, 2, 'Full'),
('T23', 'Bàn T23 tầng 2', 4, 2, 'Empty');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbill`
--
ALTER TABLE `tblbill`
  ADD PRIMARY KEY (`BILLID`,`TABLEID`,`DETAILBILLID`),
  ADD KEY `FKTABLEID` (`TABLEID`),
  ADD KEY `FK_DEATILBILLID` (`DETAILBILLID`);

--
-- Indexes for table `tbldetailbill`
--
ALTER TABLE `tbldetailbill`
  ADD PRIMARY KEY (`DETAILBILLID`,`FOODID`,`TABLEID`),
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
  ADD CONSTRAINT `FKTABLEID` FOREIGN KEY (`TABLEID`) REFERENCES `tbltablemap` (`TABLEID`),
  ADD CONSTRAINT `FK_DEATILBILLID` FOREIGN KEY (`DETAILBILLID`) REFERENCES `tbldetailbill` (`DETAILBILLID`);

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