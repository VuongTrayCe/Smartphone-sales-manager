-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: smartphonemanagement
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baohanh`
--

DROP TABLE IF EXISTS `baohanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baohanh` (
  `Mabaohanh` varchar(20) NOT NULL,
  `Ngaybatdau` datetime NOT NULL,
  `Ngayketthuc` datetime NOT NULL,
  `Chitietbaohanh` varchar(200) NOT NULL,
  `Trangthai` tinyint NOT NULL,
  PRIMARY KEY (`Mabaohanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `mactdh` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Masp` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Madh` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Soluong` int NOT NULL,
  PRIMARY KEY (`mactdh`),
  KEY `Fk_chitietdonhang_sanpham_idx` (`Masp`),
  KEY `Fk_chitietdonhang_donhang_idx` (`Madh`),
  CONSTRAINT `Fk_chitietdonhang_donhang` FOREIGN KEY (`Madh`) REFERENCES `donhang` (`Madh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_chitietdonhang_sanpham` FOREIGN KEY (`Masp`) REFERENCES `sanpham` (`Masp`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `MaChiTietPhieuNhap` varchar(20) NOT NULL,
  `Masp` varchar(20) NOT NULL,
  `Maphieunhap` varchar(20) NOT NULL,
  `GiaNhap` int NOT NULL,
  `Soluong` int NOT NULL,
  PRIMARY KEY (`MaChiTietPhieuNhap`),
  KEY `Fk_chitietphieunhap_sanpham_idx` (`Masp`),
  KEY `Fk_chitietphieunhap_phieunhap_idx` (`Maphieunhap`),
  CONSTRAINT `Fk_chitietphieunhap_phieunhap` FOREIGN KEY (`Maphieunhap`) REFERENCES `phieunhap` (`Maphieunhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_chitietphieunhap_sanpham` FOREIGN KEY (`Masp`) REFERENCES `sanpham` (`Masp`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `Madh` varchar(20) NOT NULL,
  `Makh` varchar(20) NOT NULL,
  `Manv` varchar(20) NOT NULL,
  `Makm` varchar(20) NOT NULL,
  `Mabaohanh` varchar(20) NOT NULL,
  `Ngayban` varchar(20) NOT NULL,
  `SoLuong` int NOT NULL,
  `Tongtien` double NOT NULL,
  PRIMARY KEY (`Madh`),
  KEY `FK_donhang_khachhang_idx` (`Makh`),
  KEY `FK_donhang_nhanvien_idx` (`Manv`),
  KEY `FK_donhang_khuyenmai_idx` (`Makm`),
  KEY `Fk_donhang_baohanh_idx` (`Mabaohanh`),
  CONSTRAINT `Fk_donhang_baohanh` FOREIGN KEY (`Mabaohanh`) REFERENCES `baohanh` (`Mabaohanh`) ON UPDATE CASCADE,
  CONSTRAINT `FK_donhang_khachhang` FOREIGN KEY (`Makh`) REFERENCES `khachhang` (`Makh`) ON UPDATE CASCADE,
  CONSTRAINT `FK_donhang_khuyenmai` FOREIGN KEY (`Makm`) REFERENCES `khuyenmai` (`Makm`) ON UPDATE CASCADE,
  CONSTRAINT `FK_donhang_nhanvien` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Manv`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `giasanpham`
--

DROP TABLE IF EXISTS `giasanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giasanpham` (
  `Magiasp` varchar(20) NOT NULL,
  `Masp` varchar(20) NOT NULL,
  `Giaban` double NOT NULL,
  `Ngayupdate` varchar(20) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Magiasp`),
  KEY `FK_giasanpham_sanpham_idx` (`Masp`),
  CONSTRAINT `FK_giasanpham_sanpham` FOREIGN KEY (`Masp`) REFERENCES `sanpham` (`Masp`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `Makh` varchar(20) NOT NULL,
  `Tenkh` varchar(100) NOT NULL,
  `SDT` int NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Makh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `Makm` varchar(20) NOT NULL,
  `Loaikm` varchar(100) NOT NULL,
  `Ngaybatdau` varchar(20) NOT NULL,
  `Ngayketthuc` varchar(20) NOT NULL,
  PRIMARY KEY (`Makm`,`Ngayketthuc`,`Ngaybatdau`,`Loaikm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `Mancc` varchar(20) NOT NULL,
  `Tenncc` varchar(100) NOT NULL,
  `SDT` int NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Mancc`),
  UNIQUE KEY `Mancc_UNIQUE` (`Mancc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `Manv` varchar(20) NOT NULL,
  `Tennv` varchar(100) NOT NULL,
  `SoCCCD` int NOT NULL,
  `Tuoi` int NOT NULL,
  `Diachi` varchar(100) NOT NULL,
  `ChucDanh` varchar(50) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Manv`),
  UNIQUE KEY `Manv_UNIQUE` (`Manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `Maphieunhap` varchar(20) NOT NULL,
  `Manv` varchar(20) NOT NULL,
  `Mancc` varchar(20) NOT NULL,
  `SoLuong` int NOT NULL,
  `NgayNhap` varchar(20) NOT NULL,
  `TongTien` double NOT NULL,
  PRIMARY KEY (`Maphieunhap`),
  KEY `FK_phieunhap_nhanvien_idx` (`Manv`),
  KEY `FK_phieunhap_nhacungcap_idx` (`Mancc`),
  CONSTRAINT `FK_phieunhap_nhacungcap` FOREIGN KEY (`Mancc`) REFERENCES `nhacungcap` (`Mancc`) ON UPDATE CASCADE,
  CONSTRAINT `FK_phieunhap_nhanvien` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Manv`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quyen`
--

DROP TABLE IF EXISTS `quyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyen` (
  `Maquyen` varchar(20) NOT NULL,
  `Tenquyen` varchar(20) NOT NULL,
  PRIMARY KEY (`Maquyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quyen_tk`
--

DROP TABLE IF EXISTS `quyen_tk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyen_tk` (
  `Maquyentk` varchar(20) NOT NULL,
  `Matk` varchar(20) NOT NULL,
  `Maquyen` varchar(20) NOT NULL,
  PRIMARY KEY (`Maquyentk`),
  KEY `Fk_quyentk_taikhoan_idx` (`Matk`),
  KEY `FK_quyentk_quyen_idx` (`Maquyen`),
  CONSTRAINT `FK_quyentk_quyen` FOREIGN KEY (`Maquyen`) REFERENCES `quyen` (`Maquyen`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_quyentk_taikhoan` FOREIGN KEY (`Matk`) REFERENCES `taikhoan` (`Matk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `Masp` varchar(20) NOT NULL,
  `Tensp` varchar(100) NOT NULL,
  `Loaisp` varchar(20) NOT NULL,
  `soluong` int NOT NULL,
  `MauSac` varchar(100) NOT NULL,
  `Namsx` varchar(20) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Masp`),
  UNIQUE KEY `Masp_UNIQUE` (`Masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `Matk` varchar(20) NOT NULL,
  `Manv` varchar(20) NOT NULL,
  `Tendangnhap` varchar(20) NOT NULL,
  `Matkhau` varchar(100) NOT NULL,
  `TrangThai` varchar(20) NOT NULL,
  PRIMARY KEY (`Matk`),
  KEY `Fk_taikhoan_nhanvien_idx` (`Manv`),
  CONSTRAINT `Fk_taikhoan_nhanvien` FOREIGN KEY (`Manv`) REFERENCES `nhanvien` (`Manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16  0:18:34
