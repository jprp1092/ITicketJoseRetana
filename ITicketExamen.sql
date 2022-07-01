CREATE DATABASE iticketExamen;
use iticketExamen;

CREATE TABLE `artistas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `artistas` VALUES (1,'Bad Bunny'),(2,'Canserbero'),(3,'Residente');

CREATE TABLE `conciertos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEvento` varchar(45) NOT NULL,
  `costo` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `capacidadMax` varchar(9) NOT NULL,
  `lugar` varchar(75) DEFAULT NULL,
  `artistas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`artistas_id`),
  KEY `fk_conciertos_artista_idx` (`artistas_id`),
  CONSTRAINT `fk_conciertos_artistas` FOREIGN KEY (`artistas_id`) REFERENCES `artistas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

INSERT INTO `conciertos` VALUES (1,'Vuelto Clover','10000000','2-2-2222','10000','San Jose',2);
INSERT INTO `conciertos` VALUES (2,'Vuelto Loco','20000000','3-3-3333','20000','San Jose',3);
INSERT INTO `conciertos` VALUES (3,'Tropical','30000000','4-4-4444','20000','Cartago',1);


