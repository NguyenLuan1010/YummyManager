-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 03, 2021 lúc 03:50 AM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `yummymanager`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddNewAccount` (IN `AccID` CHAR(50), IN `UserName` CHAR(50), IN `Email` CHAR(50), IN `Pass` CHAR(50), IN `Type` CHAR(50))  BEGIN
INSERT INTO `tblaccount`(  `ACCOUNTID`, `NAME`, `EMAIL`, `PASSWORD`, `TYPE`) VALUES (AccID,UserName,Email,Pass,`Type`);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewTable` (IN `tableID` TEXT, IN `tableName` TEXT, IN `seatsNumber` INT, IN `floorsNumber` INT, IN `tableStatus` TEXT)  BEGIN
	INSERT INTO  tbltablemap (TABLEID,TABLENAME,SEATSNUMBER,FLOORNUMBER,TABLESTATUS) VALUES (tableID,tableName,seatsNumber,floorsNumber,tableStatus);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `checkDataUser` (IN `phoneNumber` TEXT, IN `passwordHash` TEXT)  BEGIN
     SELECT * FROM tblaccount WHERE PHONENUMBER = phoneNUmber AND PASSWORD = passwordHash;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAccByID` (IN `IDAcc` CHAR(50))  BEGIN
DELETE FROM `tblaccount` WHERE `ACCOUNTID` =  IDAcc;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EditAccount` (IN `userName` CHAR(50), IN `email` CHAR(50), IN `pass` CHAR(50), IN `type` CHAR(50), IN `status` CHAR(50), IN `idAcc` CHAR(50))  BEGIN
UPDATE `tblaccount` SET `NAME`= `userName` ,`EMAIL`= email ,`PASSWORD`= pass,`TYPE`= `type` ,`STATUS`= `status` WHERE `ACCOUNTID` = idAcc ;
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

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataForBill` (IN `BillID` CHAR(50))  BEGIN
SELECT c.DETAILBILLID , a.FOODNAME,SUM(b.FOODQUANTITY) AS FOODQUANTITY,a.FOODPRICE,c.SUMOFPRICE from tblfoodmenu a JOIN tbldetailbill b on a.FOODID=b.FOODID JOIN tblbill c ON c.DETAILBILLID = b.DETAILBILLID WHERE c.DETAILBILLID = BillID GROUP BY a.FOODNAME;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `searchByNameAcc` (IN `inputSQL` CHAR(50))  BEGIN
	SELECT * FROM `tblaccount` WHERE `NAME` LIKE  ''%'+inputSQL+'%'';
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblaccount`
--

