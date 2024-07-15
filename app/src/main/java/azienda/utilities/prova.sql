CREATE DATABASE  IF NOT EXISTS `azienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `azienda`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: azienda
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amministratore` (
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  UNIQUE KEY `FKDip_Amm_IND` (`CodiceFiscale`),
  CONSTRAINT `FKDip_Amm_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `dipendente` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES ('CF001'),('CF002'),('CF003'),('CF004'),('CF005');
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoriaprodotto`
--

DROP TABLE IF EXISTS `categoriaprodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoriaprodotto` (
  `NomeProdotto` char(30) NOT NULL,
  `Pro_Percentuale` float DEFAULT NULL,
  PRIMARY KEY (`NomeProdotto`),
  UNIQUE KEY `ID_CategoriaProdotto_IND` (`NomeProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriaprodotto`
--

LOCK TABLES `categoriaprodotto` WRITE;
/*!40000 ALTER TABLE `categoriaprodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoriaprodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colore`
--

DROP TABLE IF EXISTS `colore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colore` (
  `CodiceProdotto` char(20) NOT NULL,
  `Colore` char(20) NOT NULL,
  PRIMARY KEY (`CodiceProdotto`,`Colore`),
  UNIQUE KEY `ID_Colore_IND` (`CodiceProdotto`,`Colore`),
  CONSTRAINT `FKVer_Col` FOREIGN KEY (`CodiceProdotto`) REFERENCES `versioneprodotto` (`CodiceProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colore`
--

LOCK TABLES `colore` WRITE;
/*!40000 ALTER TABLE `colore` DISABLE KEYS */;
/*!40000 ALTER TABLE `colore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credito`
--

DROP TABLE IF EXISTS `credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credito` (
  `CodiceSconto` char(10) NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`,`CodiceSconto`),
  UNIQUE KEY `ID_Credito_IND` (`CodiceFiscale`,`CodiceSconto`),
  KEY `FKCre_Sco_IND` (`CodiceSconto`),
  CONSTRAINT `FKCre_Sco_FK` FOREIGN KEY (`CodiceSconto`) REFERENCES `scontoutente` (`CodiceSconto`),
  CONSTRAINT `FKCre_Ute` FOREIGN KEY (`CodiceFiscale`) REFERENCES `utenteonline` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credito`
--

LOCK TABLES `credito` WRITE;
/*!40000 ALTER TABLE `credito` DISABLE KEYS */;
INSERT INTO `credito` VALUES ('SCONTO10','RCCPLA75A01H501V'),('SCONTO15','FRRGLL90A01H501X'),('SCONTO20','FRRGLL90A01H501X');
/*!40000 ALTER TABLE `credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datifatturazione`
--

DROP TABLE IF EXISTS `datifatturazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datifatturazione` (
  `IBAN` char(1) NOT NULL,
  `Via` char(20) NOT NULL,
  `CAP` int NOT NULL,
  `NumCivico` int NOT NULL,
  PRIMARY KEY (`IBAN`),
  UNIQUE KEY `FKFatturazione_ID` (`Via`,`CAP`,`NumCivico`),
  UNIQUE KEY `ID_DatiFatturazione_IND` (`IBAN`),
  UNIQUE KEY `FKFatturazione_IND` (`Via`,`CAP`,`NumCivico`),
  CONSTRAINT `FKFatturazione_FK` FOREIGN KEY (`Via`, `CAP`, `NumCivico`) REFERENCES `indirizzo` (`Via`, `CAP`, `NumCivico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datifatturazione`
--

LOCK TABLES `datifatturazione` WRITE;
/*!40000 ALTER TABLE `datifatturazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `datifatturazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dettaglioordine`
--

DROP TABLE IF EXISTS `dettaglioordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dettaglioordine` (
  `CodiceOrdine` char(20) NOT NULL,
  `Quantita` int NOT NULL,
  `NumeroLinea` int NOT NULL,
  `CodPacco` char(20) DEFAULT NULL,
  `CodiceProdotto` char(20) NOT NULL,
  `CodMagazzino` char(20) DEFAULT NULL,
  PRIMARY KEY (`CodiceOrdine`,`NumeroLinea`),
  UNIQUE KEY `ID_DettaglioOrdine_IND` (`CodiceOrdine`,`NumeroLinea`),
  UNIQUE KEY `FKGes_Det_ID` (`CodPacco`),
  UNIQUE KEY `FKGes_Det_IND` (`CodPacco`),
  KEY `FKRiferimento_IND` (`CodiceProdotto`),
  KEY `FKCommissionato_IND` (`CodMagazzino`),
  CONSTRAINT `FKCommissionato_FK` FOREIGN KEY (`CodMagazzino`) REFERENCES `magazzino` (`CodMagazzino`),
  CONSTRAINT `FKComposizione` FOREIGN KEY (`CodiceOrdine`) REFERENCES `ordine` (`CodiceOrdine`),
  CONSTRAINT `FKGes_Det_FK` FOREIGN KEY (`CodPacco`) REFERENCES `gestioneordine` (`CodPacco`),
  CONSTRAINT `FKRiferimento_FK` FOREIGN KEY (`CodiceProdotto`) REFERENCES `versioneprodotto` (`CodiceProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dettaglioordine`
--

LOCK TABLES `dettaglioordine` WRITE;
/*!40000 ALTER TABLE `dettaglioordine` DISABLE KEYS */;
/*!40000 ALTER TABLE `dettaglioordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendente` (
  `CodiceFiscale` char(20) NOT NULL,
  `CodiceDipendente` char(20) NOT NULL,
  `CodMagazzino` char(20) NOT NULL,
  `Magazziniere` char(1) DEFAULT NULL,
  `Amministratore` char(1) DEFAULT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  UNIQUE KEY `SID_Dipendente_ID` (`CodMagazzino`,`CodiceDipendente`),
  UNIQUE KEY `SID_Dipendente_IND` (`CodMagazzino`,`CodiceDipendente`),
  UNIQUE KEY `FKPer_Dip_IND` (`CodiceFiscale`),
  CONSTRAINT `FKPer_Dip_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `persona` (`CodiceFiscale`),
  CONSTRAINT `FKReferenza` FOREIGN KEY (`CodMagazzino`) REFERENCES `magazzino` (`CodMagazzino`),
  CONSTRAINT `EXTONE_Dipendente` CHECK ((((`Magazziniere` is not null) and (`Amministratore` is null)) or ((`Magazziniere` is null) and (`Amministratore` is not null))))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendente`
--

LOCK TABLES `dipendente` WRITE;
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` VALUES ('CF001','D011','MAG001',NULL,'1'),('CF002','D012','MAG002',NULL,'1'),('CF003','D013','MAG003',NULL,'1'),('CF004','D014','MAG004',NULL,'1'),('CF005','D015','MAG005',NULL,'1'),('CF101','D001','MAG001','1',NULL),('CF102','D002','MAG001','1',NULL),('CF103','D003','MAG001','1',NULL),('CF104','D004','MAG001','1',NULL),('CF105','D005','MAG001','1',NULL),('CF106','D006','MAG001','1',NULL),('CF107','D007','MAG002','1',NULL),('CF108','D008','MAG003','1',NULL),('CF109','D009','MAG004','1',NULL),('CF110','D010','MAG005','1',NULL);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore`
--

DROP TABLE IF EXISTS `fornitore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornitore` (
  `CodiceFornitore` char(20) NOT NULL,
  PRIMARY KEY (`CodiceFornitore`),
  UNIQUE KEY `ID_Fornitore_IND` (`CodiceFornitore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore`
--

LOCK TABLES `fornitore` WRITE;
/*!40000 ALTER TABLE `fornitore` DISABLE KEYS */;
INSERT INTO `fornitore` VALUES ('FOR001'),('FOR002'),('FOR003');
/*!40000 ALTER TABLE `fornitore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestioneordine`
--

DROP TABLE IF EXISTS `gestioneordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestioneordine` (
  `CodPacco` char(20) NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodPacco`),
  UNIQUE KEY `FKGes_Pac_IND` (`CodPacco`),
  KEY `FKGes_Amm_IND` (`CodiceFiscale`),
  CONSTRAINT `FKGes_Amm_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `amministratore` (`CodiceFiscale`),
  CONSTRAINT `FKGes_Pac_FK` FOREIGN KEY (`CodPacco`) REFERENCES `paccopreparato` (`CodPacco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestioneordine`
--

LOCK TABLES `gestioneordine` WRITE;
/*!40000 ALTER TABLE `gestioneordine` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestioneordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestionerifornimento`
--

DROP TABLE IF EXISTS `gestionerifornimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestionerifornimento` (
  `CodiceFiscale` char(20) NOT NULL,
  `CodiceRifornimento` char(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`,`CodiceRifornimento`),
  UNIQUE KEY `ID_GestioneRifornimento_IND` (`CodiceFiscale`,`CodiceRifornimento`),
  KEY `FKGes_Rif_IND` (`CodiceRifornimento`),
  CONSTRAINT `FKGes_Mag` FOREIGN KEY (`CodiceFiscale`) REFERENCES `magazziniere` (`CodiceFiscale`),
  CONSTRAINT `FKGes_Rif_FK` FOREIGN KEY (`CodiceRifornimento`) REFERENCES `rifornimento` (`CodiceRifornimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestionerifornimento`
--

LOCK TABLES `gestionerifornimento` WRITE;
/*!40000 ALTER TABLE `gestionerifornimento` DISABLE KEYS */;
INSERT INTO `gestionerifornimento` VALUES ('CF101','RIF001'),('CF103','RIF002'),('CF106','RIF003'),('CF107','RIF004'),('CF110','RIF005');
/*!40000 ALTER TABLE `gestionerifornimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indirizzo`
--

DROP TABLE IF EXISTS `indirizzo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `indirizzo` (
  `Via` char(20) NOT NULL,
  `Citta` char(20) NOT NULL,
  `CAP` int NOT NULL,
  `NumCivico` int NOT NULL,
  PRIMARY KEY (`Via`,`CAP`,`NumCivico`),
  UNIQUE KEY `ID_Indirizzo_IND` (`Via`,`CAP`,`NumCivico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indirizzo`
--

LOCK TABLES `indirizzo` WRITE;
/*!40000 ALTER TABLE `indirizzo` DISABLE KEYS */;
INSERT INTO `indirizzo` VALUES ('Corso Venezia','Milano',20121,15),('Via Bari','Bari',70121,45),('Via Bologna','Bologna',40121,25),('Via Cagliari','Cagliari',9100,50),('Via Firenze','Firenze',50100,20),('Via Genova','Genova',16121,40),('Via Napoli','Napoli',80100,10),('Via Palermo','Palermo',90100,35),('Via Torino','Torino',10121,30),('Via Verona','Verona',37121,55);
/*!40000 ALTER TABLE `indirizzo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `Ese_CodiceFiscale` char(20) NOT NULL,
  `Data` date NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`Ese_CodiceFiscale`,`Data`),
  UNIQUE KEY `ID_Inventario_IND` (`Ese_CodiceFiscale`,`Data`),
  KEY `FKCommissione_IND` (`CodiceFiscale`),
  CONSTRAINT `FKCommissione_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `amministratore` (`CodiceFiscale`),
  CONSTRAINT `FKEsecuzione` FOREIGN KEY (`Ese_CodiceFiscale`) REFERENCES `magazziniere` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locazioneutente`
--

DROP TABLE IF EXISTS `locazioneutente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locazioneutente` (
  `Via` char(20) NOT NULL,
  `CAP` int NOT NULL,
  `NumCivico` int NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`Via`,`CAP`,`NumCivico`,`CodiceFiscale`),
  UNIQUE KEY `ID_LocazioneUtente_IND` (`Via`,`CAP`,`NumCivico`,`CodiceFiscale`),
  KEY `FKLoc_Ute_IND` (`CodiceFiscale`),
  CONSTRAINT `FKLoc_Ind` FOREIGN KEY (`Via`, `CAP`, `NumCivico`) REFERENCES `indirizzo` (`Via`, `CAP`, `NumCivico`),
  CONSTRAINT `FKLoc_Ute_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `utenteonline` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locazioneutente`
--

LOCK TABLES `locazioneutente` WRITE;
/*!40000 ALTER TABLE `locazioneutente` DISABLE KEYS */;
/*!40000 ALTER TABLE `locazioneutente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotto`
--

DROP TABLE IF EXISTS `lotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lotto` (
  `CodiceLotto` char(20) NOT NULL,
  `Datascadenza` date NOT NULL,
  PRIMARY KEY (`CodiceLotto`),
  UNIQUE KEY `ID_Lotto_IND` (`CodiceLotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotto`
--

LOCK TABLES `lotto` WRITE;
/*!40000 ALTER TABLE `lotto` DISABLE KEYS */;
INSERT INTO `lotto` VALUES ('L001','2025-01-01'),('L002','2025-02-01'),('L003','2025-03-01'),('L004','2025-04-01'),('L005','2025-05-01'),('L006','2025-06-01'),('L007','2025-07-01'),('L008','2025-08-01'),('L009','2025-09-01'),('L010','2025-10-01');
/*!40000 ALTER TABLE `lotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazziniere`
--

DROP TABLE IF EXISTS `magazziniere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazziniere` (
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  UNIQUE KEY `FKDip_Mag_IND` (`CodiceFiscale`),
  CONSTRAINT `FKDip_Mag_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `dipendente` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazziniere`
--

LOCK TABLES `magazziniere` WRITE;
/*!40000 ALTER TABLE `magazziniere` DISABLE KEYS */;
INSERT INTO `magazziniere` VALUES ('CF101'),('CF102'),('CF103'),('CF104'),('CF105'),('CF106'),('CF107'),('CF108'),('CF109'),('CF110');
/*!40000 ALTER TABLE `magazziniere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazzino`
--

DROP TABLE IF EXISTS `magazzino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazzino` (
  `DataFondazione` date NOT NULL,
  `CodMagazzino` char(20) NOT NULL,
  `Via` char(20) NOT NULL,
  `CAP` int NOT NULL,
  `NumCivico` int NOT NULL,
  PRIMARY KEY (`CodMagazzino`),
  UNIQUE KEY `FKLocazioneMagazzino_ID` (`Via`,`CAP`,`NumCivico`),
  UNIQUE KEY `ID_Magazzino_IND` (`CodMagazzino`),
  UNIQUE KEY `FKLocazioneMagazzino_IND` (`Via`,`CAP`,`NumCivico`),
  CONSTRAINT `FKLocazioneMagazzino_FK` FOREIGN KEY (`Via`, `CAP`, `NumCivico`) REFERENCES `indirizzo` (`Via`, `CAP`, `NumCivico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazzino`
--

LOCK TABLES `magazzino` WRITE;
/*!40000 ALTER TABLE `magazzino` DISABLE KEYS */;
INSERT INTO `magazzino` VALUES ('2000-01-01','MAG001','Via Napoli',80100,10),('2001-02-02','MAG002','Corso Venezia',20121,15),('2002-03-03','MAG003','Via Firenze',50100,20),('2003-04-04','MAG004','Via Bologna',40121,25),('2004-05-05','MAG005','Via Torino',10121,30);
/*!40000 ALTER TABLE `magazzino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `CodiceOrdine` char(20) NOT NULL,
  `DataOrdine` date NOT NULL,
  `IndirizzoDestinatario` char(30) NOT NULL,
  `CodiceSconto` char(10) DEFAULT NULL,
  `CodicePromo` char(20) DEFAULT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodiceOrdine`),
  UNIQUE KEY `ID_Ordine_IND` (`CodiceOrdine`),
  KEY `FKRiscossione_IND` (`CodiceSconto`),
  KEY `FKPossedere_IND` (`CodicePromo`),
  KEY `FKEffettuazione_IND` (`CodiceFiscale`),
  CONSTRAINT `FKEffettuazione_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `persona` (`CodiceFiscale`),
  CONSTRAINT `FKPossedere_FK` FOREIGN KEY (`CodicePromo`) REFERENCES `venditapromozionale` (`CodicePromo`),
  CONSTRAINT `FKRiscossione_FK` FOREIGN KEY (`CodiceSconto`) REFERENCES `scontoutente` (`CodiceSconto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paccopreparato`
--

DROP TABLE IF EXISTS `paccopreparato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paccopreparato` (
  `CodPacco` char(20) NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodPacco`),
  UNIQUE KEY `SID_PaccoPreparato_ID` (`CodiceFiscale`,`CodPacco`),
  UNIQUE KEY `ID_PaccoPreparato_IND` (`CodPacco`),
  UNIQUE KEY `SID_PaccoPreparato_IND` (`CodiceFiscale`,`CodPacco`),
  CONSTRAINT `FKPreparazioneOrdine` FOREIGN KEY (`CodiceFiscale`) REFERENCES `magazziniere` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paccopreparato`
--

LOCK TABLES `paccopreparato` WRITE;
/*!40000 ALTER TABLE `paccopreparato` DISABLE KEYS */;
/*!40000 ALTER TABLE `paccopreparato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `Nome` char(30) NOT NULL,
  `Cognome` char(30) NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  `Telefono` bigint NOT NULL,
  `UtenteOnline` char(1) DEFAULT NULL,
  `Dipendente` char(1) DEFAULT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  UNIQUE KEY `ID_Persona_IND` (`CodiceFiscale`),
  CONSTRAINT `LSTONE_Persona` CHECK (((`UtenteOnline` is not null) or (`Dipendente` is not null)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('Elena','Rossi','CF001',1234567810,NULL,'1'),('Giulia','Bianchi','CF002',1234567811,NULL,'1'),('Francesco','Verdi','CF003',1234567812,NULL,'1'),('Giorgio','Gialli','CF004',1234567813,NULL,'1'),('Sofia','Neri','CF005',1234567814,NULL,'1'),('Mario','Rossi','CF101',1234567890,NULL,'1'),('Luigi','Bianchi','CF102',1234567891,NULL,'1'),('Giovanni','Verdi','CF103',1234567892,NULL,'1'),('Anna','Gialli','CF104',1234567893,NULL,'1'),('Maria','Neri','CF105',1234567894,NULL,'1'),('Paolo','Marroni','CF106',1234567895,NULL,'1'),('Luca','Bianchi','CF107',1234567896,NULL,'1'),('Laura','Rossi','CF108',1234567897,NULL,'1'),('Sara','Verdi','CF109',1234567898,NULL,'1'),('Marco','Gialli','CF110',1234567899,NULL,'1'),('Giulia','Ferrari','FRRGLL90A01H501X',3456789012,'1',NULL),('Paolo','Ricci','RCCPLA75A01H501V',5678901234,'1',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `NumeroSeriale` char(20) NOT NULL,
  `CodiceLotto` char(20) NOT NULL,
  `CodPacco` char(20) DEFAULT NULL,
  `CodiceProdotto` char(20) NOT NULL,
  `CodRipiano` char(20) NOT NULL,
  PRIMARY KEY (`NumeroSeriale`),
  UNIQUE KEY `ID_Prodotto_IND` (`NumeroSeriale`),
  KEY `FKPresenza_IND` (`CodiceLotto`),
  KEY `FKInserimento_IND` (`CodPacco`),
  KEY `FKDisponibilita_IND` (`CodiceProdotto`),
  KEY `FKContenimento_IND` (`CodRipiano`),
  CONSTRAINT `FKContenimento_FK` FOREIGN KEY (`CodRipiano`) REFERENCES `ripiano` (`CodRipiano`),
  CONSTRAINT `FKDisponibilita_FK` FOREIGN KEY (`CodiceProdotto`) REFERENCES `versioneprodotto` (`CodiceProdotto`),
  CONSTRAINT `FKInserimento_FK` FOREIGN KEY (`CodPacco`) REFERENCES `paccopreparato` (`CodPacco`),
  CONSTRAINT `FKPresenza_FK` FOREIGN KEY (`CodiceLotto`) REFERENCES `lotto` (`CodiceLotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantitalotti`
--

DROP TABLE IF EXISTS `quantitalotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quantitalotti` (
  `CodiceLotto` char(20) NOT NULL,
  `CodiceRifornimento` char(20) NOT NULL,
  `numero` int NOT NULL,
  PRIMARY KEY (`CodiceLotto`,`CodiceRifornimento`),
  UNIQUE KEY `ID_QuantitaLotti_IND` (`CodiceLotto`,`CodiceRifornimento`),
  KEY `FKRichiestaQuantita_IND` (`CodiceRifornimento`),
  CONSTRAINT `FKRichiestaLotto` FOREIGN KEY (`CodiceLotto`) REFERENCES `lotto` (`CodiceLotto`),
  CONSTRAINT `FKRichiestaQuantita_FK` FOREIGN KEY (`CodiceRifornimento`) REFERENCES `rifornimento` (`CodiceRifornimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantitalotti`
--

LOCK TABLES `quantitalotti` WRITE;
/*!40000 ALTER TABLE `quantitalotti` DISABLE KEYS */;
INSERT INTO `quantitalotti` VALUES ('L001','RIF001',10),('L002','RIF001',7),('L003','RIF002',16),('L004','RIF002',3),('L005','RIF003',8),('L006','RIF003',12),('L007','RIF004',15),('L008','RIF005',2),('L009','RIF005',6),('L010','RIF005',6);
/*!40000 ALTER TABLE `quantitalotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rifornimento`
--

DROP TABLE IF EXISTS `rifornimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rifornimento` (
  `CodiceRifornimento` char(20) NOT NULL,
  `CodiceFornitore` char(20) NOT NULL,
  `CodiceFiscale` char(20) NOT NULL,
  PRIMARY KEY (`CodiceRifornimento`),
  UNIQUE KEY `ID_Rifornimento_IND` (`CodiceRifornimento`),
  KEY `FKFornitura_IND` (`CodiceFornitore`),
  KEY `FKRichiesta_IND` (`CodiceFiscale`),
  CONSTRAINT `FKFornitura_FK` FOREIGN KEY (`CodiceFornitore`) REFERENCES `fornitore` (`CodiceFornitore`),
  CONSTRAINT `FKRichiesta_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `amministratore` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rifornimento`
--

LOCK TABLES `rifornimento` WRITE;
/*!40000 ALTER TABLE `rifornimento` DISABLE KEYS */;
INSERT INTO `rifornimento` VALUES ('RIF001','FOR001','CF001'),('RIF002','FOR002','CF001'),('RIF003','FOR003','CF001'),('RIF004','FOR001','CF001'),('RIF005','FOR002','CF001');
/*!40000 ALTER TABLE `rifornimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ripiano`
--

DROP TABLE IF EXISTS `ripiano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ripiano` (
  `CodRipiano` char(20) NOT NULL,
  `CodScaffale` char(20) NOT NULL,
  PRIMARY KEY (`CodRipiano`),
  UNIQUE KEY `ID_Ripiano_IND` (`CodRipiano`),
  KEY `FKAppartenenzaScaffale_IND` (`CodScaffale`),
  CONSTRAINT `FKAppartenenzaScaffale_FK` FOREIGN KEY (`CodScaffale`) REFERENCES `scaffale` (`CodScaffale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ripiano`
--

LOCK TABLES `ripiano` WRITE;
/*!40000 ALTER TABLE `ripiano` DISABLE KEYS */;
INSERT INTO `ripiano` VALUES ('RIP001','SCA001'),('RIP002','SCA002'),('RIP003','SCA003'),('RIP004','SCA004'),('RIP005','SCA005'),('RIP006','SCA006'),('RIP007','SCA007'),('RIP008','SCA008'),('RIP009','SCA009'),('RIP010','SCA010'),('RIP011','SCA011'),('RIP012','SCA012'),('RIP013','SCA013'),('RIP014','SCA014'),('RIP015','SCA015'),('RIP016','SCA016'),('RIP017','SCA017'),('RIP018','SCA018'),('RIP019','SCA019'),('RIP020','SCA020');
/*!40000 ALTER TABLE `ripiano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scaffale`
--

DROP TABLE IF EXISTS `scaffale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scaffale` (
  `CodScaffale` char(20) NOT NULL,
  `CodSettore` char(20) NOT NULL,
  PRIMARY KEY (`CodScaffale`),
  UNIQUE KEY `ID_Scaffale_IND` (`CodScaffale`),
  KEY `FKAppartenenzaSettore_IND` (`CodSettore`),
  CONSTRAINT `FKAppartenenzaSettore_FK` FOREIGN KEY (`CodSettore`) REFERENCES `settore` (`CodSettore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scaffale`
--

LOCK TABLES `scaffale` WRITE;
/*!40000 ALTER TABLE `scaffale` DISABLE KEYS */;
INSERT INTO `scaffale` VALUES ('SCA001','SET001'),('SCA002','SET001'),('SCA003','SET002'),('SCA004','SET002'),('SCA005','SET003'),('SCA006','SET003'),('SCA007','SET004'),('SCA008','SET004'),('SCA009','SET005'),('SCA010','SET005'),('SCA011','SET006'),('SCA012','SET006'),('SCA013','SET007'),('SCA014','SET007'),('SCA015','SET008'),('SCA016','SET008'),('SCA017','SET009'),('SCA018','SET009'),('SCA019','SET010'),('SCA020','SET010');
/*!40000 ALTER TABLE `scaffale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scontoutente`
--

DROP TABLE IF EXISTS `scontoutente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scontoutente` (
  `PercentualeScontoUtente` float NOT NULL,
  `CodiceSconto` char(10) NOT NULL,
  PRIMARY KEY (`CodiceSconto`),
  UNIQUE KEY `ID_ScontoUtente_IND` (`CodiceSconto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scontoutente`
--

LOCK TABLES `scontoutente` WRITE;
/*!40000 ALTER TABLE `scontoutente` DISABLE KEYS */;
INSERT INTO `scontoutente` VALUES (10,'SCONTO10'),(15,'SCONTO15'),(20,'SCONTO20');
/*!40000 ALTER TABLE `scontoutente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settore`
--

DROP TABLE IF EXISTS `settore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settore` (
  `CodSettore` char(20) NOT NULL,
  `CodMagazzino` char(20) NOT NULL,
  PRIMARY KEY (`CodSettore`),
  UNIQUE KEY `ID_Settore_IND` (`CodSettore`),
  KEY `FKDivisione_IND` (`CodMagazzino`),
  CONSTRAINT `FKDivisione_FK` FOREIGN KEY (`CodMagazzino`) REFERENCES `magazzino` (`CodMagazzino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settore`
--

LOCK TABLES `settore` WRITE;
/*!40000 ALTER TABLE `settore` DISABLE KEYS */;
INSERT INTO `settore` VALUES ('SET001','MAG001'),('SET002','MAG001'),('SET003','MAG002'),('SET004','MAG002'),('SET005','MAG003'),('SET006','MAG003'),('SET007','MAG004'),('SET008','MAG004'),('SET009','MAG005'),('SET010','MAG005');
/*!40000 ALTER TABLE `settore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stipendio`
--

DROP TABLE IF EXISTS `stipendio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stipendio` (
  `CodiceFiscale` char(20) NOT NULL,
  `Importo` float NOT NULL,
  `Bonus` float DEFAULT NULL,
  `DataEmissione` date NOT NULL,
  `IBAN` char(1) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`,`DataEmissione`),
  UNIQUE KEY `ID_Stipendio_IND` (`CodiceFiscale`,`DataEmissione`),
  KEY `FKDestinazione_IND` (`IBAN`),
  CONSTRAINT `FKDestinazione_FK` FOREIGN KEY (`IBAN`) REFERENCES `datifatturazione` (`IBAN`),
  CONSTRAINT `FKRisquote` FOREIGN KEY (`CodiceFiscale`) REFERENCES `dipendente` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stipendio`
--

LOCK TABLES `stipendio` WRITE;
/*!40000 ALTER TABLE `stipendio` DISABLE KEYS */;
/*!40000 ALTER TABLE `stipendio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenteonline`
--

DROP TABLE IF EXISTS `utenteonline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenteonline` (
  `CodiceFiscale` char(20) NOT NULL,
  `Username` char(30) NOT NULL,
  `Password` char(20) NOT NULL,
  `E_mail` char(30) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  UNIQUE KEY `SID_UtenteOnline_ID` (`Username`),
  UNIQUE KEY `SID_UtenteOnline_IND` (`Username`),
  UNIQUE KEY `FKPer_Ute_IND` (`CodiceFiscale`),
  CONSTRAINT `FKPer_Ute_FK` FOREIGN KEY (`CodiceFiscale`) REFERENCES `persona` (`CodiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenteonline`
--

LOCK TABLES `utenteonline` WRITE;
/*!40000 ALTER TABLE `utenteonline` DISABLE KEYS */;
INSERT INTO `utenteonline` VALUES ('FRRGLL90A01H501X','giulia.ferrari','password3','giulia.ferrari@example.com'),('RCCPLA75A01H501V','paolo.ricci','password5','paolo.ricci@example.com');
/*!40000 ALTER TABLE `utenteonline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venditapromozionale`
--

DROP TABLE IF EXISTS `venditapromozionale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venditapromozionale` (
  `DataFine` date NOT NULL,
  `DataInizio` date NOT NULL,
  `PercentualeSconto` float NOT NULL,
  `CodicePromo` char(20) NOT NULL,
  PRIMARY KEY (`CodicePromo`),
  UNIQUE KEY `ID_VenditaPromozionale_IND` (`CodicePromo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venditapromozionale`
--

LOCK TABLES `venditapromozionale` WRITE;
/*!40000 ALTER TABLE `venditapromozionale` DISABLE KEYS */;
INSERT INTO `venditapromozionale` VALUES ('2024-12-31','2024-12-24',25,'PROMO25'),('2024-11-30','2024-11-01',30,'PROMO30');
/*!40000 ALTER TABLE `venditapromozionale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `versioneprodotto`
--

DROP TABLE IF EXISTS `versioneprodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `versioneprodotto` (
  `Specifiche` char(100) NOT NULL,
  `Disponibilita` int NOT NULL,
  `CodiceProdotto` char(20) NOT NULL,
  `NomeProdotto` char(30) NOT NULL,
  PRIMARY KEY (`CodiceProdotto`),
  UNIQUE KEY `ID_VersioneProdotto_IND` (`CodiceProdotto`),
  KEY `FKAppartenenza_IND` (`NomeProdotto`),
  CONSTRAINT `FKAppartenenza_FK` FOREIGN KEY (`NomeProdotto`) REFERENCES `categoriaprodotto` (`NomeProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `versioneprodotto`
--

LOCK TABLES `versioneprodotto` WRITE;
/*!40000 ALTER TABLE `versioneprodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `versioneprodotto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-15 18:07:26
