-- MySQL Workbench Synchronization
-- Generated: 2019-04-13 10:43
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Retiro - 02

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `ERP_TV` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `ERP_TV`.`programa` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` LONGTEXT NOT NULL,
  `horario` TIME NOT NULL,
  `tipo` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ERP_TV`.`item` (
  `id` BIGINT(20) NOT NULL,
  `descricao` LONGTEXT NOT NULL,
  `entrada` TIMESTAMP NULL DEFAULT NULL,
  `saida` TIMESTAMP NOT NULL DEFAULT NOW(),
  `status` LONGTEXT NOT NULL,
  `quem` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ERP_TV`.`programa_item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `id_programa` BIGINT(20) NOT NULL,
  `id_item` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_programa_item_programa`
    FOREIGN KEY (`id_programa`)
    REFERENCES `ERP_TV`.`programa` (`id`),
  CONSTRAINT `fk_programa_item_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `ERP_TV`.`item` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