CREATE TABLE `tblaccount` (
  `ACCOUNTID` text NOT NULL,
  `NAME` text NOT NULL,
  `EMAIL` text NOT NULL,
  `PASSWORD` text NOT NULL,
  `TYPE` text NOT NULL,
  `STATUS` text NOT NULL DEFAULT 'Unlock'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblaccount`
--

INSERT INTO `tblaccount` (`ACCOUNTID`, `NAME`, `EMAIL`, `PASSWORD`, `TYPE`, `STATUS`) VALUES
('A03', 'Tran DInh Nam', '', '', 'admin', 'unlock'),
('#3089', 'NaM', 'nam@gmail.com', 'Nam123456789', 'Admin', 'UnLock'),
('#11736', 'Tran Dinh Nam', 'Nam@gmail.com', 'Nam123456789', 'Employee', 'Unlock'),
('#13734', 'Tran Dinh Nam', 'Nam@gmail.com', 'Nam123456789', 'Admin', 'Unlock'),
('#14360', 'tran dinh nam', 'NAM@gmail.com', 'Nam123456789', 'Employee', 'Unlock');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblbill`
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
-- Đang đổ dữ liệu cho bảng `tblbill`
--

INSERT INTO `tblbill` (`BILLID`, `DATETIME`, `TABLEID`, `DETAILBILLID`, `SUMOFPRICE`, `BillStatus`) VALUES
('D02', '2021-12-01', 'T01', 'D01', 100, 'On'),
('D03', '2022-01-01', 'T02', 'D02', 10, 'On'),
('D04', '2022-02-01', 'T01', 'D01', 100, 'On');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldetailbill`
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
-- Đang đổ dữ liệu cho bảng `tbldetailbill`
--

INSERT INTO `tbldetailbill` (`DETAILBILLID`, `FOODID`, `TABLEID`, `FOODQUANTITY`, `SUMOFPRICE`, `BILLSTATUS`, `SALECODE`) VALUES
('D01', 'F01', 'T01', 5, 100, 'On', 'ABC123XYZ'),
('D01', 'F02', 'T01', 5, 100, 'On', 'ABC123XYZ'),
('D02', 'F02', 'T01', 10, 200, 'On', 'ABC123XYZ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblfoodmenu`
--

CREATE TABLE `tblfoodmenu` (
  `FOODID` varchar(50) NOT NULL,
  `FOODIMAGE` text NOT NULL,
  `FOODNAME` text NOT NULL,
  `FOODTYPEID` int(20) NOT NULL,
  `FOODMATERIAL` text NOT NULL,
  `FOODSTATUS` text NOT NULL DEFAULT 'Active',
  `FOODPRICE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblfoodmenu`
--

INSERT INTO `tblfoodmenu` (`FOODID`, `FOODIMAGE`, `FOODNAME`, `FOODTYPEID`, `FOODMATERIAL`, `FOODSTATUS`, `FOODPRICE`) VALUES
('F01', 'img5.jpg', 'Hamberger', 1, 'beff,salat,tomato,cheese', 'Active', 30),
('F02', 'img5.jpg', 'Sprite', 1, 'abc,xyz', 'Active', 20),
('F03', 'img5.jpg', 'Thai hot pot', 1, 'a,b,c,d', 'Active', 50),
('F04', 'img5.jpg', 'Fruit bowl', 1, 'x,y,z', 'Active', 40),
('F05', 'img5.jpg', 'food name', 3, 'food material', 'Active', 100),
('F06', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F07', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F08', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F09', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F10', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F11', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F12', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F13', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F14', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F15', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F16', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F17', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100),
('F18', 'img5.jpg', 'name food', 3, 'food material', 'Active', 100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsaledetail`
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
-- Đang đổ dữ liệu cho bảng `tblsaledetail`
--

INSERT INTO `tblsaledetail` (`SALECODE`, `DATESTART`, `DATEEND`, `DECRIPTION`, `DISCOUNT`, `SALESTATUS`) VALUES
('ABC123XYZ', '1-1-2022', '1-2-2022', 'Khuyễn mãi đầu năm', 20, 'Off');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltablemap`
--

CREATE TABLE `tbltablemap` (
  `TABLEID` varchar(50) NOT NULL,
  `SEATSNUMBER` int(11) NOT NULL,
  `FLOORNUMBER` int(11) NOT NULL,
  `TABLESTATUS` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbltablemap`
--

INSERT INTO `tbltablemap` (`TABLEID`, `SEATSNUMBER`, `FLOORNUMBER`, `TABLESTATUS`) VALUES
('T01', 4, 1, 'Active'),
('T02', 2, 2, 'Active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltypefood`
--

CREATE TABLE `tbltypefood` (
  `ID` int(20) NOT NULL,
  `TYPE` text CHARACTER SET utf8mb4 NOT NULL,
  `STATUS` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT 'Unlock'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbltypefood`
--

INSERT INTO `tbltypefood` (`ID`, `TYPE`, `STATUS`) VALUES
(1, 'Main Food', 'Unlock'),
(2, 'Drinks', 'Unlock'),
(3, 'Hot Pot', 'Unlock'),
(4, 'Salad', 'Unlock'),
(5, 'Dessert', 'Unlock');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblbill`
--
ALTER TABLE `tblbill`
  ADD PRIMARY KEY (`BILLID`,`TABLEID`,`DETAILBILLID`),
  ADD KEY `FKTABLEID` (`TABLEID`),
  ADD KEY `FK_DEATILBILLID` (`DETAILBILLID`);

--
-- Chỉ mục cho bảng `tbldetailbill`
--
ALTER TABLE `tbldetailbill`
  ADD PRIMARY KEY (`DETAILBILLID`,`FOODID`,`TABLEID`),
  ADD KEY `FKBILLTABLEID` (`TABLEID`),
  ADD KEY `FK_DETAIL_FOODID` (`FOODID`),
  ADD KEY `FK_SALECODE` (`SALECODE`);

--
-- Chỉ mục cho bảng `tblfoodmenu`
--
ALTER TABLE `tblfoodmenu`
  ADD PRIMARY KEY (`FOODID`),
  ADD KEY `FK_TYPEFOOD` (`FOODTYPEID`);

--
-- Chỉ mục cho bảng `tblsaledetail`
--
ALTER TABLE `tblsaledetail`
  ADD PRIMARY KEY (`SALECODE`);

--
-- Chỉ mục cho bảng `tbltablemap`
--
ALTER TABLE `tbltablemap`
  ADD PRIMARY KEY (`TABLEID`);

--
-- Chỉ mục cho bảng `tbltypefood`
--
ALTER TABLE `tbltypefood`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbltypefood`
--
ALTER TABLE `tbltypefood`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tblbill`
--
ALTER TABLE `tblbill`
  ADD CONSTRAINT `FKTABLEID` FOREIGN KEY (`TABLEID`) REFERENCES `tbltablemap` (`TABLEID`),
  ADD CONSTRAINT `FK_DEATILBILLID` FOREIGN KEY (`DETAILBILLID`) REFERENCES `tbldetailbill` (`DETAILBILLID`);

--
-- Các ràng buộc cho bảng `tbldetailbill`
--
ALTER TABLE `tbldetailbill`
  ADD CONSTRAINT `FKBILLTABLEID` FOREIGN KEY (`TABLEID`) REFERENCES `tbltablemap` (`TABLEID`),
  ADD CONSTRAINT `FK_DETAIL_FOODID` FOREIGN KEY (`FOODID`) REFERENCES `tblfoodmenu` (`FOODID`),
  ADD CONSTRAINT `FK_SALECODE` FOREIGN KEY (`SALECODE`) REFERENCES `tblsaledetail` (`SALECODE`);

--
-- Các ràng buộc cho bảng `tblfoodmenu`
--
ALTER TABLE `tblfoodmenu`
  ADD CONSTRAINT `FK_TYPEFOOD` FOREIGN KEY (`FOODTYPEID`) REFERENCES `tbltypefood` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;