-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2024 at 05:45 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nguyenngocviet_2110900054_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `nguyenngocviet_2110900054_product`
--

CREATE TABLE `nguyenngocviet_2110900054_product` (
  `MaSP_2110900054` int(11) NOT NULL,
  `TenSP_2110900054` varchar(50) DEFAULT NULL,
  `SoLuong_2110900054` int(11) DEFAULT NULL,
  `DonGia_2110900054` float DEFAULT NULL,
  `Anh_2110900054` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nguyenngocviet_2110900054_product`
--

INSERT INTO `nguyenngocviet_2110900054_product` (`MaSP_2110900054`, `TenSP_2110900054`, `SoLuong_2110900054`, `DonGia_2110900054`, `Anh_2110900054`) VALUES
(2110900054, 'Nguyễn Ngọc Việt', 21, 43.3, 'a1.png'),
(4324, 'Bài tập giữa kỳ1', 4312, 23.41, 'a1.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
