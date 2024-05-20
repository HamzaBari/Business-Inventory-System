-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: businessinventorysystem
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `archive`
--

DROP TABLE IF EXISTS `archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archive` (
  `ArchiveID` varchar(4) NOT NULL,
  `ProductStatus` varchar(30) NOT NULL,
  `AvaliableByWhen` varchar(30) NOT NULL,
  PRIMARY KEY (`ArchiveID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archive`
--

LOCK TABLES `archive` WRITE;
/*!40000 ALTER TABLE `archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `BillID` varchar(4) NOT NULL,
  `BillIssueDate` date NOT NULL,
  `BillPaidDate` date NOT NULL,
  PRIMARY KEY (`BillID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `business`
--

DROP TABLE IF EXISTS `business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business` (
  `BusinessName` varchar(30) NOT NULL,
  `BusinessType` varchar(30) NOT NULL,
  `BusinessDescription` varchar(30) NOT NULL,
  `OwnerID` varchar(4) DEFAULT NULL,
  `BusinessAccountID` varchar(4) DEFAULT NULL,
  `DrpID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`BusinessName`),
  KEY `FK_business_orders` (`OwnerID`),
  KEY `FK_business_businessaccount` (`BusinessAccountID`),
  KEY `FK_business_disasterrecoveryplan` (`DrpID`),
  CONSTRAINT `FK_business_businessaccount` FOREIGN KEY (`BusinessAccountID`) REFERENCES `businessaccount` (`BusinessAccountID`),
  CONSTRAINT `FK_business_disasterrecoveryplan` FOREIGN KEY (`DrpID`) REFERENCES `disasterrecoveryplan` (`drpID`),
  CONSTRAINT `FK_business_orders` FOREIGN KEY (`OwnerID`) REFERENCES `orders` (`OwnerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business`
--

LOCK TABLES `business` WRITE;
/*!40000 ALTER TABLE `business` DISABLE KEYS */;
/*!40000 ALTER TABLE `business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessaccount`
--

DROP TABLE IF EXISTS `businessaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessaccount` (
  `BusinessAccountID` varchar(4) NOT NULL,
  `BusinessBudget` int(11) NOT NULL,
  `Profit/Loss` int(11) NOT NULL,
  `ExpensesID` varchar(4) DEFAULT NULL,
  `SalesRevenueID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`BusinessAccountID`),
  KEY `FK_businessaccount_expensestype` (`ExpensesID`),
  KEY `FK_businessaccount_salesrevenue` (`SalesRevenueID`),
  CONSTRAINT `FK_businessaccount_expensestype` FOREIGN KEY (`ExpensesID`) REFERENCES `expensestype` (`ExpensesID`),
  CONSTRAINT `FK_businessaccount_salesrevenue` FOREIGN KEY (`SalesRevenueID`) REFERENCES `salesrevenue` (`SalesRevenueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessaccount`
--

LOCK TABLES `businessaccount` WRITE;
/*!40000 ALTER TABLE `businessaccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `businessaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disasterrecoveryplan`
--

DROP TABLE IF EXISTS `disasterrecoveryplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disasterrecoveryplan` (
  `drpID` varchar(4) NOT NULL,
  `MajorGoals` varchar(500) NOT NULL,
  `Personnel` varchar(500) NOT NULL,
  `ApplicationProfile` varchar(500) NOT NULL,
  `ExternalCosts` varchar(500) NOT NULL,
  `BackupInfo` varchar(500) NOT NULL,
  `BackupProcedure` varchar(500) NOT NULL,
  `MarketResearch` varchar(500) NOT NULL,
  `LegalRequirements` varchar(500) NOT NULL,
  `FinanceInfo` varchar(500) NOT NULL,
  `RecPlanOnsite` varchar(500) NOT NULL,
  `InfoAboutRestoring` varchar(500) NOT NULL,
  `dataRecoveryProcedure` varchar(500) NOT NULL,
  `assessingDamage` varchar(500) NOT NULL,
  `testProcedure` varchar(500) NOT NULL,
  `siteRebuildingPlan` varchar(500) NOT NULL,
  `VideoNames` varchar(500) NOT NULL,
  `imagePathForFloorPlans` varchar(500) NOT NULL,
  `recordAllChanges` varchar(500) NOT NULL,
  PRIMARY KEY (`drpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disasterrecoveryplan`
--

LOCK TABLES `disasterrecoveryplan` WRITE;
/*!40000 ALTER TABLE `disasterrecoveryplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `disasterrecoveryplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `EmployeeID` varchar(4) NOT NULL,
  `Firstname` varchar(30) NOT NULL,
  `Lastname` varchar(30) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Postcode` varchar(10) NOT NULL,
  `Phonenumber` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `MonthlySalary` int(11) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `JobRoleID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `FK__jobrole` (`JobRoleID`),
  CONSTRAINT `FK__jobrole` FOREIGN KEY (`JobRoleID`) REFERENCES `jobrole` (`JobRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expensestype`
--

DROP TABLE IF EXISTS `expensestype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expensestype` (
  `ExpensesID` varchar(4) NOT NULL,
  `ExpensesType` varchar(30) NOT NULL,
  `ExpensesName` varchar(30) NOT NULL,
  `Expense` int(11) NOT NULL,
  PRIMARY KEY (`ExpensesID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expensestype`
--

LOCK TABLES `expensestype` WRITE;
/*!40000 ALTER TABLE `expensestype` DISABLE KEYS */;
/*!40000 ALTER TABLE `expensestype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobrole`
--

DROP TABLE IF EXISTS `jobrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobrole` (
  `JobRoleID` varchar(4) NOT NULL,
  `JobRoleTitle` varchar(30) NOT NULL,
  `JobDescription` varchar(30) NOT NULL,
  PRIMARY KEY (`JobRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobrole`
--

LOCK TABLES `jobrole` WRITE;
/*!40000 ALTER TABLE `jobrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onsite`
--

DROP TABLE IF EXISTS `onsite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `onsite` (
  `onSiteID` varchar(4) NOT NULL,
  `Section` int(11) NOT NULL,
  `Row` int(11) NOT NULL,
  `ShelfNo` int(11) NOT NULL,
  PRIMARY KEY (`onSiteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onsite`
--

LOCK TABLES `onsite` WRITE;
/*!40000 ALTER TABLE `onsite` DISABLE KEYS */;
/*!40000 ALTER TABLE `onsite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetails` (
  `OrderDetailsID` varchar(4) NOT NULL,
  `PricePerUnit` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Discount` int(11) NOT NULL,
  `TotalPrice` int(11) NOT NULL,
  `OrderID` varchar(4) DEFAULT NULL,
  `ProductID` varchar(4) DEFAULT NULL,
  `BillID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`OrderDetailsID`),
  KEY `FK_orderdetails_orders` (`OrderID`),
  KEY `FK_orderdetails_bill` (`BillID`),
  KEY `FK_orderdetails_products` (`ProductID`),
  CONSTRAINT `FK_orderdetails_bill` FOREIGN KEY (`BillID`) REFERENCES `bill` (`BillID`),
  CONSTRAINT `FK_orderdetails_orders` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`),
  CONSTRAINT `FK_orderdetails_products` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `OrderID` varchar(4) NOT NULL,
  `OrderDate` date NOT NULL,
  `OwnerID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_orders_owners` (`OwnerID`),
  CONSTRAINT `FK_orders_owners` FOREIGN KEY (`OwnerID`) REFERENCES `owners` (`OwnerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owners`
--

DROP TABLE IF EXISTS `owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owners` (
  `OwnerID` varchar(4) NOT NULL,
  `Firstname` varchar(30) NOT NULL,
  `Lastname` varchar(30) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Postcode` varchar(10) NOT NULL,
  `Phonenumber` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `JobRoleID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`OwnerID`),
  KEY `FK_owners_jobrole` (`JobRoleID`),
  CONSTRAINT `FK_owners_jobrole` FOREIGN KEY (`JobRoleID`) REFERENCES `jobrole` (`JobRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owners`
--

LOCK TABLES `owners` WRITE;
/*!40000 ALTER TABLE `owners` DISABLE KEYS */;
/*!40000 ALTER TABLE `owners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ProductID` varchar(4) NOT NULL,
  `ProductName` varchar(30) NOT NULL,
  `ProductType` varchar(30) NOT NULL,
  `ProductDescription` varchar(30) NOT NULL,
  `ProductPrice` int(11) NOT NULL,
  `ProductCode` varchar(50) NOT NULL,
  `ProductQty` int(11) NOT NULL,
  `ProductStatus` enum('Y','N') NOT NULL,
  `SupplierID` varchar(4) DEFAULT NULL,
  `WarehouseID` varchar(4) DEFAULT NULL,
  `onSiteID` varchar(4) DEFAULT NULL,
  `ArchiveID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `FK_products_suppliers` (`SupplierID`),
  KEY `FK_products_warehouses` (`WarehouseID`),
  KEY `FK_products_onsite` (`onSiteID`),
  KEY `FK_products_archive` (`ArchiveID`),
  CONSTRAINT `FK_products_archive` FOREIGN KEY (`ArchiveID`) REFERENCES `archive` (`ArchiveID`),
  CONSTRAINT `FK_products_onsite` FOREIGN KEY (`onSiteID`) REFERENCES `onsite` (`onSiteID`),
  CONSTRAINT `FK_products_suppliers` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`SupplierID`),
  CONSTRAINT `FK_products_warehouses` FOREIGN KEY (`WarehouseID`) REFERENCES `warehouses` (`WarehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesrevenue`
--

DROP TABLE IF EXISTS `salesrevenue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesrevenue` (
  `SalesRevenueID` varchar(4) NOT NULL,
  `SalesName` varchar(30) NOT NULL,
  `SalesType` varchar(30) NOT NULL,
  `Sales` int(11) NOT NULL,
  PRIMARY KEY (`SalesRevenueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesrevenue`
--

LOCK TABLES `salesrevenue` WRITE;
/*!40000 ALTER TABLE `salesrevenue` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesrevenue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `SupplierID` varchar(4) NOT NULL,
  `SupplierName` varchar(30) NOT NULL,
  `SupplierType` varchar(30) NOT NULL,
  `SupplierAddress` varchar(30) NOT NULL,
  `SupplierPhoneNo` int(11) NOT NULL,
  `SupplierEmail` varchar(30) NOT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouses`
--

DROP TABLE IF EXISTS `warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouses` (
  `WarehouseID` varchar(4) NOT NULL,
  `WarehouseLocation` varchar(30) NOT NULL,
  `Shelf` varchar(4) NOT NULL,
  `ShelfNo` int(11) NOT NULL,
  PRIMARY KEY (`WarehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouses`
--

LOCK TABLES `warehouses` WRITE;
/*!40000 ALTER TABLE `warehouses` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-12  4:00:00
