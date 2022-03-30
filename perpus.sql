-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2021 at 10:22 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `judul_buku` varchar(255) DEFAULT NULL,
  `pengarang` varchar(255) DEFAULT NULL,
  `penerbit` varchar(255) DEFAULT NULL,
  `tahun_terbit` int(5) DEFAULT NULL,
  `ketersediaan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul_buku`, `pengarang`, `penerbit`, `tahun_terbit`, `ketersediaan`) VALUES
(2, 'siksa kubur', 'aku', 'hidup', 2005, 513),
(6, 'abc', 'a', 'babababa', 2013, 21),
(8, 'kursi', 'abc', 'a', 2010, 3);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `username`, `nama`, `role`, `password`) VALUES
(1, 'admin', 'aldi rio setiawan', 1, '12345'),
(2, 'bambang', 'bambang', 0, '12345'),
(3, 'abdul', 'abdul', 2, '12345'),
(4, '1915026043', 'Naufal Najib', 0, '1915026043'),
(5, 'nestha', 'nestha', 2, '12345'),
(7, '1915026041', 'dira', 0, '26041'),
(8, '1915026001', 'ghozali', 1, '26001');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_buku`
--

CREATE TABLE `transaksi_buku` (
  `id` int(11) NOT NULL,
  `peminjam` int(11) DEFAULT NULL,
  `buku` int(11) DEFAULT NULL,
  `tangga_pinjam` datetime DEFAULT NULL,
  `batas_kembali` datetime DEFAULT NULL,
  `tangga_kembali` datetime DEFAULT NULL,
  `sts_pengembalian` varchar(50) DEFAULT NULL,
  `denda` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi_buku`
--

INSERT INTO `transaksi_buku` (`id`, `peminjam`, `buku`, `tangga_pinjam`, `batas_kembali`, `tangga_kembali`, `sts_pengembalian`, `denda`) VALUES
(16, 4, 2, '2021-05-18 00:00:00', '2021-05-25 00:00:00', NULL, 'Belum Kembali', '0'),
(18, 4, 8, '2021-05-18 00:00:00', '2021-05-25 00:00:00', NULL, 'Belum Kembali', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `transaksi_buku`
--
ALTER TABLE `transaksi_buku`
  ADD PRIMARY KEY (`id`),
  ADD KEY `meminjam` (`peminjam`),
  ADD KEY `dipinjam` (`buku`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaksi_buku`
--
ALTER TABLE `transaksi_buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi_buku`
--
ALTER TABLE `transaksi_buku`
  ADD CONSTRAINT `dipinjam` FOREIGN KEY (`buku`) REFERENCES `buku` (`id`),
  ADD CONSTRAINT `meminjam` FOREIGN KEY (`peminjam`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
