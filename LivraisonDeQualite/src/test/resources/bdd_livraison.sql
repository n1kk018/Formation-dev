-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema livraison_qualite_test
--

CREATE DATABASE IF NOT EXISTS livraison_qualite_test;
USE livraison_qualite_test;

--
-- Definition of table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE `commande` (
  `id_commande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `etat_commande` varchar(45) NOT NULL,
  `date_commande` datetime NOT NULL,
  `id_preparateur_commande` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `FK_commande_preparateur` (`id_preparateur_commande`),
  CONSTRAINT `FK_commande_preparateur` FOREIGN KEY (`id_preparateur_commande`) REFERENCES `preparateur` (`id_preparateur`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande`
--

/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` (`id_commande`,`etat_commande`,`date_commande`,`id_preparateur_commande`) VALUES 
 (1,'a preparer','2016-09-21 00:00:00',NULL),
 (2,'livree','2016-09-21 00:00:00',1),
 (3,'preparee','2016-09-21 00:00:00',2),
 (4,'preparee','2016-09-21 00:00:00',1),
 (5,'preparee','2016-09-21 00:00:00',1),
 (6,'preparee','2016-09-21 00:00:00',2);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;


--
-- Definition of table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
CREATE TABLE `ligne_commande` (
  `id_ligne_commande` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantite_ligne_commande` int(10) unsigned NOT NULL,
  `produit_ligne_commande` int(10) unsigned NOT NULL,
  `commande_ligne_commande` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_ligne_commande`),
  KEY `FK_ligne_commande_produit` (`produit_ligne_commande`),
  KEY `FK_ligne_commande_commande` (`commande_ligne_commande`),
  CONSTRAINT `FK_ligne_commande_produit` FOREIGN KEY (`produit_ligne_commande`) REFERENCES `produit` (`id_produit`),
  CONSTRAINT `FK_ligne_commande_commande` FOREIGN KEY (`commande_ligne_commande`) REFERENCES `commande` (`id_commande`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ligne_commande`
--

/*!40000 ALTER TABLE `ligne_commande` DISABLE KEYS */;
INSERT INTO `ligne_commande` (`id_ligne_commande`,`quantite_ligne_commande`,`produit_ligne_commande`,`commande_ligne_commande`) VALUES 
 (1,16,1,1),
 (2,10,2,2),
 (3,5,1,2),
 (4,12,3,4),
 (5,10,2,4),
 (6,21,1,3),
 (7,20,2,5),
 (8,25,1,5),
 (9,12,1,6),
 (10,13,2,6);
/*!40000 ALTER TABLE `ligne_commande` ENABLE KEYS */;


--
-- Definition of table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE `livraison` (
  `id_livraison` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_depart_livraison` datetime NOT NULL,
  `date_arrivee_livraison` datetime DEFAULT NULL,
  `preparateur_livraison` int(10) unsigned DEFAULT NULL,
  `livreur_livraison` int(10) unsigned DEFAULT NULL,
  `commande_livraison` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_livraison`),
  KEY `FK_livraison_preparateur` (`preparateur_livraison`),
  KEY `FK_livraison_commande` (`commande_livraison`),
  KEY `FK_livraison_livreur` (`livreur_livraison`),
  CONSTRAINT `FK_livraison_commande` FOREIGN KEY (`commande_livraison`) REFERENCES `commande` (`id_commande`),
  CONSTRAINT `FK_livraison_livreur` FOREIGN KEY (`livreur_livraison`) REFERENCES `livreur` (`id_livreur`),
  CONSTRAINT `FK_livraison_preparateur` FOREIGN KEY (`preparateur_livraison`) REFERENCES `preparateur` (`id_preparateur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livraison`
--

/*!40000 ALTER TABLE `livraison` DISABLE KEYS */;
INSERT INTO `livraison` (`id_livraison`,`date_depart_livraison`,`date_arrivee_livraison`,`preparateur_livraison`,`livreur_livraison`,`commande_livraison`) VALUES 
 (1,'2016-09-21 09:12:00','2016-09-21 09:21:00',1,1,2),
 (2,'2016-09-22 09:00:00','2016-09-22 09:40:00',1,1,3),
 (3,'2016-09-22 09:12:00',NULL,1,2,4),
 (4,'2016-09-22 09:00:00','2016-09-22 09:21:00',1,3,5),
 (5,'2016-09-22 09:25:00',NULL,1,3,1);
/*!40000 ALTER TABLE `livraison` ENABLE KEYS */;


--
-- Definition of table `livreur`
--

DROP TABLE IF EXISTS `livreur`;
CREATE TABLE `livreur` (
  `id_livreur` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_livreur` varchar(45) NOT NULL,
  `prenom_livreur` varchar(45) NOT NULL,
  PRIMARY KEY (`id_livreur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livreur`
--

/*!40000 ALTER TABLE `livreur` DISABLE KEYS */;
INSERT INTO `livreur` (`id_livreur`,`nom_livreur`,`prenom_livreur`) VALUES 
 (1,'nour','nour'),
 (2,'livreur test1','livreur test1'),
 (3,'livreur test2','livreur test2');
/*!40000 ALTER TABLE `livreur` ENABLE KEYS */;


--
-- Definition of table `preparateur`
--

DROP TABLE IF EXISTS `preparateur`;
CREATE TABLE `preparateur` (
  `id_preparateur` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_preparateur` varchar(45) NOT NULL,
  `login_preparateur` varchar(45) NOT NULL,
  `password_preparateur` varchar(45) NOT NULL,
  PRIMARY KEY (`id_preparateur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preparateur`
--

/*!40000 ALTER TABLE `preparateur` DISABLE KEYS */;
INSERT INTO `preparateur` (`id_preparateur`,`nom_preparateur`,`login_preparateur`,`password_preparateur`) VALUES 
 (1,'preparateur test1','test1','test1'),
 (2,'preparateur test2','test2','test2'),
 (3,'preparateur test3','test3','test3');
/*!40000 ALTER TABLE `preparateur` ENABLE KEYS */;


--
-- Definition of table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE `produit` (
  `id_produit` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(45) NOT NULL,
  `prix_produit` decimal(8,2) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` (`id_produit`,`nom_produit`,`prix_produit`) VALUES 
 (1,'Croissant au beurre','0.90'),
 (2,'Pain au chocolat','1.10'),
 (3,'Pain aux raisins','1.20');
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
